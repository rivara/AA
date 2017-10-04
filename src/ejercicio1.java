
/**
 * Write a description of class ArbolesRecubrimientoCosteMinimo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ejercicio1
{

       public static int Kruskal1 (int[] us, int[] vs, int[] costes, int n) {
      // calcula el coste mínimo y los arcos correspondientes
      // grafo como lista de adyacencia
      // presupone que los arcos vienen ordenados en orden creciente de coste
      // vectores que representan los arcos del MST (orgenes y destinos)
      int[] orig = new int[n-1];
      int[] dest = new int[n-1];
      int a = 0;
      int coste = 0;
      // representacin implcita del bosque de nodos que forman el MST
      int[] conjs = new int[n];
      for (int i=0; i<n; i++)
         conjs[i] = i;
      // bucle voraz
      for (int i=0; i<us.length && a<n; i++) {
         // se selecciona el arco m�s corto
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
            coste += costes[i];
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
      

}