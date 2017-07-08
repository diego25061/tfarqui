package com.pcd;

import java.awt.event.KeyEvent;

import com.pcd.math.Vec;
import com.pcd.network.ClientClean;

public class Movible extends EntidadControlable{


	protected Vec pos;
	protected Vec vel;
	
	public Movible() {
		pos = new Vec();
		vel = new Vec();
	}
	
	@Override
	public void ejecutar(float step) {
		super.ejecutar(step);
	
		pos.addX( step * vel.x());
		pos.addY( step * vel.y());
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		switch (e.getKeyCode()){
		
		case KeyEvent.VK_W:
			//vel.Y += -100;
			ClientClean.enviarObjeto(null);
			vel.addY(-100);
			break;
			
		case KeyEvent.VK_S:
			//vY += 100;
			vel.addY(100);
			break;
			
		case KeyEvent.VK_A:
			//vX += -100;
			vel.addX(-100);
			break;
			
		case KeyEvent.VK_D:
			//vX += 100;
			vel.addX(100);
			break;
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		
		switch (e.getKeyCode()){
		
		case KeyEvent.VK_W:
			//vY += 100;
			vel.addY(100);
			break;
			
		case KeyEvent.VK_S:	
			//vY += -100;
			vel.addY(-100);
			break;
			
		case KeyEvent.VK_A:
			//vX += +100;
			vel.addX(100);
			break;
			
		case KeyEvent.VK_D:
			//vX += -100;
			vel.addX(-100);
			break;
		}
		
		
	}
	
}
