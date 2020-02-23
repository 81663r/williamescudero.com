package com.williamescudero.projects.repositories;

import java.util.List;

import com.williamescudero.projects.entities.ProjectEntity;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ProjectsRepository extends CassandraRepository<ProjectEntity, Integer>{
    List<ProjectEntity> findAll();
}