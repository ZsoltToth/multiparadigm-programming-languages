package hu.uni.ekcu.java.service;

import java.io.PrintStream;

public class NotifierStdOutImpl extends PrintStreamNotifier{
    public NotifierStdOutImpl() {
        super(System.out);
    }
}
