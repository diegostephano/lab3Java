package com.lab3.juego;

import java.util.List;import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;
import java.util.ArrayList;

import com.lab3.modelos.*;

/**
 * Hello world!
 *
 */
public class App 
{
	static Metodo metodo;
	static Menu menu = new Menu();
	
    public static void main( String[] args )
    {
//      System.out.println( "Hello World!" );
//    	createSpace(5, 10, 3, 5, 27,435);
//    	int n = 11;
//    	int m = 5;
//    	int numPartitions = 3;
//    	int fireRange = 8;
//    	int numAsteroids = 20;
//    	int seed = 2354;
    	Scanner k;
    	int accion= -1;
    	menu.runMenu();
    	metodo = menu.getMetodo();
    	do {
			System.out.println(metodo.printSpace());
			System.out.println("Elija opcion");
			System.out.println("|Movimiento		Disparo		|");
			System.out.println("|	W				|");
			System.out.println("|A	S	D	Space		|");
			gameLoop();
			
		} while (metodo.getNave().getVidas()>0);
    	System.out.println("GAME OVER");
    }
    

	public static void gameLoop() {
		
		Scanner k = new Scanner(System.in);
		String accion = "";
		int op = -1;
		
		try { 
			accion = k.nextLine();
			System.out.println(accion.toLowerCase());
//			if ( accion.toLowerCase()!="d" || accion.toLowerCase()!="s" || accion.toLowerCase()!= "a" || accion.toLowerCase()!= "w" || accion.toLowerCase()!=" ") { 
//				System.out.println("Opcion Invalida. Elija denuevo."); 
			if (accion.equalsIgnoreCase("d")) {
				op = 0;
			}else if (accion.equalsIgnoreCase("s")) {
				op = 1;
			}else if (accion.equalsIgnoreCase("a")) {
				op = 2;
			}else if (accion.equalsIgnoreCase("w")) {
				op = 3;
			}else if (accion.equalsIgnoreCase(" ")) {
				op = 4;
			}else {
				System.out.println("Opcion Invalida. Elija denuevo."); 
			}
					
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		switch (op) {
		case  0:
			metodo.moveElement(true, 0);
			break;
		case  1:
			metodo.moveElement(true, 1);
			break;
		case  2:
			metodo.moveElement(true, 2);
			break;
		case  3:
			metodo.moveElement(true, 3);
			break;
		case  4:
			//TODO: SHOOT
			metodo.moveElement(true, 1);
			break;
		default:
			metodo.moveElement(false, 0);
			break;
		}
	}
    
    
    
    
}
