package com.pcd;

import grf.dr.core.ControladorEntidades;
import grf.dr.core.Entidad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class EntidadControlable extends Entidad implements KeyListener, MouseMotionListener, MouseListener{

	public boolean movibleActivado = false;
	public EntidadControlable() {
		super();
		ControladorEntidades.getInstance().agregarControlable(this);
	}
	
	@Override
	public void keyPressed(KeyEvent e){ 		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

}
