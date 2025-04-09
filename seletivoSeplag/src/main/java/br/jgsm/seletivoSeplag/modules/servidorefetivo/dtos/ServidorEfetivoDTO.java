package br.jgsm.seletivoSeplag.modules.servidorefetivo.dtos;

import br.jgsm.seletivoSeplag.modules.pessoa.dtos.PessoaDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServidorEfetivoDTO extends PessoaDTO{
    
    @NotBlank(message = "Matrícula é obrigatória")
    private String matricula;

}
