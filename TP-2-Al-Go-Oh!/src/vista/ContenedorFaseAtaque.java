package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import vista.handlers.BotonAtacarHandler;
import vista.handlers.BotonPasarDeFaseHandler;
import vista.handlers.BotonTomarCartaHandler;

public class ContenedorFaseAtaque extends BorderPane{

	BarraDeMenu menuBar;
	Canvas canvasCentral;
	VBox contenedorCentral;
	
	public ContenedorFaseAtaque(Stage stage, Scene escenaFaseTrampas, Scene escenaFaseMagia) {
        this.setMenu(stage);
        this.setCentro();
        this.setBotonera(stage, escenaFaseTrampas, escenaFaseMagia);
        
	}
	
	private void setBotonera(Stage stage, Scene escenaFaseTrampas, Scene escenaFaseMagia) {
		
		Label nombreFase = new Label();
		nombreFase.setText("Fase Ataque");
		nombreFase.setFont(Font.font("courier new", FontWeight.EXTRA_BOLD, 25));
		nombreFase.setTextFill(Color.BLACK);
		
        Button botonAtacar = new Button();
        botonAtacar.setText("Atacar");
        botonAtacar.setMaxWidth(200);
	    botonAtacar.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
	    
		Button botonPasarDeFase = new Button();
        botonPasarDeFase.setText("Pasar de fase");
        botonPasarDeFase.setMaxWidth(150);
	    botonPasarDeFase.setStyle("-fx-font: 15 arial; -fx-base: #b6e7c9;");
	    
	    BotonAtacarHandler botonAtacarHandler = new BotonAtacarHandler(stage, escenaFaseTrampas);
	    botonAtacar.setOnAction(botonAtacarHandler);
	    
	    BotonPasarDeFaseHandler botonPasarDeFaseHandler = new BotonPasarDeFaseHandler(stage, escenaFaseMagia);
	    botonPasarDeFase.setOnAction(botonPasarDeFaseHandler);

        VBox contenedorVertical = new VBox(nombreFase, botonAtacar, botonPasarDeFase);
        contenedorVertical.setSpacing(200);
        contenedorVertical.setAlignment(Pos.TOP_CENTER);
        contenedorVertical.setPadding(new Insets(20));
        contenedorVertical.setPrefWidth(300);
        Image imagen = new Image("file:src/vista/imagenes/repetible.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorVertical.setBackground(new Background(imagenDeFondo));

        this.setRight(contenedorVertical);
	}

	private void setCentro() {
		canvasCentral = new Canvas(460, 220);
		 
        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        Image imagen = new Image("file:src/vista/imagenes/red-checkered.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));
        
        this.setCenter(contenedorCentral);
	}

	private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);		
	}
	
	public BarraDeMenu getBarraDeMenu() {
		return menuBar;
	}
}