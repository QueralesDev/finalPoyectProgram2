package org.finalProyect.utilities.Generators;

import org.finalProyect.management.ManagementSystem;
import org.finalProyect.models.Clase;
import org.finalProyect.models.Student;
import org.finalProyect.models.Teacher;
import org.finalProyect.utilities.JsonReader;

import java.io.IOException;
import java.util.List;

public class ClaseGenerator {
    private int classIndex = 0;

    ManagementSystem managementSystem = new ManagementSystem();

    String[] nameClass ={"Clase 1", "Clase 2", "Clase 3", "Clase 4", "Clase 5", "Clase 6", "Clase 7", "Clase 8", "Clase 9", "Clase 10"};
    String[] date ={"Nov 14, 2024, 12:00:00 AM",
            "Dec 25, 2024, 03:15:30 PM",
            "Jan 01, 2050, 11:59:59 PM",
            "Feb 29, 2400, 06:30:45 AM",
            "Jul 04, 3000, 08:00:00 PM",
            "Oct 31, 2100, 07:45:00 AM",
            "Mar 15, 2150, 09:15:15 PM",
            "Apr 20, 2200, 10:10:10 AM",
            "May 05, 2300, 05:05:05 PM",
            "Jun 21, 2500, 02:22:22 AM"};


    public String generateNameClass(){
        String className = nameClass[classIndex];
        classIndex = (classIndex + 1) % nameClass.length;
        return className;
    }

    public String generateDate(){
        return date[PersonGenerator.random.nextInt(date.length)];
    }

    public Clase createClase() throws IOException {

        List<Teacher> teachers = JsonReader.readTeachers("teachers.json");

        return new Clase(generateNameClass(), generateDate(), teachers.get(PersonGenerator.random.nextInt(teachers.size())));
    }

}
