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

    /**
    * Constructor predeterminado que inicializa una lista vacía de estudiantes inscritos.
    */
    public Clase() {
        this.enrolledStudents = new ArrayList<>();
    }

    /**
    * Constructor con parámetros para inicializar la clase con nombre, fecha y profesor.
    * `@param` name El nombre de la clase
    * `@param` date La fecha de la clase
    * `@param` teacher El profesor de la clase
    */
    public Clase(String name, String date, Teacher teacher) {
        setName(name);
        setDate(date);
        setTeacher(teacher);
        this.enrolledStudents = new ArrayList<>();
    }

    /**
    * Obtiene el nombre de la clase.
    * `@return` El nombre de la clase
    */
    public String getName() {
        return name;
    }

    /**
    * Establece el nombre de la clase.
    * Verifica que el nombre no sea nulo o vacío.
    * `@param` name El nombre de la clase
    */
    public void setName(String name) {
        //Verifica que el nombre no sea nulo o vacio
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la clase no puede estar vacio");
        }
        this.name = name;
    }

    /**
    * Obtiene la fecha de la clase.
    * `@return` La fecha de la clase
    */
    public String getDate() {
        return date;
    }

    /**
    * Establece la fecha de la clase.
    * Verifica que la fecha no sea nula.
    * `@param` date La fecha de la clase
    */
    public void setDate(String date) {
        //Verifica que la fecha no sea nula
        if (date == null) {
            throw new IllegalArgumentException("La fecha de la clase no puede ser nula");
        }
        this.date = date;
    }

    /**
    * Obtiene el profesor de la clase.
    * `@return` El profesor de la clase
    */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
    * Establece el profesor de la clase.
    * Verifica que el profesor no sea nulo.
    * `@param` teacher El profesor de la clase
    */
    public void setTeacher(Teacher teacher) {
        //Verifica que el profesor no sea nulo
        if (teacher == null) {
            throw new IllegalArgumentException("Profesor no puede ser nulo");
        }
        this.teacher = teacher;
    }

    /**
    * Obtiene la lista de estudiantes inscritos en la clase.
    * `@return` La lista de estudiantes inscritos
    */
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    /**
    * Añade un estudiante a la clase.
    * Verifica que el estudiante no sea nulo y que no esté duplicado.
    * `@param` student El estudiante a inscribir
    */
    public void addStudent(Student student) {
        //Verifica que el estudiante no sea nulo
        if (student == null) {
            throw new IllegalArgumentException("Student no puede ser nulo");
        }
        //Verifica que el estudiante no esté inscrito en la clase para evitar duplicados
        if (this.enrolledStudents.contains(student)) {
            System.out.println("El estudiante ya está inscrito en la clase.");
            return;
        }
        this.enrolledStudents.add(student);
    }

    /**
    * Muestra los detalles de la clase incluyendo los estudiantes inscritos.
    */
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

    /**
    * Devuelve una representación en cadena de la clase, incluyendo detalles del profesor y los estudiantes inscritos.
    * `@return` Una cadena con los detalles de la clase
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Detalles ").append(name).append("\n");
        sb.append("────────────────────────\n");
        sb.append("Date: ").append(date).append("\n");
        sb.append("Profesor:\n");
        //Verifica si el profesor no es nulo
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