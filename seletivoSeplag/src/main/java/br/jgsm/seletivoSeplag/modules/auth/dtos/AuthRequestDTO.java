package br.jgsm.seletivoSeplag.modules.auth.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthRequestDTO {
    
    @NotBlank(message = "Usuário é obrigatório")
    private String usuario;

    @NotBlank(message = "Senha é obrigatória")
    private String senha;
}
