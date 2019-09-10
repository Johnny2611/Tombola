package application;

public class RegisterControll {


	public static int ispravnaSifra(String pass){

		char[] niz=pass.toCharArray();

		int i,n;
		boolean flag1=false,flag2=false,flag3=false;

		n=niz.length;
		if(n>3 && n<21){

			flag1=true;
		}

		for(i=0; i<n; i++){

			if(Character.isUpperCase(niz[i])){

				flag2=true;
			}

			if(niz[i]>='0' && niz[i]<='9'){


				flag3=true;

			}

		}

		if(flag1==false ){
			return 4;
		}

		else if(flag2==false && flag3==false){

			return 3;

		}

		else if(flag2==false){
			return 5;
		}
		else if(flag3==false){

			return 6;
		}
		else if(flag1==true && flag2==true && flag3==true){

			return 7;
		}
		else
			return 0;



	}

	public static boolean proveriSifru(String pass1,String pass2){

		if(pass1.equals(pass2)){

			return true;
		}
		else


		return false;
	}


}
