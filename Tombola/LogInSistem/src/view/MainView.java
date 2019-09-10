package view;

import java.io.FileNotFoundException;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainView {


	public void prikazi(){

		Stage stage1=new Stage();
		stage1.setTitle("Aplikacija");

		Label naslov=new Label("Dobrodosli u nasu aplikaciju!");
		naslov.setFont(Font.font("Verdana",FontWeight.BOLD,20));
		naslov.setTextFill(Color.BLUE);

		Label user=new Label("Username:");
		Label pass=new Label("Password:");

		TextField username=new TextField();
		PasswordField password=new PasswordField();

		Button login=new Button("Login");
		login.setOnAction(e->{
			try {
				GameView.prikaziIgru();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		Label pitanje=new Label("Nemate nalog? Napravite ga:");
		pitanje.setFont(Font.font("Helvetica",FontWeight.SEMI_BOLD,15));

		Button register=new Button("Register");
		register.setOnAction(e-> RegisterWindow.prikazi());

		VBox vertikala=new VBox();
		vertikala.setAlignment(Pos.TOP_CENTER);
		vertikala.setSpacing(80);

		HBox horizontala=new HBox();
		horizontala.setAlignment(Pos.BOTTOM_RIGHT);
		horizontala.getChildren().add(login);


		GridPane grid=new GridPane();
		grid.setVgap(20);
		grid.setHgap(20);
		grid.setAlignment(Pos.BOTTOM_CENTER);
		grid.add(user, 0, 0);
		grid.add(username, 1, 0);
		grid.add(pass, 0, 1);
		grid.add(password, 1, 1);
		grid.add(horizontala, 1, 2);

		VBox vertikala2=new VBox();
		vertikala2.setAlignment(Pos.CENTER);
		vertikala2.setSpacing(20);
		vertikala2.getChildren().addAll(pitanje,register);



		vertikala.getChildren().addAll(naslov,grid,vertikala2);

		Scene scena= new Scene(vertikala,400,400);

		stage1.setScene(scena);
		stage1.show();





	}



}
