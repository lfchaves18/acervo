package br.com.lucas.acervo.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CamposRetorno {

    private Integer status;
    private String erro;
}
