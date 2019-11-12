package oop.design.patterns.observer;

import oop.design.patterns.observer.editor.Editor;
import oop.design.patterns.observer.exception.ObserverException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class ObserverApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ObserverApp.class, args);

        Editor editor = (Editor) context.getBean("editor");
//        System.out.println("******************************************************************" + editor.fileName);
            editor.openFile();
    }
}
