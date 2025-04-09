package br.jgsm.seletivoSeplag.modules.lotacao;

import java.util.Date;

import br.jgsm.seletivoSeplag.modules.crud.CrudEntity;
import br.jgsm.seletivoSeplag.modules.pessoa.Pessoa;
import br.jgsm.seletivoSeplag.modules.unidade.Unidade;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "lotacao")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "lot_id", nullable = false, columnDefinition = "INT"))
public class Lotacao extends CrudEntity {

    @Column(name = "lot_data_lotacao", nullable = false, columnDefinition = "DATE")
    private Date dataLotacao;
    
    @Column(name = "lot_data_remocao", nullable = true, columnDefinition = "DATE")
    private Date dataRemocao;

    @Column(name = "lot_portaria", nullable = true, columnDefinition = "VARCHAR(100)")
    private String portaria;

    @ManyToOne
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "unid_id", referencedColumnName = "unid_id")
    private Unidade unidade;
}
