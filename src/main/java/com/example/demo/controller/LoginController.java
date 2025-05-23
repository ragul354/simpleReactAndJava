package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // React default port
public class LoginController {

    @PostMapping("/login")
    public Response Login(@RequestBody User user) {
        // Simple hardcoded validation
        if ("rahul030504@gmail.com".equals(user.getEmail()) && "Ragul@123".equals(user.getPassword())) {
            return new Response("Login successful", true);
        } else {
            return new Response("Invalid email or password", false);
        }
    }

    static class User {
        private String email;
        private String password;

        // getters & setters
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    static class Response {
        private String message;
        private boolean success;

        public Response(String message, boolean success) {
            this.message = message;
            this.success = success;
        }

        // getters
        public String getMessage() { return message; }
        public boolean isSuccess() { return success; }
    }
} 