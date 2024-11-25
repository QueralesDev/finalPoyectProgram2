package org.finalProyect.models;

import java.util.UUID;

public abstract class AbstractPerson {
    private UUID id;
    private String name;
    private String lastName;
    private String dni;
    private String email;

    /**
     * Constructor de la clase AbstractPerson.
     * @param name Nombre de la persona.
     * @param lastName Apellido de la persona.
     * @param dni DNI de la persona.
     * @param email Correo electrónico de la persona.
     */
    public AbstractPerson(String name, String lastName, String dni, String email) {
        this.id = UUID.randomUUID();
        setName(name);
        setLastName(lastName);
        setDni(dni);
        setEmail(email);
    }

    /**
     * Constructor de la clase AbstractPerson.
     */
    public AbstractPerson() {

    }

/**
* Obtiene el nombre de la persona.
* `@return` El nombre de la persona.
*/
public String getName() {
        return name;
    }

/**
* Establece el nombre de la persona.
* `@param` name El nombre de la persona.
*/
public void setName(String name) {
        //Verifica que el nombre no sea nulo o vacío
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        //Verifica que el nombre solo contenga letras
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("El nombre solo puede contener letras");
        }
        this.name = name;
    }

/**
* Obtiene el apellido de la persona.
* `@return` El apellido de la persona.
*/
public String getLastName() {
        return lastName;
    }

/**
* Establece el apellido de la persona.
* `@param` lastName El apellido de la persona.
*/
public void setLastName(String lastName) {
        //Verifica que el apellido no sea nulo o vacío
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("El Apellido no puede estar vacío");
        }
        //Verifica que el apellido solo contenga letras
        if (!lastName.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]+")) {
            throw new IllegalArgumentException("El Apellido solo puede contener letras");
        }

        this.lastName = lastName;
    }

/**
* Obtiene el DNI de la persona.
* `@return` El DNI de la persona.
*/
public String getDni() {
        return dni;
    }

/**
* Establece el DNI de la persona.
* `@param` dni El DNI de la persona.
*/
public void setDni(String dni) {
        //Verifica que el DNI no sea nulo o vacío
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío");
        }
        //Verifica que el DNI solo contenga números
        if (!dni.matches("\\d+")) {
            throw new IllegalArgumentException("El DNI debe ser numérico");
        }


        this.dni = dni;
    }

/**
* Obtiene el correo electrónico de la persona.
* `@return` El correo electrónico de la persona.
*/
public String getEmail() {
        return email;
    }

/**
* Establece el correo electrónico de la persona.
* `@param` email El correo electrónico de la persona.
*/
public void setEmail(String email) {
        //Verifica que el email no sea nulo o vacío
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Mail invalido");
        }
        this.email = email;
    }

/**
* Obtiene el ID de la persona.
* `@return` El ID de la persona.
*/
public UUID getId() {
        return id;
    }

/**
* Muestra la información de la persona.
*/
public void show(){
        System.out.println("id...................: " + id);
        System.out.println("Nombre...............: " + name);
        System.out.println("Apellido.............: " + lastName);
        System.out.println("dni..................: " + dni);
        System.out.println("email................: " + email);
    }

/**
* Devuelve una representación en formato string de la persona.
* `@return` Representación en string de la persona.
*/
@Override
public String toString() {
        return "AbstractPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

