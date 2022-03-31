package br.com.lucas.acervo.controller;

import br.com.lucas.acervo.dto.LivroDTO;
import br.com.lucas.acervo.dto.LivroMapper;
import br.com.lucas.acervo.model.Livro;
import br.com.lucas.acervo.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/livro")
public class LivroController {

    private final LivroService livroService;

    @PostMapping("/")
    public ResponseEntity<Livro> postLivro(@RequestBody Livro livro) {
        Livro livroSalvo = livroService.criaLivro(livro);
        return new ResponseEntity<>(livroSalvo, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<Livro>> getAllLivros() {
        List<Livro> livros = livroService.buscaTodosLivros();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivroById(@PathVariable Long id) {
        Livro livro = livroService.buscaLivroPorId(id);
        return new ResponseEntity<>(livro, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        livroService.deletaLivro(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> deleteLivro(@PathVariable Long id, @RequestBody Livro livro) {
        Livro livroAlterado = livroService.alteraLivro(id, livro);
        return new ResponseEntity<>(livroAlterado, HttpStatus.OK);
    }

}
