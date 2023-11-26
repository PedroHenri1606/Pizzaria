package com.piazzariap1.pizzaria.controller;

import com.piazzariap1.pizzaria.config.security.TokenService;
import com.piazzariap1.pizzaria.service.implementada.UserEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserEntityController {

    @Autowired
    UserEntityServiceImpl service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;
}
