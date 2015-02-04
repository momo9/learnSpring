package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import org.apache.log4j.Logger;

@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();

        Logger logger = Logger.getLogger(Application.class);

        logger.error("not ok");

        logger.info("Done");
    }
}
