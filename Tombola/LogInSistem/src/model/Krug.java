package model;

import java.util.ArrayList;
import java.util.Random;

public class Krug {

	private ArrayList<Kuglica> kuglice;
	private ArrayList<Integer> brojevi;
	private ArrayList<Korisnik> ulogovaniKorisnici;
	
	public Krug() {
		kuglice = Database.getInstance().getKuglice();
		popuniBrojeve();
		popuniKorisnike();
	}
	
	private void popuniBrojeve() {
		Random r = new Random();
		for(int i = 0; i < 36; i++) {
			brojevi.add(r.nextInt() % 48 + 1);
		}
	}

	public ArrayList<Kuglica> getKuglice() {
		return kuglice;
	}

	public ArrayList<Integer> getBrojevi() {
		return brojevi;
	}
	
	private void popuniKorisnike() {
		ArrayList<Korisnik> korisnici = Database.getInstance().getKorisnici();
		for(Korisnik k : korisnici) {
			if(k.isLoggedIn()) {
				ulogovaniKorisnici.add(k);
			}
		}
	}
	
	
	
}
