package org.projetos.workshopmongo.service;

import org.projetos.workshopmongo.domain.User;

import org.projetos.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;
    public List<User> findAll() {
        return repo.findAll();
    }
}
