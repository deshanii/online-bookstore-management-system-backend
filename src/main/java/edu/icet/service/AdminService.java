package edu.icet.service;

import edu.icet.dto.Admin;
import edu.icet.dto.Login;
import edu.icet.response.LoginResponse;

public interface AdminService {
    String addAdmin(Admin admin);

    LoginResponse loginAdmin(Login login);
}
