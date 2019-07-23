package com.lab3.modelos;

public class SpaceShip {
	
	private int vidas;
	private int posicionX;
	private int posicionY;
	private double orientacion;
	private int fireRange;
	
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	public int getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	public int getPosicionY() {
		return posicionY;
	}
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	public double getOrientacion() {
		return orientacion;
	}
	public void setOrientacion(double orientacion) {
		if(orientacion > 359) {
			this.orientacion = 0;
		}else if(orientacion < 0) {
			this.orientacion = 359;
		}else {
			this.orientacion = orientacion;
		}		
	}
	public int getFireRange() {
		return fireRange;
	}
	public void setFireRange(int fireRange) {
		this.fireRange = fireRange;
	}
	public SpaceShip(int posicionX, int posicionY, int fireRange) {
		super();
		this.vidas = 3;
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.fireRange = fireRange;
		this.orientacion = 0;
	}
	
	public SpaceShip() {
		
	}
	
	//0 : izquierda, 1 : derecha
	public void girar(int direccion) {
		if (direccion == 0) {
			this.setOrientacion(orientacion+15);
		}else {
			this.setOrientacion(orientacion-15);
		}
	}
	
	
}
