package com.dzc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
//@RequestMapping("/login")
@Validated
@ControllerAdvice
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @RequestMapping("login")
    public String login(String username, String password, HttpServletRequest request, HttpServletResponse response){
        if(username != null && password != null){
            return "userName = " + username + ", password = " +password;
        }
        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return null;
    }

    @RequestMapping("/lgoin1")
    public String login1(@NotBlank String username,@NotBlank String password){
        return "userName = " + username + ", password = " +password;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity invalidArgumentExceptionHandler(Exception e){
        logger.info(e.getMessage());
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
