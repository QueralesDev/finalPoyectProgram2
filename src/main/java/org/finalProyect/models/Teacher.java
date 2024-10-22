package org.finalProyect.models;

import org.finalProyect.enums.TypeMaterial;
import org.finalProyect.enums.TypeSpeciality;

public  class Teacher extends AbstractPerson {
    private TypeSpeciality speciality;

    public Teacher(String name, String lastName, String dni, String email, TypeSpeciality speciality) {
        super(name, lastName, dni, email);
        this.speciality = speciality;
    }

    public TypeSpeciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(TypeSpeciality speciality) {
        this.speciality = speciality;
    }


}
