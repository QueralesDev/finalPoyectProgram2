package org.finalProyect.models;

import java.util.UUID;

public abstract class AbstractPerson {
    private UUID id;
    private String name;
    private String lastName;
    private String dni;
    private String email;

    public AbstractPerson(String name, String lastName, String dni, String email) {
        this.id = UUID.randomUUID();
        setName(name);
        setLastName(lastName);
        setDni(dni);
        setEmail(email);
    }

    public AbstractPerson() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("El nombre solo puede contener letras");
        }
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("El Apellido no puede estar vacío");
        }
        if (!lastName.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ]+")) {
            throw new IllegalArgumentException("El Apellido solo puede contener letras");
        }

        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío");
        }

        if (!dni.matches("\\d+")) {
            throw new IllegalArgumentException("El DNI debe ser numérico");
        }


        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Mail invalido");
        }
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void show(){
        System.out.println("id...................: " + id);
        System.out.println("Nombre...............: " + name);
        System.out.println("Apellido.............: " + lastName);
        System.out.println("dni..................: " + dni);
        System.out.println("email................: " + email);
    }

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

