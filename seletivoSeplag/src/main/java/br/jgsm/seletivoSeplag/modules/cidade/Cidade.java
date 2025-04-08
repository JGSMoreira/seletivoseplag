package br.jgsm.seletivoSeplag.modules.cidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "cid_id", nullable = false, columnDefinition = "INT")
    private int id;

    @Column(name = "cid_nome", nullable = false, columnDefinition = "VARCHAR(200)")
    private String nome;

    @Column(name = "cid_uf", nullable = false, columnDefinition = "VARCHAR(2)")
    private String uf;
}
