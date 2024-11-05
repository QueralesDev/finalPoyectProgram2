package org.finalProyect.utilities.Generators;

import org.finalProyect.enums.Level;
import org.finalProyect.models.Course;

import java.io.IOException;

public class CourseGenerator {

    private DidacticMaterialGenerator didacticMaterialGenerator;
    private ClaseGenerator claseGenerator;
    private Level[] levels;

    public CourseGenerator() {
        didacticMaterialGenerator = new DidacticMaterialGenerator();
        claseGenerator = new ClaseGenerator();
        levels = Level.values();
    }

    public Course createCourse() throws IOException {

        Level level = levels[PersonGenerator.random.nextInt(levels.length)];
        Course course = new Course(level);

        course.addDidacticMaterial(didacticMaterialGenerator.createDidacticMaterial());
        for(int i = 0; i < 10; i++){
            course.addClass(claseGenerator.createClase());
        }

        return course;
    }
}
