
package org.finalProyect.models;

import org.finalProyect.enums.TypeSpeciality;

import java.util.Objects;

public class Teacher extends AbstractPerson {
    private TypeSpeciality speciality;

    /**
     * Constructor por defecto para Teacher
     * Inicializa un nuevo objeto Teacher
     */
    public Teacher(){
        super();
    }


    /**
     * Constructor para Teacher con parámetros
     * `@param` name El nombre del docente
     * `@param` lastName El apellido del docente
     * `@param` dni El DNI del docente
     * `@param` email El correo electrónico del docente
     * `@param` speciality La especialidad del docente
     */
    public Teacher(String name, String lastName, String dni, String email, TypeSpeciality speciality) {
        super(name, lastName, dni, email);
        setSpeciality(speciality);
    }


    /**
     * Obtiene la especialidad del docente
     * `@return` La especialidad del docente
     */
    public TypeSpeciality getSpeciality() {
        return speciality;
    }


    /**
     * Establece la especialidad del docente
     * `@param` speciality La especialidad a establecer
     * `@throws` IllegalArgumentException si la especialidad es null
     */
    public void setSpeciality(TypeSpeciality speciality) {
        if (speciality == null) {
            throw new IllegalArgumentException("La especialidad no puede estar vacia");
        }
        this.speciality = speciality;
    }


    /**
     * Muestra la información del docente, incluyendo la especialidad
     */
    @Override
    public void show() {
        super.show();
        System.out.println("Especialidad.........: " + speciality);
        System.out.println("________________________________________________________________________");
    }

    /**
     * Devuelve una representación de cadena del objeto Teacher
     * `@return` Una cadena que representa al objeto Teacher
     */
    @Override
    public String toString() {
        return "Teacher{" +
                "speciality=" + speciality +
                "} " + super.toString();
    }


    /**
     * Compara este Teacher con otro objeto para ver si son iguales
     * `@param` o El objeto a comparar
     * `@return` true si los objetos son iguales, false de lo contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getId(), teacher.getId());
    }


    /**
     * Calcula el código hash para este docente
     * `@return` El código hash del docente
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
