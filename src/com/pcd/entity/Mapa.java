package com.pcd.entity;

import java.awt.Color;
import java.awt.Graphics;

import grf.dr.core.Entidad;
import java.util.ArrayList;

public class Mapa extends Entidad{
	
    
    public static ArrayList<Entidad> entidades;
    
	@Override
	protected void enFrame0() {
		super.enFrame0();
		poblarMapa();
		
	}
	
	public void poblarMapa(){
            
                new Cuadrado();
		new Bolita();
	}
	
	@Override
	public void ejecutar(float step) {
		super.ejecutar(step);
	}
	
	@Override
	public void presentar(Graphics g) {
		super.presentar(g);
                
		int borde = 25;
		int maxX = 800;
		int maxY = 600;
		g.setColor(Color.WHITE);
		
		g.fillRect(0,0,1000,1000);
		
		g.setColor(Color.DARK_GRAY);

		g.fillRect(0, 0, maxX, borde);
		g.fillRect(0, 0, borde, maxY);
		g.fillRect(0, maxY-borde, maxX, borde);
		g.fillRect(maxX-borde, 0, borde, maxY);
	}	

}
