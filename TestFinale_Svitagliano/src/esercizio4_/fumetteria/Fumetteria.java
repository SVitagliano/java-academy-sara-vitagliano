package esercizio4_.fumetteria;

import java.util.Arrays;

public class Fumetteria {

	private String nome;
	private String via;
	private String titolare;
	private int numFumettiMax;
	private Fumetto [] fumetti;
	
	public Fumetteria(String nome, String via, String titolare, int numFumettiMax, Fumetto[] fumetti) {
		this.nome = nome;
		this.via = via;
		this.titolare = titolare;
		this.numFumettiMax = numFumettiMax;
		this.fumetti = fumetti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getTitolare() {
		return titolare;
	}

	public void setTitolare(String titolare) {
		this.titolare = titolare;
	}

	public int getNumFumettiMax() {
		return numFumettiMax;
	}

	public void setNumFumettiMax(int numFumettiMax) {
		this.numFumettiMax = numFumettiMax;
	}

	public Fumetto[] getFumetti() {
		return fumetti;
	}

	public void setFumetti(Fumetto[] fumetti) {
		this.fumetti = fumetti;
	}
	
	public String stampaDati() {
		
		return "Fumetteria [nome=" + nome + ", via=" + via + ", titolare=" + titolare + ", numFumettiMax="
				+ numFumettiMax + ", fumetti=" + Arrays.toString(fumetti) + "]";
		
	}

	
}
