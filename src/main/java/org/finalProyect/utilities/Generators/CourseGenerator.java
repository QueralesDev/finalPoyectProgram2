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
    private final Map<Student, Integer> studentCourseCounts; // Cursos actuales
    private final Map<Student, Integer> studentCourseLimits; // Límite de cursos por estudiante

    /**
     * Inicializa un nuevo generador de cursos con material didáctico, clases y estudiantes.
     */
public CourseGenerator() {
        didacticMaterialGenerator = new DidacticMaterialGenerator();
        claseGenerator = new ClaseGenerator();
        levels = Level.values();
        random = new Random();
        studentCourseCounts = new HashMap<>();
        studentCourseLimits = new HashMap<>();
    }

    /**
     * Crea un curso y asigna estudiantes a él, asegurando que se cumplan ciertos criterios y límites.
     *
     * @return El curso creado con los estudiantes asignados.
     * @throws IOException Sí ocurre un error al leer los estudiantes desde el archivo JSON.
     * <p>
     * Este metodo realiza las siguientes acciones:
     * 1. Lee una lista de estudiantes desde un archivo JSON.
     * 2. Verifica si la lista de estudiantes está vacía y lanza una excepción si es así.
     * 3. Selecciona un nivel aleatorio para el curso y lo crea.
     * 4. Agrega material didáctico al curso.
     * 5. Inicializa contadores y límites aleatorios para cada estudiante.
     * 6. Filtra los estudiantes elegibles según su límite de cursos.
     * 7. Verifica si hay estudiantes elegibles y retorna un curso vacío si no los hay.
     * 8. Mezcla los estudiantes para evitar sesgos y asegura al menos un estudiante en el curso.
     * 9. Asigna un número aleatorio de estudiantes adicionales al curso.
     * 10. Genera 10 clases y asigna estudiantes aleatorios a cada una y las agrega al curso.
     * 11. Retorna el curso creado.
     */
public Course createCourse() throws IOException {
        List<Student> students = JsonReader.readStudents("students.json");
        // Verificar si la lista de estudiantes está vacía si no lanzar una excepción
        if (students.isEmpty()) {
            throw new IllegalArgumentException("No hay estudiantes disponibles para inscribir en el curso.");
        }
        // Seleccionar un nivel aleatorio para el curso
        Level level = levels[random.nextInt(levels.length)];
        Course course = new Course(level);

        // Agregar material didáctico al curso
        course.addDidacticMaterial(didacticMaterialGenerator.createDidacticMaterial());

        // Inicializar contadores y límites para los estudiantes
        for (Student student : students) {
            studentCourseCounts.putIfAbsent(student, 0);
            studentCourseLimits.putIfAbsent(student, random.nextInt(5) + 1); // Límite aleatorio entre 1 y 5
        }

        // Filtrar estudiantes elegibles según su límite
        List<Student> eligibleStudents = new ArrayList<>();
        for (Student student : students) {
            int currentCount = studentCourseCounts.get(student);
            int maxLimit = studentCourseLimits.get(student);
            if (currentCount < maxLimit) {
                eligibleStudents.add(student);
            }
        }
        // Verificar si la lista de estudiantes elegibles está vacía
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
        addedStudents.add(initialStudent);

        for (Student student : eligibleStudents) {
            // Verificar si ya se agregó el número máximo de estudiantes al curso
            if (addedStudents.size() >= randomStudentCount) {
                break; // Detenemos cuando alcanzamos el límite de estudiantes para este curso
            }

            // Verificar si el estudiante ya está inscrito en el curso
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
            // Asignar estudiantes aleatorios a la clase de los estudiantes inscritos en el curso
            if (!enrolledStudents.isEmpty()) {
                int randomCount = random.nextInt(enrolledStudents.size()) + 1; // Mínimo 1 estudiante por clase
                Collections.shuffle(enrolledStudents);
                for (int j = 0; j < randomCount; j++) {
                    clase.addStudent(enrolledStudents.get(j));
                }
            }
            // Agregar la clase al curso
            course.addClass(clase);
        }

        return course;
    }
}
