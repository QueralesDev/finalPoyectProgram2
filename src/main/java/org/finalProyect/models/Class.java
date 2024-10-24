package org.finalProyect.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Class {
    private String name;
    private LocalDateTime date;
    private Teacher teacher;
    private List<Student> enrolledStudents;

    public Class(String name, LocalDateTime date, Teacher teacher) {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        if (date == null || date.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Fecha de clase invalida");
        }
        this.date = date;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        if (teacher == null) {
            throw new IllegalArgumentException("Teacher no puede ser nulo");
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
        this.enrolledStudents.add(student);
    }
}
