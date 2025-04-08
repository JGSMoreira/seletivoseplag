package br.jgsm.seletivoSeplag.modules.pessoa.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PessoaDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

}
