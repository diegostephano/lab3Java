package com.lab3.modelos;

public class GameSpace {
	
	private int x;
	private int y;
	private String matriz[][];
	private int estado; 
	private int dificultad;
	
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
	public String[][] getMatriz() {
		return matriz;
	}
	public void setMatriz(String[][] matriz) {
		this.matriz = matriz;
	}
	public GameSpace(int x, int y, Integer... dificultad ) {
		super();
		this.x = x;
		this.y = y;
		this.dificultad = dificultad.length>0?dificultad[0]:0;
	}
	public GameSpace() {

	}
	
	
	
}
