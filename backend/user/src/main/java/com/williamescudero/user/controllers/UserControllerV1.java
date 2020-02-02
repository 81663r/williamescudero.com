package com.williamescudero.user.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/user")
public class UserControllerV1{

    @ApiOperation(value = "Return if user is unique")
    @GetMapping(value = "/unique/{cookie}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(origins = "http://localhost:8081")
    public Boolean isUserUnique(@RequestHeader(value = "User-Agent") String userAgent, @PathVariable("cookie") String cookie, HttpServletRequest request){
        System.out.println("userAgent: "+userAgent);
        System.out.println("request: "+request.getRemoteHost());
        System.out.println("cookie:"+cookie);
        return true;
    }
}