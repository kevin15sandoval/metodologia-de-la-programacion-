package Caso4;

public class Beca {
    private int inicio;
    private int fin;
    private int cantidad;

    // @German: constructor
    public Beca(int inicio, int fin, int cantidad) {
        this.inicio = inicio;
        this.fin = fin;
        this.cantidad = cantidad;
    }

    // @German: getters y setters
    public int getInicio() {
        return inicio;
    }
    public void setInicio(int inicio) {
        this.inicio = inicio;
    }
    public int getFin() {
        return fin;
    }
    public void setFin(int fin) {
        this.fin = fin;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
