package com.umb.taller.domain;

/**
 * Represents a subject with an associated teacher.
 * This class demonstrates association between Asignatura and Docente.
 * It is cohesive because it keeps subject attributes and relationships together.
 */
public class Asignatura {

    private String nombre;
    private int creditos;
    private Docente docente;

    public Asignatura(String nombre, int creditos, Docente docente) {
        this.nombre = nombre;
        this.creditos = creditos;
        this.docente = docente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String mostrarInformacion() {
        String docenteInfo = docente != null ? docente.mostrarInformacion() : "No hay docente asignado";
        return "Asignatura: " + nombre + " | Creditos: " + creditos + "\n" +
               "  Docente asociado -> " + docenteInfo;
    }
}
