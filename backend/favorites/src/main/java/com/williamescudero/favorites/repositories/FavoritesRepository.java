package com.williamescudero.favorites.repositories;

import java.util.List;

import com.williamescudero.favorites.entities.FavoritesEntity;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface FavoritesRepository extends CassandraRepository<FavoritesEntity, Integer>{

    List<FavoritesEntity> findAll();


}