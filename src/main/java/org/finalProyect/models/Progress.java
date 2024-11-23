package org.finalProyect.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
}
