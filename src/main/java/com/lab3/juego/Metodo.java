package com.lab3.juego;

import java.util.ArrayList;
import java.util.List;

import com.lab3.modelos.Asteroid;
import com.lab3.modelos.GameSpace;
import com.lab3.modelos.SpaceShip;

public class Metodo {
	
	private List<Asteroid> asteroides = new ArrayList<Asteroid>();
	private Asteroid asteroide;
	private GameSpace espacio;
	private SpaceShip nave;
	
	public String createSpace(int n, int m, int numPartitions, int fireRange, int numAsteroids, int seed) {
    	String retorno = "";
    	boolean insertar = false;
    	boolean existe = false;
    	espacio = new GameSpace(n, m);
    	List<Asteroid> asteroidesListos = new ArrayList<Asteroid>();
    	nave = new SpaceShip((int)n/2, (int)m/2, fireRange);
    	for (int i = 0; i < numAsteroids; i++) {
    		asteroide = new Asteroid(numPartitions);
    		//TODO: agregar distintos asteroides
    		int x = ((int)(10*Math.random()*seed))%n;
    		int y = ((int)(10*Math.random()*seed))%m;
    		int pendiente = (int)(10*Math.random()*359);
//    		int pendiente = 0;
    		asteroide.setPendiente(x, y, pendiente);
    		for (Asteroid asteroid : asteroides) {
    			if(asteroid.getX() == asteroide.getX() && asteroid.getY() == asteroide.getY()) {
    				i--;
    				existe = true;
    				break;
    			}
    		}
			if (!existe) {
				asteroides.add(asteroide);
			}
			existe = false;
		}
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if((int)n/2 == i && (int)m/2 == j-1) {
					retorno=retorno.substring(0,retorno.length()-3)+"[N]";
				}else {
					for (Asteroid asteroid : asteroides) {
						if (asteroid.getX()==i && asteroid.getY()==j) {
							asteroide = asteroid;
							insertar = true;
						}
					}
					asteroides.remove(asteroide);
				}		
				retorno += insertar?"[A]":"[ ]";				
				insertar = false;
			}
			retorno += "\n";
		}
    	return retorno;
    }
}
