package org.finalProyect.utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileDataManager {

    private ObjectMapper objectMapper;

    public FileDataManager() {
        this.objectMapper = new ObjectMapper();
    }

    // Metodo para guardar una lista de objetos en un archivo JSON
    public <T> void saveToFile(String fileName, List<T> data) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), data);
        } catch (IOException e) {
            System.err.println("Error guardando datos en archivo: " + e.getMessage());
        }
    }

    // Metodo para cargar una lista de objetos desde un archivo JSON
    public <T> List<T> loadFromFile(String fileName, TypeReference<List<T>> typeReference) {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                return objectMapper.readValue(file, typeReference);
            } else {
                System.out.println("Archivo no existe: " + fileName);
                return List.of();
            }
        } catch (IOException e) {
            System.err.println("Error de carga desde el archivo: " + e.getMessage());
            return List.of();
        }
    }
}
