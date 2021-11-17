package hu.uni.ekcu.java.service;

import java.io.PrintStream;

public abstract class PrintStreamNotifier implements Notifier {

    private final PrintStream stream;

    public PrintStreamNotifier(PrintStream stream) {
        this.stream = stream;
    }

    @Override
    public void notify(String message) {
        stream.println(message);
    }
}
