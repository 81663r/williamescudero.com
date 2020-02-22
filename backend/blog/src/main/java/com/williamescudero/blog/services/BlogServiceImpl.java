
package com.williamescudero.blog.services;

import java.util.ArrayList;
import java.util.List;

import com.williamescudero.blog.entities.BlogEntity;
import com.williamescudero.blog.models.blog.Blog;
import com.williamescudero.blog.repositories.BlogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("BlogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;


    @Override
    public List<Blog> getBlogPosts(){

        List<Blog> lst = new ArrayList<>();
        List<BlogEntity> rlst = blogRepository.findAll();

        if (rlst == null){
            return lst;
        }

        for(BlogEntity entity:rlst){
            Blog blog = new Blog(entity);
            lst.add(blog);
        }

        return lst;
    }
}