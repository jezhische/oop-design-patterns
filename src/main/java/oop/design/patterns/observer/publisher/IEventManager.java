package oop.design.patterns.observer.publisher;

import oop.design.patterns.observer.eventType.EventTypes;
import oop.design.patterns.observer.listeners.EventListener;

import java.io.File;

public interface IEventManager {
    boolean subscribe(EventTypes event, EventListener listener);
    boolean unsubscribe(EventTypes event, EventListener listener);
    void notify(EventTypes event, File file);
}
