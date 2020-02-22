package com.williamescudero.blog.models.blog;

import java.util.Date;
import java.util.UUID;

import com.williamescudero.blog.entities.BlogEntity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    public Blog(BlogEntity blog){

        setId(blog.getId());
        setTitle(blog.getTitle());
        setContent(blog.getContent());
        setAuthor(blog.getAuthor());
        setDate(blog.getDate());
    }
    
    UUID id;

    String title;

    String content;

    String author;

    Date date;

}