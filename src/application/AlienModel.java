package application;

import java.util.ArrayList;

public class AlienModel {

	private String regex="^([a-zA-Z]+)$";
	ArrayList<Word> parole;
	
	
	AlienModel(){
		parole=new ArrayList<Word>();
	}
	/*String wordCheck(String text) {
		text=text.toLowerCase();
		String[] value=text.split(" ");
    	if(value.length==2) {
    		System.out.println("a");
    		if(value[0].matches(regex) && value[1].matches(regex)) {
    			System.out.println("true");
    			inserisciTraduzione(new Word(value[0], value[1]));
    			return "INFO: La traduzione e' stata inserita/aggiornata con successo.";
    		}
		return "ERRORE: Il formato usato non e' corretto. lo standard e': parola traduzione, separati da uno spazio, altrimenti solo la parola se si vuole visualizzare la traduzione. ";
    	}
    	System.out.println("b");
    	s();
    	if(value.length==1)
    		return getTraduzione(value[0]);
    	else 
    		return "ERRORE: Il formato usato non e' corretto. lo standard e': parola traduzione, separati da uno spazio, altrimenti solo la parola se si vuole visualizzare la traduzione. ";
	}*/
	String wordCheck(String text) {
		String returnedValue="";
		text=text.toLowerCase();
		if(formatType(text)==1) {
			return getTraduzione(text.split(" ")[1]);
		}if(formatType(text)==2) {
			inserisciTraduzione(new Word(text.split(" ")[0], text.split(" ")[1]));
			return "INFO: La traduzione e' stata inserita/aggiornata con successo.";
		}
		return returnedValue;
		
	}
	//0 se sbagliato, 1 se parola singola, 2 se parola composta
	int formatType(String text) {
		String[] valori=text.split(" ");
		if(valori.length==1) {
			if(valori[1].matches(regex)) {
				return 1;
			}else
				return 0;
		}else if(valori.length<=2 || valori.length>=1) {
			if(valori[0].matches(regex) && valori[1].matches(regex))
				return 2;
			else
				return 0;
		}return 0;
	}
	
	//
	void inserisciTraduzione(Word parole) {
		int index=exists(parole);
		if(index==-1) {
			this.parole.add(new Word(parole.alien, parole.word));
		}else{
			this.parole.get(index).word=parole.word;
			}
		}
	//decommentare se non si vuole la riscrittura delle vecchie traduzioni.
	/*String inserisciTraduzione(String parole) {
		String[] p=parole.split(" ");
		if(exists(parole==-1)) {
			this.parole.add(new Word(p[0], p[1]));
			return "";
		}
		return "INFO: La parola e' gia' presente nel database.";
		}*/
	//
	int exists(Word parola){
		int pos=-1;
		for(Word w:parole) {
			pos++;
			if(w.equals(parola))
				return pos;
		}
		return pos;
	}
	//
	void s() {
		for(Word w: parole) {
			System.out.println(w.word+" "+w.word+" ;");
		}
	}
	//
	String getTraduzione(String parola) {
		String traduzione="ERRORE: La parola non e' presente nel database.";
		for(Word w:parole) 
			if(w.alien.equals(parola)) {
				traduzione=w.word;
				break;
			}
		return traduzione;
	}
}

class Word{
	String alien;
	String word;
	Word(String alien, String word){
		this.alien=alien;
		this.word=word;
	}
	
	boolean equals(Word o) {
		if(o.alien.equalsIgnoreCase(alien) && o.word.equalsIgnoreCase(word))
			return true;
		return false;
	}
}
