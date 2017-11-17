package com.pcd;

import java.awt.event.KeyEvent;

import com.pcd.math.Vec;

public class Movible extends EntidadControlable{


	public Vec pos;
	public Vec vel;
	
	
	public Movible() {
		super();
		pos = new Vec();
		vel = new Vec();
	}
	
	@Override
	public void ejecutar(float step) {
		super.ejecutar(step);
		if(pos==null)
			pos= new Vec();
		pos.addX( step * vel.x());
		pos.addY( step * vel.y());
	}

	public void setPosicion(float x, float y){
		pos.setX(x);
		pos.setY(y);
	}
	
	public void empezarMovimientoArriba(){
		vel.addY(-100);
	}
	
	public void empezarMovimientoDerecha(){
		vel.addX(100);
	}
	
	public void empezarMovimientoIzquierda(){
		vel.addX(-100);
	}
	
	public void empezarMovimientoAbajo(){
		vel.addY(100);
	}
	
	public void finalizarMovimientoArriba(){
		vel.addY(100);
	}

	public void finalizarMovimientoDerecha(){
		vel.addX(-100);
	}

	public void finalizarMovimientoIzquierda(){
		vel.addX(100);
	}

	public void finalizarMovimientoAbajo(){
		vel.addY(-100);
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		switch (e.getKeyCode()){
		
		case KeyEvent.VK_W:
			//vel.Y += -100;
			//vel.addY(-100);
			empezarMovimientoArriba();
			break;
			
		case KeyEvent.VK_S:
			//vY += 100;
			//vel.addY(100);
			empezarMovimientoAbajo();
			break;
			
		case KeyEvent.VK_A:
			//vX += -100;
			//vel.addX(-100);
			empezarMovimientoIzquierda();
			break;
			
		case KeyEvent.VK_D:
			//vX += 100;
			//vel.addX(100);
			empezarMovimientoDerecha();
			break;
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		
		switch (e.getKeyCode()){
		
		case KeyEvent.VK_W:
			//vY += 100;
			//vel.addY(100);
			finalizarMovimientoArriba();
			break;
			
		case KeyEvent.VK_S:	
			//vY += -100;
			//vel.addY(-100);
			finalizarMovimientoAbajo();
			break;
			
		case KeyEvent.VK_A:
			//vX += +100;
			//vel.addX(100);
			finalizarMovimientoIzquierda();
			break;
			
		case KeyEvent.VK_D:
			//vX += -100;
			//vel.addX(-100);
			finalizarMovimientoDerecha();
			break;
		}
		
		
	}
	
}
