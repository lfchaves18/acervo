package br.com.lucas.acervo.dto;

import br.com.lucas.acervo.model.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LivroMapper {

    LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);

    Livro toLivroEntity(LivroDTO LivroDTO);

    LivroDTO toLivroDTO(Livro Livro);

    List<LivroDTO> livrosToLivrosDTO(List<Livro> livros);
}
