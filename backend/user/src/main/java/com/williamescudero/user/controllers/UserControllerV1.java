package com.williamescudero.user.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/user")
public class UserControllerV1{

    @ApiOperation(value = "Return if user is unique")
    @GetMapping(value = "/unique/{cookie}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(origins = "http://localhost:8080")
    public Boolean isUserUnique(@RequestHeader(value = "User-Agent") String userAgent, HttpServletRequest request){
        System.out.println("userAgent: "+userAgent);
        System.out.println("request: "+request.getRemoteHost());
        System.out.println("cookie:"+request.getCookies());
        return true;
    }
}