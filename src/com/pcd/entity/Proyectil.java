package com.pcd.entity;

import java.awt.Color;
import java.awt.Graphics;

import com.pcd.Movible;
import com.pcd.TexturedMovable;

public class Proyectil extends TexturedMovable {

	TexturedMovable target;

	
	public Proyectil(String imgPath, float size, Movible origen, TexturedMovable target) {
		super(imgPath,size);
		this.target = target;
		pos.set(origen.pos.x(), origen.pos.y());
	}
	
	@Override
	public void ejecutar(float step) {
		super.ejecutar(step);
		if(activado)
		if(target.pos.dist(pos)<10){
			mostrar = false;
			target.lastimar(10);
			activado= false;
		}else{
			vel.setModulo(150);;
			vel.setAngulo(pos,target.pos);
		}
	}

	
	@Override
	public void presentar(Graphics g) {
		
		if(imagen!=null && mostrar)
			g.drawImage( imagen , (int) pos.x() - imagen.getWidth()/2, (int) pos.y() - imagen.getHeight()/2, null);
	}
	
}
