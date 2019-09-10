package model;
import java.util.ArrayList;

public class Korisnik {

	private ArrayList<Kuglica> kombinacija;
	private int racun;
	private String username;
	private String password;
	private boolean loggedIn;
	
	public Korisnik(String username, String password) {
		this.username = username;
		this.password = password;
		this.racun = 0;
		Database.getInstance().getKorisnici().add(this);
	}

	public int getRacun() {
		return racun;
	}

	public void setRacun(int racun) {
		this.racun = racun;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Kuglica> getKombinacija() {
		return kombinacija;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
	
	
	
}
