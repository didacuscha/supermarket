package com.codecademy.supermercado.controller;

import com.codecademy.supermercado.model.Usuario;
import com.codecademy.supermercado.repository.UsuarioRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControlador {
    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioControlador(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @GetMapping
    public String getAllUsuarios(Model model,
                                 @RequestParam(required = false) String searchName,
                                 @RequestParam(required = false) List<String> roles) {
        List<Usuario> usuarios;

        if (searchName != null && !searchName.isEmpty()) {
            usuarios = usuarioRepositorio.findByNombreContainingIgnoreCase(searchName);
        } else {
            usuarios = (List<Usuario>) usuarioRepositorio.findAll();
        }

        if (roles != null && !roles.isEmpty()) {
            usuarios = usuarios.stream()
                    .filter(u -> roles.contains(u.getRol()))
                    .collect(Collectors.toList());
        }

        long totalUsers = usuarioRepositorio.count();
        long clientCount = usuarioRepositorio.countByRol("Cliente");
        long providerCount = usuarioRepositorio.countByRol("Proveedor");
        long adminCount = usuarioRepositorio.countByRol("Administrador");
        long cajeroCount = usuarioRepositorio.countByRol("Cajero");

        model.addAttribute("usuarios", usuarios);
        model.addAttribute("searchName", searchName);
        model.addAttribute("selectedRoles", roles);
        model.addAttribute("allRoles", Arrays.asList("Cliente", "Proveedor", "Cajero", "Administrador"));

        model.addAttribute("totalUsers", totalUsers);
        model.addAttribute("clientCount", clientCount);
        model.addAttribute("providerCount", providerCount);
        model.addAttribute("adminCount", adminCount);
        model.addAttribute("cajeroCount", cajeroCount);

        return "usuarios-list";
    }

    /*
    @GetMapping
    public String getAllUsuarios(Model model) {
        List<Usuario> usuarios = (List<Usuario>) usuarioRepositorio.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios-list.html";
    }
    */
    // @GetMapping
    //public List<Usuario> getAllUsuarios() {
       // return (List<Usuario>) usuarioRepositorio.findAll();
    // }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioRepositorio.findById(id);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        Usuario usuario = usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario not found with id: " + id));

        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setRol(usuarioDetails.getRol());
        usuario.setEmail(usuarioDetails.getEmail());
        usuario.setTelefono(usuarioDetails.getTelefono());

        return usuarioRepositorio.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioRepositorio.deleteById(id);
    }

    @GetMapping("/byNombre/{nombre}")
    public Optional<Usuario> getUsuarioByNombre(@PathVariable String nombre) {
        return usuarioRepositorio.getByNombre(nombre);
    }

    @GetMapping("/byEmail/{email}")
    public Optional<Usuario> getUsuarioByEmail(@PathVariable String email) {
        return usuarioRepositorio.getByEmail(email);
    }
}
