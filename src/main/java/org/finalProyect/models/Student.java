package org.finalProyect.models;

import org.finalProyect.enums.Level;

public class Student extends AbstractPerson {

    private Level level;

    public Student(String name, String lastName, String dni, String email, Level level) {
        super(name, lastName, dni, email);
        this.level = level;
    }
}
