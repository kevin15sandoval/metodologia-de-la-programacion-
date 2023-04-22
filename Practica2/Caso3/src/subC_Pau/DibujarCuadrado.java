package subC_Pau;

public class DibujarCuadrado {
	public static void dibujarCuadrado(int n, int[] tamaniosBaldosas, int[] cantidadesBaldosas) {
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
