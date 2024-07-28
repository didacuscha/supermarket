package com.codecademy.goldmedal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String rol;

    private String email;

    private Long telefono;

    public Usuario() {}

    public Usuario(Usuario usuario) {
        this.nombre = usuario.getNombre();
        this.rol = usuario.getRol();
        this.email = usuario.getEmail();
        this.telefono = usuario.getTelefono();
    }

    // Constructor with all fields
    public Usuario(String nombre, String rol, String email, Long telefono) {
        this.nombre = nombre;
        this.rol = rol;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
}
