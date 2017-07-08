package com.pcd;
import grf.dr.core.ControladorEntidades;
import grf.dr.core.MotorGrafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import com.pcd.entity.Contador;
import com.pcd.entity.Mapa;
import com.pcd.network.ClientClean;


public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		ClientClean.inicializarCliente();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ControladorEntidades cont  = new ControladorEntidades();
		frame.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		frame.addKeyListener( new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				ControladorEntidades.getInstance().keyTyped(e);
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				ControladorEntidades.getInstance().keyReleased(e);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				ControladorEntidades.getInstance().keyPressed(e);
			}
		});
		
		MotorGrafico mg = new MotorGrafico();
		Thread t = new Thread(){
			@Override
			public void run() {
				mg.run();	
			}
		};
		t.start();
		
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(mg.getLienzo() ,  BorderLayout.CENTER);
		
		Mapa mapa = new Mapa();
		MotorGrafico.agregarEntidad(mapa);
		MotorGrafico.agregarEntidad(new Contador());
		/*
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		*/
	}

}
