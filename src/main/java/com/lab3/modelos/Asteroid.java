package com.lab3.modelos;

public class Asteroid {
	
	private int tamanio;
	private int x;
	private int y;
	private int velocidad;
	private int pendiente;
	
	public int getTamanio() {
		return tamanio;
	}
	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {		
		this.velocidad = velocidad;
	}
	public int getPendiente() {
		return pendiente;
	}
	public void setPendiente(int x, int y, int pendiente) {
		this.x = x;
		this.y = y;
		this.pendiente = pendiente;
	}
	public Asteroid(int tamanio) {
		super();
		this.tamanio = tamanio;
	}
	
	
	
}
