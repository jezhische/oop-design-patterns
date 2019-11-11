package oop.design.patterns.observer.eventType;

public enum EventTypes {
    OPEN, SAVE;


    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
