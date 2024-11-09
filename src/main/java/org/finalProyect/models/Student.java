package org.finalProyect.models;

import org.finalProyect.enums.Level;

import java.util.ArrayList;
import java.util.List;

public class Student extends AbstractPerson {
    private Level level;
    private List<Progress> progresses;

    public Student() {
        super();
        this.progresses = new ArrayList<>();
    }

    public Student(String name, String lastName, String dni, String email, Level level) {
        super(name, lastName, dni, email);
        setLevel(level);
        this.progresses = new ArrayList<>();
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        if (level == null) {
            throw new IllegalArgumentException("El nivel no puede estar vacío");
        }
        this.level = level;
    }

    public List<Progress> getProgresses() {
        return progresses;
    }

    public void addProgress(Progress progress) {
        if (this.progresses == null) {
            this.progresses = new ArrayList<>();
        }
        this.progresses.add(progress);
    }

    public void setProgresses(List<Progress> progresses) {
        if (progresses == null) {
            throw new IllegalArgumentException("La lista de progresos no puede estar vacía");
        }
        this.progresses = progresses;
    }

    public void showStudentProgress() {
        System.out.println("Progresos del estudiante " + this.getName() + ":");
        for (Progress progress : this.getProgresses()) {
            System.out.println("Curso: " + progress.getCourse().getName() + ", Progreso: " + progress.getProgressPercentage() + "%");
        }
    }

    @Override
    public void show() {
        super.show();
        System.out.println("level.................: " + level);
        showStudentProgress();
        System.out.println("________________________________________________________________________");
    }

    @Override
    public String toString() {
        return "Student{" +
                "level=" + level +
                ", progresses=" + progresses +
                "} " + super.toString();
    }
}
