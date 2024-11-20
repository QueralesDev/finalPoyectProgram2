package org.finalProyect.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clase {
    private String name;
    private String date;
    private Teacher teacher;
    private List<Student> enrolledStudents;

    public Clase() {
        this.enrolledStudents = new ArrayList<>();
    }

    public Clase(String name, String date, Teacher teacher) {
        setName(name);
        setDate(date);
        setTeacher(teacher);
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la clase no puede estar vacio");
        }
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date == null) {
            throw new IllegalArgumentException("La fecha de la clase no puede ser nula");
        }
        this.date = date;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        if (teacher == null) {
            throw new IllegalArgumentException("Profesor no puede ser nulo");
        }
        this.teacher = teacher;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student no puede ser nulo");
        }
        if (this.enrolledStudents.contains(student)) {
            System.out.println("El estudiante ya está inscrito en la clase.");
            return;
        }
        this.enrolledStudents.add(student);
    }

    public void show(){
        System.out.println("<<<<<<<<<<<<<<<<<Clase>>>>>>>>>>>>>>");
        System.out.println("Nombre.........................: " + name);
        System.out.println("Fecha de la clase..............: " + date);
        System.out.println("Profesor.......................: " + teacher.getName()+ " " + teacher.getLastName());
        System.out.println("Lista de Alumnos Inscritos : ");
        for (Student student : enrolledStudents) {
            System.out.println("Alumno............: " + student.getName() + " " + student.getLastName());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Detalles ").append(name).append("\n");
        sb.append("────────────────────────\n");
        sb.append("Date: ").append(date).append("\n");

        sb.append("Profesor:\n");
        if (teacher != null) {
            sb.append("  - Nombre: ").append(teacher.getName()).append("\n");
            sb.append("  - Especialidad: ").append(teacher.getSpeciality() != null ? teacher.getSpeciality() : "No disponible").append("\n");
            sb.append("  - Correo: ").append(teacher.getEmail() != null ? teacher.getEmail() : "No disponible").append("\n");
        } else {
            sb.append("  - No disponible\n");
        }

        return sb.toString();
    }

}