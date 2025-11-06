package org.projetos.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CommetDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private String texto;
    private Date date;
    private AuthorDTO author;

    public CommetDTO() {}

    public CommetDTO(String texto, Date date, AuthorDTO author) {
        this.texto = texto;
        this.date = date;
        this.author = author;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

}
