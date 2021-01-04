package com.itlize.microservice.auth.controller;



import com.itlize.microservice.auth.entity.User;
import com.itlize.microservice.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile() {
        User u = userService.getCurUserInfo();
        u.setPassword("");
        return ResponseEntity.ok(u);
    }

    @GetMapping("/change")
    public ResponseEntity<?> changePassword() {

        return ResponseEntity.ok("Successfully updated");
    }

    @GetMapping("/inactivate")
    public ResponseEntity<?> inActivateAccount() {

        return ResponseEntity.ok("Successfully inactivate");
    }
}
