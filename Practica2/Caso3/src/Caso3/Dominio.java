package Caso3;
import java.util.*;

public class Dominio {
    /*public static void Dominio(int size_solar, int[] listado_baldosas ) {    	
        soladoSuperficie(size_solar , listado_baldosas);        
    }
    */
    public static void main(String[] args) {
        int n = 10; // Tamaño del cuadrado principal
        int[] tamaniosBaldosas = {5, 3, 2}; // Tamaños de los cuadrados de relleno
        soladoSuperficie(n, tamaniosBaldosas);
    }

    private static void soladoSuperficie(int n, int[] tamaniosBaldosas) {
        List<Integer> colaBaldosas = crearColaBaldosas(tamaniosBaldosas);
        int[] cantidadesBaldosas = new int[tamaniosBaldosas.length];
        int areaRestante = n * n;
        while (areaRestante > 0) {
            int baldosa = seleccionarBaldosa(colaBaldosas, areaRestante);
            int cantidadBaldosas = areaRestante / baldosa;
            int indiceTamanioBaldosa = buscarIndiceTamanioBaldosa(tamaniosBaldosas, baldosa);
            cantidadesBaldosas[indiceTamanioBaldosa] += cantidadBaldosas;
            areaRestante -= baldosa * cantidadBaldosas;
        }
        dibujarCuadrado(n, tamaniosBaldosas, cantidadesBaldosas);
    }

    private static List<Integer> crearColaBaldosas(int[] tamaniosBaldosas) {
        List<Integer> colaBaldosas = new ArrayList<Integer>();
        for (int i = 0; i < tamaniosBaldosas.length; i++) {
            colaBaldosas.add(tamaniosBaldosas[i]);
        }
        Collections.sort(colaBaldosas, Collections.reverseOrder());
        return colaBaldosas;
    }

    private static int seleccionarBaldosa(List<Integer> colaBaldosas, int areaRestante) {
        for (int i = colaBaldosas.size() - 1; i >= 0; i--) {
            if (colaBaldosas.get(i) <= areaRestante) {
                return colaBaldosas.get(i);
            }
        }
        return -1; // En caso de error
    }

    private static int buscarIndiceTamanioBaldosa(int[] tamaniosBaldosas, int baldosa) {
        for (int i = 0; i < tamaniosBaldosas.length; i++) {
            if (tamaniosBaldosas[i] == baldosa) {
                return i;
            }
        }
        return -1; // En caso de error
    }
    private static void dibujarCuadrado(int n, int[] tamaniosBaldosas, int[] cantidadesBaldosas) {
    	System.out.println("n = " + n);	
	    int[][] cuadrado = new int[n][n];
	    System.out.println("cuadrado.length = " + cuadrado.length);
	    System.out.println("cuadrado[0].length = " + cuadrado[0].length);
        // Crear cuadrado inicial
        // int[][] cuadrado = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cuadrado[i][j] = 0;
            }
        }
        
        // Mostrar cuadrado inicial
        System.out.println("Cuadrado inicial:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(cuadrado[i][j] + "#");
            }
            System.out.println();
        }
        System.out.println();
        
        // Llenar cuadrado con baldosas
        int fila = 0;
        int columna = 0;
        for (int i = 0; i < tamaniosBaldosas.length; i++) {
            int cantidadBaldosas = cantidadesBaldosas[i];
            for (int j = 0; j < cantidadBaldosas; j++) {
                int tamBaldosa = tamaniosBaldosas[i];
                for (int k = fila; k < fila + tamBaldosa; k++) {
                    for (int l = columna; l < columna + tamBaldosa && l < n; l++) {
                        cuadrado[k][l] = tamBaldosa;
                    }
                }
                columna += tamBaldosa;
                if (columna >= n) {
                    fila += tamBaldosa;
                    columna = 0;
                }
            }
        }
        
        // Mostrar cuadrado final
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tamBaldosa = cuadrado[i][j];
                for (int k = 0; k < tamBaldosa; k++) {
                    for (int l = 0; l < tamBaldosa; l++) {
                        if (k == 0 || l == 0) {
                            System.out.print(tamBaldosa + " ");
                        } else {
                            System.out.print("  ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

}