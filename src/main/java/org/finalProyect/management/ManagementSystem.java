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

    /**
     * Constructor que inicializa el sistema de gestión, cargando los datos desde archivos.
     */
    public ManagementSystem() {
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.progresses = new ArrayList<>();
        this.fileDataManager = new FileDataManager();

        // Cargar los datos desde archivos al iniciar
        loadData();
    }

    /**
     * Guarda los datos de estudiantes, profesores y cursos en archivos.
     */
    public void saveData() {
        System.out.println("Estudiantes: " + students.size());
        System.out.println("Profesores: " + teachers.size());
        System.out.println("Cursos: " + courses.size());
        fileDataManager.saveToFile(STUDENTS_FILE, students);
        fileDataManager.saveToFile(TEACHERS_FILE, teachers);
        fileDataManager.saveToFile(COURSES_FILE, courses);
    }

    /**
     * Carga los datos de estudiantes, profesores y cursos desde archivos.
     */
    private void loadData() {
        this.students = fileDataManager.loadFromFile("students.json", Student.class);
        this.teachers = fileDataManager.loadFromFile("teachers.json", Teacher.class);
        this.courses = fileDataManager.loadFromFile("courses.json", Course.class);
    }

    /**
     * Agrega un nuevo estudiante al sistema y guarda los cambios.
     *
     * @param student El estudiante a agregar.
     * @throws IllegalArgumentException si el estudiante es nulo o ya existe.
     */
    public void addStudent(Student student) {
        if (student == null || students.contains(student)) {
            throw new IllegalArgumentException("Invalido o Estudiante duplicado");
        }
        students.add(student);
        saveData(); // Guardar cambios en archivo
        System.out.println("Estudiante Agregado: " + student.getName());
    }

    /**
     * Obtiene la lista de estudiantes.
     *
     * @return La lista de estudiantes.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Agrega un nuevo profesor al sistema y guarda los cambios.
     *
     * @param teacher El profesor a agregar.
     * @throws IllegalArgumentException si el profesor es nulo o ya existe.
     */
    public void addTeacher(Teacher teacher) {
        if (teacher == null || teachers.contains(teacher)) {
            throw new IllegalArgumentException("Invalido o Profesor duplicado");
        }
        teachers.add(teacher);
        saveData(); // Guardar cambios en archivo
        System.out.println("Profesor Agregado: " + teacher.getName());
    }

    /**
     * Obtiene la lista de profesores.
     *
     * @return La lista de profesores.
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Agrega un nuevo curso al sistema y guarda los cambios.
     *
     * @param course El curso a agregar.
     * @throws IllegalArgumentException si el curso es nulo o ya existe.
     */
    public void addCourse(Course course) {
        if (course == null || courses.contains(course)) {
            throw new IllegalArgumentException("Invalido o Curso duplicado");
        }
        courses.add(course);
        saveData(); // Guardar cambios en archivo
        System.out.println("Curso Agregado: " + course.getName());
    }

    /**
     * Obtiene la lista de cursos.
     *
     * @return La lista de cursos.
     */
    public List<Course> getCourses(){
        return courses;
    }

    /**
     * Genera datos simulados de progreso para los estudiantes en los cursos disponibles.
     */
    public void generateMockProgressData() {
        if (students.isEmpty() || courses.isEmpty()) {
            System.out.println("No se pueden generar progresos debido a que no hay estudiantes o cursos disponibles.");
            return;
        }
        
        ProgressGenerator generator = new ProgressGenerator();
        List<Progress> mockProgresses = generator.generateProgresses(students, courses);

        // Verificar si la lista de progresos está vacía
        if (mockProgresses.isEmpty()) {
            System.out.println("No se generó ningún progreso.");
        } else {
            System.out.println("Se generaron " + mockProgresses.size() + " progresos.");
        }
        // Asignar los progresos a los estudiantes
        for (Progress progress : mockProgresses) {
            Student student = progress.getStudent();
            // Verificar si el estudiante ya tiene el progreso para evitar duplicados
            if (!student.getProgresses().contains(progress)) {
                student.addProgress(progress);
                progresses.add(progress);
            }
        }
        // Guardar los estudiantes con sus progresos actualizados
        saveData();

    }

    /**
     * Obtiene la lista de progresos.
     *
     * @return La lista de progresos.
     */
    public List<Progress> getProgresses() {
        return progresses;
    }

    /**
     * Verifica si un DNI específico existe en un archivo JSON.
     *
     * @param filePath La ruta del archivo JSON.
     * @param dni El DNI a verificar.
     * @return {@code true} si el DNI existe, {@code false} en caso contrario.
     */
    public boolean doesDniExist(String filePath, String dni) {

        // Verificar si el dni esta vacio
        if (dni == null || dni.isEmpty()) {
            System.out.println("El DNI no puede estar vacío");
        }

        // Verificar si el dni es numérico
        if (!dni.matches("\\d+")) {
            System.out.println("El DNI debe ser numérico");
        }
        // Verificar si el dni ya existe en el archivo
        try (FileReader reader = new FileReader(filePath)) {
            JsonElement jsonElement = JsonParser.parseReader(reader);
            // Verificar si el archivo es un objeto
            if (jsonElement.isJsonArray()) {
                JsonArray jsonArray = jsonElement.getAsJsonArray();
                // Recorrer el array de objetos
                for (JsonElement element : jsonArray) {
                    // Verificar si el objeto tiene la propiedad dni
                    if (element.isJsonObject()) {
                        JsonObject jsonObject = element.getAsJsonObject();
                        // Verificar si el dni es igual al dni del objeto
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