package grf.dr.core;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MotorGrafico extends Thread{
	
	static ArrayList<Entidad> entidades;
	final double maxStep = 0.02;
	static double frecuencia = 0.0166666;
	Canvas canvas;
	Graphics g;
	
	static Lienzo lienzo;
	BufferedImage output;
	//Graphics2D g;
	
	public Lienzo getLienzo(){
		return lienzo;
	}
	
	public MotorGrafico(){
		lienzo = new Lienzo();
		entidades = new ArrayList<Entidad>();
	}
	
	public static void agregarEntidad(Entidad p){
		entidades.add(p);
		lienzo.agregarEntidad(p);
	}
	
	@Override
	public void run(){
		double ultimoT = System.nanoTime();
		double t;
		double step = 0;
		while(true){
			t = System.nanoTime();
			if(step > frecuencia){
				
				
				if (step > maxStep)
					step = maxStep;
				actualizar( (float) step);
				presentar( (float) step);
				step = 0;
			}else
				step += ( t - ultimoT ) / 1000000000.0;
			ultimoT = t;
		}
	}
	
	private void actualizar(float step){
		for( int i = 0 ; i < entidades.size();i ++){
			entidades.get(i).preEjecutar(step);
			entidades.get(i).ejecutar(step);
			entidades.get(i).postEjecutar(step);
		}
	}
	
	private void presentar(float step){
		//System.out.println("presentando!: " + frames);
		lienzo.repaint();
	}

}
