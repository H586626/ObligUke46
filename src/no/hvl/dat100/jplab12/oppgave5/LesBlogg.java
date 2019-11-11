package no.hvl.dat100.jplab12.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) {
		Blogg samling = new Blogg();
		try {
			
		File fil = new File(MAPPE+filnavn);
		
		BufferedReader br = new BufferedReader(new FileReader(fil));
		String antallTxt = br.readLine();
			int antall = Integer.parseInt(antallTxt);
			samling = new Blogg(antall);
				for (int i = 0; i < antall; i++) {
					String st = br.readLine();
					if (st.equals(TEKST)) {
						Tekst innlegg = new Tekst(Integer.parseInt(br.readLine()), br.readLine().trim(), br.readLine().trim(),
								Integer.parseInt(br.readLine()), br.readLine());
						samling.leggTil(innlegg);
					} else if(st.equals(BILDE)){
						Bilde innlegg = new Bilde(Integer.parseInt(br.readLine()), br.readLine().trim(), br.readLine().trim(),
								Integer.parseInt(br.readLine()), br.readLine(), br.readLine());

						samling.leggTil(innlegg);
					}
				}
				br.close();
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Filen " + filnavn + " finnes ikke. \n" + e.getMessage());
		}
		
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return samling;
		}
}
	

