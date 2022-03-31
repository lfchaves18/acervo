package br.com.lucas.acervo.dto;

import br.com.lucas.acervo.model.Livro;
import lombok.Data;

import java.util.Set;

@Data
public class AutorDTO {

    private String nome;
    private String nacionalidade;
}
