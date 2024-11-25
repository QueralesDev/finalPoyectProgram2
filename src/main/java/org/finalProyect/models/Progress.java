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
    public Progress(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.progressPercentage = calculateProgressPercentage();
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    @JsonProperty("courseName") // Solo serializar el nombre del curso
    public String getCourseName() {
        return course != null ? course.getName() : null;
    }

    public double getProgressPercentage() {
        return progressPercentage;
    }

    public void setProgressPercentage(double progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

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

    public void show() {
        this.progressPercentage = calculateProgressPercentage();
        System.out.println("El progreso del estudiante " + student.getName() + " en el curso " + course.getName() + " es del " + progressPercentage + "%");
    }

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
