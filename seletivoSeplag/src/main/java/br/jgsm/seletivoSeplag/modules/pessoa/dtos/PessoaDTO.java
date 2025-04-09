package br.jgsm.seletivoSeplag.modules.pessoa.dtos;

import java.time.LocalDate;
import java.util.List;

import br.jgsm.seletivoSeplag.modules.endereco.dtos.EnderecoDTO;
import br.jgsm.seletivoSeplag.modules.lotacao.dtos.LotacaoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PessoaDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Sexo é obrigatório")
    private String sexo;

    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate dataNascimento;

    private String mae;

    private String pai;

    List<@Valid LotacaoDTO> lotacoes;

    List<@Valid EnderecoDTO> enderecos;

}
