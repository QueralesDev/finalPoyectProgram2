
package org.finalProyect.models;

import org.finalProyect.enums.TypeMaterial;

public class DidacticMaterial {
    private String name;
    private TypeMaterial typeMaterial;
    private String link;

    /**
    * Constructor por defecto de DidacticMaterial
    */
    public DidacticMaterial(){

    }

    /**
    * Constructor con parámetros de DidacticMaterial
    * `@param` name Nombre del material
    * `@param` typeMaterial Tipo de material didáctico
    * `@param` link Enlace del material didáctico
    */
    public DidacticMaterial(String name, TypeMaterial typeMaterial, String link) {
        setName(name);
        setTypeMaterial(typeMaterial);
        setLink(link);
    }

    /**
    * Obtiene el nombre del material didáctico
    * `@return` El nombre del material
    */
    public String getName() {
        return name;
    }

    /**
    * Establece el nombre del material didáctico
    * `@param` name Nombre del material
    */
    public void setName(String name) {
        //Verificar que el nombre no sea nulo o vacio sino lanzar una excepcion
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre del material no puede estar vacio");
        }
        this.name = name;
    }

    /**
    * Obtiene el tipo de material didáctico
    * `@return` El tipo de material
    */
    public TypeMaterial getTypeMaterial() {
        return typeMaterial;
    }

    /**
    * Establece el tipo de material didáctico
    * `@param` typeMaterial Tipo de material didáctico
    */
    public void setTypeMaterial(TypeMaterial typeMaterial) {
        //Verificar que el tipo de material no sea nulo sino lanzar una excepcion
        if (typeMaterial == null) {
            throw new IllegalArgumentException("El tipo der material no puede estar vacio");
        }
        this.typeMaterial = typeMaterial;
    }

    /**
    * Obtiene el enlace del material didáctico
    * `@return` El enlace del material
    */
    public String getLink() {
        return link;
    }

    /**
    * Establece el enlace del material didáctico
    * `@param` link Enlace del material didáctico
    */
    public void setLink(String link) {
        //Verificar que el link no sea nulo o vacio sino lanzar una excepcion
        if (link == null || link.isEmpty()) {
            throw new IllegalArgumentException("El link al material no puede estar vacio");
        }
        this.link = link;
    }

    /**
    * Muestra la información del material didáctico
    */
    public void show(){
        System.out.println("<<<<<<Material Didactico del Curso>>>>>");
        System.out.println("Nombre................: " + name);
        System.out.println("Tipo de material...: " + typeMaterial);
        System.out.println("Link del material didactico........: " + link);
    }
}
