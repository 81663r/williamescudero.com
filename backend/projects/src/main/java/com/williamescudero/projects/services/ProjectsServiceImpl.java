package com.williamescudero.projects.services;


import com.williamescudero.projects.repositories.ProjectsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("ProjectsService")
public class ProjectsServiceImpl implements ProjectsService {

    @Autowired
    ProjectsRepository projectRepository;


}