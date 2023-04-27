package Becas2;

import java.util.ArrayList;
import java.util.List;

	public class Main {
	    public static void main(String[] args) {
	    	List<Beca> becas = new ArrayList<>();
	    	becas.add(new Beca(1, 4, 300));
	    	becas.add(new Beca(3, 8, 100));
	    	becas.add(new Beca(5, 6, 100));
	    	becas.add(new Beca(6, 12, 200));
	    	becas.add(new Beca(8, 12, 400));
	    	becas.add(new Beca(7, 8, 500));
	    	becas.add(new Beca(1, 12, 200));


	        PlanificadorBecas planificador = new PlanificadorBecas(becas);
	        List<Beca> solucion = planificador.getSolucion();
	        System.out.println("La combinacion de becas con mayor beneficio es el siguiente (ordenadas de mayor a menor): ");
	        for (int i = 0; i < solucion.size(); i++) {
	            System.out.println(solucion.get(i).toString());
	        }
	    }
	}




