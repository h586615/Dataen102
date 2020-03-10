package dat102.hvl;

public class Kladdeoppgave6 {


	public static int fibonacci (int n) {
		//basis steg først
		if (n == 0 || n == 1) {
			return 1;
		} else {
			int fn = fibonacci(n-1) + fibonacci(n -1);
			return fn;
		}
	}
	public static double potens (double a, int n) {
		if (n == 0) {
			return 1.0;
		} else {
			double rek = a * potens(a,n-1);
			return rek;
		}
	}
	public static double potens2 (double a, int n) {
		if (n == 0) {
			return 1.0;
		} else {
			if (n % 2 == 0) {
				//return potens(a,n/2) * potens(a,n/2);
			double svar = potens2(a,n/2);
			return svar * svar;
			} else {
				double svar = potens2(a,n/2);
				return a*svar*svar;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(potens(3,2));
	}
}
