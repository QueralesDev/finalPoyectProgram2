package org.finalProyect.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.finalProyect.models.Student;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StudentDataLoader {

    public static List<Student> loadStudentsFromJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Parseamos el JSON a una lista de objetos Student
            return objectMapper.readValue(new File(filePath),
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + e.getMessage());
            return List.of(); // Retornamos una lista vacía en caso de error
        }
    }
}
