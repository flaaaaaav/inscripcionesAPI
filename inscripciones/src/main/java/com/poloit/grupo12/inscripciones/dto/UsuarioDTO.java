package com.poloit.grupo12.inscripciones.dto;

import java.util.Date;

public class UsuarioDTO {

    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNacimiento;
    private Long rolId;  // ID del rol

    // Constructor vacío
    public UsuarioDTO() {}

    // Constructor con parámetros
    public UsuarioDTO(String nombre, String apellido, String email, Date fechaNacimiento, Long rolId) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.rolId = rolId;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }
}
