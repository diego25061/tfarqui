package grf.dr.core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import com.pcd.EntidadControlable;

public class ControladorEntidades implements KeyListener, MouseMotionListener, MouseListener{

	private ArrayList<EntidadControlable> entidades;
	private static ControladorEntidades instance;

	boolean [][] pressed;
	
	public static ControladorEntidades getInstance(){
		if(instance==null)
			instance = new ControladorEntidades();
		return instance;			
	}
	
	private ControladorEntidades() {
		entidades = new ArrayList<EntidadControlable>();
		pressed = new boolean[200][300];
	}
	
	public void agregarControlable(EntidadControlable ent){
		entidades.add(ent);
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		for(int i = 0 ;i< entidades.size();i++) {
			if(entidades.get(i).movibleActivado)
				if(!pressed[i][e.getKeyCode()]) {
					entidades.get(i).keyPressed(e);
					pressed[i][e.getKeyCode()] = true;
				}
		}
		/*
		for ( KeyListener ent: entidades){
			if(!pressed[e.getKeyCode()]){
				ent.keyPressed(e);
				pressed[e.getKeyCode()] = true;
			}
		}*/
	}

	@Override
	public void keyReleased(KeyEvent e) {
		for(int i = 0 ;i< entidades.size();i++) {
			if(entidades.get(i).movibleActivado)
				if(pressed[i][e.getKeyCode()]) {
					entidades.get(i).keyReleased(e);
					pressed[i][e.getKeyCode()] = false;
				}
		}
		/*
		for ( KeyListener ent: entidades){
			if(pressed[e.getKeyCode()]){
				ent.keyReleased(e);
				pressed[e.getKeyCode()] = false;
			}
			
		}	*/	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		for ( KeyListener ent: entidades){
			ent.keyTyped(e);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		for(int i = 0 ;i< entidades.size();i++) {
			if(entidades.get(i).movibleActivado) {
				entidades.get(i).mouseClicked(e);;
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		for ( MouseListener ent: entidades){
			ent.mouseEntered(e);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for ( MouseListener ent: entidades){
			ent.mousePressed(e);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for ( MouseListener ent: entidades){
			ent.mouseReleased(e);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		for ( MouseMotionListener ent: entidades){
			ent.mouseDragged(e);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		for ( MouseMotionListener ent: entidades){
			ent.mouseMoved(e);
		}
	}
	
	
	
}
