package org.finalProyect.models;

import org.finalProyect.enums.Level;

import java.util.List;
import java.util.Random;

public class Student extends AbstractPerson {
    private Level level;
    private List<Progress> progresses;

    public Student(){
        super();

    }

    public Student(String name, String lastName, String dni, String email, Level level) {
        super(name, lastName, dni, email);
        setLevel(level);
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        if (level == null) {
            throw new IllegalArgumentException("El nivel no puede estar vacio");
        }
        this.level = level;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("level.................: " + level);
        System.out.println("________________________________________________________________________");
    }
}
