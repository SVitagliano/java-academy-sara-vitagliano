package esercizio3.implementazione;

import esercizio3.interfaccia.GiocatoreProfessionista;

public class Calciatore implements GiocatoreProfessionista{

	private String nome;
	private String cognome;
	private int annoNascita;
	private String luogoNascita;
	private String squadra;
	private String ruolo;
	private int costoCartellino;
	private int annoContratto;
	private int stipendioAnnuo;
	
	
	public Calciatore(String nome, String cognome, int annoNascita, String luogoNascita, String squadra, String ruolo,
			int costoCartellino, int annoContratto, int stipendioAnnuo) {
		
		this.nome = nome;
		this.cognome = cognome;
		this.annoNascita = annoNascita;
		this.luogoNascita = luogoNascita;
		this.squadra = squadra;
		this.ruolo = ruolo;
		this.costoCartellino = costoCartellino;
		this.annoContratto = annoContratto;
		this.stipendioAnnuo = stipendioAnnuo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}


	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public int getAnnoNascita() {
		return annoNascita;
	}


	public void setAnnoNascita(int annoNascita) {
		this.annoNascita = annoNascita;
	}


	public String getLuogoNascita() {
		return luogoNascita;
	}


	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}


	public String getSquadra() {
		return squadra;
	}


	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}


	public String getRuolo() {
		return ruolo;
	}


	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}


	public int getCostoCartellino() {
		return costoCartellino;
	}


	public void setCostoCartellino(int costoCartellino) {
		this.costoCartellino = costoCartellino;
	}


	public int getAnnoContratto() {
		return annoContratto;
	}


	public void setAnnoContratto(int annoContratto) {
		this.annoContratto = annoContratto;
	}


	public int getStipendioAnnuo() {
		return stipendioAnnuo;
	}


	public void setStipendioAnnuo(int stipendioAnnuo) {
		this.stipendioAnnuo = stipendioAnnuo;
	}
	
	
	public String stampaDati() {
		
		return "Calciatore [nome=" + nome + ", cognome=" + cognome + ", annoNascita=" + annoNascita + ", luogoNascita="
				+ luogoNascita + ", squadra=" + squadra + ", ruolo=" + ruolo + ", costoCartellino=" + costoCartellino
				+ ", annoContratto=" + annoContratto + ", stipendioAnnuo=" + stipendioAnnuo + "]";
		
	}

	public float calcolaStipendioMensile() {
		return (stipendioAnnuo/12);
	}

	
}
