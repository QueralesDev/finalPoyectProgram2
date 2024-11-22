
package org.finalProyect.models;

import org.finalProyect.enums.TypeSpeciality;

import java.util.Objects;

public class Teacher extends AbstractPerson {
    private TypeSpeciality speciality;

    public Teacher(){
        super();
    }

    public Teacher(String name, String lastName, String dni, String email, TypeSpeciality speciality) {
        super(name, lastName, dni, email);
        setSpeciality(speciality);
    }

    public TypeSpeciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(TypeSpeciality speciality) {
        if (speciality == null) {
            throw new IllegalArgumentException("La especialidad no puede estar vacia");
        }
        this.speciality = speciality;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Especialidad.........: " + speciality);
        System.out.println("________________________________________________________________________");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "speciality=" + speciality +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getId(), teacher.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
