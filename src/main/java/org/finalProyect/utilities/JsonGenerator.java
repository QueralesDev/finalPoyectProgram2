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

class JSONGenerator {

    public static void generateStudents(int count) {
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

    public static void generateTeachers(int count) {
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

    public static void generateCourses(int count) {
        List<Course> courses = new ArrayList<>();
        String[] courseNames = { "Introduction to Classical Piano",
                "Jazz Guitar Essentials",
                "Advanced Music Theory",
                "Beginner Violin Lessons",
                "Rock Drumming Techniques",
                "Flamenco Guitar for Beginners",
                "Intermediate Saxophone Practice",
                "Mastering the Clarinet",
                "Fundamentals of Songwriting",
                "Baroque Harpsichord Performance",
                "Percussion for Beginners",
                "Music Composition with Piano",
                "Advanced Vocal Techniques",
                "Improvisation for Jazz Musicians",
                "Celtic Harp for Beginners",
                "Electronic Music Production",
                "Pop Music Songwriting",
                "Introduction to Conducting",
                "String Quartet Performance",
                "Film Scoring and Composition"};
        Level[] levels = Level.values();
        String[] plinks = {"https://cursosonline.com/video", "https://cursosonline.com/audio", "https://cursosonline.com/partitura"};

        for (int i = 0; i < count; i++) {
            String courseName = courseNames[PersonGenerator.random.nextInt(courseNames.length)];
            Level level = Level.valueOf(String.valueOf(levels[PersonGenerator.random.nextInt(levels.length)]));
            TypeMaterial typeMaterial = TypeMaterial.valueOf(String.valueOf(levels[PersonGenerator.random.nextInt(levels.length)]));
            String links = plinks[PersonGenerator.random.nextInt(plinks.length)];

            Course course = new Course(courseName, level);
            course.addDidacticMaterial(new DidacticMaterial("Material" + i, typeMaterial, links));
            courses.add(course);
        }

        saveToFile(courses, "courses.json");
    }

    private static <T> void saveToFile(List<T> data, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(data, writer);
            System.out.println("Saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

