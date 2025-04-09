package br.jgsm.seletivoSeplag.modules.unidade.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UnidadeDTO {
    
    @NotBlank(message = "Nome não pode ser nulo ou vazio")
    String nome;

    @NotBlank(message = "Sigla não pode ser nulo ou vazio")
    String sigla;
}
