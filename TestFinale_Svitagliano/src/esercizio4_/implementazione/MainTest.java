package esercizio4_.implementazione;

import esercizio4_.fumetteria.Fumetteria;
import esercizio4_.fumetteria.Fumetto;

public class MainTest {

	public static void main(String[] args) {
		
int dim=6;
		
		Fumetto fumetto1=new Fumetto("Topolino", "Sara", 2008, 10, "Disney", "Topolino", "Sara");
		Fumetto fumetto2=new Fumetto("Paperino", "Matteo", 2005, 20, "Disney", "Paperino", "Matteo");
		
		Fumetto [] arrayFumetto=new Fumetto[dim];
		
		arrayFumetto[0]=fumetto1;
		arrayFumetto[1]=fumetto2;
		
		Fumetteria fumetteria=new Fumetteria("Marvel", "via Napoli", "Marco", 100, arrayFumetto);
		
		System.out.println(fumetteria.stampaDati());

	}

}
