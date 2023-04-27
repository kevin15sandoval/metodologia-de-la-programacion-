package Becas2;

public class Beca {
    private int mesInicio;
    private int mesFin;
    private int salario;

    //constructor de la clase beca 
    public Beca(int mesInicio, int mesFin, int salario) {
        this.mesInicio = mesInicio;
        this.mesFin = mesFin;
        this.salario = salario;
    }

    public int getMesInicio() {
        return mesInicio;
    }

    public int getMesFin() {
        return mesFin;
    }

    public int getSalario() {
        return salario;
    }
    public String toString() {
        return "Iniciando en el mes " + mesInicio + " hasta el mes " + mesFin + " con un salario de " + salario + "€" ;
    }

}

