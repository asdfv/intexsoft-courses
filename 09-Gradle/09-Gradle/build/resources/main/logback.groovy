import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender

import static ch.qos.logback.classic.Level.*

appender("consoleAppender", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "[%d{HH:mm:ss}] [%thread] [%-5level] [%logger{36}] - %msg%n"
    }
}

root(DEBUG, ["consoleAppender"])
