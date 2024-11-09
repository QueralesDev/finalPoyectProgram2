
package org.finalProyect;

import org.finalProyect.enums.Level;
import org.finalProyect.enums.TypeMaterial;
import org.finalProyect.enums.TypeSpeciality;
import org.finalProyect.management.ManagementSystem;
import org.finalProyect.models.*;
import org.finalProyect.utilities.Generators.GeneratorJson;
import org.finalProyect.utilities.Generators.PersonGenerator;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private GeneratorJson generatorJson;
    private ManagementSystem managementSystem;
    private Scanner scanner;


    public Menu() throws IOException {
        this.generatorJson = new GeneratorJson();
        generatorJson.generateStudents(3);
        generatorJson.generateTeachers(5);
        generatorJson.generateCourses(20);
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
            System.out.println("1. Listar Cursos Disponibles");
            System.out.println("2. Listar Alumnos Inscritos en los Cursos");
            System.out.println("3. Listar Clases de Cada Curso");
            System.out.println("4. Buscar Curso");
            System.out.println("5. Eliminar Curso");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Elija una opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1": listCourses(); break;
                case "2": listEnrolledStudents(); break;
                case "3": listCourseClasses(); break;
                case "4": searchCourse(); break;
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
                case "1": createClass(); break;
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
        System.out.print("Ingrese el DNI del profesor que desea eliminar: ");
        String dni = scanner.nextLine().trim();
        Teacher teacher = managementSystem.getTeachers().stream()
                .filter(s -> s.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if (teacher == null) {
            System.out.println("Profesor no encontrado.");
            return;
        }

        managementSystem.getStudents().remove(teacher);
        System.out.println("Profesor Eliminado.");
    }

    // Métodos CRUD para Cursos
    private void createCourse() {
        System.out.print("Ingrese el nombre: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter level (PRINCIPIANTE, INTERMEDIO, AVANZADO): ");
        String levelStr = scanner.nextLine().trim();
        TypeMaterial[] typeMaterials = TypeMaterial.values();
        String[] plinks = {"https://cursosonline.com/video", "https://cursosonline.com/audio", "https://cursosonline.com/partitura"};
        TypeMaterial typeMaterial = TypeMaterial.valueOf(String.valueOf(typeMaterials[PersonGenerator.random.nextInt(typeMaterials.length)]));
        String links = plinks[PersonGenerator.random.nextInt(plinks.length)];

        try {
            Level level = Level.valueOf(levelStr.toUpperCase());
            Course course = new Course(firstName, level);
            course.addDidacticMaterial(new DidacticMaterial("Material", typeMaterial, links));
            managementSystem.addCourse(course);
            System.out.println("Curso creado: ");
            course.show();
        } catch (IllegalArgumentException e) {
            System.out.println("Nivel invalido. Use: PRINCIPIANTE, INTERMEDIO, or AVANZADO.");
        }
    }

    private void listCourses() {
        managementSystem.getCourses().forEach(Course::show);
    }

    private void listEnrolledStudents() {
        managementSystem.getCourses().forEach(course -> {
            System.out.println("Curso: " + course.getName());
            List<Student> enrolledStudents = course.getEnrolledStudents();
            System.out.println("Número de estudiantes inscritos: " + enrolledStudents.size());
            enrolledStudents.forEach(Student::show);
        });
    }

    private void listCourseClasses() {
        managementSystem.getCourses().forEach(course -> {
            System.out.println("Curso: " + course.getName());
            course.getClases().forEach(Clase::show);
        });
    }

    private void searchCourse() {
        String[] cursos = {
                "Introducción al Piano Clásico",
                "Fundamentos de la Guitarra Jazz",
                "Teoría Musical Avanzada",
                "Lecciones de Violín para Principiantes",
                "Técnicas de Batería Rock",
                "Guitarra Flamenca para Principiantes",
                "Práctica Intermedia de Saxofón",
                "Dominando el Clarinete",
                "Fundamentos de Composición de Canciones",
                "Interpretación de Clavecín Barroco",
                "Percusión para Principiantes",
                "Composición Musical con Piano",
                "Técnicas Vocales Avanzadas",
                "Improvisación para Músicos de Jazz",
                "Arpa Celta para Principiantes",
                "Producción de Música Electrónica",
                "Composición de Canciones Pop",
                "Introducción a la Dirección Musical",
                "Interpretación de Cuarteto de Cuerdas",
                "Composición y Armonización para Cine"
        };

        System.out.println("Seleccione el número del curso que desea buscar de la siguiente lista:");
        for (int i = 0; i < cursos.length; i++) {
            System.out.println((i + 1) + ". " + cursos[i]);
        }

        System.out.print("Ingrese el número del curso: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        // Validamos la opción ingresada
        if (opcion < 1 || opcion > cursos.length) {
            System.out.println("Opción inválida. Intente de nuevo.");
            return;
        }

        // Obtenemos el nombre del curso seleccionado
        String courseName = cursos[opcion - 1];

        // Buscamos el curso en el sistema de gestión
        managementSystem.getCourses().stream()
                .filter(s -> s.getName().equalsIgnoreCase(courseName))
                .forEach(Course::show);
    }


    private void updateCourse() {
        System.out.println("No tiene los permisos para modificar los cursos existentes");
    }

    private void deleteCourse() {
        System.out.println("No tiene los permisos para eliminar los cursos existentes");
        String[] cursos = {
                "Introducción al Piano Clásico",
                "Fundamentos de la Guitarra Jazz",
                "Teoría Musical Avanzada",
                "Lecciones de Violín para Principiantes",
                "Técnicas de Batería Rock",
                "Guitarra Flamenca para Principiantes",
                "Práctica Intermedia de Saxofón",
                "Dominando el Clarinete",
                "Fundamentos de Composición de Canciones",
                "Interpretación de Clavecín Barroco",
                "Percusión para Principiantes",
                "Composición Musical con Piano",
                "Técnicas Vocales Avanzadas",
                "Improvisación para Músicos de Jazz",
                "Arpa Celta para Principiantes",
                "Producción de Música Electrónica",
                "Composición de Canciones Pop",
                "Introducción a la Dirección Musical",
                "Interpretación de Cuarteto de Cuerdas",
                "Composición y Armonización para Cine"
        };

        System.out.println("Seleccione el número del curso de la lista que desea eliminar:");
        for (int i = 0; i < cursos.length; i++) {
            System.out.println((i + 1) + ". " + cursos[i]);
        }

        System.out.print("Ingrese el número del curso: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        // Validamos la opción ingresada
        if (opcion < 1 || opcion > cursos.length) {
            System.out.println("Opción inválida. Intente de nuevo.");
            return;
        }

        // Eliminamos el curso
        managementSystem.getCourses().remove(opcion - 1);
        System.out.println("Curso Eliminado.");

    }

    // Métodos CRUD para Clases
    private void createClass() {
        //similar al create students
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
