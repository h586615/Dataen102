package dat102.hvl;

import static javax.swing.JOptionPane.*;

public class Vare {

	protected int varenummer;
	private String navn;
	private double pris;
	private int antall;
	
	public Vare () {
		
	}
	
	public static void main (String[] args) {
		
	}
	
	public Vare(int varenr) {
		this.varenummer = varenr;
	}
	public Vare(int varenummer, String navn, double pris, int antall) {
		this.varenummer = varenummer;
		this.navn = navn;
		this.pris = pris;
		this.antall = antall;
	}

	public int getVareNr() {
		return varenummer;
	}
	public void setVareNr(int varenummer) {
		this.varenummer = varenummer;
	}
	
	public String getNavn() {
		return navn;
	}
	public int getAntall() {
		return antall;
	}

	public void setAntall(int antall) {
		this.antall = antall;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	public double getPris() {
		return pris;
	}
	public void setPris(double pris) {
		this.pris = pris;
	}
	
	public void lesVare() {
		navn = showInputDialog("Oppgi navn til varen");
		boolean positivPris = false;
		do {
		pris = Double.parseDouble(showInputDialog("Oppgi prisen til varen"));
		if (pris > 0) {
			positivPris = true;
		}
		} while (!positivPris);
	}
	
	public String toString() {
		String output = "Varen heter: " +  getNavn() + " Varen koster : " + getPris() + " Varenummeret er: "
				+ getVareNr();
		return output;
	}
	
}
