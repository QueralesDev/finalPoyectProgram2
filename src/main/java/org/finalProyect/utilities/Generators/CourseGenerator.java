package org.finalProyect.utilities.Generators;

import org.finalProyect.enums.Level;
import org.finalProyect.models.Course;

import java.io.IOException;

public class CourseGenerator {

    private DidacticMaterialGenerator didacticMaterialGenerator;
    private ClaseGenerator claseGenerator;
    private Level[] levels;

    String[] courseNames = { "Introducción al Piano Clásico",
            "Fundamentos de la Guitarra Jazz",
            "Teoría Musical Avanzada",
            "Lecciones de Violín para Principiantes",
            "Técnicas de Batería Rock",
            "Guitarra Flamenca para Principiantes",
            "Práctica Intermedia de Saxofón",
            "Dominando el Clarinete",
            "Fundamentos de Composición de Canciones",
            "Interpretación de Clavecín Barroco",
            "Percusión para Principiantes",
            "Composición Musical con Piano",
            "Técnicas Vocales Avanzadas",
            "Improvisación para Músicos de Jazz",
            "Arpa Celta para Principiantes",
            "Producción de Música Electrónica",
            "Composición de Canciones Pop",
            "Introducción a la Dirección Musical",
            "Interpretación de Cuarteto de Cuerdas",
            "Composición y Armonización para Cine" };

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