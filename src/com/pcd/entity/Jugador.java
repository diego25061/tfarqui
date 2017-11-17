/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcd.entity;

import java.awt.Color;
import java.awt.Graphics;

import com.pcd.Movible;

/**
 *
 * @author alumnos
 */
public class Jugador extends Movible {
    
    private Color color;
    
    public Jugador(Color color){
        this.color = color;
    }

    @Override
    public void presentar(Graphics g) {
		super.presentar(g);
		g.setColor(color);
		g.fillOval( (int) pos.x(), (int) pos.y(), 20, 20);
    }
    
    
}
