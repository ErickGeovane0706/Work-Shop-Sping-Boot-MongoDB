package org.projetos.workshopmongo.resources;

import org.projetos.workshopmongo.domain.Post;
import org.projetos.workshopmongo.domain.User;
import org.projetos.workshopmongo.dto.UserDTO;
import org.projetos.workshopmongo.service.PostService;
import org.projetos.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService service;

    @RequestMapping(value ="/{id}",method = RequestMethod.GET)
    public ResponseEntity<Post> findByid(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(new Post(obj));
    }

}
