package org.finalProyect.models;

import org.finalProyect.enums.TypeSpeciality;

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
}
