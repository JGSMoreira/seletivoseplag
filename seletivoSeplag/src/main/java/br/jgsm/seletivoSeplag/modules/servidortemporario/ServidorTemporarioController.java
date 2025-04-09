package br.jgsm.seletivoSeplag.modules.servidortemporario;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jgsm.seletivoSeplag.modules.crud.CrudController;
import br.jgsm.seletivoSeplag.modules.crud.SpecificationBuilder;
import br.jgsm.seletivoSeplag.modules.servidortemporario.dtos.ServidorTemporarioDTO;

@RestController
@RequestMapping("/servidor-temporario")
public class ServidorTemporarioController extends CrudController<ServidorTemporario, ServidorTemporarioRepository, Specification<ServidorTemporario>, ServidorTemporarioDTO, ServidorTemporarioMapper> {

    public ServidorTemporarioController(ServidorTemporarioRepository repository, ServidorTemporarioMapper mapper, SpecificationBuilder<ServidorTemporario> specBuilder) {
        this.repository = repository;
        this.mapper = mapper;
        this.specBuilder = specBuilder;
    }

}
