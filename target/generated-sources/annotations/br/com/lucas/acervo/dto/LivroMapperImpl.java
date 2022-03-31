package br.com.lucas.acervo.dto;

import br.com.lucas.acervo.model.Livro;
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
public class LivroMapperImpl implements LivroMapper {

    @Override
    public Livro toLivroEntity(LivroDTO LivroDTO) {
        if ( LivroDTO == null ) {
            return null;
        }

        Livro livro = new Livro();

        livro.setNome( LivroDTO.getNome() );
        livro.setGenero( LivroDTO.getGenero() );
        livro.setAutor( LivroDTO.getAutor() );

        return livro;
    }

    @Override
    public LivroDTO toLivroDTO(Livro Livro) {
        if ( Livro == null ) {
            return null;
        }

        LivroDTO livroDTO = new LivroDTO();

        livroDTO.setNome( Livro.getNome() );
        livroDTO.setGenero( Livro.getGenero() );
        livroDTO.setAutor( Livro.getAutor() );

        return livroDTO;
    }

    @Override
    public List<LivroDTO> livrosToLivrosDTO(List<Livro> livros) {
        if ( livros == null ) {
            return null;
        }

        List<LivroDTO> list = new ArrayList<LivroDTO>( livros.size() );
        for ( Livro livro : livros ) {
            list.add( toLivroDTO( livro ) );
        }

        return list;
    }
}
