package com.blog_api.blogging_platform.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.blog_api.blogging_platform.entities.Blog;

public interface BlogRepository extends CrudRepository<Blog, Long> {
    List<Blog> findByCategory(String category);
}
