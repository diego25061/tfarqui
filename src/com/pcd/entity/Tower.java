package com.pcd.entity;

import java.util.ArrayList;

import com.pcd.Movible;
import com.pcd.TexturedMovable;

public class Tower extends TexturedMovable {
	
	ArrayList<TexturedMovable> unidadesAlrededor;

	public float frecuenciaDisparo = 1;
	private float tiempoSinDisparar=0;
	float rango = 230;
	
	
	public Tower(String imgPath, float size, ArrayList<TexturedMovable> movibles ) {
		super(imgPath, size);
		unidadesAlrededor = movibles;
	}
	
	
	@Override
	public void ejecutar(float step) {
		super.ejecutar(step);
		tiempoSinDisparar += step;
		
		for(int i = 0 ;i<unidadesAlrededor.size();i++){
			TexturedMovable m = unidadesAlrededor.get(i);

			if(m.pos.menos(pos).getModulo() < rango && tiempoSinDisparar>frecuenciaDisparo){
				//System.out.println("atacar!!!");
				atacar(m);
				tiempoSinDisparar=0;
			}
		}
	}
	
	
	public void atacar(TexturedMovable mov){
		new Proyectil("recursos/img/building1.png", 0.1f, this,mov);
	}
	
}