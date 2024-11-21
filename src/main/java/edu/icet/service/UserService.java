package edu.icet.service;

import edu.icet.dto.Login;
import edu.icet.dto.User;
import edu.icet.response.LoginResponse;

public interface UserService {
    String addUser(User user);

    LoginResponse loginUser(Login login);
}
