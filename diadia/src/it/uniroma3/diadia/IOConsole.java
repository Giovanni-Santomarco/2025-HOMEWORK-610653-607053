package it.uniroma3.diadia;
import java.util.Scanner;

public class IOConsole implements IO {
	
	private final Scanner scannerDiLinee = new Scanner(System.in);
	
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	public String leggiRiga() {
		String riga = scannerDiLinee.nextLine();
		return riga;
	}
	
	void close() {
		try {
			scannerDiLinee.close();			
		}catch(Exception e) {
			
		};
	}
}