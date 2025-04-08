package br.jgsm.seletivoSeplag.modules.pessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.jgsm.seletivoSeplag.modules.pessoa.dtos.PessoaDTO;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaMapper pessoaMapper;

    @GetMapping
    public ResponseEntity<Page<Pessoa>> listarPessoas(Pageable pageable) {
        return ResponseEntity.ok(pessoaRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaMapper.toEntity(pessoaDTO);
        return ResponseEntity.ok(pessoaRepository.save(pessoa));
    }
    

}
