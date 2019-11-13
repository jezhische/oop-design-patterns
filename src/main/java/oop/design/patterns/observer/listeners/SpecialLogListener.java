package oop.design.patterns.observer.listeners;

import oop.design.patterns.observer.eventType.EventTypes;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SpecialLogListener implements EventListener {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z");
    @Autowired
    @Qualifier("observerLogger")
    private Logger log;

    @Override
    public void update(EventTypes event, File file) {
        log.warn(dateFormat.format(new Date()) + ": From SpecialLogListener: event " + event +
                        " occurred for file " + file.getName());
    }
}
