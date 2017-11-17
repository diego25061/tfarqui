package grf.dr.core;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Lienzo extends JPanel{

	static ArrayList<IPresentable> presentables;
	
	public Lienzo(){
		presentables = new ArrayList<IPresentable>();
	}
	
	protected void agregarEntidad(IPresentable e){
		presentables.add(e);
	}
	
	@Override
	public void paint(Graphics g) {		
		setDoubleBuffered(true);

		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
			    RenderingHints.VALUE_ANTIALIAS_ON);
		
		for( int i = 0 ; i < presentables.size();i ++)
			presentables.get(i).presentar(g);
	}
	
}
