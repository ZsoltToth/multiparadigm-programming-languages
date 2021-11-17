package hu.uni.ekcu.java.service;

import java.io.PrintStream;

public class NotifierStdErrImpl extends PrintStreamNotifier{

    public NotifierStdErrImpl() {
        super(System.err);
    }
}
