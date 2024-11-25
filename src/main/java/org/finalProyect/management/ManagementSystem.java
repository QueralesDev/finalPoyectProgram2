package org.finalProyect.management;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.finalProyect.models.Course;
import org.finalProyect.models.Progress;
import org.finalProyect.models.Student;
import org.finalProyect.models.Teacher;
import org.finalProyect.utilities.FileDataManager;
import org.finalProyect.utilities.Generators.ProgressGenerator;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManagementSystem {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;
    private List<Progress> progresses;
    private FileDataManager fileDataManager;

    private static final String STUDENTS_FILE = "students.json";
    private static final String TEACHERS_FILE = "teachers.json";
    private static final String COURSES_FILE = "courses.json";

    public ManagementSystem() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.progresses = new ArrayList<>();
        this.fileDataManager = new FileDataManager();


        // Cargar los datos desde archivos al iniciar
        loadData();
        // Generar datos de progreso de forma aleatoria
//        generateMockProgressData();
    }

    // Guardar los datos en archivos JSON
    public void saveData() {
        System.out.println("Estudiantes: " + students.size());
        System.out.println("Profesores: " + teachers.size());
        System.out.println("Cursos: " + courses.size());
        fileDataManager.saveToFile(STUDENTS_FILE, students);
        fileDataManager.saveToFile(TEACHERS_FILE, teachers);
        fileDataManager.saveToFile(COURSES_FILE, courses);
    }


    // Cargar los datos desde archivos JSON
    private void loadData() {
        this.students = fileDataManager.loadFromFile("students.json", Student.class);
        this.teachers = fileDataManager.loadFromFile("teachers.json", Teacher.class);
        this.courses = fileDataManager.loadFromFile("courses.json", Course.class);
    }

    public void addStudent(Student student) {
        if (student == null || students.contains(student)) {
            throw new IllegalArgumentException("Invalido o Estudiante duplicado");
        }
        students.add(student);
        saveData(); // Guardar cambios en archivo
        System.out.println("Estudiante Agregado: " + student.getName());
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addTeacher(Teacher teacher) {
        if (teacher == null || teachers.contains(teacher)) {
            throw new IllegalArgumentException("Invalido o Profesor duplicado");
        }
        teachers.add(teacher);
        saveData(); // Guardar cambios en archivo
        System.out.println("Profesor Agregado: " + teacher.getName());
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addCourse(Course course) {
        if (course == null || courses.contains(course)) {
            throw new IllegalArgumentException("Invalido o Curso duplicado");
        }
        courses.add(course);
        saveData(); // Guardar cambios en archivo
        System.out.println("Curso Agregado: " + course.getName());
    }

    public List<Course> getCourses(){
        return courses;
    }

    public void generateMockProgressData() {
        if (students.isEmpty() || courses.isEmpty()) {
            System.out.println("No se pueden generar progresos debido a que no hay estudiantes o cursos disponibles.");
            return;
        }
        
        ProgressGenerator generator = new ProgressGenerator();
        List<Progress> mockProgresses = generator.generateProgresses(students, courses);

        if (mockProgresses.isEmpty()) {
            System.out.println("No se generó ningún progreso.");
        } else {
            System.out.println("Se generaron " + mockProgresses.size() + " progresos.");
        }

        for (Progress progress : mockProgresses) {
            Student student = progress.getStudent();
            if (!student.getProgresses().contains(progress)) { // Evitar duplicados
                student.addProgress(progress);
                progresses.add(progress);
            }
        }
        // Guardar los estudiantes con sus progresos actualizados
        saveData();

    }


    public List<Progress> getProgresses() {
        return progresses;
    }


    public boolean doesDniExist(String filePath, String dni) {

        // Verificar si el dni esta vacio
        if (dni == null || dni.isEmpty()) {
            System.out.println("El DNI no puede estar vacío");
        }

        // Verificar si el dni es numérico
        if (!dni.matches("\\d+")) {
            System.out.println("El DNI debe ser numérico");
        }

        try (FileReader reader = new FileReader(filePath)) {
            JsonElement jsonElement = JsonParser.parseReader(reader);

            if (jsonElement.isJsonArray()) {
                JsonArray jsonArray = jsonElement.getAsJsonArray();

                for (JsonElement element : jsonArray) {
                    if (element.isJsonObject()) {
                        JsonObject jsonObject = element.getAsJsonObject();
                        if (jsonObject.has("dni") && jsonObject.get("dni").getAsString().equals(dni)) {
                            return true;
                        }
                    }
                }
                return false;
            }

        } catch (IOException e) {
            System.out.println(".get = " + e.getMessage());
            return false;
        }
        return true;
    }

}




