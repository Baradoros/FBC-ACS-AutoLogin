package main;

@SuppressWarnings("unused")
public class Main {
	
	
	public Main() {
		Handler handler = new Handler();
		GUI gui = new GUI();
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		new Main();
		long end = System.nanoTime();
		System.out.println("Time: " + (end - start) * 0.000000001);
	}
}
