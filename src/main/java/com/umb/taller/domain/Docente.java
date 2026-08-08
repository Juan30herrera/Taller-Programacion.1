package com.umb.taller.domain;

/**
 * Represents a teacher in the university system.
 * Inherits from Persona and adds a specialization field.
 * Demonstrates inheritance and polymorphism through shared Persona behavior.
 */
public class Docente extends Persona {

    // ENCAPSULAMIENTO: Teacher specialization is private and accessed by methods.
    private String especialidad;

    public Docente(String nombre, String correo, String especialidad) {
        super(nombre, correo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String mostrarInformacion() {
        return "Docente: " + getNombre() + " | Correo: " + getCorreo() +
               " | Especialidad: " + especialidad;
    }
}
