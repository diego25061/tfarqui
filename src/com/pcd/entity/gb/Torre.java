package com.pcd.entity.gb;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.pcd.Movible;

public class Torre extends Movible {
	
	BufferedImage imagen;
	ArrayList<Movible> unidadesAlrededor;
	
	public Torre(ArrayList<Movible> movibles) {
		super();
		try {
			imagen =  ImageIO.read(new File("recursos/img/ClockTower7.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void enFrame0() {
		super.enFrame0();
		
		float factor = 0.3f;
		
		int nuevoAncho =(int) (imagen.getWidth() * factor);
		int nuevoAlto = (int) (imagen.getHeight() * factor);
		
		BufferedImage resizedImage = new BufferedImage( nuevoAncho, nuevoAlto , BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(imagen.getScaledInstance( nuevoAncho,nuevoAlto , Image.SCALE_SMOOTH), 0, 0,nuevoAncho, nuevoAlto, null);
		g.dispose();
		imagen = resizedImage;
	}
	
	
	@Override
	public void presentar(Graphics g) {
		super.presentar(g);
		g.drawImage( imagen , (int) pos.x() - imagen.getWidth()/2, (int) pos.y() - imagen.getHeight()/2, null);
	}
	
	@Override
	public void ejecutar(float step) {
		// TODO Auto-generated method stub
		super.ejecutar(step);
	}
}
