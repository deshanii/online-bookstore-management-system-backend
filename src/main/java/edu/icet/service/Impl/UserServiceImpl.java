package edu.icet.service.Impl;

import edu.icet.dto.Login;
import edu.icet.dto.User;
import edu.icet.repository.UserRepository;
import edu.icet.response.LoginResponse;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String addUser(User user) {
        edu.icet.entity.User user1 = new edu.icet.entity.User(
                user.getId(),
                user.getName(),
                user.getEmail(),
                this.passwordEncoder.encode(user.getPassword())
        );
        userRepository.save(user1);
        return user1.getName();
    }

    @Override
    public LoginResponse loginUser(Login login) {
        String msg = "";
        edu.icet.entity.User user = userRepository.findByEmail(login.getEmail());
        if (user != null) {
            String password = login.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password, encodedPassword);
            if (isPasswordRight) {
                Optional<edu.icet.entity.User> employee = userRepository.findOneByEmailAndPassword(login.getEmail(), encodedPassword);
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
