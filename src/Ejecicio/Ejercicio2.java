package Ejecicio;

public class Ejercicio2 {

	public static int sedes1 (int[] c0, int[] c1, int f) {
	//int[] result= new int[f+c0.length+c1.length];
	int result=0;
	boolean esta=false;
		for(int d =0; d < c0.length; d ++ ) {
			
			//if a >b coge a
			if(c0[d]<=c1[d]) {
				result=result+c0[d];
				esta=false;
			}else {
				if(esta) {
					result=result+c0[d];
					esta=true;
				}else {
					
				}
			}
		}
			
			
			/*
			//suma 
			// if a<b coge b
			if(c0[d]>c1[d]) {
				result=result+c1[d];
			}else {
				result=result+f;
			}
			//suma
			result=result+f;
		}*/
		
		return result;
	}
	/*
	public static int sedes2 (int[] c0, int[] c1, int f) {}*/
	
	public static void main(String[] args) {
		  int c0[]={1,3,20,30};
		  int c1[]={50,20,2,4};
		  int f=10;
		  System.out.print(sedes1(c1,c0,f));
		  
	}
}

