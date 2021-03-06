package hu.uni.eszterhazy.multiparadigm.oop;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.uni.eszterhazy.multiparadigm.oop.model.Level;
import hu.uni.eszterhazy.multiparadigm.oop.model.LogEntry;

import java.io.IOException;
import java.util.Date;

/**
 * Design an API for writing and reading LogEntry objects into JSON format with Jackson.
 *
 * Functional Requirements:
 *  - Logger can create and write log entries.
 *  - A Logger can write entries into different files. For example your service logs into the service.logs and all.logs.
 *  - You can read and query Log files by {date, level, source, message}
 */
public class App {
    public static void main(String[] args) throws IOException {
        LogEntry entry = LogEntry.builder()
                .date(new Date())
                .source(App.class)
                .level(Level.FATAL)
                .message("Fatal Error")
                .build();


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(System.out, entry);

    }
}
