package com.pcd.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerClean {
	
	public static final int PORT = 31999;
	//int conexiones; 
	static ArrayList<Socket> sockets;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		iniciar();

	}
	
	public static void iniciar(){

		ServerSocket server;
		sockets = new ArrayList<Socket>();
		
		try {
			server = new ServerSocket(PORT);
			System.out.println("Servidor abierto");
			final Socket clientSocket;
			while(true){
				iniciarCliente(server.accept());
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void iniciarCliente(final Socket client){
		sockets.add(client);
		final int id = sockets.size() -1;
		System.out.println("Conexion nueva entro con id " + (id));
		Thread t = new Thread( new Runnable (){
			@Override
			public void run(){ 
				
				//@@@@@@@@@@@@@@ chat				
				System.out.println("Thread execution start");
				Reader br = null;
				
				while(true){
					try{
						
						ObjectInputStream objStream = new ObjectInputStream (client.getInputStream());
						Holder holder = (Holder) objStream.readObject();
						procesarEventoRecibido(id, holder);
					}catch(Exception ex){
						ex.printStackTrace();
						return;
					}

				}
				//@@@@@@@@@@@@@@@@@@@@@@
			}
		});
		t.start();
	}
	
	public static void procesarEventoRecibido(final int idCliente, Holder holder){
		System.out.println("@"+idCliente+". " +  holder.msg);
	}
	
}
