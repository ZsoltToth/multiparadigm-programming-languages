package hu.uni.ekcu.java.service;

public class NoRealSolutionException extends Exception {

    public NoRealSolutionException() {
    }

    public NoRealSolutionException(String message) {
        super(message);
    }

    public NoRealSolutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRealSolutionException(Throwable cause) {
        super(cause);
    }

    public NoRealSolutionException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
