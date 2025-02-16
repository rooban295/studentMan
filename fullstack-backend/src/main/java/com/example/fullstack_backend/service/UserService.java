package com.example.fullstack_backend.service;

import com.example.fullstack_backend.exception.UserNotFoundException;
import com.example.fullstack_backend.model.User;
import com.example.fullstack_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public ResponseEntity<User> addUser(User user) {

        return new ResponseEntity<>(repo.save(user), HttpStatus.ACCEPTED);
    }


    public List<User> getUser() {
       return repo.findAll();
    }

    public ResponseEntity<User> findUserById(long id) {
        return new ResponseEntity<>(
                repo.findById(id).orElseThrow(()->new UserNotFoundException(id)),
                HttpStatus.OK);
    }

    public ResponseEntity DeleteUserById(Long id) {
        if(!repo.findById(id).isPresent()){
            throw new UserNotFoundException(id);
        }
        repo.deleteById(id);
        return new ResponseEntity<>("Delete Successfully "+id ,HttpStatus.OK);
    }
}
