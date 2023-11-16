package colin.dev.myfirstlogger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping
public class Controller {

    private static final Logger logger = Logger.getLogger(LoggingExample.class.getName());
    @GetMapping
    public String testLog(){
        String a = "a";
        try {
            Integer.parseInt(a);
        } catch (Exception ex) {
            //Incorrect way of handling exceptions.
            //By returning "error" no information is given to the costumer.
            return "error";
        }
        return "OK";
    }

    @GetMapping("/alternative")
    public String testLogUpdated(){
        String a = "a";
        try {
            Integer.parseInt(a);
        } catch (Exception ex) {
            //Incorrect way of handling exceptions.
            //By returning "error" no information is given to the costumer.
            logger.log(Level.SEVERE,"Impossible to parse a vowel to integer.",ex);
            return "Something went wrong, please check logs";
        }
        return "OK";
    }
}