package org.finalProyect.utilities.Generators;

import org.finalProyect.enums.TypeMaterial;
import org.finalProyect.models.DidacticMaterial;

public class DidacticMaterialGenerator {
    //Se crean los valores de los materiales didácticos.
    TypeMaterial[] typeMaterials = TypeMaterial.values();
    //Se crean los valores de los enlaces.
    String[] plinks = {"https://cursosonline.com/video", "https://cursosonline.com/audio", "https://cursosonline.com/partitura"};

    /**
     * Genera un tipo de material didáctico aleatorio.
     * @return un valor aleatorio de TypeMaterial.
     */
    public TypeMaterial generateTypeMaterial(){
        return typeMaterials[PersonGenerator.random.nextInt(typeMaterials.length)];
    }

    /**
     * Genera un enlace aleatorio de los disponibles.
     * @return un enlace aleatorio en formato de String.
     */
    public String generateLink(){
        String link = plinks[PersonGenerator.random.nextInt(plinks.length)];
        return link;

    }

    /**
     * Crea un material didáctico con valores generados aleatoriamente.
     * @return una instancia de DidacticMaterial con valores generados.
     */
    public DidacticMaterial createDidacticMaterial(){
        DidacticMaterial didacticMaterial = new DidacticMaterial("material 1 ",generateTypeMaterial(), generateLink());
        return didacticMaterial;
    }

}
