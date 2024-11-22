/*package org.finalProyect.utilities;

import org.finalProyect.enums.Level;
import org.finalProyect.enums.TypeSpeciality;
import org.finalProyect.models.Student;
import org.finalProyect.models.Teacher;
import org.finalProyect.models.Course;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class CollectionPerformanceTest {

    private static final int ELEMENT_COUNT = 1_000_000; // Número de elementos a insertar

    public static void main(String[] args) {
        testListPerformance();
        testSetPerformance();
        testMapPerformance();
    }

    private static void testListPerformance() {
        List<Student> studentArrayList = new ArrayList<>();
        List<Teacher> teacherVector = new Vector<>();
        Deque<Course> courseDeque = new ArrayDeque<>();

        System.out.println("--- List Performance ---");
        measurePerformance(studentArrayList, "ArrayList (Student)");
        measurePerformance(teacherVector, "Vector (Teacher)");
        measurePerformance(courseDeque, "Deque (Course)");
    }

    private static void testSetPerformance() {
        Set<Student> studentHashSet = new HashSet<>();
        Set<Teacher> teacherLinkedHashSet = new LinkedHashSet<>();
        Set<Course> courseTreeSet = new TreeSet<>(Comparator.comparingInt(Course::hashCode));

        System.out.println("--- Set Performance ---");
        measurePerformance(studentHashSet, "HashSet (Student)");
        measurePerformance(teacherLinkedHashSet, "LinkedHashSet (Teacher)");
        measurePerformance(courseTreeSet, "TreeSet (Course)");
    }

    private static void testMapPerformance() {
        Map<Integer, Student> studentHashMap = new HashMap<>();
        Map<Integer, Teacher> teacherLinkedHashMap = new LinkedHashMap<>();
        Map<Integer, Course> courseTreeMap = new TreeMap<>();

        System.out.println("--- Map Performance ---");
        measurePerformance(studentHashMap, "HashMap (Student)");
        measurePerformance(teacherLinkedHashMap, "LinkedHashMap (Teacher)");
        measurePerformance(courseTreeMap, "TreeMap (Course)");
    }

    private static void measurePerformance(Collection<?> collection, String collectionName) {
        long startTime = System.nanoTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            collection.add(createInstance(collection.getClass(), i));
        }
        long endTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println(collectionName + " - Tiempo de Carga: " + duration + " ms");

        startTime = System.nanoTime();
        boolean exists = collection.contains(createInstance(collection.getClass(), ELEMENT_COUNT - 1)); // Buscar el último elemento
        endTime = System.nanoTime();
        duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println(collectionName + " - Tiempo de Búsqueda del Último Elemento: " + duration + " ms");
    }

    private static void measurePerformance(Map<Integer, ?> map, String mapName) {
        long startTime = System.nanoTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            map.put(i, createInstance(map.getClass(), i));
        }
        long endTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println(mapName + " - Tiempo de Carga: " + duration + " ms");

        startTime = System.nanoTime();
        boolean exists = map.containsKey(ELEMENT_COUNT - 1); // Buscar el último elemento
        endTime = System.nanoTime();
        duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println(mapName + " - Tiempo de Búsqueda del Último Elemento: " + duration + " ms");
    }

    private static <T> T createInstance(Class<?> collectionClass, int id) {
        if (collectionClass == ArrayList.class ||
                collectionClass == HashSet.class ||
                collectionClass == HashMap.class ||
                collectionClass == ArrayDeque.class) {
            // Generar nombre válido solo con letras y DNI numérico
            return (T) new Student("Name", "LastName", String.valueOf(id), "Email" + id + "@example.com", Level.PRINCIPIANTE);
        } else if (collectionClass == Vector.class ||
                collectionClass == LinkedHashSet.class ||
                collectionClass == LinkedHashMap.class) {
            return (T) new Teacher("Name", "LastName", String.valueOf(id), "Email" + id + "@example.com", TypeSpeciality.ARPA); // Ajusta la especialidad según sea necesario
        } else if (collectionClass == TreeSet.class ||
                collectionClass == TreeMap.class) {
            return (T) new Course("Course" + id, Level.PRINCIPIANTE); // Ajusta el nivel según sea necesario
        }
        return null;
    }
} */

package org.finalProyect.utilities;

import org.finalProyect.enums.Level;
import org.finalProyect.models.Student;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class CollectionPerformanceTest {

    private static final int ELEMENT_COUNT = 1_000_000; // Número de elementos a insertar

    public static void main(String[] args) {
        testListPerformance();
        testSetPerformance();
        testMapPerformance();
    }

    private static void testListPerformance() {
        List<Student> studentArrayList = new ArrayList<>();
        List<Student> studentVector = new Vector<>();
        Deque<Student> studentDeque = new ArrayDeque<>();

        System.out.println("<<<<<<<<<<<<<Prueba de Rendimiento de Colecciones>>>>>>>>>>>>>");

        System.out.println("--- List Performance ---");
        measurePerformance(studentArrayList, "ArrayList (Student)");
        measurePerformance(studentVector, "Vector (Student)");
        measurePerformance(studentDeque, "Deque (Student)");
    }

    private static void testSetPerformance() {
        Set<Student> studentHashSet = new HashSet<>();
        Set<Student> studentLinkedHashSet = new LinkedHashSet<>();
        Set<Student> studentTreeSet = new TreeSet<>(Comparator.comparingInt(Student::hashCode));

        System.out.println("--- Set Performance ---");
        measurePerformance(studentHashSet, "HashSet (Student)");
        measurePerformance(studentLinkedHashSet, "LinkedHashSet (Student)");
        measurePerformance(studentTreeSet, "TreeSet (Student)");
    }

    private static void testMapPerformance() {
        Map<Integer, Student> studentHashMap = new HashMap<>();
        Map<Integer, Student> studentLinkedHashMap = new LinkedHashMap<>();
        Map<Integer, Student> studentTreeMap = new TreeMap<>();

        System.out.println("--- Map Performance ---");
        measurePerformance(studentHashMap, "HashMap (Student)");
        measurePerformance(studentLinkedHashMap, "LinkedHashMap (Student)");
        measurePerformance(studentTreeMap, "TreeMap (Student)");
    }

    private static void measurePerformance(Collection<Student> collection, String collectionName) {
        long startTime = System.nanoTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            collection.add(createInstance(i));
        }
        long endTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println(collectionName + " - Tiempo de Carga: " + duration + " ms");

        startTime = System.nanoTime();
        boolean exists = collection.contains(createInstance(ELEMENT_COUNT - 1)); // Buscar el último elemento
        endTime = System.nanoTime();
        duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println(collectionName + " - Tiempo de Búsqueda del Último Elemento: " + duration + " ms");
    }

    private static void measurePerformance(Map<Integer, Student> map, String mapName) {
        long startTime = System.nanoTime();
        for (int i = 0; i < ELEMENT_COUNT; i++) {
            map.put(i, createInstance(i));
        }
        long endTime = System.nanoTime();
        long duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println(mapName + " - Tiempo de Carga: " + duration + " ms");

        startTime = System.nanoTime();
        boolean exists = map.containsKey(ELEMENT_COUNT - 1); // Buscar el último elemento
        endTime = System.nanoTime();
        duration = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        System.out.println(mapName + " - Tiempo de Búsqueda del Último Elemento: " + duration + " ms");
    }

    private static Student createInstance(int id) {
        return new Student("Name", "LastName", String.valueOf(id), "Email" + id + "@example.com", Level.PRINCIPIANTE);
    }
}