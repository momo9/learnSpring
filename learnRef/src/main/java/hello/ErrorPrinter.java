package hello;

/**
 * Created by momo9 on 2/5/2015.
 */
public class ErrorPrinter implements MessageService {
    @Override
    public String getMessage() {
        return "Error";
    }
}
