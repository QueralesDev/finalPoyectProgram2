package org.finalProyect.utilities.Generators;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.finalProyect.enums.Level;
import org.finalProyect.enums.TypeMaterial;
import org.finalProyect.enums.TypeSpeciality;
import org.finalProyect.models.*;
import org.finalProyect.models.Clase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneratorJson {

    PersonGenerator personGenerator = new PersonGenerator();
    ClaseGenerator claseGenerator = new ClaseGenerator();
    CourseGenerator courseGenerator = new CourseGenerator();

    public void generateStudents(int count) {
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            students.add(personGenerator.createStudent());
        }

        saveToFile(students, "students.json");
    }

    public void generateTeachers(int count) {
        List<Teacher> teachers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            teachers.add(personGenerator.createTeacher());
        }

        saveToFile(teachers, "teachers.json");
    }

    public void generateCourses(int count) throws IOException {
        List<Course> courses = new ArrayList<>();
        String[] coursesNames ={"Introducción al Piano Clásico",
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
        for (int i = 0; i < count; i++) {
            Course course = courseGenerator.createCourse();
            course.setName(coursesNames[i]);
            courses.add(course);
        }

        saveToFile(courses, "courses.json");
    }


    private <T> void saveToFile(List<T> data, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(data, writer);
            System.out.println("Guardado en: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
