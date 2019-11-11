package no.hvl.dat100.jplab12.oppgave4;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

import no.hvl.dat100.jplab12.oppgave3.*;
import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;


public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";
	
	public static boolean skriv(Blogg samling, String filnavn) throws IOException{
		try {
		Innlegg[] tab = samling.getSamling();
		PrintWriter printWriter = new PrintWriter(MAPPE+filnavn);
		for (int i = 0; i < samling.getAntall(); i++) {
			printWriter.printf(tab[i].toString());
		}
		printWriter.close();

		return true;
		}
	catch (FileNotFoundException var7) {
        JOptionPane.showMessageDialog(null, "Filen " + filnavn + " finnes ikke. \n" + var7.getMessage());
	}
		return false;
	}
}