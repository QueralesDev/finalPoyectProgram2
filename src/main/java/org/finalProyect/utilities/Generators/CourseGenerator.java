package org.finalProyect.utilities.Generators;

import org.finalProyect.enums.Level;
import org.finalProyect.models.Clase;
import org.finalProyect.models.Course;
import org.finalProyect.models.Student;
import org.finalProyect.utilities.JsonReader;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

        course.addDidacticMaterial(didacticMaterialGenerator.createDidacticMaterial());

        int randomStudentCount = random.nextInt(students.size()) + 1;
        Set<Student> addedStudents = new HashSet<>();
        while (addedStudents.size() < randomStudentCount) {
            Student student = students.get(random.nextInt(students.size()));
            if (!addedStudents.contains(student)) {
                course.addStudent(student);
                addedStudents.add(student);
            }
        }

        for (int i = 0; i < 10; i++) {
            Clase clase = claseGenerator.createClase();
            Collections.shuffle(students);
            int randomCount = random.nextInt(students.size()) + 1;
            for (int j = 0; j < randomCount; j++) {
                clase.addStudent(students.get(j));
            }
            course.addClass(clase);
        }

        return course;
    }
}