package com.example.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.finalProyect.enums.Level;
import org.finalProyect.models.Student;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CollectionPerformanceController {

    @FXML
    private Button btnRunTests;

    @FXML
    private TextArea resultsArea;

    private static final int ELEMENT_COUNT = 1_000_000;

    @FXML
    private void initialize() {
        btnRunTests.setOnAction(e -> runAllTests());
    }

    private void runAllTests() {
        resultsArea.clear(); // Limpiar el área de resultados

        // Ejecutar y mostrar todos los tests
        resultsArea.appendText("<<<<<< Prueba de Rendimiento de Todas las Colecciones >>>>>>\n\n");
        resultsArea.appendText("--- List Performance ---\n");
        testListPerformance();
        resultsArea.appendText("\n--- Set Performance ---\n");
        testSetPerformance();
        resultsArea.appendText("\n--- Map Performance ---\n");
        testMapPerformance();
    }

    private void testListPerformance() {
        List<Student> studentArrayList = new ArrayList<>();
        List<Student> studentVector = new Vector<>();
        Deque<Student> studentDeque = new ArrayDeque<>();

        measurePerformance(studentArrayList, "ArrayList (Student)");
        measurePerformance(studentVector, "Vector (Student)");
        measurePerformance(studentDeque, "Deque (Student)");
    }

    private void testSetPerformance() {
        Set<Student> studentHashSet = new HashSet<>();
        Set<Student> studentLinkedHashSet = new LinkedHashSet<>();
        Set<Student> studentTreeSet = new TreeSet<>(Comparator.comparingInt(Student::hashCode));

        measurePerformance(studentHashSet, "HashSet (Student)");
        measurePerformance(studentLinkedHashSet, "LinkedHashSet (Student)");
        measurePerformance(studentTreeSet, "TreeSet (Student)");
    }

    private void testMapPerformance() {
        Map<Integer, Student> studentHashMap = new HashMap<>();
        Map<Integer, Student> studentLinkedHashMap = new LinkedHashMap<>();
        Map<Integer, Student> studentTreeMap = new TreeMap<>();

        measurePerformance(studentHashMap, "HashMap (Student)");
        measurePerformance(studentLinkedHashMap, "LinkedHashMap (Student)");
        measurePerformance(studentTreeMap, "TreeMap (Student)");
    }

    private void measurePerformance(Collection<Student> collection, String collectionName) {
        long startTime = System.nanoTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            collection.add(createInstance(i));
        }
        long endTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        resultsArea.appendText(collectionName + " - Tiempo de Carga: " + duration + " ms\n");

        startTime = System.nanoTime();
        boolean exists = collection.contains(createInstance(ELEMENT_COUNT - 1));
        endTime = System.nanoTime();
        duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        resultsArea.appendText(collectionName + " - Tiempo de Búsqueda del Último Elemento: " + duration + " ms\n");
    }

    private void measurePerformance(Map<Integer, Student> map, String mapName) {
        long startTime = System.nanoTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            map.put(i, createInstance(i));
        }
        long endTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        resultsArea.appendText(mapName + " - Tiempo de Carga: " + duration + " ms\n");

        startTime = System.nanoTime();
        boolean exists = map.containsKey(ELEMENT_COUNT - 1);
        endTime = System.nanoTime();
        duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        resultsArea.appendText(mapName + " - Tiempo de Búsqueda del Último Elemento: " + duration + " ms\n");
    }

    private Student createInstance(int id) {
        return new Student("Name", "LastName", String.valueOf(id), "Email" + id + "@example.com", Level.PRINCIPIANTE);
    }



public void switchToScene1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/scenes/MAIN_MENU.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 453, 295);
        stage.setScene(scene);
        stage.show();
    }
}
