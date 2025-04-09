package br.jgsm.seletivoSeplag.modules.lotacao.dtos;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LotacaoDTO {
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Data de Lotação não pode ser nulo")
    Date dataLotacao;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date dataRemocao;

    @NotBlank(message = "Portaria não pode ser nulo ou vazio")
    String portaria;

    @NotNull(message = "Unidade não pode ser nulo")
    Integer unidade;
}
