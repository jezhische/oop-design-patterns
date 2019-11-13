package oop.design.patterns.observer.listeners;

import oop.design.patterns.observer.eventType.EventTypes;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ConsoleSoutListener implements EventListener {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z");

    @Override
    public void update(EventTypes event, File file) {
        System.out.printf("%s: From ConsoleSoutListener: event %s occurred for file %s\n",
                dateFormat.format(new Date()), event, file.getName());
    }
}
