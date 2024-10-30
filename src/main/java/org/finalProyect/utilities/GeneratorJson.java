package org.finalProyect.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.finalProyect.enums.Level;
import org.finalProyect.enums.TypeMaterial;
import org.finalProyect.enums.TypeSpeciality;
import org.finalProyect.models.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneratorJson {

    public void generateStudents(int count) {
        List<Student> students = new ArrayList<>();
        Level[] levels = Level.values();

        for (int i = 0; i < count; i++) {
            String name = PersonGenerator.generateName();
            String lastName = PersonGenerator.generateLastName();
            String dni = PersonGenerator.generateDNI();
            String email = PersonGenerator.generateEmail(name, lastName);
            Level level = Level.valueOf(String.valueOf(levels[PersonGenerator.random.nextInt(levels.length)]));

            Student student = new Student(name, lastName, dni, email, level);
            students.add(student);
        }

        saveToFile(students, "students.json");
    }

    public void generateTeachers(int count) {
        List<Teacher> teachers = new ArrayList<>();
        TypeSpeciality[] specialties = TypeSpeciality.values();

        for (int i = 0; i < count; i++) {
            String name = PersonGenerator.generateName();
            String lastName = PersonGenerator.generateLastName();
            String dni = PersonGenerator.generateDNI();
            String email = PersonGenerator.generateEmail(name, lastName);
            TypeSpeciality specialty = TypeSpeciality.valueOf(String.valueOf(specialties[PersonGenerator.random.nextInt(specialties.length)]));

            Teacher teacher = new Teacher(name, lastName, dni, email, specialty);
            teachers.add(teacher);
        }

        saveToFile(teachers, "teachers.json");
    }

    public void generateCourses(int count) {

        List<Course> courses = new ArrayList<>();
        Level[] levels = Level.values();
        TypeMaterial[] typeMaterials = TypeMaterial.values();
        String[] plinks = {"https://cursosonline.com/video", "https://cursosonline.com/audio", "https://cursosonline.com/partitura"};
        for (int i = 0; i < count; i++) {
            //String courseName = courseNames[PersonGenerator.random.nextInt(courseNames.length)];
            Level level = Level.valueOf(String.valueOf(levels[PersonGenerator.random.nextInt(levels.length)]));
            TypeMaterial typeMaterial = TypeMaterial.valueOf(String.valueOf(typeMaterials[PersonGenerator.random.nextInt(typeMaterials.length)]));
            String links = plinks[PersonGenerator.random.nextInt(plinks.length)];

            Course course = new Course(level);
            course.addDidacticMaterial(new DidacticMaterial("Material" + i, typeMaterial, links));
            courses.add(course);
        }


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
        for (int i = 0; i< courseNames.length; i++){
            courses.get(i).setName(courseNames[i]);

        }
        saveToFile(courses, "courses.json");
    }

    private <T> void saveToFile(List<T> data, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(data, writer);
            System.out.println("Saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
