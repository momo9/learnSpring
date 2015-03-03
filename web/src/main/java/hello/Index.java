package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
    
    @RequestMapping("/new/{val}")
    public String doGet(@PathVariable String val, Model model) {
        model.addAttribute("message", val);
        return "/show";
    }
    
}
