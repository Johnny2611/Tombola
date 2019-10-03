package view;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.event.ChangeListener;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Kuglica;

public class GameView {


	public static void prikaziIgru() throws FileNotFoundException{


		Stage gameStage= new Stage();

		gameStage.setTitle("Lucky Six");

		Label naslov=new Label("- Lucky Six -");
		naslov.setFont(Font.font("Verdana",FontWeight.BOLD,40));
		naslov.setTextFill(Color.BLUE);

		Label odaberiteBr = new Label("Odaberite vase brojeve:");
		odaberiteBr.setFont(Font.font("Verdana",FontWeight.BOLD,20));

		Label kombinacija=new Label("Vasa kombinacija:");
		kombinacija.setFont(Font.font("Verdana",FontWeight.BOLD,20));

		Label uplata=new Label("Uplata:");
		uplata.setFont(Font.font("Verdana",FontWeight.BOLD,15));

		Label din=new Label("din");
		din.setFont(Font.font("Verdana",FontWeight.BOLD,15));
		
		Label brojevi=new Label("Kombinacija brojeva");
		din.setFont(Font.font("Verdana",FontWeight.BOLD,15));
		

		TextField zauplatu=new TextField();

		Button odigraj=new Button("Odigraj");
		odigraj.setPrefSize(120, 60);
		odigraj.setPrefSize(120, 60);
		odigraj.setOnAction(e->{
			
			PlayView p=new PlayView();
			p.prikaziBrojeve();
			
		});

		Button napravikomb=new Button("Napravi komb.");
		napravikomb.setPrefSize(120, 50);






		/*RadioButton rb1 = new RadioButton("1");
		rb1.setToggleGroup(brojevi);

		RadioButton rb2 = new RadioButton("2");
		rb1.setToggleGroup(brojevi);

		RadioButton rb3 = new RadioButton("3");
		rb1.setToggleGroup(brojevi);

		RadioButton rb4 = new RadioButton("4");
		rb1.setToggleGroup(brojevi);

		RadioButton rb5 = new RadioButton("5");
		rb1.setToggleGroup(brojevi);

		RadioButton rb6 = new RadioButton("6");
		rb1.setToggleGroup(brojevi);

		RadioButton rb7 = new RadioButton("7");
		rb1.setToggleGroup(brojevi);

		RadioButton rb8 = new RadioButton("8");
		rb1.setToggleGroup(brojevi);
		*/

		FlowPane flowpane = new FlowPane();




		int i;
		for(i=1; i<49; i++){

			RadioButton rb=new RadioButton(Integer.toString(i));
			rb.setScaleX(2);
			rb.setScaleY(2);
			Kuglica k=new Kuglica(i);
			flowpane.getChildren().add(rb);
		}

		flowpane.getChildren().add(napravikomb);
		flowpane.setHgap(60);
		flowpane.setVgap(40);

		/*GridPane pane=new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10));
		pane.add(rb1, 2, 0);
		pane.add(rb2, 1, 0);
		pane.add(rb3, 2, 1);
		pane.add(rb4, 1, 1);
		pane.add(rb5, 2, 2);
		pane.add(rb6, 1, 2);
		pane.add(rb7, 2, 3);
		pane.add(rb8, 1, 3);
		pane.setHgap(10);
		pane.setVgap(5);
*/

		HBox boks1= new HBox();

		boks1.setAlignment(Pos.TOP_CENTER);
		boks1.getChildren().add(naslov);

		HBox boks2= new HBox();
		boks2.setAlignment(Pos.CENTER);
		boks2.getChildren().add(odaberiteBr);

		HBox uplatiboks=new HBox();
		uplatiboks.setAlignment(Pos.CENTER);
		uplatiboks.getChildren().addAll(uplata,zauplatu,din);

		VBox vertikala1=new VBox();
		vertikala1.setAlignment(Pos.CENTER);
		vertikala1.setSpacing(20);
		vertikala1.getChildren().addAll(boks2,flowpane);

		VBox vertikala2=new VBox();
		vertikala2.setAlignment(Pos.CENTER);
		vertikala2.setSpacing(60);
		vertikala2.getChildren().addAll(kombinacija,brojevi,uplatiboks,odigraj);

		HBox boks3=new HBox();
		boks3.setAlignment(Pos.CENTER);
		boks3.setSpacing(100);
		boks3.getChildren().addAll(vertikala1,vertikala2);



		BackgroundFill background_fill = new BackgroundFill(Color.AQUAMARINE,
                CornerRadii.EMPTY, Insets.EMPTY);

		Background background = new Background(background_fill);



		VBox glavni=new VBox();
		glavni.setAlignment(Pos.TOP_CENTER);
		glavni.setSpacing(10);
		glavni.setBackground(background);
		glavni.getChildren().addAll(boks1,boks3);
		glavni.isResizable();
		
		



		
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth();
		int height = gd.getDisplayMode().getHeight();
				
		Scene gamescena=new Scene(glavni,1000,800);


		gameStage.setScene(gamescena);
		//gameStage.setResizable(true);
		gameStage.show();






	}


}
