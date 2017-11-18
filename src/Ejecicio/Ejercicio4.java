package Ejecicio;

import java.util.Arrays;

public class Ejercicio4 {
	public static int f(int x, int y) {
		if (y == 0)
			return x;
		else {
			return f(x, y - 1) + f(x + 1, y - 1);
		}
	}
///////////////////////////////////////////////////////////////////
// memorización //////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////
	
	
	
	// principal
	private static void fibM(int x, int y, int z, int[][] fibs) {
		if (fibs[z][y] == -1)
			if (y == 0)
				fibs[z][y] = x;
			else {
				fibM(x, y - 1, z, fibs);
				fibM(x + 1, y - 1, z + 1, fibs);
				fibs[z][y] = fibs[z][y - 1] + fibs[z + 1][y - 1];
			}
	}

	// auxiliar
	public static int fM(int x, int y) {
		int[][] fibs = new int[x + 2][y + 2];
		for (int i = 0; i <= x; i++)
			for (int z = 0; z <= x; z++)
				fibs[i][z] = -1;
		fibM(x, y, 0, fibs);
		return fibs[0][y];
	}

///////////////////////////////////////////////////////////////////
//tabulación //////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////
	public static int fT(int x, int y) {
		int[][] fs = new int[y + 1][y + 1];
		// Calculamos valor inicial en (0,0)
		fs[0][0] = x;
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
		System.out.println(fM(3,3));
		System.out.println(fT(3,3));
	}

}
