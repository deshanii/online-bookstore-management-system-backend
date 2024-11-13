package edu.icet.controller;

import edu.icet.dto.Admin;
import edu.icet.dto.Login;
import edu.icet.response.LoginResponse;
import edu.icet.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody Login login)
    {
        LoginResponse loginResponse = adminService.loginAdmin(login);
        return ResponseEntity.ok(loginResponse);
    }
}
