package com.williamescudero.blog.controllers;

import java.util.List;

import com.williamescudero.blog.models.blog.Blog;
import com.williamescudero.blog.services.BlogService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/blog")
public class BlogControllerV1{

    @Autowired
    private BlogService blogService;

    @ApiOperation(value = "Get all blog posts")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful") })
    @GetMapping(value = "/posts", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(origins = "http://localhost:8081")
    public List<Blog> getBlogPosts(){
        return blogService.getBlogPosts();
    }
}