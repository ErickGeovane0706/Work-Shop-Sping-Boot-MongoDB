package org.projetos.workshopmongo;

import org.projetos.workshopmongo.domain.Post;
import org.projetos.workshopmongo.domain.User;
import org.projetos.workshopmongo.dto.AuthorDTO;
import org.projetos.workshopmongo.dto.CommetDTO;
import org.projetos.workshopmongo.repository.PostRepository;
import org.projetos.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
            userRepository.saveAll(Arrays.asList(maria,alex,bob));

        Post post1 = new Post(null,sdf.parse("21/03/2025"), "Partiu Viagem", "Vou Viajar para São Paulo. Abraços!",new AuthorDTO(maria));
        Post post2 = new Post(null,sdf.parse("23/03/2025"),"Bom dia","Acordei Feliz Hoje", new AuthorDTO(maria));
        CommetDTO c1 = new CommetDTO("Boa Viagem Mano",sdf.parse("21/03/2018"),new AuthorDTO(alex));
        CommetDTO c2 = new CommetDTO("Aproveite ",sdf.parse("22/03/2018"),new AuthorDTO(bob));
        CommetDTO c3 = new CommetDTO("Tenha um Otimo Dia",sdf.parse("23/03/2018"),new AuthorDTO(alex));

        post1.getCommets().addAll(Arrays.asList(c1,c2));
        post2.getCommets().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1,post2));
            maria.getPost().addAll(Arrays.asList(post1,post2));
            userRepository.save(maria);

    }
}
