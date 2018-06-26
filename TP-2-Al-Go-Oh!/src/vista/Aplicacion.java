package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.aplicacion.AlGoOh;
import modelo.tablero.CampoDeBatalla;
import vista.handlers.AplicacionOnKeyPressEventHandler;

public class Aplicacion extends Application{

    public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(final Stage stage) throws Exception {
		
		stage.setTitle("AlGoOh!");
		
		
		ContenedorCambioDeTurno contenedorCambioDeTurno = new ContenedorCambioDeTurno(stage);
		Scene escenaCambioDeTurno = new Scene(contenedorCambioDeTurno, 640, 480);
		
		ContenedorFaseMagia contenedorFaseMagia = new ContenedorFaseMagia(stage, escenaCambioDeTurno);
		Scene escenaMagia = new Scene(contenedorFaseMagia, 640, 480);
		
		ContenedorFaseTrampas contenedorFaseTrampas = new ContenedorFaseTrampas(stage, escenaMagia);
		Scene escenaTrampas = new Scene(contenedorFaseTrampas, 640, 480);
		
		ContenedorFaseAtaque contenedorFaseAtaque = new ContenedorFaseAtaque(stage, escenaTrampas, escenaMagia);
		Scene escenaAtaque = new Scene(contenedorFaseAtaque, 640, 480);
		
		ContenedorFasePreparacion contenedorFasePreparacion = new ContenedorFasePreparacion(stage, escenaAtaque);
		Scene escenaPreparacion = new Scene(contenedorFasePreparacion, 640, 480);
		
		ContenedorFaseInicial contenedorFaseInicial = new ContenedorFaseInicial(stage,escenaPreparacion);
		Scene escenaFaseInicial = new Scene(contenedorFaseInicial, 640, 480);
		
	    ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaFaseInicial);    
	    Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);
		
	    //Los siguientes dos m�todos se encuentran separados debido a que necesitan tener creados los objetos de arriba
	    contenedorFaseTrampas.asignarEscenaFaseAtaque(stage,escenaAtaque);
	    contenedorCambioDeTurno.asignarEscenaFaseInicial(stage,escenaFaseInicial);
	    
		AplicacionOnKeyPressEventHandler bienvenidosHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorFaseInicial.getBarraDeMenu());
		escenaFaseInicial.setOnKeyPressed(bienvenidosHandler);
		AplicacionOnKeyPressEventHandler preparacionHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorFasePreparacion.getBarraDeMenu());
		escenaPreparacion.setOnKeyPressed(preparacionHandler);
		AplicacionOnKeyPressEventHandler ataqueHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorFaseAtaque.getBarraDeMenu());
		escenaAtaque.setOnKeyPressed(ataqueHandler);
		AplicacionOnKeyPressEventHandler trampasHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorFaseTrampas.getBarraDeMenu());
		escenaTrampas.setOnKeyPressed(trampasHandler);
		AplicacionOnKeyPressEventHandler magiaHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorFaseMagia.getBarraDeMenu());
		escenaMagia.setOnKeyPressed(magiaHandler);
		
		
        stage.setScene(escenaBienvenidos);
		stage.setFullScreen(true);

        stage.show();
	}


}
