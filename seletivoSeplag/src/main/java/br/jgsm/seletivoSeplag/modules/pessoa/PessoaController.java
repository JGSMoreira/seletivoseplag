package br.jgsm.seletivoSeplag.modules.pessoa;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jgsm.seletivoSeplag.modules.crud.CrudController;
import br.jgsm.seletivoSeplag.modules.crud.SpecificationBuilder;
import br.jgsm.seletivoSeplag.modules.pessoa.dtos.PessoaDTO;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/pessoa")
public class PessoaController extends CrudController<Pessoa, PessoaRepository, Specification<Pessoa>, PessoaDTO, PessoaMapper> {

    public PessoaController(PessoaRepository repository, PessoaMapper mapper, SpecificationBuilder<Pessoa> specBuilder) {
        this.repository = repository;
        this.mapper = mapper;
        this.specBuilder = specBuilder;
    }

    @Override
    @PostMapping
    public ResponseEntity<Pessoa> criar(@RequestBody @Valid PessoaDTO dto) {
        throw new UnsupportedOperationException("Não é possível criar uma pessoa diretamente.");
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Integer id, @RequestBody @Valid PessoaDTO dto) {
        throw new UnsupportedOperationException("Não é possível atualizar uma pessoa diretamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        throw new UnsupportedOperationException("Não é possível deletar uma pessoa diretamente.");
    }
    
}
