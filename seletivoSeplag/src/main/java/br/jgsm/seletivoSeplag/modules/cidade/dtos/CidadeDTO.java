package br.jgsm.seletivoSeplag.modules.cidade.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CidadeDTO {
    
    @NotBlank(message = "O nome da cidade é obrigatório")
    private String nome;

    @NotBlank(message = "A Unidade Federativa da cidade é obrigatória")
    private String uf;
}
