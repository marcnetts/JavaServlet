package negocio;

/**
 *
 * @author marcnetts
 */
public class Triangulo extends Figura {
    
    public Triangulo(float largura, float altura){
        super(largura, altura);
    }
    
    @Override
    public void calcularArea() {
        area = getLargura() * getAltura() / 2;
    }
}
