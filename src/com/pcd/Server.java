/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcd;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import com.pcd.entity.Jugador;
import com.pcd.entity.Mapa;

/**
 *
 * @author alumnos
 */
public class Server {
    
    Random random;
    
    ArrayList<Jugador> jugadores;
    
    Input in;
    
    public Server(){
        random = new Random();
        in = new Input();
    }
    
    public static void main(String[] args) {        
            
        System.out.println("==SERVER==");
        ServerSocket MyService = null;
        Socket clientSocket = null;
        InputStream instream = null;

        try {
            System.out.println("Abriendo server");
            MyService = new ServerSocket(36000);
            System.out.println("Esperando conexion");
            
            clientSocket = MyService.accept();
            
            System.out.println("Entró una conexion");
        
            
            instream = clientSocket.getInputStream();
            
            if(instream!=null)
                System.out.println("Leyendo instream");
            
            DataInputStream datain = new DataInputStream(instream);
            //BufferedReader bf = new BufferedReader(new Reader());
            System.out.println(datain.readLine());
         
        }
        catch (IOException e) {
            System.out.println(e);
        }        
    }
    
    
    
    public void jugadorEntra(){
     
        int r = (int)(random.nextInt()*255);
        int g = (int)(random.nextInt()*255);
        int b = (int)(random.nextInt()*255);
        
        Color c = new Color(r,g,b);
        Jugador j = new Jugador(c);
        Mapa.entidades.add(j);
        jugadores.add(j);
    }
    
    
    public class Input implements KeyListener{

	boolean [] pressed;

        public Input() {
            pressed = new boolean[65536];
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
            for ( KeyListener ent: jugadores){
                if(!pressed[e.getKeyCode()]){
                    ent.keyPressed(e);
                    pressed[e.getKeyCode()] = true;
                }
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            for ( KeyListener ent: jugadores){
                if(!pressed[e.getKeyCode()]){
                    ent.keyPressed(e);
                    pressed[e.getKeyCode()] = true;
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            for ( KeyListener ent: jugadores){
                if(!pressed[e.getKeyCode()]){
                    ent.keyPressed(e);
                    pressed[e.getKeyCode()] = true;
                }
            }
        }
        
        
    }
    
}
