package hello;

public class RandomMessage implements MessageService {

    private Message message;

    public void setMessage(Message message) {
        this.message = message;
    }

    public Message message() {
        return message;
    }

}
