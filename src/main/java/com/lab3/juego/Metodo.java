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
	
	
	
	public List<Asteroid> getAsteroides() {
		return asteroides;
	}

	public void setAsteroides(List<Asteroid> asteroides) {
		this.asteroides = asteroides;
	}

	public GameSpace getEspacio() {
		return espacio;
	}

	public void setEspacio(GameSpace espacio) {
		this.espacio = espacio;
	}

	public SpaceShip getNave() {
		return nave;
	}

	public void setNave(SpaceShip nave) {
		this.nave = nave;
	}
	
	private Asteroid ajustarPendiente(Asteroid ast) {
		int x = ast.getX();
		int y = ast.getY();
		while (ast.getPendiente()>=360 || ast.getPendiente()<0) {
			
			if (ast.getPendiente()>=360) {
				ast.setPendiente(x, y, ast.getPendiente()-359);	
			}else if(ast.getPendiente()<0) {
				ast.setPendiente(x, y, ast.getPendiente()+359);				
			}
			
		}
		return ast;
	}

	//
	public String createSpace(int n, int m, int numPartitions, int fireRange, int numAsteroids, int seed) {
    	String retorno = "";
    	boolean insertar = false;
    	boolean existe = false;
    	this.espacio = new GameSpace(n, m);
    	List<Asteroid> asteroidesListos = new ArrayList<Asteroid>();
    	this.nave = new SpaceShip((int)n/2, (int)m/2, fireRange);
    	for (int i = 0; i < numAsteroids; i++) {
    		asteroide = new Asteroid(numPartitions);
    		//TODO: agregar distintos asteroides
    		int x = ((int)(10*Math.random()*seed))%n;
    		int y = ((int)(10*Math.random()*seed))%m;
    		int pendiente = (int)(10*Math.random()*359);
//    		int pendiente = 0;
    		asteroide.setPendiente(x, y, pendiente);
    		while (asteroide.getPendiente()>=360 || asteroide.getPendiente()<0) {
    			if (asteroide.getPendiente()>=360) {
    				asteroide.setPendiente(x, y, asteroide.getPendiente()-359);	
    			}else if(asteroide.getPendiente()<0) {
    				asteroide.setPendiente(x, y, asteroide.getPendiente()+359);				
    			}
    			
    		}
    		for (Asteroid asteroid : this.asteroides) {
    			if(asteroid.getX() == asteroide.getX() && asteroid.getY() == asteroide.getY()) {
    				i--;
    				existe = true;
    				break;
    			}
    		}
			if (!existe) {
				this.asteroides.add(asteroide);
				asteroidesListos.add(asteroide);
			}
			existe = false;
		}
    	for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if((int)n/2 == i && (int)m/2 == j-1) {
					retorno=retorno.substring(0,retorno.length()-3)+"[N]";
				}else {
					for (Asteroid asteroid : asteroidesListos) {
						if (asteroid.getX()==i && asteroid.getY()==j) {
							asteroide = asteroid;
							insertar = true;
						}
					}
					asteroidesListos.remove(asteroide);
				}		
				retorno += insertar?"[A]":"[ ]";				
				insertar = false;
			}
			retorno += "\n";
		}
    	retorno += String.format("Vidas : %s\nOrientacion : %s\n",Integer.toString(this.nave.getVidas()), Double.toString(this.nave.getOrientacion()));
    	return retorno;
    }
	
	public String printSpace() {
		String retorno = "";
		int n = this.espacio.getX();
		int m = this.espacio.getY();
		boolean insertar = false;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(this.nave.getPosicionX() == i && this.nave.getPosicionY() == j) {
					retorno += "[N]";
				}else {
					for (Asteroid asteroid : this.asteroides) {
						if (asteroid.getX()==i && asteroid.getY()==j) {
							asteroide = asteroid;
							insertar = true;
						}
					}
					retorno += insertar?"[A]":"[ ]";
				}				
				insertar = false;
			}
			retorno += "\n";
		}
		retorno += String.format("Vidas : %s\nOrientacion : %s\n",Integer.toString(this.nave.getVidas()), Double.toString(this.nave.getOrientacion()));
		return retorno;
	}
	
	public boolean moveElement(boolean moviendo, int direccion) {
		ArrayList<Double> lista = new ArrayList<Double>();
		List<Asteroid> asteroidesMovidos = new ArrayList<Asteroid>();
		double x;
		double y;
		int n = this.espacio.getX();
		int m = this.espacio.getY();
		if(moviendo){
			lista.add(this.nave.getOrientacion());
			lista.add((double) this.nave.getPosicionX());
			lista.add((double) this.nave.getPosicionY());
			switch (direccion) {
			case 0://derecha
				this.nave.girar(1);
				break;
			case 1://atras
				lista = moverObjeto(lista,1);
				break;
			case 2://izquierda
				this.nave.girar(0);
				break;
			case 3://arriba
				lista = moverObjeto(lista,3);
				break;
			default:
				break;
			}
			x = lista.get(1)>n?0:lista.get(1);
			x = lista.get(1)<0?n:lista.get(1);
			y = lista.get(2)>m?0:lista.get(2);
			y = lista.get(2)<0?m:lista.get(2);
			
			this.nave.setPosicionX((int)x);
			this.nave.setPosicionY((int)y);
			lista.clear();
		}
		for (Asteroid ast : this.asteroides) {
			lista.add((double) ast.getPendiente());
			lista.add((double) ast.getX());
			lista.add((double) ast.getY());

			lista = moverObjeto(lista,3);
			
			x = lista.get(1)>n?0:lista.get(1);
			x = lista.get(1)<0?n:lista.get(1);
			y = lista.get(2)>m?0:lista.get(2);
			y = lista.get(2)<0?m:lista.get(2);
			
			ast.setPendiente((int)x, (int)y, ast.getPendiente());
			asteroidesMovidos.add(ast);
			lista.clear();
			if (this.nave.getPosicionX() == ast.getX() && this.nave.getPosicionY() == ast.getY()) {
				this.nave.setVidas(this.nave.getVidas() - 1);
				return false;
			}
		}
		this.asteroides = asteroidesMovidos;
		return true;
	}
	
	private ArrayList<Double> moverObjeto(ArrayList<Double> datos, int direccion) {
		double orientacion = datos.get(0);
		ArrayList<Double> coord = datos;
		int paso = direccion==3?1:-1;
		if(orientacion > 337.5 || orientacion <= 22.5){
			coord.set(1,coord.get(1) + paso);
		}else if(orientacion > 22.5 && orientacion <= 67.5) {
			coord.set(1,coord.get(1) + paso);
			coord.set(2,coord.get(2) + paso);
		}else if(orientacion > 67.5 && orientacion <= 112.5) {
			coord.set(2,coord.get(2) + paso);
		}else if(orientacion > 112.5 && orientacion <= 157.5) {
			coord.set(2,coord.get(2) + paso);
			coord.set(1,coord.get(1) - paso);
		}else if(orientacion > 157.5 && orientacion <= 202.5) {
			coord.set(1,coord.get(1) - paso);
		}else if(orientacion > 202.5 && orientacion <= 247.5) {
			coord.set(2,coord.get(2) - paso);
			coord.set(1,coord.get(1) - paso);
		}else if(orientacion > 247.5 && orientacion <= 292.5) {
			coord.set(2,coord.get(2) - paso);
		}else if(orientacion > 292.5 && orientacion <= 337.5) {
			coord.set(2,coord.get(2) - paso);
			coord.set(1,coord.get(1) + paso);
		}
		
		return coord;
	}
}
