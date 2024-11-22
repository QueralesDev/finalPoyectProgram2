package org.finalProyect.utilities.Generators;

import org.finalProyect.enums.Level;
import org.finalProyect.models.Clase;
import org.finalProyect.models.Course;
import org.finalProyect.models.Student;
import org.finalProyect.utilities.JsonReader;

import java.io.IOException;
import java.util.*;

public class CourseGenerator {
    private final DidacticMaterialGenerator didacticMaterialGenerator;
    private final ClaseGenerator claseGenerator;
    private final Level[] levels;
    private final Random random;
    private final Map<Student, Integer> studentCourseCounts;

    public CourseGenerator() {
        didacticMaterialGenerator = new DidacticMaterialGenerator();
        claseGenerator = new ClaseGenerator();
        levels = Level.values();
        random = new Random();
        studentCourseCounts = new HashMap<>(); // Inicializa aquí el mapa
    }

    public Course createCourse() throws IOException {
        List<Student> students = JsonReader.readStudents("students.json");

        if (students.isEmpty()) {
            throw new IllegalArgumentException("No hay estudiantes disponibles para inscribir en el curso.");
        }

        Level level = levels[random.nextInt(levels.length)];
        Course course = new Course(level);

        // Agregar material didáctico al curso
        course.addDidacticMaterial(didacticMaterialGenerator.createDidacticMaterial());

        // Inicializar contador de cursos por estudiante
        for (Student student : students) {
            studentCourseCounts.putIfAbsent(student, 0);
        }

        // Filtrar estudiantes elegibles (aquellos con menos de 5 cursos)
        List<Student> eligibleStudents = new ArrayList<>();
        for (Student student : students) {
            if (studentCourseCounts.get(student) < 5) {
                eligibleStudents.add(student);
            }
        }

        if (eligibleStudents.isEmpty()) {
            System.out.println("No hay estudiantes elegibles para asignar a este curso.");
            return course; // Retornamos el curso vacío si no hay estudiantes elegibles
        }

        // Mezclar estudiantes para evitar sesgos
        Collections.shuffle(eligibleStudents);

        // Garantizar al menos un estudiante en el curso
        Student initialStudent = eligibleStudents.get(0);
        course.addStudent(initialStudent);
        studentCourseCounts.put(initialStudent, studentCourseCounts.get(initialStudent) + 1);

        // Asignar estudiantes adicionales al curso
        int randomStudentCount = random.nextInt(eligibleStudents.size()) + 1; // Número aleatorio de estudiantes
        Set<Student> addedStudents = new HashSet<>();
        addedStudents.add(initialStudent); // Incluimos al estudiante inicial

        for (Student student : eligibleStudents) {
            if (addedStudents.size() >= randomStudentCount) {
                break; // Detenemos cuando alcanzamos el límite de estudiantes para este curso
            }

            if (!addedStudents.contains(student)) {
                course.addStudent(student);
                addedStudents.add(student);
                studentCourseCounts.put(student, studentCourseCounts.get(student) + 1);
            }
        }

        // Generar clases para el curso
        List<Student> enrolledStudents = new ArrayList<>(course.getEnrolledStudents());
        for (int i = 0; i < 10; i++) {
            Clase clase = claseGenerator.createClase();
            if (!enrolledStudents.isEmpty()) {
                int randomCount = random.nextInt(enrolledStudents.size()) + 1; // Mínimo 1 estudiante por clase
                Collections.shuffle(enrolledStudents);
                for (int j = 0; j < randomCount; j++) {
                    clase.addStudent(enrolledStudents.get(j));
                }
            }
            course.addClass(clase);
        }

        return course;
    }
}

