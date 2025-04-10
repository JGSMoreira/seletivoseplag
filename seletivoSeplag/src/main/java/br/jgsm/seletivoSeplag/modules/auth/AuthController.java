package br.jgsm.seletivoSeplag.modules.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jgsm.seletivoSeplag.modules.auth.dtos.AuthRequestDTO;
import br.jgsm.seletivoSeplag.modules.jwt.JwtService;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequestDTO request) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getSenha())
        );

        UserDetails user = userDetailsService.loadUserByUsername(request.getUsuario());
        String token = jwtService.generateToken(user);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer "))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        String token = authHeader.substring(7);
        String username = jwtService.extractUsername(token);
        UserDetails user = userDetailsService.loadUserByUsername(username);

        if (!jwtService.isValid(token, user)) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        String newToken = jwtService.generateToken(user);
        return ResponseEntity.ok(Map.of("token", newToken));
    }
}

