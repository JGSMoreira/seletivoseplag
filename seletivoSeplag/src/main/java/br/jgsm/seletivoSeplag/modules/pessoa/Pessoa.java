package br.jgsm.seletivoSeplag.modules.pessoa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.jgsm.seletivoSeplag.modules.crud.CrudEntity;
import br.jgsm.seletivoSeplag.modules.fotopessoa.FotoPessoa;
import br.jgsm.seletivoSeplag.modules.lotacao.Lotacao;
import br.jgsm.seletivoSeplag.modules.pessoaendereco.PessoaEndereco;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "pessoa")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "pes_id", nullable = false, columnDefinition = "INT"))
public class Pessoa extends CrudEntity{

    @Column(name = "pes_nome", nullable = false, columnDefinition = "VARCHAR(200)")
    private String nome;

    @Column(name = "pes_data_nascimento", nullable = true)
    private LocalDate dataNascimento;

    @Formula("DATE_PART('year', AGE(CURRENT_DATE, pes_data_nascimento))")
    private int idade;

    @Column(name = "pes_sexo", nullable = true, columnDefinition = "VARCHAR(9)")
    private String sexo;

    @Column(name = "pes_mae", nullable = true, columnDefinition = "VARCHAR(200)")
    private String mae;

    @Column(name = "pes_pai", nullable = true, columnDefinition = "VARCHAR(200)")
    private String pai;

    @JsonIgnoreProperties("pessoa")
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PessoaEndereco> pessoaEnderecos = new ArrayList<>();

    @JsonIgnoreProperties("pessoa")
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FotoPessoa> fotos = new ArrayList<>();

    @JsonIgnoreProperties("pessoa")
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lotacao> lotacoes = new ArrayList<>();

}
