package trainning.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("html")
public class ThymeleafTestController {

    @RequestMapping("index")
    public String getHome(){
        return "index";
    }
}
