package br.jgsm.seletivoSeplag.modules.fotopessoa;

import java.util.Date;

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
@Table(name = "foto_pessoa")
public class FotoPessoa {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fp_data", nullable = false, columnDefinition = "DATE")
    private Date data;

    @Column(name = "fp_bucket", nullable = false, columnDefinition = "VARCHAR(50)")
    private String bucket;

    @Column(name = "fp_hash", nullable = false, columnDefinition = "VARCHAR(50)")
    private String hash;

    @ManyToOne
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    private Pessoa pessoa;
}
