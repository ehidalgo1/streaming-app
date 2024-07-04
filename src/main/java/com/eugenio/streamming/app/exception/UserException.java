package com.eugenio.streamming.app.exception;

/**
 * this is a exception class to user
 */
public class UserException extends RuntimeException {

    /**
     * constructor
     * @param message message
     */
    public UserException(String message) {
        super(message);
    }

    /**
     * constructor
     * @param message message
     * @param ex exception
     */
    public UserException(String message, Exception ex) {
        super(message, ex);
    }

}
