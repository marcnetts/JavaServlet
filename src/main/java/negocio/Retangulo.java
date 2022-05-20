package negocio;

/**
 *
 * @author marcoszanetti
 */
public class Retangulo extends Figura {
    
    public Retangulo(float largura, float altura){
        super(largura, altura);
    }
    
    @Override
    public void calcularArea() {
        area = getLargura() * getAltura();
    }
}
