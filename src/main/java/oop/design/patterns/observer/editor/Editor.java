package oop.design.patterns.observer.editor;

import oop.design.patterns.observer.publisher.EventManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
@PropertySource(value = "observerFiles.properties")
public class Editor {
    private EventManager eventManager;
    private File file;

    @Autowired
    public Editor(@Value("${file1.name}") String fileName, EventManager eventManager) {
        this.eventManager = eventManager;
        file = new File(fileName);
    }
}
