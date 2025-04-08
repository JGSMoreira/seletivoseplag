package br.jgsm.seletivoSeplag.modules.unidade;

import java.util.List;

import br.jgsm.seletivoSeplag.modules.unidadeendereco.UnidadeEndereco;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "unidade")
public class Unidade {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "unid_id", nullable = false, columnDefinition = "INT")
    private int id;

    @Column(name = "unid_nome", nullable = false, columnDefinition = "VARCHAR(200)")
    private String nome;

    @Column(name = "unid_sigla", nullable = false, columnDefinition = "VARCHAR(20)")
    private String sigla;

    @ManyToMany(mappedBy = "unidade")
    private List<UnidadeEndereco> unidadeEnderecos;
}
