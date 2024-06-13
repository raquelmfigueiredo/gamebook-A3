package org.example.controller;

import java.util.Optional;
import org.example.model.UsersLogin;
import org.example.model.Users;
import org.example.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsersController {

    @Autowired
    private UsersService usuarioService;

    @PostMapping("/logar")
    public ResponseEntity<UsersLogin> Autentication(@RequestBody Optional<UsersLogin> users){
        return usuarioService.Logar(users).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
    @PostMapping("/cadastrar")
    public ResponseEntity<Users> Post(@RequestBody Users usuario){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.CadastrarUsuario(usuario));
    }
}