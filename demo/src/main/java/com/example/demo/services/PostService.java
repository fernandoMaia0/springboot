package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
    
    @Autowired
    private PostRepository repo;

    public Post findByID(String id){
        Post post = repo.findById(id).orElse(null);
        if(post == null){
            throw new ObjectNotFoundException("Post not found");
        }
        return post;
    }
}
