package com.pcd.entity;

import java.awt.Color;
import java.awt.Graphics;

import grf.dr.core.Entidad;

public class Contador extends Entidad {
	
	float fps;
	
	@Override
	public void ejecutar(float step) {
		super.ejecutar(step);
		
		int a ;
		//System.out.println(""+step);
		/*
			for(int i = 0; i< 9000;i++){
				System.out.println(""+step);
				//a = i;
			}*/
		fps = 1.0f/step;
	}
	
	@Override
	public void presentar(Graphics g) {
		super.presentar(g);
		
		g.setColor(Color.white);
		g.drawString(""+fps, 20, 20);
	}

}
