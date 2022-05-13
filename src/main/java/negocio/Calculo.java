package negocio;

/**
 *
 * @author marcnetts
 */
public abstract class Calculo implements ICalculo {
    protected float valor1;
    protected float valor2;
    protected float resultado;
    protected String simbolo;
    
    public Calculo(){
        this.simbolo = "?";
    }
    
    public Calculo(float valor1, float valor2){
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.simbolo = "?";
    }
    
    public float getValor1() {
        return valor1;
    }

    public void setValor1(float valor1) {
        this.valor1 = valor1;
    }

    public float getValor2() {
        return valor2;
    }

    public void setValor2(float valor2) {
        this.valor2 = valor2;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public float getResultado() {
        return resultado;
    }
    
    @Override
    public void calcular(){
        
    };
    
    public String getContaInteira(){
        calcular();
        return String.format("%.3f %s %.3f = %.3f", valor1, simbolo, valor2, resultado);
    };
}
