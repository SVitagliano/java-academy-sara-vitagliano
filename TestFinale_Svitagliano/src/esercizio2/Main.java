package esercizio2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int dimensione=5;
		int condizione=0;
		double somma;
		somma=0;
		double media;
		int voto;
		int i=0;
		
		int [] voti= new int[dimensione];
		
		Scanner sc= new Scanner(System.in);
		
		do {
			
			System.out.println("Inserire voto, -1 se si vuole uscire ");
			voto=sc.nextInt();
			
			if(voto==-1) {
				System.out.println("Terminato!");
				condizione=-1;
				
			}else if(voto<18 || voto>30) {
				System.out.println("Valore inserito non corretto!");
				
			}
			else {
			voti[i]=voto;
			i++;
			}
			
		}while(condizione!=-1);
		
		
		for(int a=0; a<dimensione; a++) {
			somma=somma+voti[i];
		}
		
		media=somma/dimensione;

		System.out.println("La media dei voti è: " +media);
		
		sc.close();
	}

}
