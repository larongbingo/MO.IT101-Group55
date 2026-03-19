package org.motorph.employees;

public interface LoginRepository {
    Employee getEmployeeByCredentials(String username, String password);
}
