package com.williamescudero.favorites.repositories;

import java.util.List;
import java.util.UUID;

import com.williamescudero.favorites.entities.FavoriteItemsEntity;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface FavoriteItemsRepository extends CassandraRepository<FavoriteItemsEntity, Integer>{

    List<FavoriteItemsEntity> findAllByfavoriteid(UUID favorite_id);


}