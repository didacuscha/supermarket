package com.codecademy.goldmedal.repository;

import com.codecademy.goldmedal.model.Country;
import com.codecademy.goldmedal.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
    List<Usuario> getAllByOrderByNombreAsc();
    List<Usuario> getAllByOrderByNombreDesc();
    List<Usuario> getAllByOrderByRolAsc();
    List<Usuario> getAllByOrderByRolDesc();
    List<Usuario> getAllByOrderByEmailAsc();
    List<Usuario> getAllByOrderByEmailDesc();
    List<Usuario> getAllByOrderByTelefonoAsc();
    List<Usuario> getAllByOrderByTelefonoDesc();
    Optional<Usuario> getByNombre(String nombre);
    Optional<Usuario> getByEmail(String email);
}
