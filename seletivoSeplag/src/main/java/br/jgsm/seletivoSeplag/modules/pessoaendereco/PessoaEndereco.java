package br.jgsm.seletivoSeplag.modules.pessoaendereco;

import br.jgsm.seletivoSeplag.modules.endereco.Endereco;
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
@Table(name = "pessoa_endereco")
public class PessoaEndereco {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "pes_end_id", nullable = false, columnDefinition = "INT")
    private int id;

    @ManyToOne
    @JoinColumn(name = "pes_id", referencedColumnName = "pes_id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "end_id", referencedColumnName = "end_id")
    private Endereco endereco;
}
