
public class PuntuacionJugadores {

	public char [] jugador1 =new char [8];
	public char [] jugador2=new char [8];
	public char [] jugador3=new char [8];
	public char[]jugador4=new char [8];
	public char[]jugador5=new char [8];
	public char[]jugador6=new char [8];
	public char[]jugador7=new char [8];
	public char[]jugador8=new char [8];
	public PuntuacionJugadores() {
	}
	
	public String llenadoJugadores(int indiceJugadorALlenar, int indicePosicionALlenar, char []palabra ) {
		String llenado=""; 
		
		switch (indiceJugadorALlenar) {
		case 1:
			for (int i= 0; i<indicePosicionALlenar-1; i++) {
				
				llenado += String.valueOf(palabra[i]);
			
			}
			
			return llenado;
		case 2: 
	for (int i= 0; i<indicePosicionALlenar-1; i++) {
				
				llenado += String.valueOf(palabra[i]);
			
			}
			return llenado;
			
		case 3:
	for (int i= 0; i<indicePosicionALlenar-1; i++) {
				
				llenado += String.valueOf(palabra[i]);
			
			}
			return llenado;
			
		case 4:
	for (int i= 0; i<indicePosicionALlenar-1; i++) {
				
				llenado += String.valueOf(palabra[i]);
			
			}
			return llenado;
			
		case 5:
	for (int i= 0; i<indicePosicionALlenar-1; i++) {
				
				llenado += String.valueOf(palabra[i]);
			
			}
			return llenado;
			
		case 6: 
	for (int i= 0; i<indicePosicionALlenar-1; i++) {
				
				llenado += String.valueOf(palabra[i]);
			
			}
			return llenado;
		
		case 7:
	for (int i= 0; i<indicePosicionALlenar-1; i++) {
				
				llenado += String.valueOf(palabra[i]);
			
			}
			return llenado;
			
		case 8: 
	for (int i= 0; i<indicePosicionALlenar-1; i++) {
				
				llenado += String.valueOf(palabra[i]);
			
			}
		  	return llenado;
		default:
		  	
		}
	
		return llenado;
	
	}
	
	public char[] getJugador1() {
		return jugador1;
	}
	public void setJugador1(char[] jugador1) {
		this.jugador1 = jugador1;
	}
	public char[] getJugador2() {
		return jugador2;
	}
	public void setJugador2(char[] jugador2) {
		this.jugador2 = jugador2;
	}
	public char[] getJugador3() {
		return jugador3;
	}
	public void setJugador3(char[] jugador3) {
		this.jugador3 = jugador3;
	}
	public char[] getJugador4() {
		return jugador4;
	}
	public void setJugador4(char[] jugador4) {
		this.jugador4 = jugador4;
	}
	public char[] getJugador5() {
		return jugador5;
	}
	public void setJugador5(char[] jugador5) {
		this.jugador5 = jugador5;
	}
	public char[] getJugador6() {
		return jugador6;
	}
	public void setJugador6(char[] jugador6) {
		this.jugador6 = jugador6;
	}
	public char[] getJugador7() {
		return jugador7;
	}
	public void setJugador7(char[] jugador7) {
		this.jugador7 = jugador7;
	}
	public char[] getJugador8() {
		return jugador8;
	}
	public void setJugador8(char[] jugador8) {
		this.jugador8 = jugador8;
	}
	
	
	
}
