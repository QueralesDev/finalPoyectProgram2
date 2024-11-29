package com.example.Controllers;

import org.finalProyect.management.ManagementSystem;
import org.finalProyect.utilities.Generators.GeneratorJson;

import java.io.IOException;
import java.util.Scanner;

/**
* Inicializa los componentes principales del sistema.
* `@throws` IOException sí ocurre un error al generar datos
*/
public class Initializer {
    private GeneratorJson generatorJson;
    private ManagementSystem managementSystem;
    private Scanner scanner;


/**
* Constructor de la clase Initializer.
* Este constructor inicializa un generador de JSON, un sistema de
* gestión y un objeto Scanner para la entrada de datos.
* `@throws` IOException sí ocurre un error al generar datos
*/
public Initializer() throws IOException {
        this.generatorJson = new GeneratorJson();
        generatorJson.generateStudents(2000);
        generatorJson.generateTeachers(80);
        generatorJson.generateCourses(20);
        this.managementSystem = new ManagementSystem();
        managementSystem.generateMockProgressData();
        this.scanner = new Scanner(System.in);
    }


}
