package com.example.demo.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Post;
import com.example.demo.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    
    @Autowired
    PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findByID(@PathVariable String id) {
        Post obj = service.findByID(id);
        return ResponseEntity.ok().body(obj);
    }
    
}
