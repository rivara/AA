package Ejecicio;

public class Ejercicio4 {
	public static int f(int x, int y) {
		if (y == 0)
			return x;
		else
			return f(x, y - 1) + f(x + 1, y - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(f(3, 4));
	}

}
