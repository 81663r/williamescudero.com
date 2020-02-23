package com.williamescudero.projects.services;

import java.util.ArrayList;
import java.util.List;

import com.williamescudero.projects.entities.ProjectEntity;
import com.williamescudero.projects.models.projects.Project;
import com.williamescudero.projects.repositories.ProjectsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProjectsService")
public class ProjectsServiceImpl implements ProjectsService {

    @Autowired
    ProjectsRepository projectRepository;

    @Override
    public List<Project> getProjects() {
        List<ProjectEntity> projectsFromDb = projectRepository.findAll();
        List<Project> projects = new ArrayList<>();

        if (projectsFromDb == null){
            return projects;
        }

        for (ProjectEntity entity : projectsFromDb){
            Project project = new Project(entity);
            projects.add(project);
        }

        return projects;
    }


}