package oop.design.patterns.observer.editor;

import oop.design.patterns.observer.eventType.EventTypes;
import oop.design.patterns.observer.exception.ObserverException;
import oop.design.patterns.observer.publisher.EventManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
@PropertySource(value = "observerFiles.properties")
public class Editor {
    private EventManager eventManager;
    private File file;
    @Value("${file1.name}") private String fileName;
//    @Value("${file2.name}") private String falseFileNameForTesting;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS Z");
    private FileWriter writer;
    //
//    @Autowired
//    public Editor(@Value("${file1.name}") String fileName, EventManager eventManager) {
//        this.eventManager = eventManager;
//        file = new File(fileName);
//    }

    @Autowired
    public Editor(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    /**
     * NB: {@code ObserverException} is {@code RuntimeException}
     * @throws ObserverException
     */
    public void openFile() throws ObserverException {
        // open the file
//        fileName = null;
//        fileName = "src/main/java/oop/design/patterns/observer/testFilesWWWWWWWWWWWWWWWWWWWWWW/test.txt";
//        fileName = falseFileNameForTesting;
        file = new File(fileName);
        try {
            writer = new FileWriter(file, true);
            // add mark to the file
            writer.write("\n-----------------------------------\nFile opened " + dateFormat.format(new Date()) + "\n");
            writer.flush();
            // do notify() to let listeners know about event occurred
            eventManager.notify(EventTypes.OPEN, file);
            // business logic...
            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println("Print something to writing to the file and press Enter to save this or print esc and press Enter to exit");
                String s = scanner.nextLine();
                if (s.equals("esc")) break;
                else {
                    if (s.substring(s.length() - 2).equals("\\n")) s = s.substring(0, s.length() - 2) + "\n";
                    writer.write(s);
                    writer.flush();
                }
            }
            // exit file, close writer
            saveFileAndExit();
        } catch (Exception e) {
            throw new ObserverException(e.getMessage(), e);
        }
    }

    private void saveFileAndExit() throws ObserverException {
        try {
            eventManager.notify(EventTypes.SAVE, file);
            writer.write("\nFile closed " + dateFormat.format(new Date()));
            writer.close();
            file = null;
        } catch (Exception e) {
            throw new ObserverException(e.getMessage(), e);
        }
    }

    public EventManager getEventManager() {
        return eventManager;
    }
}
