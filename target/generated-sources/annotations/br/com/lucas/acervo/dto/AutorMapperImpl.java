package br.com.lucas.acervo.dto;

import br.com.lucas.acervo.model.Autor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-31T16:59:52-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_111 (Oracle Corporation)"
)
@Component
public class AutorMapperImpl implements AutorMapper {

    @Override
    public Autor toAutorEntity(AutorDTO AutorDTO) {
        if ( AutorDTO == null ) {
            return null;
        }

        Autor autor = new Autor();

        autor.setNome( AutorDTO.getNome() );
        autor.setNacionalidade( AutorDTO.getNacionalidade() );

        return autor;
    }

    @Override
    public AutorDTO toAutorDTO(Autor Autor) {
        if ( Autor == null ) {
            return null;
        }

        AutorDTO autorDTO = new AutorDTO();

        autorDTO.setNome( Autor.getNome() );
        autorDTO.setNacionalidade( Autor.getNacionalidade() );

        return autorDTO;
    }

    @Override
    public List<AutorDTO> autoresToAutoresDTO(List<Autor> autorDTOS) {
        if ( autorDTOS == null ) {
            return null;
        }

        List<AutorDTO> list = new ArrayList<AutorDTO>( autorDTOS.size() );
        for ( Autor autor : autorDTOS ) {
            list.add( toAutorDTO( autor ) );
        }

        return list;
    }
}
