package hello;

import org.apache.log4j.Logger;

import java.beans.ConstructorProperties;

/**
 * Created by momo9 on 2/6/2015.
 */
public class Processor {

    private MessageService service;
    private String author;

    @ConstructorProperties({"service", "author"})
    public Processor(MessageService service, String author) {
        this.service = service;
        this.author = author;
    }

    public void run() {
        Logger logger = Logger.getLogger(Processor.class);
        logger.info(String.format("%s: %s", author, service.getMessage()));
    }
}
