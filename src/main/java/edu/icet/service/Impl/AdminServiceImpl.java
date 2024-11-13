package edu.icet.service.Impl;

import edu.icet.dto.Admin;
import edu.icet.dto.Login;
import edu.icet.repository.AdminRepository;
import edu.icet.response.LoginResponse;
import edu.icet.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String addAdmin(Admin admin) {
        edu.icet.entity.Admin admin1 = new edu.icet.entity.Admin(
                admin.getId(),
                admin.getName(),
                admin.getEmail(),
                this.passwordEncoder.encode(admin.getPassword())
        );
        adminRepository.save(admin1);
        return admin1.getName();
    }

    @Override
    public LoginResponse loginAdmin(Login login) {
        String msg = "";
        edu.icet.entity.Admin admin = adminRepository.findByEmail(login.getEmail());
        if (admin != null) {
            String password = login.getPassword();
            String encodedPassword = admin.getPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password, encodedPassword);
            if (isPasswordRight) {
                Optional<edu.icet.entity.Admin> employee = adminRepository.findOneByEmailAndPassword(login.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success!", true);
                } else {
                    return new LoginResponse("Login Failed!", false);
                }
            } else {
                return new LoginResponse("Password does not match", false);
            }
        }else {
            return new LoginResponse("Email does not exit", false);
        }
    }
}
