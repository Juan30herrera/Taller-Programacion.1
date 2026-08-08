package com.umb.taller.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a course section for a specific subject.
 * This class demonstrates association with Asignatura and Estudiante.
 * It keeps course responsibilities cohesive and focused.
 */
public class Curso {

    private String grupo;
    private Asignatura asignatura;
    private List<Estudiante> estudiantes;

    public Curso(String grupo, Asignatura asignatura) {
        this.grupo = grupo;
        this.asignatura = asignatura;
        this.estudiantes = new ArrayList<>();
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public List<Estudiante> getEstudiantes() {
        return new ArrayList<>(estudiantes);
    }

    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            estudiantes.add(estudiante);
        }
    }

    public String mostrarInformacion() {
        StringBuilder builder = new StringBuilder();
        builder.append("Curso: ").append(grupo).append("\n");
        builder.append("Asignatura: ").append(asignatura.getNombre()).append(" | Creditos: ").append(asignatura.getCreditos()).append("\n");
        builder.append("Docente: ").append(asignatura.getDocente().getNombre()).append("\n");
        builder.append("Estudiantes inscritos:\n");
        for (Estudiante estudiante : estudiantes) {
            builder.append("  - ").append(estudiante.mostrarInformacion()).append("\n");
        }
        return builder.toString();
    }
}
