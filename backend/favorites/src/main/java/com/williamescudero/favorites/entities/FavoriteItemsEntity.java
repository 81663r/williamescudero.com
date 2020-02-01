package com.williamescudero.favorites.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("favoriteItems")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FavoriteItemsEntity{

    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.CLUSTERED)
    UUID id;

    @PrimaryKeyColumn(name = "favorite_id", type = PrimaryKeyType.PARTITIONED)
    UUID favoriteid;

    @Column
    String title;

    @Column
    Integer likes;

    @Column
    HashMap<String, String> tags;

}