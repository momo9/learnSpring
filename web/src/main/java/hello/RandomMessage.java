package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomMessage implements MessageService {

    @Autowired
    private Message message;

    public Message message() {
        return message;
    }

}
