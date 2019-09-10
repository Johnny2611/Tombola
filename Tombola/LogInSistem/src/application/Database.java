package model;

import java.util.ArrayList;

public class Database {

	private static Database instance;
	private ArrayList<Kuglica> kuglice;
	private ArrayList<Korisnik> korisnici;
	
	private Database() {
		kuglice = new ArrayList<>();
		korisnici = new ArrayList<>();
	}
	
	public static Database getInstance() {
		if(instance == null) {
			instance = new Database();
		}
		return instance;
	}

	public ArrayList<Kuglica> getKuglice() {
		return kuglice;
	}
	
	public ArrayList<Korisnik> getKorisnici(){
		return korisnici;
	}
	
	
}
