package org.projetos.workshopmongo.service;

import org.projetos.workshopmongo.domain.User;

import org.projetos.workshopmongo.dto.UserDTO;
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
    public User insert(User obj) {
        return repo.insert(obj);
    }
    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(),objDTO.getName(),objDTO.getEmail());
    }
}
