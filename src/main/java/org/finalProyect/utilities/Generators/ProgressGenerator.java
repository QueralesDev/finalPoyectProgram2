package org.finalProyect.utilities.Generators;

import org.finalProyect.models.Clase;
import org.finalProyect.models.Course;
import org.finalProyect.models.Progress;
import org.finalProyect.models.Student;

import java.util.ArrayList;
import java.util.List;

public class ProgressGenerator {

    /**
     * Genera una lista de progresos basada en listas de estudiantes y cursos.
     * @param students Lista de estudiantes para evaluar
     * @param courses Lista de cursos para evaluar
     * @return Lista generada de instancias de Progresos
     */
    public List<Progress> generateProgresses(List<Student> students, List<Course> courses) {
        List<Progress> progresses = new ArrayList<>();
        System.out.println("Generando Progresos Aleatorios ");
        // Verificar si las listas de estudiantes y cursos son nulas o vacías
        if (students == null || students.isEmpty()) {
            System.out.println("Lista de estudiantes nula o vacía.");
            return progresses;
        }
        // Verificar si las listas de estudiantes y cursos son nulas o vacías
        if (courses == null || courses.isEmpty()) {
            System.out.println("Lista de Cursos nula o vacía.");
            return progresses;
        }
        // Iterar sobre cada curso y estudiante para generar progresos
        for (Course course : courses) {
            for (Student student : students) {
                // Verificar si el estudiante está inscrito en el curso
                boolean isEnrolled = false;
                for (Clase clase : course.getClases()) {
                    // Verificar si el estudiante está inscrito en la clase actual
                    if (clase.getEnrolledStudents() != null) {
                        for (Student enrolledStudent : clase.getEnrolledStudents()) {
                            if (enrolledStudent.getId().equals(student.getId())) {
                                isEnrolled = true;
                                break;
                            }
                        }
                    }
                    if (isEnrolled) {
                        break;
                    }
                }

                // Solo generar progreso si el estudiante está inscrito
                if (isEnrolled) {
                    Progress progress = new Progress(student, course);
                    int attendedClasses = 0;

                    for (Clase clase : course.getClases()) {
                        // Verificar si el estudiante está inscrito en la clase actual
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
                    // Asegurarse de que el porcentaje de progreso no sea negativo
                    if (progressPercentage < 0) {
                        progressPercentage = 0;
                    }

                    progress.setProgressPercentage(progressPercentage);
                    progresses.add(progress);
                }
            }
        }

        return progresses;
    }
}
