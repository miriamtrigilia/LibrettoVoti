package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List<Voto> voti;
	
	public Libretto() {
		this.voti = new ArrayList<>(); // non c'è bisogno di riparametrizzare
	}
	
	public Libretto(List<Voto> voti) {
//		#1
//		this.voti = voti; NON VA BENE, così non duplico ma copio. Ho due liste ma 1 puntatore alla stessa lista

//		#2
//		this.voti = new ArrayList<Voto>(voti); // HO DUE LISTE SEPARATE 2 puntatori MA gli oggetto sono comunque uguali

//		#3
//		this.voti = new ArrayList<Voto>();
//		for(Voto v : voti) { // quella passata come parametro
//			this.voti.add(v);
//		} itero su oggetti passati come parametro e li aggiungo alla lista corrente (#2 = #3)
		
//		#4
		this.voti = new ArrayList<Voto>();
		for(Voto v : voti) { // quella passata come parametro
			this.voti.add(new Voto(v.getEsame(),v.getVoto()));
		} // oggetti nuovi che contengono gli stessi valori di quelli di prima. creo nuovo voto a partire dalle info che ho sui voti su cui itero
		
		
		
	}
	
	
	public void add(Voto v) {
		if(this.voti.contains(v)) { // controllo se il voto esiste gia
			System.out.println("Il voto esiste gia'");
			return;
		}
		for(Voto voto : this.voti) { // stesso esame aggiorno voto
			if(voto.getEsame().equals(v.getEsame())) {
				System.out.println("Trovato lo stesso esame (aggiorno il voto)");
				voto.setVoto(v.getVoto());
				return;
			}
			
		}
		
		this.voti.add(v); // superati i controlli aggiungo il voto
		
	}
 	
	

	public void stampa25() {
		// TODO Auto-generated method stub
		for(Voto v: this.voti) {
			if (v.getVoto() == 25)
				System.out.println(v);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ci sono "+voti.size()+ " voti\n");
		
		for(Voto v : this.voti) {
			sb.append(v.toString());
			sb.append("\n");
		}
		
		return sb.toString();
	}

	public String getVotodelCorso(String nomeCorso) {
		for(Voto v: this.voti) {
			if(v.getEsame().toLowerCase().equals(nomeCorso.toLowerCase())) 
				return String.valueOf(v.getVoto());
			
		}
		
		return "nomeCorso non trovato";
		
		
	}



	public List<Voto> getVoti() {
		// TODO Auto-generated method stub
		return this.voti;
	}

	public void alzaVoti() {
		// TODO Auto-generated method stub
		for( Voto v : this.voti) {
			if(v.getVoto()>=24) 
				v.setVoto(v.getVoto()+2);
			else if(v.getVoto()>=18)
				v.setVoto(v.getVoto()+1);
			
		}
		
	}
}
