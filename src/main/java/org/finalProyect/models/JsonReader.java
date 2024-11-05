package org.finalProyect.models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class JsonReader {

    public JsonReader(){};

    public List<Student> readJsonFile(String filePath) {
        Gson gson = new Gson();
        List<Student> persons = null;

        try (FileReader reader = new FileReader(filePath)) {
            Type personListType = new TypeToken<List<Student>>() {}.getType();
            persons = gson.fromJson(reader, personListType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return persons;
    }

    public List<Teacher> readJsonFileTeacher(String filePath) {
        Gson gson = new Gson();
        List<Teacher> persons = null;

        try (FileReader reader = new FileReader(filePath)) {
            Type personListType = new TypeToken<List<Teacher>>() {}.getType();
            persons = gson.fromJson(reader, personListType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return persons;
    }




}
