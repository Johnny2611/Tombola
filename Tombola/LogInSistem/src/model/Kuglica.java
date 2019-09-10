package model;

public class Kuglica {
	private int broj;
	private boolean clover;
	
	public Kuglica(int broj){
		this.broj = broj;
		clover = false;
		Database.getInstance().getKuglice().add(this);
	}

	public boolean isClover() {
		return clover;
	}

	public void setClover(boolean clover) {
		this.clover = clover;
	}

	public int getBroj() {
		return broj;
	}
	
	
}
