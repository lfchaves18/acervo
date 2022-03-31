package br.com.lucas.acervo.controller;

import br.com.lucas.acervo.dto.AutorDTO;
import br.com.lucas.acervo.dto.AutorMapper;
import br.com.lucas.acervo.model.Autor;
import br.com.lucas.acervo.service.AutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/autor")
public class AutorController {

    private final AutorService autorService;
    private final AutorMapper autorMapper = AutorMapper.INSTANCE;

    @PostMapping("/")
    public ResponseEntity<Autor> postAutor(@RequestBody Autor autor) {
        autorService.criaAutor(autor);
        return new ResponseEntity<>(autor, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<AutorDTO>> getAllAutors() {
        List<Autor> autores = autorService.buscaTodosAutores();
        List<AutorDTO> autorsResponse = autorMapper.autoresToAutoresDTO(autores);
        return new ResponseEntity<>(autorsResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> getAutorById(@PathVariable Long id) {
        Autor autor = autorService.buscaAutorPorId(id);
        AutorDTO autorResponse = autorMapper.toAutorDTO(autor);
        return new ResponseEntity<>(autorResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        autorService.deletaAutor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> deleteAutor(@PathVariable Long id, @RequestBody AutorDTO AutorDTO) {
        Autor autor = autorMapper.toAutorEntity(AutorDTO);
        Autor autorAlterado = autorService.alteraAutor(id, autor);
        return new ResponseEntity<>(autorAlterado, HttpStatus.OK);
    }
}
