package com.williamescudero.blog.services;

import java.util.List;

import com.williamescudero.blog.models.blog.Blog;

public interface BlogService {

    List<Blog> getBlogPosts();
    
}