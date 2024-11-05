package org.finalProyect.utilities.Generators;

import org.finalProyect.enums.TypeMaterial;
import org.finalProyect.models.DidacticMaterial;

public class DidacticMaterialGenerator {

    TypeMaterial[] typeMaterials = TypeMaterial.values();
    String[] plinks = {"https://cursosonline.com/video", "https://cursosonline.com/audio", "https://cursosonline.com/partitura"};

    public TypeMaterial generateTypeMaterial(){
        return typeMaterials[PersonGenerator.random.nextInt(typeMaterials.length)];
    }

    public String generateLink(){
        String link = plinks[PersonGenerator.random.nextInt(plinks.length)];
        return link;

    }

    public DidacticMaterial createDidacticMaterial(){
        DidacticMaterial didacticMaterial = new DidacticMaterial("material 1 ",generateTypeMaterial(), generateLink());
        return didacticMaterial;
    }

}