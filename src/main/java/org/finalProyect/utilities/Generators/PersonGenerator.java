package org.finalProyect.utilities.Generators;

import org.finalProyect.enums.Level;
import org.finalProyect.enums.TypeSpeciality;
import org.finalProyect.management.ManagementSystem;
import org.finalProyect.models.Student;
import org.finalProyect.models.Teacher;

import java.util.Random;

public class PersonGenerator {
    //Arreglos de nombres, apellidos y dominios de correo
    private static final String[] firstNames = {"Luis", "John", "Maria", "Ana", "Carlos", "Laura", "Pedro", "Sofia", "Daniel", "Mariana",
            "Miguel", "Lucia", "Gabriel", "Valeria", "Ricardo", "Sandra", "Fernando", "Beatriz", "Diego", "Juliana", "Andres", "Paula", "Alberto", "Adriana", "Francisco", "Elena", "Javier", "Camila", "Esteban", "Patricia",
            "Mateo", "Liliana", "Rafael", "Cecilia", "Eduardo", "Cristina", "Raul", "Isabel", "Nicolas", "Sara", "Hugo", "Veronica", "David", "Irene", "Jorge", "Angela", "Emilio", "Rosa", "Gustavo", "Monica",
            "Martin", "Diana", "Pablo", "Lorena", "Oscar", "Silvia", "Roberto", "Claudia", "Sergio", "Victoria", "Enrique", "Gabriela", "Ignacio", "Alicia", "Alfonso", "Elisa", "Felipe", "Bianca", "Vladimir", "Olga"};
    private static final String[] lastNames = {"Querales", "Doe", "Garcia", "Rodriguez", "Lopez", "Perez", "Gonzalez", "Martinez", "Fernandez", "Sanchez", "Ramirez", "Castillo", "Morales", "Gomez", "Torres", "Flores", "Vargas", "Diaz", "Cruz", "Reyes",
            "Mendoza", "Paredes", "Herrera", "Soto", "Vega", "Rios", "Ortiz", "Silva", "Medina", "Guerrero", "Castro", "Navarro", "Cabrera", "Escobar", "Ibarra", "Aguirre", "Salazar", "Campos", "Chavez", "Pena",
            "Alvarez", "Moreno", "Hernandez", "Romero", "Blanco", "Bermudez", "Mora", "Acosta", "Luna", "Miranda", "Villalobos", "Matos", "Rosales", "Figueroa", "Montoya", "Bautista", "Zambrano", "Valenzuela", "Palacios", "Rivas",
            "Villarreal", "Mejia", "Peña", "Valencia", "Quintero", "Maldonado", "Contreras", "Cortez", "Santana", "Mora"};
    private static final String[] domains = {"example.com", "mail.com", "domain.com", "service.com", "provider.com", "webmail.com", "mailbox.org",
            "fastmail.com", "outlook.com", "yahoo.com", "gmail.com", "protonmail.com", "zohomail.com", "icloud.com",
            "hotmail.com", "aol.com", "gmx.com", "yandex.com", "inbox.com", "tutanota.com", "live.com", "hushmail.com",
            "email.com", "posteo.net", "runbox.com", "mailfence.com", "seznam.cz", "laposte.net", "orange.fr",
            "btinternet.com", "rocketmail.com", "mail.ru", "q.com", "comcast.net", "verizon.net", "optonline.net"};
    public static final Random random = new Random();
    //Arreglo de especialidades
    private TypeSpeciality[] specialties = TypeSpeciality.values();

    /**
    * Genera un nombre aleatorio a partir de un arreglo predefinido
    * @return un nombre aleatorio
    */
    public static String generateName() {
        return firstNames[random.nextInt(firstNames.length)];
    }

    /**
    * Genera un apellido aleatorio a partir de un arreglo predefinido
    * @return un apellido aleatorio
    */
    public static String generateLastName() {
        return lastNames[random.nextInt(lastNames.length)];
    }

    /**
    * Genera un número de DNI aleatorio
    * @return un número de DNI aleatorio
    */
    public static String generateDNI() {
        return String.valueOf(10000000 + random.nextInt(90000000));
    }

    /**
    * Genera un correo electrónico basado en un nombre y apellido dado
    * @param name El nombre de la persona
    * @param lastName El apellido de la persona
    * @return un correo electrónico generado
    */
    public static String generateEmail(String name, String lastName) {
        return name.toLowerCase() + "." + lastName.toLowerCase() + "@" + domains[random.nextInt(domains.length)];
    }

    /**
    * Crea un objeto Teacher con valores generados aleatoriamente
    * @return un nuevo objeto Teacher
    */
    public Teacher createTeacher() {

            String name = PersonGenerator.generateName();
            String lastName = PersonGenerator.generateLastName();
            String dni = PersonGenerator.generateDNI();
            String email = PersonGenerator.generateEmail(name, lastName);
            TypeSpeciality specialty = TypeSpeciality.valueOf(String.valueOf(specialties[PersonGenerator.random.nextInt(specialties.length)]));

            Teacher teacher = new Teacher(name, lastName, dni, email, specialty);

        return teacher;
    }

    /**
    * Crea un objeto Student con valores generados aleatoriamente
    * @return un nuevo objeto Student
    */
    public Student createStudent() {

            String name = PersonGenerator.generateName();
            String lastName = PersonGenerator.generateLastName();
            String dni = PersonGenerator.generateDNI();
            String email = PersonGenerator.generateEmail(name, lastName);
            Level level = Level.valueOf(String.valueOf(Level.values()[PersonGenerator.random.nextInt(Level.values().length)]));

            Student student = new Student(name, lastName, dni, email, level);
        return student;
    }
}

