package Ejejercicio;

import java.util.Arrays;

public class Ejercicio4a {
	public static int f(int x, int y) {
		if (y == 0)
			return x;
		else {
			return f(x, y - 1) + f(x + 1, y - 1);
		}
	}



	
	
	
	public static void main(String[] args) {
		System.out.println(f(2,3));
	

	}

}
