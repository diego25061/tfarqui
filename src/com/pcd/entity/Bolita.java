package com.pcd.entity;

import java.awt.Color;
import java.awt.Graphics;

import com.pcd.Movible;

public class Bolita extends Movible {

	
	@Override
	protected void enFrame0() {
		super.enFrame0();
		pos.setX(200);
		pos.setY(200);
	}
	
	@Override
	public void ejecutar(float step) {
		super.ejecutar(step);
		//x= (float) Math.cos( tiempoTotal * 3 )* 180 + 300;
		//y= (float) Math.sin( tiempoTotal * 3 )* 180 + 300;
	}
	
	@Override
	public void presentar(Graphics g) {
		super.presentar(g);
		g.setColor(Color.RED);
		g.fillOval( (int) pos.x(), (int) pos.y(), 20, 20);
		
	}

	
}
