package no.hvl.dat102.tabell;

import no.hvl.dat102.EmptyCollectionException;
import no.hvl.dat102.adt.OrdnetListeADT;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		T resultat = liste[bak - 1];
		liste[bak - 1] = null;
		bak--;
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		bak--;
		for (int i = 0; i < bak; i++) {
			liste[i] = liste[i + 1];
		}
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		// ...Fyll ut

		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {
		if (bak == liste.length) {
			utvid();
		}
		if (bak == 0) { // Dersom listen er tom så legges elementet inn
			// På første posisjon
			liste[0] = element;
			bak++;
		} else {
			int j = 0;
			for (int i = 0; i < bak; i++) { // For å finne hvor elementet skal plasseres
				if (liste[i].compareTo(element) < 0) { //
					j = i + 1;
				}
			}
			for (int k = bak; k > j; k--) { // flytte alle elementenr mellom bak og j
				//
				liste[k] = liste[k - 1];
			}
			liste[j] = element;
			bak++;
		}
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	@Override
	public T fjern(T element) {
		if (erTom())
			throw new EmptyCollectionException("ordnetliste");
		T svar = null;
		int indeks = finn(element);
		if (indeks >= 0 && indeks < bak) {
			svar = liste[indeks];
			for (int i = indeks; i < bak; i++) {
				liste[i] = liste[i + 1];
			}
			bak--;
		}
		return svar;
	}

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;
		for (i = 0; i < bak; i++) {
			if (liste[i].equals(el)) {
				resultat = i;
			}
		}

		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
