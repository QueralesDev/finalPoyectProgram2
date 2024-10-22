package org.finalProyect.management;

import com.fasterxml.jackson.core.type.TypeReference;
import org.finalProyect.models.Course;
import org.finalProyect.models.Student;
import org.finalProyect.models.Teacher;
import org.finalProyect.utilities.FileDataManager;

import java.util.ArrayList;
import java.util.List;

public class ManagementSystem {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;
    private FileDataManager fileDataManager;

    // Archivos para la persistencia
    private static final String STUDENTS_FILE = "students.json";
    private static final String TEACHERS_FILE = "teachers.json";
    private static final String COURSES_FILE = "courses.json";

    public ManagementSystem() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.fileDataManager = new FileDataManager();

        // Cargar los datos desde archivos al iniciar
        loadData();
    }

    // Guardar los datos en archivos JSON
    public void saveData() {
        fileDataManager.saveToFile(STUDENTS_FILE, students);
        fileDataManager.saveToFile(TEACHERS_FILE, teachers);
        fileDataManager.saveToFile(COURSES_FILE, courses);
    }

    // Cargar los datos desde archivos JSON
    private void loadData() {
        this.students = fileDataManager.loadFromFile(STUDENTS_FILE, new TypeReference<List<Student>>() {});
        this.teachers = fileDataManager.loadFromFile(TEACHERS_FILE, new TypeReference<List<Teacher>>() {});
        this.courses = fileDataManager.loadFromFile(COURSES_FILE, new TypeReference<List<Course>>() {});
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
}

