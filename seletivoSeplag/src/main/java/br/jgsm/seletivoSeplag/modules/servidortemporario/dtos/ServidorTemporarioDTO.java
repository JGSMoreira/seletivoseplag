package br.jgsm.seletivoSeplag.modules.servidortemporario.dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import br.jgsm.seletivoSeplag.modules.pessoa.dtos.PessoaDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ServidorTemporarioDTO extends PessoaDTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Data de admissão é obrigatória")
    private Date dataAdmissao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataDemissao;

}
