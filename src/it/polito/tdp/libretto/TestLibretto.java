package it.polito.tdp.libretto;

import java.util.Collections;
import java.util.Comparator;

public class TestLibretto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Libretto lib = new Libretto();
		
		lib.add(new Voto("Analisi", 30));
		lib.add(new Voto("Chimica",28));
		lib.add(new Voto("TdP", 25));
		lib.add(new Voto("Fisica",18));
		
//		System.out.println("Voti uguali a 25");
//		lib.stampa25();
//		
//		System.out.println(lib.getVotodelCorso("TdP voto: "));
//		
//		lib.add(new Voto("Chimica",28)); // esiste gia
//		lib.add(new Voto("Chimica",27)); // ho cambiato il voto
//		
		
		System.out.println("\nLibretto");
		System.out.println(lib.toString());
		
		Libretto newLib = new Libretto(lib.getVoti());
		
		System.out.println("\nNuovo Libretto");
		System.out.println(newLib.toString());
		
		newLib.alzaVoti();
		
		System.out.println("\nLibretto");
		System.out.println(lib.toString());
		
		System.out.println("\nNuovo Libretto");
		System.out.println(newLib.toString());
		
		Collections.sort(newLib.getVoti());
		
		System.out.println("\nNuovo Libretto");
		System.out.println(newLib.toString());
		
		Collections.sort(newLib.getVoti(), new Comparator<Voto>() {
			public int compare (Voto o1, Voto o2) {
				return -(o1.getVoto() - o2.getVoto());
			}
		});
		
		System.out.println("\nNuovo Libretto");
		System.out.println(newLib.toString());
	}
	

}
