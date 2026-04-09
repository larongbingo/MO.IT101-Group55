package org.motorph.employees.crypto;

public interface StringHashing {
    String hash(String plaintext);
    boolean verify(String plaintext, String hash);
}
