package hu.uni.ekcu.java.service;

public class NotifierStdOutImpl extends PrintStreamNotifier {
    public NotifierStdOutImpl() {
        super(System.out);
    }
}
