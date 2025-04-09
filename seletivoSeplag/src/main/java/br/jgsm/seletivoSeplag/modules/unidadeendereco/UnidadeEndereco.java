package br.jgsm.seletivoSeplag.modules.unidadeendereco;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.jgsm.seletivoSeplag.modules.endereco.Endereco;
import br.jgsm.seletivoSeplag.modules.unidade.Unidade;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "unidade_endereco")
public class UnidadeEndereco {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "unid_end_id", nullable = false, columnDefinition = "INT")
    private int id;

    @ManyToOne
    @JoinColumn(name = "unid_id", referencedColumnName = "unid_id")
    private Unidade unidade;

    @JsonIgnoreProperties("unidade")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "end_id", referencedColumnName = "end_id")
    private Endereco endereco;
}
