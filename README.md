# Logging and Exception Handling in Java

## Overview
In Java, an exception is an event that disrupts the normal flow of a program, thrown at runtime. Logging, on the other hand, is a crucial aid for understanding and debugging a program's runtime behaviour. It involves capturing and persisting important data for analysis, critical for debugging and auditing purposes. Java offers a built-in logging framework in java.util.logging and various third-party frameworks like Log4j, Logback, and tinylog.

## Logging in Java
Effective logging requires systematic recording of important details in an easy-to-process format. While print statements are rudimentary, they have limitations such as transient output and lack of customization. The default Java logging framework comprises loggers, handlers, and formatters. Loggers capture events, handlers determine log destinations, and formatters define log entry formats.


### Key Components:

- **Loggers:** Capture log events and redirect them to handlers.
- **Handlers:** Define log destinations, such as the console or files.
- **Formatter:** Specify the format of log entries.

## Common Mistakes and Best Practices

### Common Mistakes
**Not Logging in catch Statement:** Failing to log anything in a catch statement hinders the understanding of errors.

**Logging Only Developer's Message:** Logging only a developer's message without additional context can be insufficient for understanding exceptions.

**Logging Only Exception Message:** If an exception, like NullPointerException, has a null message, logging just the message might not provide enough information.


![Non descriptive error message](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/4c3q2fllskp1npcybr3u.png)

```java
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
```

### Best Practices
**Log the Exception Object:** Log both the developer's message and the entire exception object. This provides a comprehensive view of the exception, including the invoked methods and the stack trace.

**Include Exception Type in Log:** Including the type of exception in the log helps in identifying the nature of the issue.


![More descriptive error message](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/wcvsik3r30dbor0vh7r6.png)


```java
@GetMapping("/alternative/{a}")
    public ResponseEntity<?> testLogUpdated(@PathVariable String a){
        try {
            Integer.parseInt(a);
        } catch (Exception ex) {
            String message = "Impossible to parse a non-numeric value to integer.";
            logger.log(Level.SEVERE, message,ex);
            return ResponseEntity.badRequest().body(message + "<br/>" + ex);
        }
        return ResponseEntity.ok().build();
    }
```

![Error stack trace](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/takfzj1tocq2xam2iwdk.png)

## Conclusion
In conclusion, effective logging and exception handling are essential for robust Java applications. By avoiding common mistakes and following best practices, developers can enhance the readability and usefulness of logs. The choice of logging frameworks, such as Java's built-in logging or third-party options, should align with project requirements. Remembering to log complete information, including exception objects and types, contributes to a clearer understanding of runtime issues. Striking a balance between logging sufficiency and performance considerations ensures a streamlined and effective logging strategy for Java applications.


## References
https://medium.com/w-logs/how-to-log-exception-properly-6aa80b62ff8a

https://www.loggly.com/ultimate-guide/java-logging-basics/

https://www.baeldung.com/java-logging-intro

https://www.crowdstrike.com/guides/java-logging/


## Contributors
Marisa Pinheiro
[LinkedIn](https://www.linkedin.com/in/marisa-pinheiro-833a12113/) [Github](https://github.com/Marisa-Pinheiro)

Colin Nordmark
[LinkedIn](https://www.linkedin.com/in/colinnordmark/)  [Github](https://github.com/colinnordmark)

