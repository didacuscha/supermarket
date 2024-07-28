package com.codecademy.supermercado.repository;

import com.codecademy.supermercado.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
    Optional<Usuario> getByNombre(String nombre);
    Optional<Usuario> getByEmail(String email);

    long countByRol(String rol);

    @Query("SELECT COUNT(u) FROM Usuario u WHERE u.rol = 'Cajero' OR u.rol = 'Administrador'")
    long countEmployees();
}
