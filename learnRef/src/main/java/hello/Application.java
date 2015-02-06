package hello;

import org.springframework.context.ApplicationContext;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"service.xml"});
        MessageService helloPrinter = context.getBean("helloPrinter", MessageService.class);
        MessageService errorPrinter = context.getBean("errorPrinter", MessageService.class);
        MessageService obj = context.getBean("withFactory", MessageService.class);
        Processor processor = context.getBean("processor", Processor.class);

        Logger logger = Logger.getLogger(Application.class);

        logger.info(helloPrinter.getMessage());
        logger.info(errorPrinter.getMessage());
        logger.info(obj.getMessage());

        processor.run();

        logger.info("Done");
    }
}
