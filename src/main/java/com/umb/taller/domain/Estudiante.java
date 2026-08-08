package com.umb.taller.domain;

/**
 * Represents a student in the university system.
 * Inherits from Persona and adds academic attributes.
 * Demonstrates inheritance and polymorphism through shared Persona behavior.
 */
public class Estudiante extends Persona {

    // ENCAPSULAMIENTO: Student-specific private fields.
    private String codigo;
    private String carrera;

    public Estudiante(String nombre, String correo, String codigo, String carrera) {
        super(nombre, correo);
        this.codigo = codigo;
        this.carrera = carrera;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String mostrarInformacion() {
        return "Estudiante: " + getNombre() + " | Correo: " + getCorreo() +
               " | Codigo: " + codigo + " | Carrera: " + carrera;
    }
}
