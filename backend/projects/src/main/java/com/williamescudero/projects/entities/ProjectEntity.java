package com.williamescudero.projects.entities;

import java.util.Date;
import java.util.Map;
import java.util.UUID;


import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("projects")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectEntity{

    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    UUID id;

    @Column
    String name;

    @Column
    String description;

    @Column
    String author;

    @Column
    String source;

    @Column
    Map<String, String> details;

    @Column
    Date lastUpdate;
}