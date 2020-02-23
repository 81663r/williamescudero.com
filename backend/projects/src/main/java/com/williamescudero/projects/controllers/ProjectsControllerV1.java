package com.williamescudero.projects.controllers;

import java.util.List;

import com.williamescudero.projects.models.projects.Project;
import com.williamescudero.projects.services.ProjectsService;

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
@RequestMapping("/api/v1")
public class ProjectsControllerV1 {

    @Autowired
    ProjectsService projectsService;


    @ApiOperation(value = "Get all projects")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful") })
    @GetMapping(value = "/projects", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(origins = "http://localhost:8081")
    public List<Project> getProjects(){
        return this.projectsService.getProjects();
    }
}