package no.hvl.dat102;

import no.hvl.dat102.Film;
import no.hvl.data102.adt.FilmArkivADT;

public class Filmarkiv implements FilmArkivADT {
	private Film[] filmTabell;
	private int antallFilmer;

	public Filmarkiv(int antall) {
		this.filmTabell = new Film[antall];
		this.antallFilmer = 0;
	}

	public void leggTilFilm(Film film) {
		if (antallFilmer < filmTabell.length) {
			filmTabell[antallFilmer] = film;
			antallFilmer++;
		}
		// feilmeld nødvendig?
	}

	public boolean slettFilm(int filmNr) {
		int sok = sokNr(filmNr);
		if (sok != -1) {
			// comments show alternative solution
			antallFilmer--;
			filmTabell[sok] = filmTabell[antallFilmer]; // -1
			filmTabell[antallFilmer] = null; // -1
			// antallFilmer--;
			return true;
		}

		return false;
	}

	public Film[] hentFilmTabell() {
		return filmTabell;
	}

	public int sokNr(int filmNr) {
		for (int i = 0; i < antallFilmer; i++) {
			if (filmNr == filmTabell[i].getFilmnr() && filmTabell[i] != null) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Film[] sokTittel(String delstreng) {
		Film[] tittelTabell = new Film[antallFilmer];
		int teller = 0;

		for (int i = 0; i < antallFilmer; i++) {
			if (filmTabell[i].getTittel() != null && filmTabell[i].getTittel().contains(delstreng)) {
				tittelTabell[teller] = filmTabell[i];
				teller++;
			}
		}
		
		return tittelTabell;
	}
	@Override
	public Film[] sokProdusent(String delstreng) {
		Film[] produsentTabell = new Film[antallFilmer];
		int teller = 0;

		for (int i = 0; i < antallFilmer; i++) {

			if (filmTabell[i].getProdusent() != null && filmTabell[i].getProdusent().contains(delstreng)) {
				produsentTabell[teller] = filmTabell[i];
				teller++;
			}
		}
		return produsentTabell;
	}

	public void skrivUtTitler() {
		for (int i = 0; i < antallFilmer; i++) {
			System.out.println(filmTabell[i].getTittel());
		}
	}

	public int antallSjanger(Sjanger sjanger) {
		int antallSjanger = 0;
		for (int i = 0; i < antallFilmer; i++) {
			if (filmTabell[i].getSjanger() == sjanger) {
				antallSjanger++;
			}
		}
		return antallSjanger;
	}

	public int antall() {
		return antallFilmer;
	}
}
