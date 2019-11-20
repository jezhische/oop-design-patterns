package oop.design.patterns.observer.aop;

import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ObserverAspect {
    @Autowired
    @Qualifier("observerCommonLogger")
    private Logger logger;

//    public ObserverAspect(@Autowired @Qualifier("observerCommonLogger") Logger logger) {
//        this.logger = logger;
//    }

    @Pointcut("execution(void oop.design.patterns.observer.listeners.SpecialLogListener.update(..))")
    private void forSpecialLogListenerUpdate() {}

    @Before("forSpecialLogListenerUpdate()")
    public void beforeSpecialLogListenerUpdate(JoinPoint joinPoint) {
        // the method this advice is calling
        String method = joinPoint.getSignature().toString();
        logger.debug("*******************@Before(\"forSpecialLogListenerUpdate\") is calling method: " + method);
        // the called method arguments
        Object[] args = joinPoint.getArgs();
        if (args.length == 0) logger.debug(String.format("********************the method %s has no arguments", method));
        else {
            for (int i = 0; i < args.length; i++) {
                logger.debug(String.format("method %s argument %d type: %s, value: %s",
                        method, i, args[i].getClass().getName(), args[i].toString()));
            }
        }
    }


}
