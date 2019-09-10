package application;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class RegisterWindow {

public static void prikazi(){


	Stage regprozor=new Stage();
	regprozor.setTitle("Registracija");
	regprozor.initModality(Modality.APPLICATION_MODAL);

	Label naslov=new Label("Registracija:");
	naslov.setFont(Font.font("Verdana",FontWeight.BOLD,20));
	naslov.setTextFill(Color.BLUE);

	Label ime=new Label("Ime:");
	Label user=new Label("Username:");
	Label pass=new Label("Password:");
	Label confpass=new Label("Conf. password:");
	Label mail=new Label("E-mail:");
	Label sifra1=new Label("Sifra mora biti od 3-20 karaktera!");
	sifra1.setVisible(false);

	Label sifra2=new Label("Sifra mora imati veliko slovo!");
	sifra2.setVisible(false);

	Label sifra3=new Label("Sifra mora imati broj!");
	sifra3.setVisible(false);

	Label sifra4=new Label("Sifra mora imati broj i makar jedno veliko slovo!");
	sifra4.setVisible(false);

	Label sifra5=new Label("Nije unesena ista sifra u konfirmaciju!");
	sifra5.setVisible(false);


	TextField zaime=new TextField();
	TextField username=new TextField();
	PasswordField password=new PasswordField();
	PasswordField confirm=new PasswordField();
	TextField email=new TextField();

	Button cancel=new Button("Cancel");
	cancel.setOnAction(e->{

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Information Dialog");
		alert.setHeaderText("Zelite da napustite registraciju?");
		alert.setContentText("Vas nalog nece biti napravljen!");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){

			regprozor.close();
	}

	});



	Button clear=new Button("Clear");
	clear.setOnAction(e->{

		zaime.clear();
		username.clear();
		password.clear();
		confirm.clear();
		email.clear();

	});



	Button done=new Button("Done");
	done.setOnAction(e->{

		sifra1.setVisible(false);
		sifra2.setVisible(false);
		sifra3.setVisible(false);
		sifra4.setVisible(false);
		sifra5.setVisible(false);


		int broj=RegisterControll.ispravnaSifra(password.getText());

		/*if(broj==1){
			System.out.println("Sifra nije pravilne duzine i nema veliko slovo!");
		}
		if(broj==2){
			System.out.println("Sifra nije pravilne duzine i ne sadrzi broj!");
		}*/
		if(broj==3){

			//System.out.println("Sifra ne sadrzi veliko slovo ni broj!");
			sifra4.setVisible(true);
		}
		if(broj==4){
			//System.out.println("Sifra nije pravilne duzine!");
			sifra1.setVisible(true);
		}
		if(broj==5){
			//System.out.println("Sifra ne sadrzi veliko slovo!");
			sifra2.setVisible(true);

		}

		if(broj==6){

			//System.out.println("Sifra ne sadrzi broj!");
			sifra3.setVisible(true);
		}

		if(broj==7){
			System.out.println("Sifra je u redu!");
			boolean ista=RegisterControll.proveriSifru(password.getText(), confirm.getText());
			if(ista==false){
				//System.out.println("Nije unesena ista sifra u konfirmaciju!");
				sifra5.setVisible(true);
			}
		}



	});

	VBox vertikala =new VBox();
	vertikala.setSpacing(60);
	vertikala.setAlignment(Pos.TOP_CENTER);

	GridPane grid=new GridPane();
	grid.setAlignment(Pos.CENTER);
	grid.setVgap(10);
	grid.setHgap(10);
	grid.add(ime, 0, 0);
	grid.add(zaime, 1, 0);
	grid.add(user,0 , 1);
	grid.add(username, 1, 1);
	grid.add(pass, 0, 2);
	grid.add(password,1,2);

	grid.add(sifra1, 2, 2);
	grid.add(sifra2, 2, 2);
	grid.add(sifra3, 2, 2);
	grid.add(sifra4, 2, 2);
	grid.add(sifra5, 2, 3);


	grid.add(confpass, 0, 3);
	grid.add(confirm, 1, 3);
	grid.add(mail, 0, 4);
	grid.add(email, 1, 4);


	HBox horizontala=new HBox();
	horizontala.setSpacing(30);
	horizontala.setAlignment(Pos.CENTER);
	horizontala.getChildren().addAll(cancel,clear,done);

	vertikala.getChildren().addAll(naslov,grid,horizontala);

	Scene scena=new Scene(vertikala,600,400);

	regprozor.setScene(scena);
	regprozor.showAndWait();










}

}
