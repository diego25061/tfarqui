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
public class Cuadrado extends Movible{

    @Override
    protected void enFrame0() {
        super.enFrame0(); //To change body of generated methods, choose Tools | Templates.
        pos.setComponentes(300, 400);
    }

    @Override
    public void ejecutar(float step) {
        super.ejecutar(step); //To change body of generated methods, choose Tools | Templates.
        
    }
    
    
    
    @Override
    public void presentar(Graphics g) {
        super.presentar(g); //To change body of generated methods, choose Tools | Templates.
        
        g.setColor(Color.blue);
        g.fillRect((int)pos.x(),(int)pos.y(),120,120);
        
    }
    
    
    
}
