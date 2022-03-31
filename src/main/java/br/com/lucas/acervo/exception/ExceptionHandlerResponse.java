package br.com.lucas.acervo.exception;

import lombok.var;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerResponse extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AutorNaoEncontradoException.class)
    public ResponseEntity<Object> handleAutorNaoEncontrado(AutorNaoEncontradoException ex, WebRequest request) {
        var status = HttpStatus.NOT_FOUND;
        CamposRetorno errorResponse = CamposRetorno.builder()
                .status(status.value())
                .erro("Não foi possível encontrar um(a) autor(a) com as descrições informadas, verifique novamente")
                .build();

        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<Object> handleLivroNaoEncontrado(LivroNaoEncontradoException ex, WebRequest request) {
        var status = HttpStatus.NOT_FOUND;
        CamposRetorno errorResponse = CamposRetorno.builder()
                .status(status.value())
                .erro("Não foi possível encontrar um livro com as descrições informadas, verifique novamente")
                .build();

        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(LivroJaExistenteException.class)
    public ResponseEntity<Object> handleLivroJaExistente(LivroJaExistenteException ex, WebRequest request) {
        var status = HttpStatus.CONFLICT;
        CamposRetorno errorResponse = CamposRetorno.builder()
                .status(status.value())
                .erro("Livro com as descrições informadas já existente no banco de dados")
                .build();

        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(AutorJaExistenteException.class)
    public ResponseEntity<Object> handleAutorJaExistente(AutorJaExistenteException ex, WebRequest request) {
        var status = HttpStatus.CONFLICT;
        CamposRetorno errorResponse = CamposRetorno.builder()
                .status(status.value())
                .erro("Autor com as descrições informadas já existente no banco de dados")
                .build();

        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), status, request);
    }
}
