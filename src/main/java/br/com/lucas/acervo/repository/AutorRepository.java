package br.com.lucas.acervo.repository;

import br.com.lucas.acervo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByNomeAndNacionalidade(String nome, String nacionalidade);
}
