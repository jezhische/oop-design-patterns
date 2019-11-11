package oop.design.patterns.observer.listeners;

import oop.design.patterns.observer.eventType.EventTypes;

import java.io.File;

public interface EventListener {
    void update(EventTypes event, File file);
}
