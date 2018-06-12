package Application;

public class ModoAtaque extends ModoDeUso {
	
	public ModoAtaque() {
		super();
	}

	@Override
	public void atacar(CartaMonstruo otraCarta, CartaMonstruo miCarta) {
		otraCarta.recibirPuntosAtaque(miCarta);
	}

	@Override
	public void defender(CartaMonstruo cartaAtacante, CartaMonstruo cartaAtacada) {
		int puntosDefensa = cartaAtacada.obtenerPuntosDeAtaque();
		int puntosAtaque = cartaAtacante.obtenerPuntosDeAtaque();
		
		if (puntosDefensa < puntosAtaque) {
			int diferencia = puntosAtaque - puntosDefensa;
			cartaAtacada.destruirCarta();
			cartaAtacada.restarVidaAJugador(diferencia);
		}
		else if (puntosDefensa < puntosAtaque) {
			cartaAtacante.destruirCarta();
		}
		
		//Dejo el else {} para lo que se hace en caso de empate
	}
	
	

}
