package oop.design.patterns.observer.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"oop.design.patterns.observer", "oop.design.patterns.util"})
public class ObserverConfig {

    @Bean(name = "observerLogger")
    public Logger getLogger() {
        return LogManager.getLogger(this.getClass());
    }
}
