package Ejecicio;

public class Ejercicio4 {
	public static int f(int x, int y) {
		if (y == 0)
			return x;
		else
			return f(x, y - 1) + f(x + 1, y - 1);
	}
	//memorización 
	public static int comb (m, n) { public static int comb (m, n) { public static int comb (m, n) { public static int comb (m, n) { public static int comb (m, n) { public static int comb (m, n) { public static int comb (m, n) { public static int comb (m, n) {public static int comb (m, n) { public static int comb (m, n) { public static int comb (m, n) {
		int[ ][ ] combs = new m int[ ][ ] combs = new m int[ ][ ] combs = new m int[ ][ ] combs = new m int[ ][ ] combs = new m int[ ][ ] combs = new m int[ ][ ] combs = new m int[ ][ ] combs = new mint[ ][ ] combs = new int[mint[ ][ ] combs = new int[m int[ ][ ] combs = new m int[ ][ ] combs = new m-n+1][1];
		for (int i=0; i<=m for (int i=0; i<=m for (int i=0; i<=m-n; i++) n; i++) n; i++)
		for (int j=0; j<=n; j++) for (int j=0; j<=n; j++) for (int j=0; j<=n; j++) for (int j=0; j<=n; j++) for (int j=0; j<=n; j++)
		combs[i][j] = 0; combs[i][j] = 0; combs[i][j] = 0; combs[i][j] = 0;combs[i][j] = 0;
		combMem (m, n, combs); combMem (m, n, combs); combMem (m, n, combs); combMem (m, n, combs); combMem (m, n, combs); combMem (m, n, combs);
		return combs[m return combs[m return combs[m -n][n];
		}
	
	
		private static void combMem private static void combMem private static void combMemprivate static void combMem private static void combMem private static void combMem private static void combMem private static void combMem
		(int m, n, int[ ][ ] combs) { (int m, n, int[ ][ ] combs) { (int m, n, int[ ][ ] combs) { (int m, n, int[ ][ ] combs) {(int m, n, int[ ][ ] combs) { (int m, n, int[ ][ ] combs) { (int m, n, int[ ][ ] combs) { (int m, n, int[ ][ ] combs) {(int m, n, int[ ][ ] combs) { (int m, n, int[ ][ ] combs) {(int m, n, int[ ][ ] combs) { (int m, n, int[ ][ ] combs) {
		if (combs[m -n][n] == 0) n][n] == 0) n][n] == 0)n][n] == 0)
		if (n==0||m==n) if (n==0||m==n) if (n==0||m==n)if (n==0||m==n) if (n==0||m==n)
		combs[m combs[m -n][n] = 1; n][n] = 1; n][n] = 1;n][n] = 1;
		else {else { else {else {
		combMem (m combMem (m combMem (m -1, n, combs); 1, n, combs); 1, n, combs); 1, n, combs);
		combMem (m combMem (m combMem (m -1, n 1, n-1, combs); 1, combs);
		combs[m combs[m -n][n] = n][n] =
		combs[m combs[m -n-1][n] + combs[m 1][n] + combs[m1][n] + combs[m 1][n] + combs[m -n][n -1];}}
	//tabulación

	public static void main(String[] args) {
		System.out.println(f(3, 4));
	}

}
