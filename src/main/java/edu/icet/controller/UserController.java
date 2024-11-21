package edu.icet.controller;

import edu.icet.dto.Login;
import edu.icet.dto.User;
import edu.icet.response.LoginResponse;
import edu.icet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody Login login)
    {
        LoginResponse loginResponse = userService.loginUser(login);
        return ResponseEntity.ok(loginResponse);
    }
}
