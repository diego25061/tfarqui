package grf.dr.core;

import java.awt.Graphics;

public class Entidad implements IPresentable{

	protected float tiempoTotal;
	public boolean activado = true;
	protected int frame;
	
	public Entidad(){
		MotorGrafico.agregarEntidad(this);
	}

	protected void agregarEntidad(Entidad e){
//MotorGrafico.agregarEntidad(e);
	}

	public void preEjecutar(float step){
            if(frame==0)
                enFrame0();
            tiempoTotal +=step;
	}

	public void ejecutar(float step){
	}
	
	public void postEjecutar(float step){
		frame++;
	}
	
	protected void enFrame0(){
		
	}

    @Override
    public void presentar(Graphics g) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	
	
	
}
