package com.pcd.math;



public class Vec {
	private float anguloR;
	private float modulo;
	private float compX, compY;
	
	public Vec(){
		
	}
	
	public Vec(Vec vectorACopiar){
		this.setComponentes(vectorACopiar.x(), vectorACopiar.y());
	}
	
	public void setComponentes(float compX, float compY){
		this.compX=compX;
		this.compY=compY;
		anguloR=(float) Math.atan2( compY,  compX);
		modulo= (float) Math.sqrt((float) Math.pow(compX, 2)+ (float) Math.pow(compY, 2));
		
	}
	
	public void setX(float x){
		setComponentes(x,compY);
	}
	
	public void setY(float y){
		setComponentes(compX,y);
	}
	
	public void addX(float x){
		setComponentes(compX+x,compY);		
	}
	
	public void addY(float y){
		setComponentes(compX,y+compY);
	}
	
	public Vec( float x , float y){
		this.setComponentes(x, y);
	}
	
	public void sumar(float x , float y){
		this.compX+=x;
		this.compY+=y;
		anguloR=(float) Math.atan2( compY,  compX);
		modulo= (float) Math.sqrt((float) Math.pow(compX, 2)+ (float) Math.pow(compY, 2));
	
	}
	
	public void setAnguloPuntos(float xPunto0, float yPunto0, float xPunto1, float yPunto1){
		compX=0;
		compY=0;
		float x = xPunto1-xPunto0;
		float y = yPunto1-yPunto0;
		sumar(x,y);
	}
	
	public float x(){
		compX=modulo*(float)Math.cos(anguloR);
		return compX;
	}
	
	public float y(){
		compY=modulo*(float)Math.sin(anguloR);
		return compY;
	}
	
	public void setAngulo(float anguloRadianes){
		this.anguloR=anguloRadianes;
	}
	
	public void setAnguloGrados(float anguloGrados){
		this.anguloR=(float) Math.toRadians(anguloGrados);
	}
	
	public float getAngulo(){
		return anguloR;
	}
	
	public float getModulo(){
		return modulo;
	}
	public float getAnguloGrados(){
		return (float) Math.toDegrees(anguloR);
	}
	
	public void setModulo(float modulo){
		this.modulo=modulo;
		//compX=modulo*(float)Math.cos(anguloRads);
		//compY=modulo*(float)Math.sin(anguloRads);
	}
	
	/*
	public float getAnguloConVector(Vector v){
	}
	*/
}