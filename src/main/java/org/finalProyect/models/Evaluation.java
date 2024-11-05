
package org.finalProyect.models;

public class Evaluation {
    private Student student;
    private Course course;
    private double calification;
    private String comment;

    public Evaluation(Student student, Course course, double calification, String comment) {
        setStudent(student);
        setCourse(course);
        setCalification(calification);
        setComment(comment);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("El campo estudiante no puede ser nulo");
        }
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("El campo Curso no puede ser nulo");
        }
        this.course = course;
    }

    public double getCalification() {
        return calification;
    }

    public void setCalification(double calification) {
        if (calification < 0 || calification > 10) {
            throw new IllegalArgumentException("La calificación debe estar entre 0 y 10");
        }
        this.calification = calification;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if (comment == null || comment.isEmpty()) {
            throw new IllegalArgumentException("El campo comentario no puede estar vacio");
        }
        this.comment = comment;
    }

    @Override
    public String toString() {
        return student.getName() + " ha recibido una calificacion de  " + calification + "/10 in " + " en el curso " + course.getName() + ": " + comment;
    }
}
