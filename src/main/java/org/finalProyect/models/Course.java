package org.finalProyect.models;

import org.finalProyect.enums.Level;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private Level level;
    private List<DidacticMaterial> didacticMaterialList;
    private List<Student> enrolledStudents;
    private List<Clase> clases;

    public Course(){
        this.didacticMaterialList = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
        this.clases = new ArrayList<>(10);
    }

    public Course(Level level){
        setLevel(level);
        this.didacticMaterialList = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
        this.clases = new ArrayList<>(10);
    }

    public Course(String name, Level level) {
        setName(name);
        setLevel(level);
        this.didacticMaterialList = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
        this.clases = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre del curso no puede estar vacio");
        }
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        if (level == null) {
            throw new IllegalArgumentException("EL nivel no puede ser nulo");
        }
        this.level = level;
    }

    public List<Clase> getClases(){
        return clases;
    }

    public void addClass(Clase clase){
        if(clase == null){
            throw new IllegalArgumentException("La clase no puede ser nulo");
        }
        this.clases.add(clase);
    }

    public List<DidacticMaterial> getDidacticMaterialList() {
        return didacticMaterialList;
    }

    public void addDidacticMaterial(DidacticMaterial material) {
        if (material == null) {
            throw new IllegalArgumentException("El material didactico no puede ser nulo");
        }
        this.didacticMaterialList.add(material);
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student no puede ser nulo");
        }
        if (this.enrolledStudents.contains(student)) {
            throw new IllegalArgumentException("Student ya esta inscrito en el curso");
        }
        this.enrolledStudents.add(student);
    }

    public Course setClases(List<Clase> clases) {
        this.clases = clases;
        return this;
    }

    public Course setDidacticMaterialList(List<DidacticMaterial> didacticMaterialList) {
        this.didacticMaterialList = didacticMaterialList;
        return this;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Course setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
        return this;
    }

    public void show(){
        System.out.println("______________________________________________________________________________");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Curso>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Nombre............................: " + name);
        System.out.println("Nivel.............................: " + level);
        didacticMaterialList.forEach(DidacticMaterial::show);
        clases.forEach(Clase::show);
        System.out.println("______________________________________________________________________________");
    }
}