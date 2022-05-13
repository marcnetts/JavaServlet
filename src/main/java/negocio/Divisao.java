package negocio;

/**
 *
 * @author marcnetts
 */
public class Divisao extends Calculo {
    
    public Divisao() {
        this.simbolo = "/";
    }
    
    public Divisao (float valor1, float valor2) {
        super(valor1, valor2);
        this.simbolo = "/";
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
        if (valor2 != 0)
            resultado = valor1 / valor2;
        else{
            System.out.println("Divisão por zero! Resetando resultado...");
            resultado = 0;
        }
    }
    
    @Override
    public String getContaInteira(){
        calcular();
        if (valor2 == 0)
            return String.format("%.3f %s %.3f = Div por zero!", valor1, simbolo, valor2);
        return String.format("%.3f %s %.3f = %.3f", valor1, simbolo, valor2, resultado); 
    }
}
