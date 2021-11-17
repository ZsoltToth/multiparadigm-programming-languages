package hu.uni.ekcu.java.service;

public class NotifierStdErrImpl extends PrintStreamNotifier {

    public NotifierStdErrImpl() {
        super(System.err);
    }
}
