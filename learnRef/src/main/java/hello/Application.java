package hello;

import org.springframework.context.ApplicationContext;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"service.xml"});
        MessageService printer = context.getBean("printer", MessageService.class);

        Logger logger = Logger.getLogger(Application.class);

        logger.info(printer.getMessage());

        logger.info("Done");
    }
}
