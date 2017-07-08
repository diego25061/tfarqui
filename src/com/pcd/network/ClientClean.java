package com.pcd.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientClean {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		inicializarCliente();
		
		new Thread( new Runnable() {
			@Override
			public void run() {
				iniciarListenThread();
			}
		}).start();
		
		enviarObjeto(null);
		/*
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));			
		PrintWriter out;
		out = new PrintWriter( bw );*/
	}
	
	static Socket socket;
	
	public static void inicializarCliente(){

		try {
			socket = new Socket("localhost", ServerClean.PORT);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void iniciarListenThread(){
		Scanner scan = new Scanner(System.in);
		
		while(true){
			System.out.println("Escribir mensaje:");
			try{
				
				/*
				socket.getOutputStream().write(1);
				
				//OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());//.append('a').append('\n');
				//writer.write(256);
				 * 
				socket.getOutputStream().write(2);
				//out.write(msj);	*/
				
				ObjectInputStream returnStream = new ObjectInputStream(socket.getInputStream());
				Holder returnObject = (Holder) returnStream.readObject();
				System.out.println(returnObject.msg);
				

			}catch(Exception ex){
				ex.printStackTrace();
				return;
			}
			
			System.out.println("Mensaje enviado");
		}
		
	}
	
	public void procesarRecibido(Holder hold){
		
	}
	
	public static void enviarObjeto(Holder hold){

		try{
		
			String msj ="mensaje de enviar!";
			
			Holder holder = new Holder();
			holder.msg = msj;
	
			ObjectOutputStream sendStream = new ObjectOutputStream(socket.getOutputStream());
			sendStream.writeObject(holder);
			
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

}
