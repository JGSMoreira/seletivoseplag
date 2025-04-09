package br.jgsm.seletivoSeplag.modules.pessoaendereco;

import br.jgsm.seletivoSeplag.modules.crud.CrudEntity;
import br.jgsm.seletivoSeplag.modules.endereco.Endereco;
import br.jgsm.seletivoSeplag.modules.pessoa.Pessoa;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "pessoa_endereco")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "pes_end_id", nullable = false, columnDefinition = "INT"))
public class PessoaEndereco extends CrudEntity{
    
    @ManyToOne
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    private Pessoa pessoa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "end_id", referencedColumnName = "end_id")
    private Endereco endereco;
}
