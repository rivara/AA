package Ejecicio;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Ejecicio3_1_b {

	static int nodos;

	public static int sedes_RyP(int[] c0, int[] c1, int f) {

		int[] solParcialial = new int[c0.length];
		int[] solOptimaima = new int[c0.length];
		int coste[][] = { c0, c1 };
		int cota = calculaCota(coste, solParcialial, -1);
		System.out.println("Cota inicial: " + cota+ ". Coste mínimo inicial: 0");
		int cOptimo2 = ryp(coste, 0, f, solParcialial, 0, solOptimaima,Integer.MAX_VALUE, cota);
		System.out.println("Número de nodos creados durante la búsqueda: ");
		System.out.print("Solución óptima: ");
		imprimir(solOptimaima); 

		return cOptimo2;
	}

	/* ramifica y poda */
	private static int ryp(int[][] coste, int i, int f, int[] solParcial,
			int cParcial, int[] solOptima, int cOptimo, int cota) {
		for (int j = 0; j < coste.length; j++) {
			solParcial[i] = j;
			cota = calculaCota(coste, solParcial, i);
			if (cota < cOptimo) {
				nodos++;
				int gasto = coste[j][i];
				if (i > 0 && solParcial[i - 1] != j)
					gasto += f;
				cParcial += gasto;
				if (i == solOptima.length - 1) {
					if (cParcial < cOptimo) {
						cOptimo = cParcial;
						for (int k = 0; k < solParcial.length; k++)
							solOptima[k] = solParcial[k];
						System.out.print("Nuevo coste mínimo: " + cOptimo+ ". Estado: ");
						imprimir(solOptima);
					}
				} else
					cOptimo = ryp(coste, i + 1, f, solParcial, cParcial,solOptima, cOptimo, cota);
					cParcial -= gasto;
					
			}
			
		}
	
		return cOptimo;
	}

	private static int calculaCota(int[][] coste, int[] solParcial, int i) {
		int cota = 0;
		for (int j = i + 1; j < solParcial.length; j++)
			cota += mini(coste, j);
		
		for (int j = 0; j <= i; j++)
			cota += coste[solParcial[j]][j];
		return cota;
	}


	   private static int mini (int[][] coste,int j) {
		      int min = Integer.MAX_VALUE;
		      
		      for (int i=0; i<coste.length; i++)
		         if (coste[i][j]<min)
		            min = coste[i][j];
		      return min;
	   }

	private static void imprimir(int[] v) {
		for (int i = 0; i < v.length; i++)
			System.out.print(v[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {

		int c0[] = { 1, 3, 20, 30 };
		int c1[] = { 50, 20, 2, 4 };
		int f = 10;

		System.out.println(sedes_RyP(c0, c1, f));
		System.out.println("numero de nodos creados: " + nodos);
	}
}
