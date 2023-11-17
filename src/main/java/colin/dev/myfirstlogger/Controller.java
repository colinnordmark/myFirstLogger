package colin.dev.myfirstlogger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping
public class Controller {

    private static final Logger logger = Logger.getLogger(LoggingExample.class.getName());
    @GetMapping("/{a}")
    public ResponseEntity<?> testLog(@PathVariable String a){
        try {
            Integer.parseInt(a);
        } catch (Exception ex) {
            //Incorrect way of handling exceptions.
            //By returning "error" no information is given to the client.
            return ResponseEntity.badRequest().body("error");
        }
        return ResponseEntity.ok().body("ok");
    }

    @GetMapping("/alternative/{a}")
    public ResponseEntity<?> testLogUpdated(@PathVariable String a){
        try {
            Integer.parseInt(a);
        } catch (Exception ex) {
            String message = "Impossible to parse a vowel to integer.";
            logger.log(Level.SEVERE, message,ex);
            return ResponseEntity.badRequest().body(message + "<br/>" + ex);
        }
        return ResponseEntity.ok().build();
    }
}
