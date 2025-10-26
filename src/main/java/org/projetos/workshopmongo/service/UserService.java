package org.projetos.workshopmongo.service;

import org.projetos.workshopmongo.domain.User;

import org.projetos.workshopmongo.repository.UserRepository;
import org.projetos.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
    public User findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuário " + id + " não encontrado"));
    }
}
