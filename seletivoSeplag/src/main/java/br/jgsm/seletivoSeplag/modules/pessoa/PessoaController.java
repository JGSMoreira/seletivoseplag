package br.jgsm.seletivoSeplag.modules.pessoa;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jgsm.seletivoSeplag.modules.crud.CrudController;
import br.jgsm.seletivoSeplag.modules.crud.SpecificationBuilder;
import br.jgsm.seletivoSeplag.modules.pessoa.dtos.PessoaDTO;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/pessoa")
public class PessoaController extends CrudController<Pessoa, PessoaRepository, Specification<Pessoa>, PessoaDTO, PessoaMapper> {

    public PessoaController(PessoaRepository repository, PessoaMapper mapper, SpecificationBuilder<Pessoa> specBuilder) {
        this.repository = repository;
        this.mapper = mapper;
        this.specBuilder = specBuilder;
    }


    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        Pessoa pessoa = mapper.toEntity(pessoaDTO);
        return ResponseEntity.ok(repository.save(pessoa));
    }

}
