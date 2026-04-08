package org.motorph.core.results;

import org.motorph.core.MotorPhException;

public record Failure<T>(MotorPhException exception) implements Result<T> { }
