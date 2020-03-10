package no.hvl.dat102.adt;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

/**
 * 
 * @author Tallah
 *
 */
public interface FilmarkivADT {
	// Returnere en tabell av
	Film[] hentFilmTabell(); // Legger til en ny tabell

	void leggTilFilm(Film nyFilm);// Sletter en Filmhvis den fins boolean

	boolean slettFilm(int filmNr);// Søker og henter Filmermed en gitt delstrengFilm[]

	Film[] sokTittel(String delstreng);// Søker og henter produsenter med en gitt

	Film[] sokProdusent(String delstreng);// Henter antall Filmer for en gitt sjanger

	int antallSjanger(Sjanger sjanger);// Returnerer antall Filmer

	int antall();
	
	int sokNr(int filmr);
}
