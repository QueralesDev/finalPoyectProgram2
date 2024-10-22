package org.finalProyect.models;

import org.finalProyect.enums.TypeMaterial;

public class DidacticMaterial {
    private String name;
    private TypeMaterial typeMaterial;
    private String link;

    public DidacticMaterial(String name, TypeMaterial typeMaterial, String link) {
        setName(name);
        setTypeMaterial(typeMaterial);
        setLink(link);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre del material no puede estar vacio");
        }
        this.name = name;
    }

    public TypeMaterial getTypeMaterial() {
        return typeMaterial;
    }

    public void setTypeMaterial(TypeMaterial typeMaterial) {
        if (typeMaterial == null) {
            throw new IllegalArgumentException("El tipo der material no puede estar vacio");
        }
        this.typeMaterial = typeMaterial;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        if (link == null || link.isEmpty()) {
            throw new IllegalArgumentException("El link al material no puede estar vacio");
        }
        this.link = link;
    }
}
