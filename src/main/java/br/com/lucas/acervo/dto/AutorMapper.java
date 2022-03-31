package br.com.lucas.acervo.dto;

import br.com.lucas.acervo.model.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    AutorMapper INSTANCE = Mappers.getMapper(AutorMapper.class);

    Autor toAutorEntity(AutorDTO AutorDTO);

    AutorDTO toAutorDTO(Autor Autor);

    List<AutorDTO> autoresToAutoresDTO(List<Autor> autorDTOS);

}
