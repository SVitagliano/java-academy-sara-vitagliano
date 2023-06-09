package esercizio3;

import esercizio3.implementazione.Calciatore;

public class MainTest {

	public static void main(String[] args) {
		
		Calciatore calciatore= new Calciatore ("Marco", "Rossi", 1997, "Napoli", "Napoli", "portiere", 6578, 2005, 20000);
		
		System.out.println("Dati del calciatore: " +calciatore.stampaDati());
		System.out.println("Stipendio mensile del calciatore: " +calciatore.calcolaStipendioMensile());

	}

}
