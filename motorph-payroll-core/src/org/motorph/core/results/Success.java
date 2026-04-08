package org.motorph.core.results;

public record Success<T>(T value) implements Result<T> {}
