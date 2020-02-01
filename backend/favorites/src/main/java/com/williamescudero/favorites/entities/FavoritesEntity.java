package com.williamescudero.favorites.entities;

import java.util.UUID;

import com.williamescudero.favorites.models.favorites.Header;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("favorites")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FavoritesEntity{

    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    UUID id;

    @Column
    Header header;

}