package Ejejercicio;

/* A Naive recursive implementation of 0-1 Knapsack problem */
public class Ejercicio5 {

	
//


		// controlamos cual es el mayor y si se ha cambiado de sede
	    // respecto al anterior
		static int min(int a, int b) {
			if(a < b){				
				return a;
			}else{ 
				return b;
			}
		}
		
		
		public static int cambios(int[] c0, int[] c1, int f) {
			int result = 0;
			boolean esta = false;
			for (int d = 0; d < c0.length; d++) {
				if (c0[d] <= c1[d]) {
					result = result + c0[d];
				}
			}
			esta = false;
			for (int d = 0; d < c0.length; d++) {
				if (c0[d] > c1[d]) {
					result = result + c1[d];
					esta = false;
				} else {
					if (!esta) {
						result = result + f;
						esta = true;
					}
				}
			}

			return result;
		}
		
		public static int sedes (int[] c0, int[] c1, int f) {
			return sedesAux(c0,c1,f,c0.length -1);
		}
		
		
		// Returns the maximum value that can be put in a knapsack of capacity W
		public static int sedesAux (int[] c0, int[] c1, int f, int n)
		{
			// Base Case
		if (n == 0 )
			return 0;
		
		
		// Return the maximum of two cases: 
		// (1) sede 0 sea mayor que la sede 1
		// (2) sede 1 sea mayor que la sede 0
		else return min(c0[n]+sedesAux(c0, c1,f, n-1),c1[n]+sedesAux(c0, c1,f,n-1))+ cambios(c0, c1, f);
		}


		
	// Driver program to test above function
	public static void main(String args[])
	{
		int c0[] = new int[]{1,3,20,30};
		int c1[] = new int[]{50,20,2,4};
		int f = 10;
		
		System.out.println(sedes(c0, c1, f));
		}
	}


