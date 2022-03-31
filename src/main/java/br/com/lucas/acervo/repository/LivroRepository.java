package br.com.lucas.acervo.repository;

import br.com.lucas.acervo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    Livro findByNomeAndGenero(String nome, String genero);
}
