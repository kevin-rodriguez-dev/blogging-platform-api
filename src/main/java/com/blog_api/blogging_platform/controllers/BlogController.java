package com.blog_api.blogging_platform.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog_api.blogging_platform.entities.Blog;
import com.blog_api.blogging_platform.services.BlogService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<Blog> findAll() {
        return blogService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Optional<Blog> blogOptional = blogService.findById(id);

        return blogOptional.isPresent() ? ResponseEntity.ok(blogOptional.get())
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> createBlog(@Valid @RequestBody Blog blog, BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(blogService.save(blog));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBlog(@Valid @RequestBody Blog blog, BindingResult result, @PathVariable Long id) {
        Optional<Blog> blogOptional = blogService.update(id, blog);

        return blogOptional.isPresent() ? ResponseEntity.status(HttpStatus.CREATED).body(blogOptional.orElseThrow())
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable Long id) {
        blogService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}