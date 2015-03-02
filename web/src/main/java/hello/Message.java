package hello;

import javax.annotation.PostConstruct;

public class Message {
    private String message;

    public Message(String message) {
        this.message = message;
    }

    @PostConstruct
    public void init() {
        message += "-init";
    }

    @Override
    public String toString() {
        return message;
    }

}
