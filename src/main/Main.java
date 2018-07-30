package main;

public class Main {
	
	
	@SuppressWarnings("unused")
	public Main() {
		Handler handler = new Handler();
		GUI gui = new GUI();
	}
	
	public boolean connected() {
		return false;
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
