package com.blog_api.blogging_platform.services;

import java.util.List;
import java.util.Optional;

import com.blog_api.blogging_platform.entities.Blog;

public interface BlogService {

    List<Blog> findAll();

    Optional<Blog> findById(Long id);

    Blog save(Blog blog);

    Optional<Blog> update(Long id, Blog blog);

    void delete(Long id);
}
