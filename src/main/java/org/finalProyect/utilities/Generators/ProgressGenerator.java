package org.finalProyect.utilities.Generators;

import org.finalProyect.models.Clase;
import org.finalProyect.models.Course;
import org.finalProyect.models.Progress;
import org.finalProyect.models.Student;

import java.util.ArrayList;
import java.util.List;

public class ProgressGenerator {

    public List<Progress> generateProgresses(List<Student> students, List<Course> courses) {
        List<Progress> progresses = new ArrayList<>();
        System.out.println("Generando Progresos Aleatorios ");

        if (students == null || students.isEmpty()) {
            System.out.println("Lista de estudiantes nula o vacia.");
            return progresses;
        }

        if (courses == null || courses.isEmpty()) {
            System.out.println("Lista de Cursos nula o vacia.");
            return progresses;
        }

        for (Course course : courses) {
            for (Student student : students) {
                Progress progress = new Progress(student, course);
                int attendedClasses = 0;

                for (Clase clase : course.getClases()) {
                    if (clase.getEnrolledStudents() != null) {
                        for (Student enrolledStudent : clase.getEnrolledStudents()) {
                            if (enrolledStudent.getId().equals(student.getId())) {
                                attendedClasses++;
                                break;
                            }
                        }
                    }
                }

                int totalClasses = course.getClases().size();
                double progressPercentage = (totalClasses > 0) ? ((double) attendedClasses / totalClasses) * 100 : 0;

                if (progressPercentage < 0) {
                    progressPercentage = 0;
                }

                progress.setProgressPercentage(progressPercentage);
                progresses.add(progress);
            }
        }

        return progresses;
    }
}
