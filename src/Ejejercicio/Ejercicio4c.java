package Ejejercicio;


public class Ejercicio4c {

	
	///Tabulacion
	
	public static int fibT (int x, int y) 
	{	  
	 int[]fibs = new int[y+1];
	 
	 for (int n=0; n<=y; n++)
		 fibs[n] = (x+y)-n;
	 		 
	 for (int n=0; n<y; n++) {	
	    for (int j=0; j<y-n; j++){
	    	fibs [j]=fibs[j]+fibs[j+1];	    	  		
	    }
	   
	}
	return fibs[0];

	}
	
	
	
	
	
	
	

	public static void main(String[] args) {

		System.out.println(fibT(3,3));
	}




}

