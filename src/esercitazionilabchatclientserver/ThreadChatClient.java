/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esercitazionilabchatclientserver;

/**
 *
 * @author Studente
 */
import java.net.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class ThreadChatClient implements Runnable{
  private List lista;
  Thread me;
  private Socket client;
  private BufferedReader input=null;
  private PrintWriter output=null;
  public ThreadChatClient(List lista, String ipServer, int porta){
    this.lista = lista;
    
    try{
      client=new Socket(ipServer,porta);
      this.input=new BufferedReader(new InputStreamReader(client.getInputStream()));
      this.output=new PrintWriter(client.getOutputStream(),true);
    }catch(Exception e){
      JOptionPane.showMessageDialog(null,"No connessione Server");
    }
    me = new Thread(this);
    me.start();
  }
  
  public void run(){
    while(true){
      try{
        String mex = null;
        while((mex=input.readLine())==null){
          
        }
        lista.add(mex);
        lista.select(lista.getItemCount()-1);
      }catch(Exception e){
      
      }
    }
  }
  
  public void spedisciMessaggioChat(String messaggio){
    try{
      output.println(messaggio);
      
    }catch(Exception e){}
  }
}
