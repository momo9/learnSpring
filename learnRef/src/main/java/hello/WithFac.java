package hello;

/**
 * Created by momo9 on 2/6/2015.
 */
public class WithFac implements WithFacService {

    private String message;

    private WithFac() {}

    public static WithFacService create() {
        WithFac obj = new WithFac();
        obj.message = "Created by factory.";
        return obj;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
