package no.hvl.dat102.kjedet;

import no.hvl.dat102.EmptyCollectionException;
import no.hvl.dat102.adt.*;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = foerste.getElement();
		foerste = foerste.getNeste();
		antall--;
		return resultat;

	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		LinearNode<T> denne = foerste;
		LinearNode<T> forrige = null;
		while (denne != siste) { // For å gå gjennom den kjedete listen for å finne den siste
			forrige = denne;
			denne = denne.getNeste();
		}
		siste = forrige; // Setter den siste til å være den forrige
		// fordi det nåværende siste elementet skal slettes, dermed hopper det 1 plass
		// bak.
		resultat = denne.getElement(); // fordi elementet skal returneres.
		if (forrige != null) {
			forrige.setNeste(null);
		}
		antall--;

		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		return foerste.getElement();
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {
		LinearNode<T> ny = new LinearNode<T>(element);

		// Finne posisjon den skal settes inn (settes mellom forrige og denne)
		LinearNode<T> denne = foerste;
		LinearNode<T> forrige = null;

		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (forrige == null) { // hvis du skal sette in først
			ny.setNeste(foerste);
			foerste = ny;
		} else { // sette inn midt i kjedetlisten
			ny.setNeste(denne);
			forrige.setNeste(ny);
		}
		if (denne == null) { // oppdaterer siste
			siste = ny;
		}
		antall++;
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // Første element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
