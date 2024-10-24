package org.finalProyect;

import org.finalProyect.enums.Level;
import org.finalProyect.enums.TypeSpeciality;
import org.finalProyect.management.ManagementSystem;
import org.finalProyect.models.Student;
import org.finalProyect.models.Teacher;
import org.finalProyect.utilities.GeneratorJson;

import java.util.Scanner;

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
            System.out.println("\n---------------- Sistema de Gestión de Clases de Música ------------");
            System.out.println("1. Gestionar Estudiantes");
            System.out.println("2. Gestionar Profesores");
            System.out.println("3. Gestionar Cursos");
            System.out.println("4. Gestionar Clases");
            System.out.println("5. Gestionar Evaluaciones y Progresos");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1": showStudentMenu(); break;
                case "2": showTeacherMenu(); break;
                case "3": showCourseMenu(); break;
                case "4": showClassMenu(); break;
                case "5": showEvaluationProgressMenu(); break;
                case "6": System.out.println("Saliendo..."); return;
                default: System.out.println("Opción inválida. Inténtelo nuevamente.");
            }
        }
    }

    private void showStudentMenu() {
        while (true) {
            System.out.println("\n--- Gestión de Estudiantes ---");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Listar Estudiantes");
            System.out.println("3. Buscar Estudiante");
            System.out.println("4. Actualizar Estudiante");
            System.out.println("5. Eliminar Estudiante");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Elija una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1": createStudent(); break;
                case "2": listStudents(); break;
                case "3": searchStudent(); break;
                case "4": updateStudent(); break;
                case "5": deleteStudent(); break;
                case "6": return;
                default: System.out.println("Opción inválida. Inténtelo nuevamente.");
            }
        }
    }

    private void showTeacherMenu() {
        while (true) {
            System.out.println("\n--- Gestión de Profesores ---");
            System.out.println("1. Agregar Profesor");
            System.out.println("2. Listar Profesores");
            System.out.println("3. Buscar Profesor");
            System.out.println("4. Actualizar Profesor");
            System.out.println("5. Eliminar Profesor");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Elija una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1": createTeacher(); break;
                case "2": listTeachers(); break;
                case "3": searchTeacher(); break;
                case "4": updateTeacher(); break;
                case "5": deleteTeacher(); break;
                case "6": return;
                default: System.out.println("Opción inválida. Inténtelo nuevamente.");
            }
        }
    }

    private void showCourseMenu() {
        while (true) {
            System.out.println("\n--- Gestión de Cursos ---");
            System.out.println("1. Agregar Curso");
            System.out.println("2. Listar Cursos");
            System.out.println("3. Buscar Curso");
            System.out.println("4. Actualizar Curso");
            System.out.println("5. Eliminar Curso");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Elija una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1": addCourse(); break;
                case "2": listCourses(); break;
                case "3": searchCourse(); break;
                case "4": updateCourse(); break;
                case "5": deleteCourse(); break;
                case "6": return;
                default: System.out.println("Opción inválida. Inténtelo nuevamente.");
            }
        }
    }

    private void showClassMenu() {
        while (true) {
            System.out.println("\n--- Gestión de Clases ---");
            System.out.println("1. Agregar Clase");
            System.out.println("2. Listar Clases");
            System.out.println("3. Buscar Clase");
            System.out.println("4. Actualizar Clase");
            System.out.println("5. Eliminar Clase");
            System.out.println("6. Asignar Estudiante a Clase");
            System.out.println("7. Volver al Menú Principal");
            System.out.print("Elija una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1": addClass(); break;
                case "2": listClasses(); break;
                case "3": searchClass(); break;
                case "4": updateClass(); break;
                case "5": deleteClass(); break;
                case "6": assignStudentToClass(); break;
                case "7": return;
                default: System.out.println("Opción inválida. Inténtelo nuevamente.");
            }
        }
    }

    private void showEvaluationProgressMenu() {
        while (true) {
            System.out.println("\n--- Gestión de Evaluaciones y Progresos ---");
            System.out.println("1. Generar Evaluación");
            System.out.println("2. Mostrar Evaluaciones");
            System.out.println("3. Mostrar Progresos");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Elija una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1": generateEvaluation(); break;
                case "2": showEvaluations(); break;
                case "3": showProgress(); break;
                case "4": return;
                default: System.out.println("Opción inválida. Inténtelo nuevamente.");
            }
        }
    }

    // Métodos CRUD para Estudiantes
    private void createStudent() {
        System.out.print("Ingrese el nombre: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Ingrese el apellido: ");
        String lastName = scanner.nextLine().trim();
        System.out.print("Ingrese el DNI: ");
        String dni = scanner.nextLine().trim();
        System.out.print("Ingrese el email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Enter level (PRINCIPIANTE, INTERMEDIO, AVANZADO): ");
        String levelStr = scanner.nextLine().trim();

        try {
            Level level = Level.valueOf(levelStr.toUpperCase());
            Student student = new Student(firstName, lastName, dni, email, level);
            managementSystem.addStudent(student);
            System.out.println("Estudiante creado: ");
            student.show();
        } catch (IllegalArgumentException e) {
            System.out.println("Nivel invalido. Use: PRINCIPIANTE, INTERMEDIO, or AVANZADO.");
        }
    }

    private void listStudents() {
        managementSystem.getStudents().forEach(Student::show);
    }

    private void searchStudent() {
        System.out.print("Ingrese el DNI del estudiante que desea buscar: ");
        String dni = scanner.nextLine().trim();
        managementSystem.getStudents().stream()
                .filter(s -> s.getDni().equalsIgnoreCase(dni))
                .forEach(Student::show);
    }
    private void updateStudent() {
        System.out.print("Ingrese el DNI del estudiante que desea actualizar: ");
        String dni = scanner.nextLine().trim();
        Student student = managementSystem.getStudents().stream()
                .filter(s -> s.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if (student == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.print("Ingrese el nuevo nombre (actual: " + student.getName() + "): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) student.setName(newName);

        System.out.print("Ingrese el nuevo apellido (actual: " + student.getLastName() + "): ");
        String newLastName = scanner.nextLine().trim();
        if (!newLastName.isEmpty()) student.setLastName(newLastName);

        System.out.print("Ingrese el nuevo apellido (actual: " + student.getEmail() + "): ");
        String newEmail = scanner.nextLine().trim();
        if (!newEmail.isEmpty()) student.setEmail(newEmail);

        System.out.println("Estudiante actualizado.");
    }

    private void deleteStudent() {
        System.out.print("Ingrese el DNI del estudiante que desea eliminar: ");
        String dni = scanner.nextLine().trim();
        Student student = managementSystem.getStudents().stream()
                .filter(s -> s.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if (student == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        managementSystem.getStudents().remove(student);
        System.out.println("Estudiante Eliminado.");
    }

    // Métodos CRUD para Profesores
    private void createTeacher() {
        System.out.print("Ingrese el nombre: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Ingrese el apellido: ");
        String lastName = scanner.nextLine().trim();
        System.out.print("Ingrese el DNI: ");
        String dni = scanner.nextLine().trim();
        System.out.print("Ingrese el email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Ingrese la Especialidad");
        String specialityStr = scanner.nextLine().trim();

        try {
            TypeSpeciality speciality = TypeSpeciality.valueOf(specialityStr.toUpperCase());
            Teacher teacher = new Teacher(firstName, lastName, dni, email, speciality);
            managementSystem.addTeacher(teacher);
            System.out.println("Profesor creado: ");
            teacher.show();
        } catch (IllegalArgumentException e) {
            System.out.println("Especialidad invalida.");
        }
    }

    private void listTeachers() {
        managementSystem.getTeachers().forEach(Teacher::show);
    }

    private void searchTeacher() {
        System.out.print("Ingrese el DNI del profesor que desea buscar: ");
        String dni = scanner.nextLine().trim();
        managementSystem.getTeachers().stream()
                .filter(s -> s.getDni().equalsIgnoreCase(dni))
                .forEach(Teacher::show);
    }

    private void updateTeacher() {
        System.out.print("Ingrese el DNI del profesor que desea actualizar: ");
        String dni = scanner.nextLine().trim();
        Teacher teacher = managementSystem.getTeachers().stream()
                .filter(s -> s.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if (teacher == null) {
            System.out.println("Profesor no encontrado.");
            return;
        }

        System.out.print("Ingrese el nuevo nombre (actual: " + teacher.getName() + "): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) teacher.setName(newName);

        System.out.print("Ingrese el nuevo apellido (actual: " + teacher.getLastName() + "): ");
        String newLastName = scanner.nextLine().trim();
        if (!newLastName.isEmpty()) teacher.setLastName(newLastName);

        System.out.print("Ingrese el nuevo apellido (actual: " + teacher.getEmail() + "): ");
        String newEmail = scanner.nextLine().trim();
        if (!newEmail.isEmpty()) teacher.setEmail(newEmail);

        System.out.println("Profesor actualizado.");
    }

    private void deleteTeacher() {
        //Similar a deleteStudents()
    }

    // Métodos CRUD para Cursos
    private void addCourse() {
        // Similar a addStudent()
    }

    private void listCourses() {
        // Similar a listStudents()
    }

    private void searchCourse() {
        // Similar a searchStudent()
    }

    private void updateCourse() {
        // Similar a updateStudent()
    }

    private void deleteCourse() {
        // Similar a deleteStudent()
    }

    // Métodos CRUD para Clases
    private void addClass() {
        // Similar a addStudent()
    }

    private void listClasses() {
        // Similar a listStudents()
    }

    private void searchClass() {
        // Similar a searchStudent()
    }

    private void updateClass() {
        // Similar a updateStudent()
    }

    private void deleteClass() {
        // Similar a deleteStudent()
    }

    private void assignStudentToClass() {
        // Implementar funcionalidad para asignar estudiante a clase
    }

    // Métodos para Evaluaciones y Progresos
    private void generateEvaluation() {
        // Implementar funcionalidad para generar evaluación
    }

    private void showEvaluations() {
        // Implementar funcionalidad para mostrar evaluaciones
    }

    private void showProgress() {
        // Implementar funcionalidad para mostrar progresos
    }
}

