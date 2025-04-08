package br.jgsm.seletivoSeplag.modules.cidade;

import br.jgsm.seletivoSeplag.modules.crud.CrudEntity;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "cidade")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "cid_id", nullable = false, columnDefinition = "INT"))
public class Cidade extends CrudEntity{

    @Column(name = "cid_nome", nullable = false, columnDefinition = "VARCHAR(200)")
    private String nome;

    @Column(name = "cid_uf", nullable = false, columnDefinition = "VARCHAR(2)")
    private String uf;
}
