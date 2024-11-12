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

        // Verifica que haya estudiantes disponibles
        if (students.isEmpty()) {
            throw new IllegalArgumentException("No hay estudiantes disponibles para inscribir en el curso.");
        }

        Level level = levels[random.nextInt(levels.length)];
        Course course = new Course(level);

        // Agrega material didáctico al curso
        course.addDidacticMaterial(didacticMaterialGenerator.createDidacticMaterial());

        // Inicializa el conteo de cursos solo para estudiantes que aún no están en el mapa
        for (Student student : students) {
            studentCourseCounts.putIfAbsent(student, 0);
        }

        // Selecciona un número aleatorio de estudiantes para inscribir en el curso
        int randomStudentCount = random.nextInt(students.size()) + 1;
        Set<Student> addedStudents = new HashSet<>();
        List<Student> eligibleStudents = new ArrayList<>(students);

        while (addedStudents.size() < randomStudentCount && !eligibleStudents.isEmpty()) {
            Student student = eligibleStudents.get(random.nextInt(eligibleStudents.size()));

            // Asegura que el estudiante no esté en más de 5 cursos
            int currentCount = studentCourseCounts.get(student);
            if (currentCount < 5 && !course.getEnrolledStudents().contains(student)) {
                course.addStudent(student);
                addedStudents.add(student);
                studentCourseCounts.put(student, currentCount + 1);

                // Si el estudiante ha alcanzado el límite, se elimina de la lista de elegibles
                if (currentCount + 1 >= 5) {
                    eligibleStudents.remove(student);
                }
            } else {
                // Eliminar el estudiante de la lista de elegibles si ya está en el curso o ha alcanzado el límite
                eligibleStudents.remove(student);
            }
        }

        // Genera clases y asigna solo estudiantes inscritos en el curso
        List<Student> enrolledStudents = new ArrayList<>(course.getEnrolledStudents());
        for (int i = 0; i < 5; i++) {
            Clase clase = claseGenerator.createClase();
            if (!enrolledStudents.isEmpty()) { // Verifica que haya estudiantes inscritos
                int randomCount = random.nextInt(enrolledStudents.size()) + 1;
                Collections.shuffle(enrolledStudents); // Mezcla la lista para seleccionar estudiantes aleatoriamente
                for (int j = 0; j < randomCount; j++) {
                    Student student = enrolledStudents.get(j);
                    clase.addStudent(student);
                }
            }
            course.addClass(clase);
        }

        return course;
    }
}

