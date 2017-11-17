package com.pcd;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class TexturedMovable extends Movible {

	protected BufferedImage imagen;
	String imagePath;
	float imageSize = 1;
	public boolean mostrar = true;
	
	private float maxhp = 100;
	private float hp = maxhp;
	
	public boolean mostrarBarra = true;
	
	public TexturedMovable(String imgPath, float size ) {
		super();
		imagePath = imgPath;
		imageSize = size;
		try {
			int nuevoAncho =(int) (128 * imageSize);
			int nuevoAlto = (int) (128 * imageSize);
			imagen =  ImageIO.read(new File(imagePath));
			//int nuevoAncho =(int) (imagen.getWidth() * imageSize);
			//int nuevoAlto = (int) (imagen.getHeight() * imageSize);
			BufferedImage resizedImage = new BufferedImage( nuevoAncho, nuevoAlto , BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(imagen.getScaledInstance( nuevoAncho,nuevoAlto , Image.SCALE_SMOOTH), 0, 0,nuevoAncho, nuevoAlto, null);
			g.dispose();
			imagen = resizedImage;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TexturedMovable(String imgPath) {
		this(imgPath,1);
	}
	
	@Override
	public void presentar(Graphics g) {
		super.presentar(g);
		if(imagen==null)
			System.out.println("CSMRE");
		if(pos==null)
			System.out.println("pos ctm");
		if(g==null)
			System.out.println("ggggggg");
		
		g.setColor(Color.red);
	
		g.fillRect((int)pos.x() - 40, (int)pos.y()+80, 80, 10);

		g.setColor(Color.green);
		g.fillRect((int)pos.x() - 40, (int)pos.y()+80, (int)(80 * hp/maxhp), 10);
		
		if(imagen!=null && mostrar)
			g.drawImage( imagen , (int) pos.x() - imagen.getWidth()/2, (int) pos.y() - imagen.getHeight()/2, null);
	}
	
	/**;-;
	 */
	public void lastimar(float danho){
		hp = hp - danho;
	}
	
}
