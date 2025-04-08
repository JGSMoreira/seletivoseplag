package br.jgsm.seletivoSeplag.modules.endereco.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EnderecoDTO {
    
    @NotBlank(message = "Tipo de logradouro é obrigatório")
    private String tipoLogradouro;

    @NotBlank(message = "Logradouro é obrigatório")
    private String logradouro;

    @NotBlank(message = "Número é obrigatório")
    private int numero;

    private String bairro;
    
    Integer cidade;
}
