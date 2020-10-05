package hu.uni.eszterhazy.multiparadigm.oop.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class LogEntry {

    private Date date;
    private Class source;
    private Level level;
    private String message;
}
