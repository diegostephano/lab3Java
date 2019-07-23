package com.lab3.juego;

import java.io.Console;
import java.util.Scanner;

public class Menu {
	
	boolean exit;
	Metodo metodo = new Metodo();
	int n, m, numPartitions, fireRange, numAsteroids, seed;
	
	public Metodo getMetodo() {
		return this.metodo;
	}
	
	public void runMenu() { 
		printHeader(); 
		printMenu(); 
		int choice = getMenuChoice(); 
					
		System.out.flush();
		printHeader(); 
		printOptions();
		performAction(choice); 
	} 

	private void printHeader() { 
		System.out.println("+-----------------------------------+"); 
		System.out.println("|                                   |"); 
		System.out.println("|           Welcome to              |"); 
		System.out.println("|          Asteroids DMC            |"); 
		System.out.println("|                                   |"); 
		System.out.println("+-----------------------------------+"); 
	} 

	private void printMenu() { 
		displayHeader("Elija Dificultad"); 
		System.out.println("1) Facil"); 
		System.out.println("2) Intermedio"); 
		System.out.println("3) Dificil"); 
		System.out.println("4) Pesadilla"); 
		System.out.println("0) Salir"); 
	}
	
	private void printOptions() { 
		System.out.print("Dimension para X: "); 
		Scanner keyboard = new Scanner(System.in);
		try { 
			this.n = Integer.parseInt(keyboard.nextLine()); 
		} catch (NumberFormatException e) { 
			System.out.println("Opcion Invalida. Solo numeros porfavor."); 
		} 
		System.out.print("Dimension para Y: "); 
		keyboard = new Scanner(System.in);
		try { 
			this.m = Integer.parseInt(keyboard.nextLine()); 
		} catch (NumberFormatException e) { 
			System.out.println("Opcion Invalida. Solo numeros porfavor."); 
		} 
		System.out.print("Cantidad de asteroides: "); 
		keyboard = new Scanner(System.in);
		try { 
			numAsteroids = Integer.parseInt(keyboard.nextLine()); 
		} catch (NumberFormatException e) { 
			System.out.println("Opcion Invalida. Solo numeros porfavor."); 
		} 
		
		
	}
	
	private void displayHeader(String message){ 
	    System.out.println(); 
	    int width = message.length() + 6; 
	    StringBuilder sb = new StringBuilder(); 
	    sb.append("+"); 
	    for(int i = 0; i < width; ++i){ 
	        sb.append("-"); 
	    } 
	    sb.append("+"); 
	    System.out.println(sb.toString()); 
	    System.out.println("|   " + message + "   |"); 
	    System.out.println(sb.toString()); 
	} 

	private int getMenuChoice() { 
		Scanner keyboard = new Scanner(System.in); 
		int choice = -1; 
		do { 
			System.out.print("Dificultad: "); 
			try { 
				choice = Integer.parseInt(keyboard.nextLine()); 
			} catch (NumberFormatException e) { 
				System.out.println("Opcion Invalida. Solo numeros porfavor."); 
			} 
			if (choice < 0 || choice > 4) { 
				System.out.println("Opcion Invalida. Elija denuevo."); 
			} 
		} while (choice < 0 || choice > 4); 
		return choice; 
	} 
	
	private void performAction(int choice) { 	
		switch (choice) { 
			case 0: 
				System.out.println("Hasta pronto."); 
				System.exit(0); 
				break; 
			case 1: 
				this.metodo.createSpace(this.n, this.m, 3, 8, this.numAsteroids, 2354);
			break; 
			case 2: 
				this.metodo.createSpace(this.n, this.m, 3, 8, this.numAsteroids, 2354);
				break; 
			case 3: 
				this.metodo.createSpace(n, m, 3, 8, numAsteroids, 2354);
				break; 
			case 4: 
				this.metodo.createSpace(n, m, 3, 8, numAsteroids, 2354);
				break; 
			default: 
				System.out.println("Error."); 
		} 
	} 
	
}
