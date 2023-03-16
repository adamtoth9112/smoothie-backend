package com.lilacode.smoothie.backend.auth;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class BasicAuthController {

    @GetMapping(path = "/auth")
    public AuthenticationBean basicAuth(@RequestHeader("Authorization") String token) {
        return new AuthenticationBean("Adam", "1", token);
    }
}
