package br.jgsm.seletivoSeplag.modules.servidortemporario;

import java.util.Date;

import br.jgsm.seletivoSeplag.modules.crud.CrudEntity;
import br.jgsm.seletivoSeplag.modules.pessoa.Pessoa;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "servidor_temporario")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "st_id", nullable = false, columnDefinition = "INT"))
public class ServidorTemporario extends CrudEntity {
    
    @Column(name = "st_data_admissao", nullable = false, columnDefinition = "DATE")
    private Date dataAdmissao;

    @Column(name = "st_data_demissao", nullable = true, columnDefinition = "DATE")
    private Date dataDemissao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    private Pessoa pessoa;
}
