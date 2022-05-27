package negocio;

/**
 *
 * @author marcnetts
 */
public class Massa implements IMassa {

    @Override
    public float converterQuiloParaLibra(float peso) {
        return peso * (float) 2.2046;
    }

    @Override
    public float converterLibraParaQuilo(float peso) {
        return peso / (float) 2.2046;
    }
    
}
