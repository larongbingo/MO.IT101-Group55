package org.motorph.core;

public class MotorPhException extends Exception {
    public MotorPhException(String message) {
        super(message, null);
    }

    public MotorPhException(String message, Throwable cause) {
        super(message, cause);
    }
}
