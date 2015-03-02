package hello;

import org.springframework.stereotype.Component;

@Component
public class ObjTwo {

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

}
