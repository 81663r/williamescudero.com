package com.williamescudero.blog.entities;

import java.util.Date;
import java.util.UUID;


import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("blog")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogEntity{

    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    UUID id;

    @Column
    String title;

    @Column
    String content;

    @Column
    String author;

    @Column
    Date date;

    

}