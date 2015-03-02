package hello;

import org.springframework.stereotype.Component;

@Component
public class ObjOne {
    
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

}
