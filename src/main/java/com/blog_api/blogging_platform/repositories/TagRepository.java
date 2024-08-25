package com.blog_api.blogging_platform.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.blog_api.blogging_platform.entities.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {
    Optional<Tag> findByName(String name);

}
