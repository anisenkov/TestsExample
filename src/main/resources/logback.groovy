/**
 * Created by astdv on 15.11.2017.
 */


import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender

import java.nio.charset.Charset

import static ch.qos.logback.classic.Level.INFO

def defaultCharset = Charset.forName("UTF-8")

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        charset = defaultCharset
        pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{5} Groovy - %msg%n"
    }
}

root(INFO, ["STDOUT"])