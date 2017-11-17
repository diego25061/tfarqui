package com.pcd.math;


public class Rec {
	

	private float limitex0 , limitex1, limitey0, limitey1;
	
	/**
	 * Creador solo para registrar las rectas de Tiled
	 * 
	 * @param x
	 * en los cuadros de dialogo de posicion se ven estos valores x e y
	 * @param y
	 * @param ancho
	 * se ven en los cuadros de dialogo de tamaño
	 * @param alto
	 * @param limiteX
	 * debería ser 1280
	 * @param limiteY
	 * deberia ser 720
	 */
	
	public Rec(float x, float y, float ancho, float alto, float limiteX, float limiteY){
		limitex0 = x*limiteX;
		limitex1 = (x+ancho)*limiteX;
		
		limitey1 = (1-y)* limiteY;
		limitey0 = (1-y-alto)* limiteY;
		
	}
	
	public Rec(float x0, float x1, float y0 , float y1){
		limitex0=x0;
		limitex1=x1;
		limitey0=y0;
		limitey1=y1;
	}

	public float getXAleatorio(){
		return (float) (Math.random()*(limitex1 - limitex0) + limitex0);	
	}
	
	public float getYAleatorio(){
		return (float) (Math.random()*(limitey1 - limitey0) + limitey0);
	}
	
	public float x0(){
		return limitex0;
	}
	public float x1(){
		return limitex1;
	}
	public float y0(){
		return limitey0;
	}
	public float y1(){
		return limitey1;
	}
	public boolean contienePunto(float x, float y){
		if(limitex0<x && limitex1>x && limitey0<y && limitey1>y)
			return true;
		else
			return false;
	}
}