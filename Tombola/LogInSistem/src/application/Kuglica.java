package application;

public class Kuglica {

    int broj;
    boolean bonus;

    public Kuglica(int broj){


    	this.broj=broj;
    	if(broj==5 || broj==15 || broj==30){

    		this.bonus=true;
    	}
    	else
    		this.bonus=false;


    }





}
