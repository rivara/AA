package Ejecicio;

public class Ejercicio4 {
	public static int f(int x, int y) {
		if (y == 0)
			return x;
		else
			return f(x, y - 1) + f(x + 1, y - 1);
	}
	//memorización 

	
//principal
	private static void fibMem(int x,int y, int[][] fibs) {
		if (fibs[x][y] == -1)
			if (y == 0) 
				fibs[x][y] = x;
		else {
				fibMem(x , y - 1 ,fibs);
				fibMem(x+1  ,y - 1, fibs);
				fibs[x][y] = fibs[x][y-1] + fibs[x+1][y-1];
			}
	}
	
	//auxiliar
	public static int fib (int x, int y) {
		int[][] fibs = new int[x+2][y+1];
		for (int i=0; i<=x; i++)
			for (int t=0; t<=y; t++)
					fibs[i][t] = -1;
		fibMem (x,y,fibs);
		return fibs[x][y];
		}

	// tabulación


	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		System.out.println(f(2,2));
		System.out.println(fib(2,2));
	}

}
