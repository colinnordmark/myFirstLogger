package colin.dev.myfirstlogger;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LoggingExample {

    // Create a logger
    private static final Logger logger = Logger.getLogger(LoggingExample.class.getName());

    public static void main (String[] args) {
        configureLogger();

        // Log messages at different levels
        logger.severe("This is a severe message.");
        logger.warning("This is a warning message.");
        logger.info("This is an informational message.");
        logger.config("This is a configuration message.");
        logger.fine("This is a fine (debug) message.");
    }

    private static void configureLogger() {
        // Get the root logger and remove existing handlers
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers) {
            rootLogger.removeHandler(handler);
        }

        // Create a console handler and set its formatter
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());

        // Set the console handler's log level
        consoleHandler.setLevel(Level.ALL);

        // Add the console handler to the root logger
        rootLogger.addHandler(consoleHandler);

        // Set the root logger's log level
        rootLogger.setLevel(Level.ALL);
    }

    // A simple formatter to customize log message formatting
    private static class SimpleFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getLevel() + ": " + record.getMessage() + "\n";
        }
    }
}