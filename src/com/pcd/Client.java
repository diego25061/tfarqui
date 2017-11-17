/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcd;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumnos
 */
public class Client {
    
    public static void main (String[] args){
        
        System.out.println("==CLIENTE==");
        Socket client = null;
        DataOutputStream os = null;
        DataInputStream is = null;
        
        
        try {
            System.out.println("Intentando conectar");
            client = new Socket("localhost", 36000);
            System.out.println("Se conectó con exito");
            //client.connect(new SocketAddress( ));
            os = new DataOutputStream(client.getOutputStream());
            is = new DataInputStream(client.getInputStream());
        
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: hostname");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: hostname");
        }
        
        if (client != null && os != null && is != null) {
            try {    
                
                os.writeBytes("HELLO\n");
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
