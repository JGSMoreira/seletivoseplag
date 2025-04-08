package br.jgsm.seletivoSeplag.modules.servidorefetivo;

import br.jgsm.seletivoSeplag.modules.pessoa.Pessoa;
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
@Table(name = "servidor_temporario")
public class ServidorEfetivo {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "st_id", nullable = false, columnDefinition = "INT")
    private int id;

    @Column(name = "se_matricula", nullable = false, columnDefinition = "VARCHAR(20)")
    private String matricula;

    @ManyToOne
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    private Pessoa pessoa;
}
