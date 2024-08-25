package com.blog_api.blogging_platform.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog_api.blogging_platform.entities.Blog;
import com.blog_api.blogging_platform.entities.Tag;
import com.blog_api.blogging_platform.repositories.BlogRepository;
import com.blog_api.blogging_platform.repositories.TagRepository;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private TagRepository tagRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    @Transactional
    public Blog save(Blog blog) {
        List<Tag> tags = blog.getTags().stream()
                .map(tag -> tagRepository.findByName(tag.getName())
                        .orElseGet(() -> {
                            Tag newTag = new Tag();
                            newTag.setName(tag.getName());
                            return tagRepository.save(newTag);
                        }))
                .collect(Collectors.toList());
        blog.setTags(tags);
        return blogRepository.save(blog);
    }

    @Override
    @Transactional
    public Optional<Blog> update(Long id, Blog blog) {
        return blogRepository.findById(id)
                .map(b -> {
                    b.setTitle(blog.getTitle() != null ? blog.getTitle() : b.getTitle());
                    b.setContent(blog.getContent() != null ? blog.getContent() : b.getContent());
                    b.setAuthor(blog.getAuthor());
                    b.setCategory(blog.getCategory());

                    List<Tag> updatedTags = blog.getTags().stream()
                            .map(tag -> tagRepository.findByName(tag.getName())
                                    .orElseGet(() -> {
                                        Tag newTag = new Tag();
                                        newTag.setName(tag.getName());
                                        return tagRepository.save(newTag);
                                    }))
                            .collect(Collectors.toList());
                    b.setTags(updatedTags);

                    return blogRepository.save(b);
                });
    }

    @Override
    @Transactional
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

}