package com.williamescudero.blog.repositories;

import java.util.List;

import com.williamescudero.blog.entities.BlogEntity;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface BlogRepository extends CassandraRepository<BlogEntity, Integer>{

    List<BlogEntity> findAll();


}