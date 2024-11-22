package org.finalProyect;

import org.finalProyect.management.ManagementSystem;
import org.finalProyect.models.Student;
import org.finalProyect.utilities.CollectionPerformanceTest;

import java.io.IOException;


public class   MainTest {
    public static void main(String[] args) throws IOException {
        Menu menu = new Menu();

        CollectionPerformanceTest.main(args);

        menu.showMenu();


    }
}