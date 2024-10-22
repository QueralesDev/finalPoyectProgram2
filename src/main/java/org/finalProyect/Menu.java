package org.finalProyect;

import com.fasterxml.jackson.core.JsonGenerator;
import org.finalProyect.enums.Level;
import org.finalProyect.enums.TypeSpeciality;
import org.finalProyect.management.ManagementSystem;
import org.finalProyect.models.Course;
import org.finalProyect.models.Student;
import org.finalProyect.models.Teacher;
import org.finalProyect.utilities.GeneratorJson;

import java.util.Scanner;
import java.util.UUID;

public class Menu {
    private GeneratorJson generatorJson;
    private ManagementSystem managementSystem;
    private Scanner scanner;


    public Menu() {
        this.generatorJson = new GeneratorJson();
        generatorJson.generateStudents(5);
        generatorJson.generateTeachers(5);
        generatorJson.generateCourses(5);
        this.managementSystem = new ManagementSystem();
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n--- Sistema de Clases de Musica Online ---");
            System.out.println("1. Add Student (Manual)");
            System.out.println("2. Add Teacher (Manual)");
            System.out.println("3. Add Course (Manual)");
            System.out.println("4. List Students");
            System.out.println("5. List Teachers");
            System.out.println("6. List Courses");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String option = scanner.nextLine();
            try {
                switch (option) {
                    case "1":
                        addStudent();
                        break;
                    case "2":
                        addTeacher();
                        break;
                    case "3":
                        addCourse();
                        break;
                    case "4":
                        listStudents();
                        break;
                    case "5":
                        listTeachers();
                        break;
                    case "6":
                        listCourses();
                        break;
                    case "7":
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Metodo para agregar un estudiante manualmente
    private void addStudent() {
        System.out.print("Enter student first name: ");
        String firstName = scanner.nextLine().trim();
        if (firstName.isEmpty()) {
            System.out.println("First name cannot be empty.");
            return;
        }

        System.out.print("Enter student last name: ");
        String lastName = scanner.nextLine().trim();
        if (lastName.isEmpty()) {
            System.out.println("Last name cannot be empty.");
            return;
        }

        System.out.print("Enter DNI (numeric): ");
        String dni = scanner.nextLine().trim();
        if (!dni.matches("\\d+")) {
            System.out.println("DNI must be a numeric value.");
            return;
        }

        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        if (!email.contains("@")) {
            System.out.println("Invalid email format.");
            return;
        }

        System.out.print("Ingrese Nivel (PRINCIPIANTE, INTERMEDIO, AVANZADO)");
        String levelStr = scanner.nextLine().trim();
        try {
            Level level = Level.valueOf(levelStr.toUpperCase());
            Student student = new Student(firstName, lastName, dni, email, level);
            managementSystem.addStudent(student);
            System.out.println("Estudiante Agregado: " + student.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid level input. Please use: PRINCIPIANTE, INTERMEDIO or AVANZADO.");
        }
    }

    // MEtodo para agregar un profesor manualmente
    private void addTeacher() {
        System.out.print("Enter teacher first name: ");
        String firstName = scanner.nextLine().trim();
        if (firstName.isEmpty()) {
            System.out.println("First name cannot be empty.");
            return;
        }

        System.out.print("Enter teacher last name: ");
        String lastName = scanner.nextLine().trim();
        if (lastName.isEmpty()) {
            System.out.println("Last name cannot be empty.");
            return;
        }

        System.out.print("Enter DNI (numeric): ");
        String dni = scanner.nextLine().trim();
        if (!dni.matches("\\d+")) {
            System.out.println("DNI must be a numeric value.");
            return;
        }

        System.out.print("Enter email: ");
        String email = scanner.nextLine().trim();
        if (!email.contains("@")) {
            System.out.println("Invalid email format.");
            return;
        }

        System.out.print("Enter speciality (e.g., VIOLIN, PIANO, GUITAR): ");
        String specialityStr = scanner.nextLine().trim();
        try {
            TypeSpeciality speciality = TypeSpeciality.valueOf(specialityStr.toUpperCase());
            Teacher teacher = new Teacher(firstName, lastName, dni, email, speciality);
            managementSystem.addTeacher(teacher);
            System.out.println("Teacher added: " + teacher.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid speciality input. Please check the available options.");
        }
    }

    // Metodo para agregar un curso manualmente
    private void addCourse() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine().trim();
        if (courseName.isEmpty()) {
            System.out.println("Course name cannot be empty.");
            return;
        }

        System.out.print("Enter course level (BEGINNER, INTERMEDIATE, ADVANCED): ");
        String levelStr = scanner.nextLine().trim();
        try {
            Level level = Level.valueOf(levelStr.toUpperCase());
            Course course = new Course(courseName, level);
            managementSystem.addCourse(course);
            System.out.println("Course added: " + course.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid level input. Please use: BEGINNER, INTERMEDIATE, or ADVANCED.");
        }
    }

    // Metodo para listar estudiantes
    private void listStudents() {
        System.out.println("Listing all students:");
        managementSystem.getStudents().forEach(s -> System.out.println(s.getName() + " " + s.getLastName()));
    }

    // Metodo para listar profesores
    private void listTeachers() {
        System.out.println("Listing all teachers:");
        managementSystem.getTeachers().forEach(t -> System.out.println(t.getName() + " " + t.getLastName()));
    }

    // Metodo para listar cursos
    private void listCourses() {
        System.out.println("Listing all courses:");
        managementSystem.getCourses().forEach(c -> System.out.println(c.getName()));
    }
}

