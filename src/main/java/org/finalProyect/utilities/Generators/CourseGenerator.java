package org.finalProyect.utilities.Generators;

import org.finalProyect.enums.Level;
import org.finalProyect.models.Clase;
import org.finalProyect.models.Course;
import org.finalProyect.models.Student;
import org.finalProyect.utilities.JsonReader;

import java.io.IOException;
import java.util.*;

public class CourseGenerator {

    private DidacticMaterialGenerator didacticMaterialGenerator;
    private ClaseGenerator claseGenerator;
    private Level[] levels;
    private Random random;

    public CourseGenerator() {
        didacticMaterialGenerator = new DidacticMaterialGenerator();
        claseGenerator = new ClaseGenerator();
        levels = Level.values();
        random = new Random();
    }

    public Course createCourse() throws IOException {
        List<Student> students = JsonReader.readStudents("students.json");
        Level level = levels[random.nextInt(levels.length)];
        Course course = new Course(level);

        // Agrega material didáctico al curso
        course.addDidacticMaterial(didacticMaterialGenerator.createDidacticMaterial());

        // Crear un mapa para controlar el número de cursos a los que está asignado cada estudiante
        Map<Student, Integer> studentCourseCounts = new HashMap<>();
        for (Student student : students) {
            // Inicializa el contador de cursos asignados para cada estudiante en 0
            studentCourseCounts.put(student, 0);
        }

        // Selecciona un número aleatorio de estudiantes para inscribir en el curso
        int randomStudentCount = random.nextInt(students.size()) + 1;
        Set<Student> addedStudents = new HashSet<>();
        while (addedStudents.size() < randomStudentCount) {
            Student student = students.get(random.nextInt(students.size()));

            // Asegura que el estudiante no esté en más de 5 cursos
            int currentCount = studentCourseCounts.get(student);
            if (currentCount < 5 && !addedStudents.contains(student)) {
                course.addStudent(student);
                addedStudents.add(student);

                // Incrementa el contador de cursos para el estudiante
                studentCourseCounts.put(student, currentCount + 1);
            }
        }

        // Genera clases y asigna solo estudiantes inscritos en el curso
        List<Student> enrolledStudents = new ArrayList<>(course.getEnrolledStudents()); // lista de estudiantes inscritos en el curso
        for (int i = 0; i < 5; i++) {
            Clase clase = claseGenerator.createClase();
            int randomCount = random.nextInt(enrolledStudents.size()) + 1;
            for (int j = 0; j < randomCount; j++) {
                Student student = enrolledStudents.get(j);
                clase.addStudent(student); // solo estudiantes inscritos
            }
            course.addClass(clase);
        }

        return course;
    }


}