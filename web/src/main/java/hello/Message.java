package hello;

import javax.annotation.PostConstruct;

public class Message {

    private String message;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Message(message);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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
