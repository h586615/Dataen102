package dat102.hvl;

public class Main {
	public static void main(String[] args) {
		Butikk coop = new Butikk("extra",3);
		
		coop.leggInnNyVare(1);
		coop.finnVare(1);
		System.out.println(coop.erLedigPlass());
	//	coop.slettVare(1);
		//coop.detaljSalg(3);
		//coop.grossInnkjop(1,4);
		//coop.salgsVerdi();
	coop.skrivUtVarer();
	}
}
