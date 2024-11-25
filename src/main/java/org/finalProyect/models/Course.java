package org.finalProyect.models;

import org.finalProyect.enums.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

 /**
 * Clase que representa un curso, que contiene un nombre, nivel,
 * lista de materiales didácticos, estudiantes inscritos y clases.
 */
public class Course {
    private String name;
    private Level level;
    private List<DidacticMaterial> didacticMaterialList;
    private List<Student> enrolledStudents;
    private List<Clase> clases;

    /**
    * Constructor por defecto que inicializa las listas de materiales didácticos,
    * estudiantes inscritos y clases.
    */
    public Course(){
        this.didacticMaterialList = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
        this.clases = new ArrayList<>(10);
    }

    /**
    * Constructor que inicializa un curso con un nivel específico.
    * `@param` level El nivel del curso
    */
    public Course(Level level){
        setLevel(level);
        this.didacticMaterialList = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
        this.clases = new ArrayList<>(10);
    }

    /**
    * Constructor que inicializa un curso con nombre y nivel específico.
    * `@param` name El nombre del curso
    * `@param` level El nivel del curso
    */
    public Course(String name, Level level) {
        setName(name);
        setLevel(level);
        this.didacticMaterialList = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
        this.clases = new ArrayList<>();
    }

    /**
    * Obtiene el nombre del curso.
    * `@return` el nombre del curso
    */
    public String getName() {
        return name;
    }

    /**
    * Establece el nombre del curso.
    * `@param` name El nombre del curso
    */
    public void setName(String name) {
        // Validar que el nombre no sea nulo o vacio
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre del curso no puede estar vacio");
        }
        this.name = name;
    }

    /**
    * Obtiene el nivel del curso.
    * `@return` el nivel del curso
    */
    public Level getLevel() {
        return level;
    }

    /**
    * Establece el nivel del curso.
    * `@param` level El nivel del curso
    */
    public void setLevel(Level level) {
        // Validar que el nivel no sea nulo sino lanzar una excepcion
        if (level == null) {
            throw new IllegalArgumentException("EL nivel no puede ser nulo");
        }
        this.level = level;
    }

    /**
    * Obtiene la lista de clases del curso.
    * `@return` la lista de clases
    */
    public List<Clase> getClases(){
        return clases;
    }

    /**
    * Agrega una clase a la lista de clases del curso.
    * `@param` clase La clase a agregar
    */
    public void addClass(Clase clase){
        // Validar que la clase no sea nula sino lanzar una excepcion
        if(clase == null){
            throw new IllegalArgumentException("La clase no puede ser nulo");
        }
        this.clases.add(clase);
    }

    /**
    * Obtiene la lista de materiales didácticos del curso.
    * `@return` la lista de materiales didácticos
    */
    public List<DidacticMaterial> getDidacticMaterialList() {
        return didacticMaterialList;
    }

    /**
    * Agrega un material didáctico a la lista del curso.
    * `@param` material El material didáctico a agregar
    */
    public void addDidacticMaterial(DidacticMaterial material) {
        // Validar que el material didactico no sea nulo sino lanzar una excepcion
        if (material == null) {
            throw new IllegalArgumentException("El material didactico no puede ser nulo");
        }
        this.didacticMaterialList.add(material);
    }

    /**
    * Agrega un estudiante a la lista de estudiantes inscritos en el curso.
    * `@param` student El estudiante a agregar
    */
    public void addStudent(Student student) {
        // Validar que el estudiante no sea nulo sino lanzar una excepcion
        if (student == null) {
            throw new IllegalArgumentException("Student no puede ser nulo");
        }
        // Validar que el estudiante no este inscrito en el curso para evitar duplicados
        if (this.enrolledStudents.contains(student)) {
            throw new IllegalArgumentException("Student ya esta inscrito en el curso");
        }
        this.enrolledStudents.add(student);
    }

    /**
    * Establece la lista de clases del curso.
    * `@param` clases La lista de clases
    * `@return` el curso con la lista de clases actualizada
   */
   public Course setClases(List<Clase> clases) {
       this.clases = clases;
        return this;
    }

    /**
    * Establece la lista de materiales didácticos del curso.
    * `@param` didacticMaterialList La lista de materiales didácticos
    * `@return` el curso con la lista de materiales didácticos actualizada
    */
    public Course setDidacticMaterialList(List<DidacticMaterial> didacticMaterialList) {
        this.didacticMaterialList = didacticMaterialList;
        return this;
    }

    /**
    * Obtiene la lista de estudiantes inscritos en el curso.
    * `@return` la lista de estudiantes inscritos
    */
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    /**
    * Establece la lista de estudiantes inscritos en el curso.
    * `@param` enrolledStudents La lista de estudiantes inscritos
    * `@return` el curso con la lista de estudiantes inscritos actualizada
    */
    public Course setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
        return this;
    }

    /**
    * Muestra la información del curso junto con sus materiales didácticos y clases.
    */
    public void show(){
        System.out.println("______________________________________________________________________________");
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Curso>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println("Nombre............................: " + name);
        System.out.println("Nivel.............................: " + level);
        didacticMaterialList.forEach(DidacticMaterial::show);
        clases.forEach(Clase::show);
        System.out.println("______________________________________________________________________________");
    }

    /**
    * Compara este curso con otro objeto para ver si son iguales.
    * `@param` o El objeto a comparar
    * `@return` true si los objetos son iguales, false de lo contrario
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name) && level == course.level;
    }

    /**
    * Calcula el código hash para el curso basado en el nombre y nivel.
    * `@return` el código hash del curso
    */
    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }
}