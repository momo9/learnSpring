package hello;

/**
 * Created by momo9 on 2/6/2015.
 */
public class WithFac implements MessageService {

    private String message;

    private WithFac() {}

    public static MessageService create() {
        WithFac obj = new WithFac();
        obj.message = "Created by factory.";
        return obj;
    }

    public String getMessage() {
        return message;
    }

}
