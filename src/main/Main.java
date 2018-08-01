package main;

@SuppressWarnings("unused")
public class Main {
	
	
	public Main() {
		GUI gui = new GUI();
		Handler handler = new Handler(gui);
	}
	
	public static void main(String[] args) {
		long start = System.nanoTime();
		new Main();
		long end = System.nanoTime();
		System.out.println("Time: " + (end - start) * 0.000000001);
	}
}
