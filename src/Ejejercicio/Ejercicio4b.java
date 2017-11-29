package Ejejercicio;

import java.util.Arrays;

public class Ejercicio4b {

	//Memorizacion
	
	// principal
	private static void fibM(int x, int y, int aux, int[][] fibs) {
                
		if (fibs[aux][y] == -1)
			if (y == 0) {
				fibs[aux][y] = x;
			} else {
				fibM(x + 1, y - 1, aux + 1, fibs);
				fibM(x, y - 1, aux, fibs);
				fibs[aux][y] = fibs[aux][y - 1] + fibs[aux + 1][y - 1];

			}
	}

	
	//auxiliar
	public static int fib(int x, int y) {
		int[][] fibs = new int[x + 2][y + 2];
		for (int i = 0; i <= x; i++)
			for (int z = 0; z <= y; z++)
				fibs[i][z] = -1;
		int aux=0;
		fibM(x, y, aux, fibs);
		return fibs[0][y];
	}


	
	
	public static void main(String[] args) {

		System.out.println(fib(3,3));
		
	}

}
