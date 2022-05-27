package negocio;

/**
 *
 * @author marcnetts
 */
public abstract class Figura implements IFigura {
    protected float largura;
    protected float altura;
    protected float area;

    public Figura(){
    }
    
    public Figura(float largura, float altura){
        this.largura = largura;
        this.altura = altura;
    }
    
    public float getLargura() {
        return largura;
    }
    
    public float getAltura() {
        return altura;
    }
    
    public float getArea() {
        return area;
    }
}
