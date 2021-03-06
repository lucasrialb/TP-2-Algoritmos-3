package modelo.cartasGenericas;

import modelo.jugador.Jugador;
import modelo.tablero.CampoDeBatalla;

public class CartaTrampa extends Carta{
	
	Estado estado;
	

	public CartaTrampa(){
				
		this.estado = new BocaAbajo();
		this.nombre = "";
	}
	
	public CartaTrampa(String nombreDeLaCarta){
				
		this.estado = new BocaAbajo();
		this.nombre = nombreDeLaCarta;
	}
	
	public void activarEfecto(CartaMonstruo atacante, CartaMonstruo atacado) {
	
		
	}
	
	public void voltearCarta() {
		
		this.estado = new BocaArriba();
	}
	
	public void desactivarEfecto() {
		
	}
	
	@Override
	public void colocateEn(CampoDeBatalla campoDeBatalla) {
	
		campoDeBatalla.colocar(this);
	}

	@Override
	public void invocate(Jugador jugador) {
		
		jugador.invocar(this);
	}

	@Override
	public void destruite(CampoDeBatalla campoDeBatalla) {
		campoDeBatalla.destruir(this);
		
	}

	@Override
	public boolean estaBocaArriba() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public boolean verificarQueEsteInvocadaEn(CampoDeBatalla campo) {
		
		return (campo.verificarQueEstaEnElCampo(this));
	}
	

}
