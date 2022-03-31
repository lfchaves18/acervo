package br.com.lucas.acervo.service;

import br.com.lucas.acervo.exception.AutorJaExistenteException;
import br.com.lucas.acervo.exception.AutorNaoEncontradoException;
import br.com.lucas.acervo.model.Autor;
import br.com.lucas.acervo.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public Autor criaAutor(Autor autor) {
        if (autorRepository.findByNomeAndNacionalidade(autor.getNome(), autor.getNacionalidade()) != null) throw new AutorJaExistenteException();
        return autorRepository.save(autor);
    }

    public List<Autor> buscaTodosAutores() {
        return autorRepository.findAll();
    }

    public Autor buscaAutorPorId(Long id) {
        return autorRepository.findById(id).orElseThrow(() -> new AutorNaoEncontradoException());
    }

    public void deletaAutor(Long id) {
        buscaAutorPorId(id);
        autorRepository.deleteById(id);
    }

    public Autor alteraAutor(Long id, Autor novoAutor) {
        buscaAutorPorId(id);
        Autor autorASerAlterado = buscaAutorPorId(id);
        autorASerAlterado.setNome(novoAutor.getNome());
        autorASerAlterado.setNacionalidade(novoAutor.getNacionalidade());

        return autorRepository.save(autorASerAlterado);
    }
}
