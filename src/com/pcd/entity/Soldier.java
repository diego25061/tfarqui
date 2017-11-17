package com.pcd.entity;

import java.awt.event.MouseEvent;

import com.pcd.TexturedMovable;
import com.pcd.math.Vec;

public class Soldier extends TexturedMovable {

	/**
	 * 0 = buscando
	 * 1 = moviendose
	 */
	
	public int estado = 0;
	
	public Vec target;
	
	
	public Soldier(String imgPath) {
		this(imgPath,1);
	}
	
	public Soldier(String imgPath, float size) {
		super(imgPath, size);
		target = new Vec();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		//System.out.println("pressedd");
		mover(e.getX(),e.getY());
	}
	
	public void mover(float x, float y){

		vel.setX( x - pos.x());
		vel.setY( y - pos.y());
		vel.setModulo(100);
		
		target.setX(x );
		target.setY(y);
		
		estado = 1;
	}
	
	@Override
	public void ejecutar(float step) {
		super.ejecutar(step);
		if(target.menos(pos).getModulo()<10) {
			estado = 0;
			vel.setCero();
		}
	}
	
	
}
