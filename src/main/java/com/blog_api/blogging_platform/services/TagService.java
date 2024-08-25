package com.blog_api.blogging_platform.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog_api.blogging_platform.entities.Tag;
import com.blog_api.blogging_platform.repositories.TagRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class TagService implements TagServiceImpl {

    @Autowired
    private TagRepository tagRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Tag> findAll() {
        return (List<Tag>) tagRepository.findAll();
    }
}
