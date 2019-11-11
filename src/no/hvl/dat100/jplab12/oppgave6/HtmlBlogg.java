package no.hvl.dat100.jplab12.oppgave6;

import no.hvl.dat100.jplab12.oppgave1.Innlegg;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.Blogg;
import no.hvl.dat100.jplab12.common.TODO;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
	@Override
	public String toString() {
		
		String st = HTMLPREFIX;
		Innlegg[] samling = this.getSamling();
		
		if(samling[this.getAntall()] instanceof Tekst) {
			st += samling[this.getAntall()].toHTML();
		}
		else if(samling[this.getAntall()] instanceof Bilde) {
			st += samling[this.getAntall()].toHTML();
		}
		st+=HTMLPOSTFIX;
		
		return st;
		
	}
}
