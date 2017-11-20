package Ejecicio;

import java.util.Arrays;

public class Ejercicio4a {
	public static int f(int x, int y) {
		if (y == 0)
			return x;
		else {
			System.out.println("z"+x+" "+y);
			return f(x, y - 1) + f(x + 1, y - 1);
		}
	}

	
///////////////////////////////////////
//tabulación////////////////////////
///////////////////////////////////////
	public static int fTab(int x, int y) {
		int[][] fs = new int[x + 1][y + 1];
		// Calculamos valor inicial en (0,0)
		fs[0][0] = x;
		// Calculamos el resto de valores base de la fila 0
		for (int i = 1; i <= y; i++)
			fs[i][0] = fs[i - 1][0] + 1;
		for (int j = 1; j <= y; j++) {
			for (int i = 0; i <= y - j; i++)
				fs[i][j] = fs[i][j - 1] + fs[i + 1][j - 1];
		}
		return fs[0][y];
	}
		
	
	
	
	public static void main(String[] args) {
		System.out.println(f(3,3));
	
		System.out.println(fTab(3,3));
		//System.out.println(fi(4));
		//System.out.println(f2(4));
	}

}
