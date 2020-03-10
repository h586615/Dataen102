package no.hvl.dat102.listeklient;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class TabellKlientTestLeggTil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OrdnetListeADT<Integer> liste1 = new TabellOrdnetListe<Integer>();
		liste1.leggTil(1);
		liste1.leggTil(2);
		liste1.leggTil(12);
		liste1.leggTil(13);
		liste1.leggTil(12);
		liste1.leggTil(4);
		liste1.leggTil(3);
		System.out.println(liste1.toString());
		
	}

}
