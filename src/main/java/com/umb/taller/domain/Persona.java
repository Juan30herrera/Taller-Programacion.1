package com.umb.taller.domain;

/**
 * Abstract representation of a person in the university system.
 * This class demonstrates abstraction and encapsulation by defining
 * common data and an abstract behavior without implementing details.
 */
public abstract class Persona {

    // ENCAPSULAMIENTO: Private attributes and controlled access.
    private String nombre;
    private String correo;

    public Persona(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Shows general information of the person.
     * Each subclass provides its own implementation.
     */
    public abstract String mostrarInformacion();
}
