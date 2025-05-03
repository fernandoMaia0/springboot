package com.example.demo.services;

import java.util.Date;
import java.util.List;

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

    public List<Post> findByTitle(String text){
        // return repo.findByTitleContainingIgnoreCase(text);
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime()+24 * 60 * 60 * 1000);
        return repo.fullSearch(text,minDate,maxDate);
    }
}
