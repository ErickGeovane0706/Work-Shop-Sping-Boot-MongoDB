package org.projetos.workshopmongo.service;

import org.projetos.workshopmongo.domain.Post;
import org.projetos.workshopmongo.domain.User;
import org.projetos.workshopmongo.dto.UserDTO;
import org.projetos.workshopmongo.repository.PostRepository;
import org.projetos.workshopmongo.repository.UserRepository;
import org.projetos.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository repo;


    public Post findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Post " + id + " não encontrado"));
    }

}
