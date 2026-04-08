package org.motorph.core.results;

import org.motorph.core.MotorPhException;

public sealed interface Result<T> permits Success, Failure {
    static <X> Success<X> success(X value) {
        return new Success<>(value);
    }

    static <X> Failure<X> failure(MotorPhException exception) {
        return new Failure<>(exception);
    }
}


