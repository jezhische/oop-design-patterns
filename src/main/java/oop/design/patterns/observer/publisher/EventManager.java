package oop.design.patterns.observer.publisher;

import oop.design.patterns.observer.eventType.EventTypes;
import oop.design.patterns.observer.listeners.EventListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
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

    }
}
