package com.blog_api.blogging_platform.services;

import java.util.List;

import com.blog_api.blogging_platform.entities.Tag;

public interface TagServiceImpl {
    List<Tag> findAll();
}
