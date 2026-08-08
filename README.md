# UMB Programming Workshop - Session 1

This project is a simple Java application designed for the Universidad Manuela Beltrán programming workshop. It demonstrates the first session requirements using object-oriented programming principles in a minimal university system model.

## Project Purpose

The project aims to illustrate key object-oriented programming pillars through a small academic domain. It includes abstract person types, student and teacher specializations, courses, and subjects. The example is intentionally simple so it can be explained clearly during a lab presentation.

## Technologies Used

- Java 21
- Maven
- Standard Java collections
- No external libraries or unnecessary dependencies

## Project Structure

- `pom.xml` - Maven build configuration for Java 21.
- `src/main/java/com/umb/taller/Main.java` - Main entry point demonstrating the program flow.
- `src/main/java/com/umb/taller/domain/Persona.java` - Abstract base class for common person data and behavior.
- `src/main/java/com/umb/taller/domain/Estudiante.java` - Student subclass with academic attributes.
- `src/main/java/com/umb/taller/domain/Docente.java` - Teacher subclass with specialization.
- `src/main/java/com/umb/taller/domain/Asignatura.java` - Subject class associated with a teacher.
- `src/main/java/com/umb/taller/domain/Curso.java` - Course class representing a group and associated students.

## OOP Pillars Demonstrated

1. Abstraction: `Persona` defines shared attributes and an abstract method without implementing details.
2. Encapsulation: Private fields with getters and setters are used throughout domain classes.
3. Inheritance: `Estudiante` and `Docente` inherit from `Persona`.
4. Polymorphism: `Persona` references store `Estudiante` and `Docente` objects and call overridden methods.
5. Association: `Asignatura` is associated with `Docente`, and `Curso` is associated with `Asignatura` and multiple `Estudiante` objects.
6. Cohesion: Each class has a focused responsibility, such as managing personal data, academic assignments, or course membership.

## How to Run the Project

1. Ensure Java 21 is installed.
2. Open a terminal in the project root directory.
3. Use Maven:
   - `mvn compile`
   - `mvn exec:java -Dexec.mainClass="com.umb.taller.Main"`

Alternatively, run the `Main` class from your IDE.

## Notes

The project is intentionally simple to meet the workshop session 1 requirements and avoid more advanced topics reserved for later sessions.
