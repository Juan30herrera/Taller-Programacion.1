package com.umb.taller;

import com.umb.taller.domain.Asignatura;
import com.umb.taller.domain.Curso;
import com.umb.taller.domain.Docente;
import com.umb.taller.domain.Estudiante;
import com.umb.taller.domain.Persona;

/**
 * Application entry point for Session 1 of the UMB programming workshop.
 */
public class Main {

    public static void main(String[] args) {
        // Create a teacher (Docente)
        Docente docente = new Docente("María López", "maria.lopez@umb.edu.co", "Ingeniería de Software");

        // Create students (Estudiante)
        Estudiante estudiante1 = new Estudiante("Carlos Pérez", "carlos.perez@umb.edu.co", "2021001", "Ingeniería de Sistemas");
        Estudiante estudiante2 = new Estudiante("Laura Gómez", "laura.gomez@umb.edu.co", "2021002", "Ingeniería de Sistemas");

        // Create subject and associate the teacher
        Asignatura asignatura = new Asignatura("Programación Orientada a Objetos", 4, docente);

        // Create course and associate the subject
        Curso curso = new Curso("Grupo A", asignatura);

        // Add students to the course
        curso.agregarEstudiante(estudiante1);
        curso.agregarEstudiante(estudiante2);

        // POLIMORFISMO: Use Persona references for different subclass instances.
        Persona personaDocente = docente;
        Persona personaEstudiante1 = estudiante1;
        Persona personaEstudiante2 = estudiante2;

        System.out.println("=== Información del docente ===");
        System.out.println(personaDocente.mostrarInformacion());

        System.out.println("\n=== Información de los estudiantes ===");
        System.out.println(personaEstudiante1.mostrarInformacion());
        System.out.println(personaEstudiante2.mostrarInformacion());

        System.out.println("\n=== Información completa del curso ===");
        System.out.println(curso.mostrarInformacion());

        // Show associations explicitly
        System.out.println("Asociación: La asignatura '" + asignatura.getNombre() + "' está enseñada por " + asignatura.getDocente().getNombre() + ".");
        System.out.println("Asociación: El curso '" + curso.getGrupo() + "' incluye " + curso.getEstudiantes().size() + " estudiantes.");
    }
}
