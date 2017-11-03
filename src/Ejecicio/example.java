package Ejecicio;

class example {
	public static int mochila_0_1 (int[] ps, int[] bs, int c) {
		  int[] solParcial = new int[ps.length];
	      int[] solOptima = new int[ps.length];
	      int bOpt = buscar01 (ps.length-1, 0, c, 0, solParcial, solOptima, -1, ps, bs, c);
	      imprimir (solOptima);
	      return bOpt;
		   }

private static int buscar01 (int n_1, int i, int p, int b, int[] solParc,
                             int[] solOpt, int bOpt,
                             int[] ps, int[] bs, int c) {
   for (int k=0; k<=1; k++) {
      if (k*ps[i]<=p) {
         solParc[i] = k;
         int np = p - k*ps[i];
         int nb = b + k*bs[i];
         if (i==n_1) {
            if (nb>bOpt) {
               bOpt = nb;
               for (int j=0; j<ps.length; j++)
                  solOpt[j] = solParc[j];
            }
         }
         else
            bOpt = buscar01 (n_1, i+1, np, nb, solParc, solOpt, bOpt, ps, bs, c);
         //int np = p + k*ps[i]; innecesarias porque en la primera iteración k==0
         //int nb = b - k*bs[i];
      }
   }
   return bOpt;
}

		   private static void imprimir (int[] v) {
		      for (int i=0; i<v.length; i++)
		         System.out.print (v[i]+" ");
		      System.out.println();
		   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int c0[] = {1, 3, 20, 30};
		int c1[] = {50, 20, 2, 4};
		
		int f = 2;

		 System.out.println(mochila_0_1(c0, c1, f));

	}

}
