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
        generateMockProgressData();
    }

    // Guardar los datos en archivos JSON
    public void saveData() {
        fileDataManager.saveToFile(STUDENTS_FILE, students);
        fileDataManager.saveToFile(TEACHERS_FILE, teachers);
        fileDataManager.saveToFile(COURSES_FILE, courses);
    }

    // Cargar los datos desde archivos JSON
    private void loadData() {
        this.students = fileDataManager.loadFromFile(STUDENTS_FILE, new TypeReference<List<Student>>() {
        });
        this.teachers = fileDataManager.loadFromFile(TEACHERS_FILE, new TypeReference<List<Teacher>>() {
        });
        this.courses = fileDataManager.loadFromFile(COURSES_FILE, new TypeReference<List<Course>>() {
        });
    }

    public void addStudent(Student student) {
        if (student == null || students.contains(student)) {
            throw new IllegalArgumentException("Invalid or duplicate student");
        }
        students.add(student);
        saveData(); // Guardar cambios en archivo
        System.out.println("Student added: " + student.getName());
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addTeacher(Teacher teacher) {
        if (teacher == null || teachers.contains(teacher)) {
            throw new IllegalArgumentException("Invalid or duplicate teacher");
        }
        teachers.add(teacher);
        saveData(); // Guardar cambios en archivo
        System.out.println("Teacher added: " + teacher.getName());
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addCourse(Course course) {
        if (course == null || courses.contains(course)) {
            throw new IllegalArgumentException("Invalid or duplicate course");
        }
        courses.add(course);
        saveData(); // Guardar cambios en archivo
        System.out.println("Course added: " + course.getName());
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void generateMockProgressData() {
        ProgressGenerator generator = new ProgressGenerator();
        List<Progress> mockProgresses = generator.generateProgresses(students, courses);
        for (Progress progress : mockProgresses) {
            Student student = progress.getStudent();
            student.addProgress(progress);
            progresses.add(progress);
        }
    }

    public List<Progress> getProgresses() {
        return progresses;
    }


    public boolean doesDniExist(String filePath, String dni) {
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




