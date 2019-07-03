package com.lab3.juego;

import java.util.List;import java.util.Random;
import java.io.InputStream;
import java.util.ArrayList;

import com.lab3.modelos.*;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	//createSpace(5, 10, 3, 5, 27,435);
    	int n = 11;
    	int m = 5;
    	int numPartitions = 3;
    	int fireRange = 8;
    	int numAsteroids = 20;
    	int seed = 2354;
    	Metodo metodo = new Metodo();
    	System.out.println(metodo.createSpace(n, m, numPartitions, fireRange, numAsteroids, seed));
    	
    }
    
    
    
    
    
}
