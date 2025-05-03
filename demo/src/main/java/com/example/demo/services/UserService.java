package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findByID(String id){
        User user = repo.findById(id).orElse(null);
        if(user == null){
            throw new ObjectNotFoundException("Object not found");
        }
        return user;
    }

    public User insert (User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
        findByID(id);
        repo.deleteById(id);
    }

    public User update(User obj){
        User newObj = repo.findById(obj.getId()).orElse(null);
        updateDate(newObj,obj);
        return repo.save(newObj);
    }

    private void updateDate(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }
}
