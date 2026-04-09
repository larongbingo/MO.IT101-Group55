package org.motorph.employees;

import org.motorph.core.results.Result;

/// Common queries for employee login data
public interface LoginRepository {
    Result<Login> addLogin(Login login);
    Result<Login> updateLogin(Login updatedLogin);

    /// Fetches an employee by their username and password
    Employee getEmployeeByCredentials(String username, String password);

    /// Fetches a Login data based on the username
    Login getLoginByUsername(String username);
}
