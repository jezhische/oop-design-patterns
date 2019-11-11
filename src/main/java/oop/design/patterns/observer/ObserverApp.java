package oop.design.patterns.observer;

import oop.design.patterns.observer.editor.Editor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ObserverApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ObserverApp.class, args);
//        System.out.println("******************************************************************" + ((Editor) context.getBean("editor")).fileName);
    }
}
