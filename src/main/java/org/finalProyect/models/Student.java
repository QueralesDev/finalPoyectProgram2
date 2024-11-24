package org.finalProyect.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.finalProyect.enums.Level;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends AbstractPerson {
    private Level level;
    @JsonManagedReference
    private List<Progress> progresses;

/**
 * Constructor por defecto de la clase Student
 */
public Student() {
        super();
        this.progresses = new ArrayList<>();
    }

/**
 * Constructor con parámetros de la clase Student
 * @param name Nombre del estudiante
 * @param lastName Apellido del estudiante
 * @param dni DNI del estudiante
 * @param email Email del estudiante
 * @param level Nivel del estudiante
 */
public Student(String name, String lastName, String dni, String email, Level level) {
        super(name, lastName, dni, email);
        setLevel(level);
        this.progresses = new ArrayList<>();
    }

/**
 * Obtiene el nivel del estudiante
 * @return Nivel del estudiante
 */
public Level getLevel() {
        return level;
    }

/**
 * Establece el nivel del estudiante
 * @param level Nivel a establecer
 * @throws IllegalArgumentException si el nivel es nulo
 */
public void setLevel(Level level) {
        if (level == null) {
            throw new IllegalArgumentException("El nivel no puede estar vacío");
        }
        this.level = level;
    }

/**
 * Obtiene la lista de progresos del estudiante
 * @return Lista de progresos del estudiante
 */
public List<Progress> getProgresses() {
        return progresses;
    }

/**
 * Añade un progreso a la lista de progresos del estudiante
 * @param progress Progreso a añadir
 */
public void addProgress(Progress progress) {
        if (this.progresses == null) {
            this.progresses = new ArrayList<>();
        }
        this.progresses.add(progress);
    }

/**
 * Establece la lista de progresos del estudiante
 * @param progresses Lista de progresos a establecer
 * @throws IllegalArgumentException si la lista de progresos es nula
 */
public void setProgresses(List<Progress> progresses) {
        if (progresses == null) {
            throw new IllegalArgumentException("La lista de progresos no puede estar vacía");
        }
        this.progresses = progresses;
    }

/**
 * Muestra los progresos del estudiante
 */
public void showStudentProgress() {
        System.out.println("Progresos del estudiante " + this.getName() + ":");
        for (Progress progress : this.getProgresses()) {
            Course course = progress.getCourse();

            // Verificar si el estudiante está inscrito en el curso
            if (course.getEnrolledStudents().contains(this)) {
                System.out.println("Curso: " + course.getName() + ", Progreso: " + progress.getProgressPercentage() + "%");
            }
        }
    }



/**
 * Muestra la información del estudiante, incluyendo su nivel y progresos.
 */
@Override
public void show() {
        super.show();
        System.out.println("level.................: " + level);
        showStudentProgress();
        System.out.println("________________________________________________________________________");
    }
/**
 * Devuelve una representación en forma de cadena del estudiante
 * @return Representación en forma de cadena del estudiante
 */
@Override
public String toString() {
    return "level=" + level +
            ", progresses=" + progresses +
            "} " + super.toString();
    }

/**
 * Compara este estudiante con otro objeto para ver si son iguales
 * @param o El objeto a comparar
 * @return true si los objetos son iguales, false de lo contrario
 */
@Override
public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId());
    }

/**
 * Calcula el código hash del estudiante
 * @return Código hash del estudiante
 */
@Override
public int hashCode() {
        return Objects.hash(getId());
    }
}
