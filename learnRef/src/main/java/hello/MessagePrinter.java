package hello;

public class MessagePrinter implements MessageService {

    @Override
    public String getMessage() {
        return "Hello World";
    }

}
