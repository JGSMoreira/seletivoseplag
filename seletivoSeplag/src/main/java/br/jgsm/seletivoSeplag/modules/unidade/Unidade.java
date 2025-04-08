package br.jgsm.seletivoSeplag.modules.unidade;

import java.util.List;

import br.jgsm.seletivoSeplag.modules.crud.CrudEntity;
import br.jgsm.seletivoSeplag.modules.unidadeendereco.UnidadeEndereco;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "unidade")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AttributeOverride(name = "id", column = @Column(name = "unid_id", nullable = false, columnDefinition = "INT"))
public class Unidade extends CrudEntity {

    @Column(name = "unid_nome", nullable = false, columnDefinition = "VARCHAR(200)")
    private String nome;

    @Column(name = "unid_sigla", nullable = false, columnDefinition = "VARCHAR(20)")
    private String sigla;

    @ManyToMany(mappedBy = "unidade")
    private List<UnidadeEndereco> unidadeEnderecos;
}
