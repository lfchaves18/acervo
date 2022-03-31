package br.com.lucas.acervo.dto;

import br.com.lucas.acervo.model.Autor;
import lombok.Data;

@Data
public class LivroDTO {

    private String nome;
    private String genero;
    private Autor autor;
}
