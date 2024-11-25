package org.finalProyect.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.finalProyect.models.Course;
import org.finalProyect.models.Student;
import org.finalProyect.models.Teacher;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {
    /**
     * Lee una lista de estudiantes desde un archivo JSON.
     * @param filePath Ruta del archivo que contiene los datos JSON.
     * @return Lista de objetos Student.
     */
    public static List<Student> readStudents(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<List<Student>>() {});
    }
    /**
     * Lee una lista de profesores desde un archivo JSON.
     * @param filePath Ruta del archivo que contiene los datos JSON.
     * @return Lista de objetos Teacher.
     */
    public static List<Teacher> readTeachers(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<List<Teacher>>() {});
    }

    /**
     * Lee una lista de cursos desde un archivo JSON.
     * @param filePath Ruta del archivo que contiene los datos JSON.
     * @return Lista de objetos Course.
     */
    public static List<Course> readCourses(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<List<Course>>() {});
    }
}