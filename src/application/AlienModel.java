package application;

import java.util.ArrayList;

public class AlienModel {

	private String regex="^([a-zA-Z]+)$";
	ArrayList<Word> parole;
	
	
	AlienModel(){
		parole=new ArrayList<Word>();
	}
	String wordCheck(String text) {
		if(exists(new Word("a","a"))==-1)
			parole.add(new Word("a","a"));
		String returnedValue="";
		text=text.toLowerCase();
		if(formatType(text)==1) {
			s();
			System.out.println("1");
			return getTraduzione(text.split(" ")[0]);
		}if(formatType(text)==2) {
			s();
			System.out.println("2");
			inserisciTraduzione(new Word(text.split(" ")[0], text.split(" ")[1]));
			return "INFO: La traduzione e' stata inserita/aggiornata con successo.";
		}
		return returnedValue;
		
	}
	//0 se sbagliato, 1 se parola singola, 2 se parola composta
	int formatType(String text) {
		String[] valori=text.split(" ");
		if(valori.length==1) {
			if(valori[0].matches(regex)) {
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
			this.parole.get(index-1).word=parole.word;
			}
		}
	//
	int exists(Word parola){
		boolean trovato=false;
		int pos=0;
		for(Word w:parole) {
			pos++;
			if(w.alien.equals(parola.alien)) {
				trovato=true;
				break;
			}
		}
		if(!trovato)
			pos=-1;
		return pos;
	}
	//
	void s() {
		for(Word w: parole) {
			System.out.println(w.alien+" "+w.word+" ;");
		}
		System.out.println("-------------------------");
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
