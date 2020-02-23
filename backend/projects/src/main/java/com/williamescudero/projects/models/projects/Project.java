package com.williamescudero.projects.models.projects;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.williamescudero.projects.entities.ProjectEntity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project{

    UUID id;

    String name;

    String description;

    String author;

    String source;

    Map<String, String> details;

    Date lastUpdate;

    public Project(ProjectEntity entity){
        setId(entity.getId());
        setName(entity.getName());
        setDescription(entity.getDescription());
        setAuthor(entity.getAuthor());
        setDetails(entity.getDetails());
        setSource(entity.getSource());
        setLastUpdate(entity.getLastUpdate());
    }

}