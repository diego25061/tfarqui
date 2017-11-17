package com.pcd.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.pcd.Movible;
import com.pcd.TexturedMovable;
import com.pcd.entity.gb.Torre;

import grf.dr.core.Entidad;

public class Mapa extends Entidad{
	
    
    public ArrayList<TexturedMovable> movibles;
    
    public Mapa() {
    	super();
    	movibles = new ArrayList<>();
    }
    
	@Override
	protected void enFrame0() {
		super.enFrame0();
		poblarMapa();
		
	}
	
	public void poblarMapa(){
		//Cuadrado c = new Cuadrado();
		//Bolita b = new Bolita();
		//movibles.add(c);
		//movibles.add(b);
		
		Tower t = new Tower("recursos/img/torre2.png", 1, movibles);
		t.pos.set(300, 400);
		
		//movibles.add(t);
		
		Edificio edificio = new Edificio( "recursos/img/ClockTower7.png" ,1);
		edificio.pos.set(100, 150);
		
		Deposito depot1 = new Deposito("recursos/img/building1.png",1);
		depot1.pos.set(200, 100);
		

		Deposito depot2 = new Deposito("recursos/img/building1.png",1);
		depot2.pos.set(170, 250);
		
		Soldier soldier = new Soldier("recursos/img/Footman.png",0.5f);
		soldier.pos.set(700,350);
		movibles.add(soldier);
		
		//soldier.mover(0, 0);
		
		
		soldier.lastimar(20);
		soldier.movibleActivado = true;
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
		g.setColor(new Color(86,136,19));
		g.fillRect(0,0,1000,1000);
		/*
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, maxX, borde);
		g.fillRect(0, 0, borde, maxY);
		g.fillRect(0, maxY-borde, maxX, borde);
		g.fillRect(maxX-borde, 0, borde, maxY);*/
	}	

}
