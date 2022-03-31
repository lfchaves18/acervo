package br.com.lucas.acervo.service;

import br.com.lucas.acervo.exception.AutorNaoEncontradoException;
import br.com.lucas.acervo.exception.LivroJaExistenteException;
import br.com.lucas.acervo.exception.LivroNaoEncontradoException;
import br.com.lucas.acervo.model.Autor;
import br.com.lucas.acervo.model.Livro;
import br.com.lucas.acervo.repository.AutorRepository;
import br.com.lucas.acervo.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public Livro criaLivro(Livro livro) {
        autorRepository.findById(livro.getAutor().getId()).orElseThrow(
                () -> new AutorNaoEncontradoException()
        );
        if(livroRepository.findByNomeAndGenero(livro.getNome(), livro.getGenero()) != null) throw new LivroJaExistenteException();

        return livroRepository.save(livro);
    }

    public List<Livro> buscaTodosLivros() {
        return livroRepository.findAll();
    }

    public Livro buscaLivroPorId(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new LivroNaoEncontradoException());
    }

    public void deletaLivro(Long id) {
        buscaLivroPorId(id);
        livroRepository.deleteById(id);
    }

    public Livro alteraLivro(Long id, Livro livroAlterado) {
        autorRepository.findById(livroAlterado.getAutor().getId()).orElseThrow(
                () -> new AutorNaoEncontradoException()
        );
        Livro livroASerAlterado = buscaLivroPorId(id);
        livroASerAlterado.setNome(livroAlterado.getNome());
        livroASerAlterado.setGenero(livroAlterado.getGenero());
        livroASerAlterado.setAutor(livroAlterado.getAutor());

        return livroRepository.save(livroASerAlterado);
    }
}
