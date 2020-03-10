package no.hvl.dat102;

import java.util.Scanner;

import javax.swing.JOptionPane;

import no.hvl.data102.adt.FilmArkivADT;

public class Tekstgrensesnitt {

	public Film lesFilm() {

		Film nyFilm;

		Scanner leser = new Scanner(System.in);
		System.out.println("Filmnummer");
		int filmnr = leser.nextInt();
		leser.nextLine();
		System.out.println("Produsent");
		String prod = leser.nextLine();
		System.out.println("Tittel");
		String tittel = leser.nextLine();
		System.out.println("Årstall");
		int aarstall = Integer.parseInt(leser.nextLine());
		System.out.println("Sjanger: Action, Drama, History eller Scifi");
		Sjanger sjang = Sjanger.finnSjanger(leser.nextLine());
		System.out.println("Filmselskap");
		String selskap = leser.nextLine();

		leser.close();

		nyFilm = new Film(filmnr, prod, tittel, aarstall, sjang, selskap);

		return nyFilm;
	}

	/*
	 * public static Film lesFilm() { String filmnummer =
	 * JOptionPane.showInputDialog("Hva er filmnummer?"); int filmnr =
	 * Integer.parseInt(filmnummer); String produsent =
	 * JOptionPane.showInputDialog("Hvem er produsent?"); String tittel =
	 * JOptionPane.showInputDialog("Hva er tittelen til filmen"); String lansering =
	 * JOptionPane.showInputDialog("Når ble filmen produsert?"); int aarstall =
	 * Integer.parseInt(lansering); String sjangerst =
	 * JOptionPane.showInputDialog("Sjanger: "); Sjanger sjanger =
	 * Sjanger.finnSjanger(sjangerst.toUpperCase()); String filmselskap =
	 * JOptionPane.showInputDialog("Hva heter filmselskapet?");
	 * 
	 * Film nyFilm = new Film(filmnr, produsent, tittel, aarstall, sjanger,
	 * filmselskap); return nyFilm; }
	 */

	public void visFilm(Film film) {
		String filmInformasjon = "Filmen heter: " + film.getTittel() + "\nProdusenten heter: " + film.getProdusent()
				+ "\nFilm nummeret er: " + film.getFilmnr() + "\nFilmen ble utgitt i: " + film.getLanseringsAar()
				+ "\nSjangeren er: " + film.getSjanger() + "\nFilmselskapet som ga ut filmen heter: "
				+ film.getFilmselskap();
		System.out.println(filmInformasjon);
	}

	public void skrivUtFilmDelstrengITittel(FilmArkivADT filmer, String delstreng) {
		Film[] filmTabell = filmer.sokTittel(delstreng);
	}

	public void skrivUtFilmProdusent(FilmArkivADT filmer, String delstreng) {
		Film[] produsentTabell = filmer.sokProdusent(delstreng);
		for (int i = 0; i < produsentTabell.length; i++) {
			if (produsentTabell[i].getProdusent().contains(delstreng)) {
				System.out.println(produsentTabell[i].getProdusent());
			}
		}
	}

	public void skrivUtStatistikk(FilmArkivADT filmer) {
		System.out.println("Antall filmer: " + filmer.antall());

		Sjanger[] sjanger = Sjanger.values();
		// system.out.println("Antall sjangre");
		for (int i = 0; i < 4; i++) {
			System.out.println(sjanger[i] + ": " + filmer.antallSjanger(Sjanger.values()[i]));
		}

	}

	// evt. andre metoder

//	public static void main(String[] args) {
		//Filmarkiv filmarkiv = new Filmarkiv(10);
		//filmarkiv.leggTilFilm(new Film(2, "Smed", "Smerte", 2020, Sjanger.ACTION, "Sony"));
		// filmarkiv.leggTilFilm(new Film());
		// filmarkiv.leggTilFilm(new Film());
		// Film minfilm = Tekstgrensesnitt.lesFilm();
		// filmarkiv.leggTilFilm(minfilm);
		// filmarkiv.skrivUtTitler();
		// Tekstgrensesnitt.skrivUtStatistikk(filmarkiv);
		// Tekstgrensesnitt.visFilm(filmarkiv.hentFilmTabell()[0]);
		//Tekstgrensesnitt.skrivUtFilmProdusent(filmarkiv, "Sme");
	//
	}
