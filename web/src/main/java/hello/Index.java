package hello;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Index {
    
    @RequestMapping("/new/{val}")
    public String doGet(@PathVariable String val, Model model) {
        model.addAttribute("message", val);
        return "/show";
    }
    
    @RequestMapping(value = "/json/{val}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message json(@PathVariable String val) {
        return new Message(val);
    }

}
