package com.example.Controllers;

import org.finalProyect.management.ManagementSystem;
import org.finalProyect.utilities.Generators.GeneratorJson;

import java.io.IOException;
import java.util.Scanner;

public class Initializer {
    private GeneratorJson generatorJson;
    private ManagementSystem managementSystem;
    private Scanner scanner;


    public Initializer() throws IOException {
        this.generatorJson = new GeneratorJson();
        generatorJson.generateStudents(30);
        generatorJson.generateTeachers(100);
        generatorJson.generateCourses(20);
        this.managementSystem = new ManagementSystem();
        managementSystem.generateMockProgressData();
        this.scanner = new Scanner(System.in);
    }


}
