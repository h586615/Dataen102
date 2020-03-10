package dat102.hvl;

import java.lang.*	;

public class TestMode {

	public static void tid(long n) {
		long k = 0;
		float start = System.nanoTime();
		for (long i = 1; i <= n; i++) {
			k = k + 5;
			
		} float slutt = System.nanoTime();
	System.out.println((slutt-start)/1000000);
	}

	public static void main(String[] args) {
		tid(100000000L);
		tid(1000000000L);
		tid(10000000000L);
	}
}
