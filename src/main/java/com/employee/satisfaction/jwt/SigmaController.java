package com.employee.satisfaction.jwt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SigmaController {
    @RequestMapping("/sigma")
    public String sigma() {
        return "Hello Sigma Free of auth";
    }
}
