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
    public static List<Student> readStudents(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<List<Student>>() {});
    }
    public static List<Teacher> readTeachers(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<List<Teacher>>() {});
    }

    public static List<Course> readCourses(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), new TypeReference<List<Course>>() {});
    }
}