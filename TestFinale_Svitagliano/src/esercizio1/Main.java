package esercizio1;

public class Main {

	public static void main(String[] args) {
		
		double somma;
		double media;
		somma=0;
		
		int[] arr = {547, 87, 1, 24, 4, 9, 54, 37, 26, 19};
		
		
		for(int i=0; i<arr.length; i++) {
			somma=somma+arr[i];
		}
		
		media=somma/arr.length;
		
		System.out.println("Media: "+media);

	}

}
