package org.finalProyect.utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileDataManager {

    private ObjectMapper objectMapper;

    /**
     * Constructor que inicializa el ObjectMapper
     */
    public FileDataManager() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper = new ObjectMapper();
        this.objectMapper.findAndRegisterModules(); // Registrar módulos
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Guarda una lista de objetos en un archivo.
     * @param fileName El nombre del archivo donde se guardará la lista.
     * @param data La lista de objetos a guardar.
     */
    public <T> void saveToFile(String fileName, List<T> data) {
        //Intenta guardar la lista en un archivo
        try {
            //Si la lista está vacía, imprime un mensaje
            if (data == null || data.isEmpty()) {
                System.out.println("Intentando guardar lista vacía en: " + fileName);
                //Si la lista no está vacía, imprime un mensaje con la cantidad de elementos a guardar
            } else {
                System.out.println("Guardando " + data.size() + " elementos en: " + fileName);
            }
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), data);
        } catch (IOException e) {
            System.err.println("Error guardando datos en archivo: " + e.getMessage());
        }
    }

    /**
     * Carga una lista de objetos desde un archivo.
     * @param fileName El nombre del archivo desde donde se cargará la lista.
     * @param clazz La clase de los objetos en la lista.
     * @return Una lista de objetos cargados desde el archivo.
     */
    public <T> List<T> loadFromFile(String fileName, Class<T> clazz) {
        //Intenta cargar la lista desde un archivo
        try {
            File file = new File(fileName);
            //Si el archivo existe, intenta cargar la lista
            if (file.exists()) {
                return objectMapper.readValue(
                        file,
                        objectMapper.getTypeFactory().constructCollectionType(List.class, clazz)
                );
                //Si el archivo no existe, imprime un mensaje
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
