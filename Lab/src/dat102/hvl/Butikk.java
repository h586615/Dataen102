package dat102.hvl;

public class Butikk {

	private Vare varer[];
	private int antallTyper;

	public Butikk(String butikknavn, int maksAntall) {
		varer = new Vare[maksAntall];
		antallTyper = 0;
	}

	public int finnVare(int varenr) {
		for (int pos = 0; pos < varer.length; pos++) {
			if (varer[pos] != null) {
				if (varer[pos].getVareNr() == varenr) {
					return pos;
				}
			}
		}
		return -1;
	}

	public boolean erLedigPlass() {
		boolean ledigplass = false;
		if (antallTyper < varer.length) {
			ledigplass = true;
		}
		return ledigplass;
	}

	public void leggInnNyVare(int varenr) {
		if (erLedigPlass() == false) {
			System.out.println("Tabellen er full");
		} else {
			if (finnVare(varenr) > -1) {
				System.out.println("Varen finnes allerede i plass: ");
			} else {
				Vare ny = new Vare(varenr);
				ny.lesVare();
				for (int i = 0; i < antallTyper; i++) {
					if ((varenr > varer[i].getVareNr()) && varenr < varer[i + 1].getVareNr()) {
						for (int j = antallTyper; j > i; j--) {
							varer[j] = varer[j - 1];
						}
						varer[i + 1] = ny;
						antallTyper++;
						break;
					}
				}
			}
		}

	}

	public void slettVare(int varenr) {
		if (finnVare(varenr) > -1) {
			for (int i = 0; i < varer.length; i++) {
				if (varenr == varer[i].getVareNr()) {
					for (int j = i + 1; j < antallTyper; j++) {
						varer[j - 1] = varer[j];
					}
					antallTyper--;
					break;
				}
			}
		} else {
			System.out.println("Varen finnes ikke");
		}
	}

	public void detaljSalg(int varenr) {
		if (finnVare(varenr) > -1) {
			for (int i = 0; i < varer.length; i++) {
				if (varer[i].getVareNr() == varenr) {
					varer[i].setAntall(varer[i].getAntall() - 1);
					if (varer[i].getAntall() == 0 ) {
						System.out.println("Varen er tom");
					}
					break;
				}
			}
		} else {
			System.out.println("Varen finnes ikke");
		}
	}
	public void grossInnkjop(int varenr, int ant) {
		if (finnVare(varenr) > -1) {
			for (int i = 0; i < varer.length; i++) {
				if (varer[i].getVareNr() == varenr) {
					varer[i].setAntall(varer[i].getAntall() + ant);
					if (varer[i].getAntall() < 0 ) {
						System.out.println("Varen er tom");
					}
					break;
				}
			}
		} else {
			System.out.println("Varen finnes ikke");
		}
	}
	 public int salgsVerdi() {
		 int verdi = 0;
		 for (int i = 0; i<varer.length; i++) {
			 verdi += (varer[i].getPris()) * (varer[i].getAntall());
		 }
		 return verdi;
	 }
	 public void skrivUtVarer() {
		 for (int i = 0; i<varer.length; i++) {
			 System.out.println(varer[i].toString());
		 }
	 }
}
