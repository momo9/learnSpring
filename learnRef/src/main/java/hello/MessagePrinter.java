package hello;

public class MessagePrinter implements MessageService {

    private String message;

    private MessagePrinter() {}

    public MessageService createHello() {
        MessagePrinter printer = new MessagePrinter();
        printer.message = "Hello World";
        return printer;
    }

    public MessageService createError() {
        MessagePrinter printer = new MessagePrinter();
        printer.message = "Error";
        return printer;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
