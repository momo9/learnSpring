package aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SomeAspect {

    @Pointcut("execution(* hello.*.set*(..))")
    private void setterCut() {}

    @Before("setterCut()")
    public void log() {
        Logger logger = Logger.getLogger(this.getClass());
        logger.info("setter called");
    }
}
