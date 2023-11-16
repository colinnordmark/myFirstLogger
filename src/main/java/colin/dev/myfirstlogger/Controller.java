package colin.dev.myfirstlogger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping
    public String testLog(){
        String a = "a";
        try {
            Integer.parseInt(a);
        } catch (Exception ex) {
            return "error";
        }
        return "OK";
    }
}
