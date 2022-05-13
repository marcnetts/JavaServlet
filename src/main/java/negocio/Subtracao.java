package negocio;

/**
 *
 * @author marcnetts
 */
public class Subtracao extends Calculo {
    
    public Subtracao() {
        this.simbolo = "-";
    }
    
    public Subtracao (float valor1, float valor2) {
        super(valor1, valor2);
        this.simbolo = "-";
    }
            
    @Override
    public float getValor1() {
        return valor1;
    }

    @Override
    public void setValor1(float valor1) {
        this.valor1 = valor1;
    }

    @Override
    public float getValor2() {
        return valor2;
    }

    @Override
    public void setValor2(float valor2) {
        this.valor2 = valor2;
    }

    @Override
    public float getResultado() {
        return resultado;
    }
    
    @Override
    public void calcular() {
        this.resultado = valor1 - valor2;
    }
}
