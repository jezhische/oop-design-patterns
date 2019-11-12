package oop.design.patterns.observer.publisher;

import oop.design.patterns.observer.eventType.EventTypes;
import oop.design.patterns.observer.listeners.EventListener;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This bean has a prototype scope by reason of: the client (i.e. main() method) creates new Editor, that contains
 * an instance of EventManager. Then the client can call this EventManager from Editor and subscribe some subscribers,
 * that will be stored in the listenerMap of this EventManager instance. So if I has several different Editor instances,
 * it's not good idea to store all the subscribers lists in one EventManager instance. I.e. EventManager instance
 * must be recreated every time new Editor instance was created (e.g. by Editor constructor
 * or by Spring context as prototype)
 */
@Component
@Scope("prototype")
public class EventManager implements IEventManager {
    private Map<EventTypes, List<EventListener>> listenerMap;

    // constructor: initialize listenerMap and fill it with values. I use enum EventTypes for keys type because of its
    // facilities: one can add or remove an event in it at any time. The listenerMap fills with pairs
    // "event - list of the listeners of this event"
    public EventManager() {
        listenerMap = new HashMap<>();
        for (EventTypes operation : EventTypes.values()) listenerMap.put(operation, new ArrayList<EventListener>());
    }

    @Override
    public boolean subscribe(EventTypes event, EventListener listener) {
        List<EventListener> operationListeners = listenerMap.get(event);
        return operationListeners.add(listener);
    }

    @Override
    public boolean unsubscribe(EventTypes event, EventListener listener) {
        List<EventListener> operationListeners = listenerMap.get(event);
        return operationListeners.add(listener);
    }

    @Override
    public void notify(EventTypes event, File file) {
        listenerMap.get(event).forEach(listener -> listener.update(event, file));
    }
}
