package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	
	private Set<String> anagrammi;
	private String partial;
	private AnagrammaDAO dao;
	
	public Model() {
		this.dao = new AnagrammaDAO();
	}

	//implemento l'algoritmo ricorsivo
	
	public Set<String> anagramma(String s) {
		this.anagrammi = new HashSet<String>();
		partial = "";
		//prima chiamata al metodo ricorsivo: inizializzazione
		anagramma_ricorsivo(partial, 0 , s, anagrammi);
		return anagrammi;
	}
	
	private void anagramma_ricorsivo(String parziale, int livello, String rimanenti, Set<String> insieme) {
		//caso terminale
		if(rimanenti.length() == 0) {
			//ho finito la ricorsione
			insieme.add(parziale); //aggiungo la soluzione alla lista ottenuta
			return;
		}
		else { //caso normale
			for( int i = 0; i < rimanenti.length(); i++) {
				//creo i sottoproblemi
				//creo la nuova soluzione parziale
				String new_parziale = parziale + rimanenti.charAt(i);
				//ciò che ho messo nella parziale lo tolgo dai rimanenti
				String new_rimanenti = rimanenti.substring(0,i)+rimanenti.substring(i+1);
				//chiamata al metodo ricorsivo: aggiornamento
				anagramma_ricorsivo(new_parziale, livello+1, new_rimanenti, insieme);
				//backtracking
			//	parziale = parziale.substring(0,parziale.length()-1);
			}
		}
	}
	
	//algoritmo per controllare se gli anagrammi sono corretti o meno
	public boolean isCorrect(String anagramma) {
		return this.dao.isCorrect(anagramma);
	}
	
}
