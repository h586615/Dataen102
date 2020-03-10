package no.hvl.dat102;

import no.hvl.dat102.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	private int antallFilmer;
	private LinearNode<Film> start;
	// private LinearNode<Film> current;

	public Filmarkiv2() {
		antallFilmer = 0;
		start = null;
		// current = null;
	}

	public static void main(String[] args) {
		Filmarkiv2 arkiv = new Filmarkiv2();
		arkiv.leggTilFilm(new Film(2, "Tallah", "Skole", 2020, Sjanger.ACTION, "Sony"));
		arkiv.leggTilFilm(new Film(1, "yallah", "Skole", 2020, Sjanger.DRAMA, "Warner bros"));
		System.out.println(arkiv.antall());
		//arkiv.slettFilm(2);
		//arkiv.slettFilm(2);
		//System.out.println(arkiv.antall());
		System.out.println(arkiv.antallSjanger(Sjanger.DRAMA));
	}

	// public Film(int filmnr, String produsent, String tittel, int aarstall,
	// Sjanger sjanger, String filmselskap)
	@Override
	public Film[] hentFilmTabell() {
		// TODO Auto-generated method stub
		Film[] filmTabell = new Film[antallFilmer];
		LinearNode<Film> current = start;

		for (int i = 0; i < antallFilmer; i++) {
			filmTabell[i] = current.getElement();
			current = current.getNeste();
			if (current == null) {
				break;
			}
		}
		return filmTabell;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> nyNode = new LinearNode<Film>(nyFilm);
		nyNode.setNeste(start);
		start = nyNode;
		antallFilmer++;
	}

	@Override
	public boolean slettFilm(int filmNr) {
		// TODO Auto-generated method stub
		// 3 typer
		boolean slettetFilm = false;
		LinearNode<Film> forrige = null;
		LinearNode<Film> current = start;

		if (start == null) {
			return slettetFilm;
			// Hvis det er ingen filmer i arkivet
		}

		if (start.getElement().getFilmnr() == filmNr) {
			start = start.getNeste();
			antallFilmer--;
			slettetFilm = true;
			// Hvis det er den aller første filmen som skal slettes
		} else {

			while (current != null && !slettetFilm) {
				if (current.getElement().getFilmnr() == filmNr) {
					forrige.setNeste(current.getNeste());
					antallFilmer--;
					slettetFilm = true;

				}
				forrige = current;
				current = current.getNeste();
			}
		}
		return slettetFilm;
	}

	@Override
	public Film[] sokTittel(String delstreng) {

		LinearNode<Film> current = start;

		// Part one: find amount in order to create array in correct length
		int ant = 0;
		while (current != null) {
			if (current.getElement().getTittel().contains(delstreng)) {
				ant++;
			}
			current = current.getNeste();
		}

		current = start;
		// Part two: create array and copy objects
		Film[] tittelTab = new Film[ant];
		int pos = 0;
		while (current != null) {
			if (current.getElement().getTittel().contains(delstreng)) {
				tittelTab[pos] = current.getElement();
				pos++;
			}
			current = current.getNeste();
		}

		return tittelTab;
	}
	@Override
	public Film[] sokProdusent(String delstreng) {

		LinearNode<Film> current = start;

		// Part one: find amount in order to create array in correct length
		int ant = 0;
		while (current != null) {
			if (current.getElement().getProdusent().contains(delstreng)) {
				ant++;
			}
			current = current.getNeste();
		}

		current = start;
		// Part two: create array and copy objects
		Film[] produsentTab = new Film[ant];
		int pos = 0;
		while (current != null) {
			if (current.getElement().getTittel().contains(delstreng)) {
				produsentTab[pos] = current.getElement();
				pos++;
			}
			current = current.getNeste();
		}

		return produsentTab;
	}

	@Override
	public int antallSjanger(Sjanger sjanger) {
		LinearNode<Film> current = start;
		int antallSjanger = 0;
		while (current != null) {
			if (current.getElement().getSjanger() == sjanger) {
				antallSjanger ++;
			}
			current = current.getNeste();
		}
		return antallSjanger;
	}

	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return antallFilmer;
	}

	@Override
	public int sokNr(int filmr) {
		// TODO Auto-generated method stub
		return 0;
	}

}