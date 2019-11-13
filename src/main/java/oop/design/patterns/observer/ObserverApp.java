package oop.design.patterns.observer;

import oop.design.patterns.observer.editor.Editor;
import oop.design.patterns.observer.eventType.EventTypes;
import oop.design.patterns.observer.exception.ObserverException;
import oop.design.patterns.observer.listeners.ConsoleSoutListener;
import oop.design.patterns.observer.listeners.SpecialLogListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class ObserverApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ObserverApp.class, args);

        Editor editor = (Editor) context.getBean("editor");
        ConsoleSoutListener consoleSoutListener = (ConsoleSoutListener) context.getBean("consoleSoutListener");
        SpecialLogListener specialLogListener = (SpecialLogListener) context.getBean("specialLogListener");
        editor.getEventManager().subscribe(EventTypes.OPEN, consoleSoutListener);
        editor.getEventManager().subscribe(EventTypes.OPEN, specialLogListener);
        editor.getEventManager().subscribe(EventTypes.SAVE, specialLogListener);
            editor.openFile();
    }
}
