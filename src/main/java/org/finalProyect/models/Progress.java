package org.finalProyect.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Random;

@JsonIgnoreProperties({"student", "course"})
public class Progress {
    @JsonBackReference
    private Student student;
    private Course course;
    private double progressPercentage;

    public Progress(){

    }
    /**
     * Constructor de la clase Progress.
     * @param student El estudiante relacionado con el progreso.
     * @param course El curso relacionado con el progreso.
     */
    public Progress(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.progressPercentage = calculateProgressPercentage();
    }

    /**
     * Obtiene el estudiante asociado con el progreso.
     * @return El estudiante.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Obtiene el curso asociado con el progreso.
     * @return El curso.
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Obtiene el nombre del curso para la serialización JSON.
     * @return El nombre del curso o null si el curso es null.
     */
    @JsonProperty("courseName")
    public String getCourseName() {
        return course != null ? course.getName() : null;
    }

    /**
     * Obtiene el porcentaje de progreso.
     * @return El porcentaje de progreso.
     */
    public double getProgressPercentage() {
        return progressPercentage;
    }

    /**
     * Establece el porcentaje de progreso.
     * @param progressPercentage El nuevo porcentaje de progreso.
     */
    public void setProgressPercentage(double progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    /**
     * Calcula el porcentaje de progreso con base en las clases asistidas.
     * @return El porcentaje de progreso calculado.
     */
    private double calculateProgressPercentage() {
        int totalClasses = course.getClases().size();
        int attendedClasses = 0;

        for (Clase clase : course.getClases()) {
            if (clase.getEnrolledStudents().contains(student)) {
                attendedClasses++;
            }
        }

        return (totalClasses > 0) ? ((double) attendedClasses / totalClasses) * 100 : 0;
    }

    /**
     * Muestra el progreso del estudiante en el curso.
     */
    public void show() {
        this.progressPercentage = calculateProgressPercentage();
        System.out.println("El progreso del estudiante " + student.getName() + " en el curso " + course.getName() + " es del " + progressPercentage + "%");
    }

    /**
     * Retorna una representación en cadena del objeto Progress.
     * @return Una cadena que representa el progreso.
     */
    @Override
    public String toString() {
        return "Progress{" +
                "student=" + student +
                ", course=" + course +
                ", progressPercentage=" + progressPercentage +
                '}';
    }

    public static String getRandomCourse() {
        // Lista de cursos
        String[] courses = {
                "Introducción al Piano Clásico",
                "Fundamentos de la Guitarra Jazz",
                "Teoría Musical Avanzada",
                "Lecciones de Violín para Principiantes",
                "Técnicas de Batería Rock",
                "Guitarra Flamenca para Principiantes",
                "Práctica Intermedia de Saxofón",
                "Dominando el Clarinete",
                "Fundamentos de Composición de Canciones",
                "Interpretación de Clavecín Barroco",
                "Percusión para Principiantes",
                "Composición Musical con Piano",
                "Técnicas Vocales Avanzadas",
                "Improvisación para Músicos de Jazz",
                "Arpa Celta para Principiantes",
                "Producción de Música Electrónica",
                "Composición de Canciones Pop",
                "Introducción a la Dirección Musical",
                "Interpretación de Cuarteto de Cuerdas",
                "Composición y Armonización para Cine"
        };

        // Generar un índice aleatorio
        Random random = new Random();
        int index = random.nextInt(courses.length);

        // Devolver el curso correspondiente
        return courses[index];
    }
}
