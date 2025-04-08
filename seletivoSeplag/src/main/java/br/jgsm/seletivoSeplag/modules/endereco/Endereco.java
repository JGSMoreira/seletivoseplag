package br.jgsm.seletivoSeplag.modules.endereco;

import br.jgsm.seletivoSeplag.modules.cidade.Cidade;
import br.jgsm.seletivoSeplag.modules.crud.CrudEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "endereco")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "end_id", nullable = false, columnDefinition = "INT"))
public class Endereco extends CrudEntity{
    
    @Column(name = "end_tipo_logradouro", nullable = false, columnDefinition = "VARCHAR(50)")
    private String tipoLogradouro;

    @Column(name = "end_logradouro", nullable = false, columnDefinition = "VARCHAR(200)")
    private String logradouro;

    @Column(name = "end_numero", nullable = false, columnDefinition = "INT")
    private int numero;

    @Column(name = "edn_bairro", columnDefinition = "VARCHAR(100)")
    private String bairro;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "cid_id", referencedColumnName = "cid_id")
    private Cidade cidade;

}
