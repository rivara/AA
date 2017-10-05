package Ejecicio;

public class Ejercicio1 {

/**
 * 
 * @author Ricardo Valle Ramirez
 */
//Algoritmo de ordenacion de cs (valor de los arcos)
	public static int[] ordenarEnIndices (int[] v) {
		int[] v2 = new int[v.length];
		v2[0] = 0;
		for (int i=1; i<v.length; i++) {
		int aux = v[i];
		int j;
		for (j=i-1; j>=0 && v[v2[j]]>aux; j--)
		v2[j+1] = v2[j];
		v2[j+1] = i;
		}
		return v2;
		}

	//Algoritmo original

    public static int Kruskal1 (int[] us, int[] vs, int[] cs, int n) {
      // calcula el coste mínimo y los arcos correspondientes
      // grafo como lista de adyacencia
      // presupone que los arcos vienen ordenados en orden creciente de coste
      // vectores que representan los arcos del MST (origenes y destinos)
      int[] orig = new int[n-1];
      int[] dest = new int[n-1];
      int a = 0;
      int coste = 0;
      // representacion implicita del bosque de nodos que forman el MST
      int[] conjs = new int[n];
      for (int i=0; i<n; i++)
         conjs[i] = i;
      // bucle voraz
      for (int i=0; i<us.length && a<n; i++) {
         // se selecciona el arco mas corto
         int u = us[i];
         int v = vs[i];
         // se halla el conjunto disjunto de sus nodos
         int conju = conjs[u];
         int conjv = conjs[v];
         // se comprueba si pertenecen a conjuntos disjuntos
         if (conju != conjv) {
            orig[a] = u;
            dest[a] = v;
            a++;
            coste += cs[i];
            // se fusionan
            int min = Math.min (conju, conjv);
            int max = Math.max (conju, conjv);
            for (int k=0; k<n; k++)
               if (conjs[k]==max)
                  conjs[k] = min;
         }
      }
      imprimirArcos (orig, dest);
      return coste;
   }


   
   private static void imprimirArcos (int[] orig, int[] dest) {
      for (int i=0; i<orig.length; i++)
         System.out.println ("Arco "+i+": ("+orig[i]+","+dest[i]+")");
   }
   
   

   public static void main(String[] args) {
       
	  /* int us[]={0,0,0,1,1,2,2,3}; 
	   int vs[]={1,2,4,3,4,3,4,4};  
	   int cs[]={16,12,21,6,11,18,33,14};
	   int n=0; */
	   
	   int us[]={2,1,2,0,0}; 
	   int vs[]={3,3,1,2,1};  
	   int cs[]={6,3,5,4,2};
	   int n=4;
	   int a=Kruskal1(us,vs,cs,n);
	  System.out.println(a +"++");
   }
      

}

