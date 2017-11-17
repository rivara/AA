package Ejecicio;

import java.util.Arrays;

public class Ejercicio4 {
	public static int f(int x, int y) {
		if (y == 0)
			return x;
		else{
			return f(x, y - 1) + f(x + 1, y - 1);
		}
	}
	//memorización 

	
//principal
	private static void fibM(int x,int y, int[] fibs) {
		if (fibs[x] == -1)
			if (y == 0) 
				fibs[x] = x;
			else {
				fibM(x ,y-1, fibs);
				fibM(x +1,y-1, fibs);
				fibs[x] = (fibs[x]+fibs[x+1])+(fibs[x]+fibs[x+1]);
			}
	}
	
	//auxiliar
	public static int fib (int x, int y) {
		int[] fibs = new int[x+2];
			for (int i=0; i<=x; i++)
					fibs[i] = -1;
		fibM(x,y,fibs);
		return fibs[x];
		}

	// tabulación
///////////////////////////////////////////////////////////////7777
////////////////////////////////////////////////////////////////
	/*
	public class Practica_4_ER {
		public static int f (int x, int y) {
		int[][] fs = new int[y + 1][y + 1];
		for (int i=0; i<=y; i++)
		for (int j=0; j<=y; j++)
		fs[i][j] = -1;
		fMem (x, y, fs, 0);
		return fs[0][y];
		}
		 Aplicamos la tabla int[][] fs = new int [y] [x - xinicial]
		Para conseguir esto, X1 será el contador que va incrementándose para
		recorrer las posiciones de la matriz en el orden adecuado, actuando
		como x - xinicial 
		public static void fMem (int x, int y, int[][] fs, int x1) {
		if (fs[x1][y] == -1)
		if (y == 0)
		fs [x1][y] = x;
		else{
		fMem (x, y-1, fs, x1);
		fMem (x+1, y-1, fs, x1+1);
		fs[x1][y] = fs[x1][y-1] + fs[x1+1][y-1];
		}
		}
		}*/
	
	
/////////////////////////////////////////////////////////////////7
///////////////////////////////////////////////////////////////77
	/*public class Practica_4_ER {
		public static int fTab (int x, int y) {
		int[][] fs = new int[y + 1][y + 1];
		// Calculamos valor inicial en (0,0)
		fs[0][0] = x;
		// Calculamos el resto de valores base de la fila 0
		for (int i=1; i<=y; i++)
		fs[i][0] = fs[i-1][0]+1;
		 Vamos bajando niveles (fila 1, fila 2...) y recorriendo para
		sumar encada caso su dos valores a los que apunte (hijos). El
		recorrido de i será hasta y-j porque por cada nivel que bajemos,
		debemos quedarnos en una posición anterior, para nunca pasar de
		la diagonal 
		for (int j=1; j<=y; j++){
		for (int i=0; i<=y-j; i++)
		fs[i][j] = fs[i][j-1] + fs[i+1][j-1];
		}
		return fs[0][y];
		}
		}*/
	
	
	
	public static void main(String[] args) {
		System.out.println(f(5,3));
		System.out.println(fib(5,3));
		//System.out.println(f2(5,3));
		//System.out.println(fi(4));
		//System.out.println(f2(4));
	}

}
