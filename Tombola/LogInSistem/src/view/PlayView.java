package view;

import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PlayView {
	
	public void prikaziBrojeve() {
		
		
		Stage reelStage=new Stage();
		
		Label naslov=new Label("- Lucky Six -");
		naslov.setFont(Font.font("Verdana",FontWeight.BOLD,40));
		naslov.setTextFill(Color.BLUE);
		
		Button start= new Button("START");
		
		Label broj=new Label("1");
		broj.setFont(Font.font("Verdana",FontWeight.BOLD,60));
		broj.setTextFill(Color.BLUE);
		
		FlowPane pane=new FlowPane();
		Random rand=new Random();
		
		int i;
		for(i=1; i<37; i++) {
			
			TextField tf=new TextField();
			int random=(int)(Math.random()*48+1);
			tf.setText(Integer.toString(random));
			tf.setPrefSize(50, 50);
			
			pane.getChildren().add(tf);
			
			
		}
		
		pane.setHgap(40);
		pane.setVgap(40);
		
		
		VBox glavni=new VBox();
		glavni.setAlignment(Pos.CENTER);
		glavni.setSpacing(50);
		glavni.getChildren().addAll(naslov,start,broj,pane);
		
		Scene scena=new Scene(glavni,800,800);
		
		reelStage.setScene(scena);
		reelStage.show();
		
		
		
		
		
		
		
	}
	

}
