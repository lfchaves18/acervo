package br.com.lucas.acervo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_autor")
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nacionalidade;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autor", fetch = FetchType.LAZY)
    private Set<Livro> livros = new HashSet<>();
}
