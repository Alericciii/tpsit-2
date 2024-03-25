/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esercitazionilabchatclientserver;

/**
 *
 * @author Studente
 */
public class ChatServer extends JFrame {
  public ChatServer(){
    super("Chat Server");
    this.setSize(new Dimension(500,300));
    this.setLocationRelativeTo(null);
    this.setEnabled(true);
    this.setBackground(Color.blue);
    PannelloChatServer pan = new PannelloChatServer();
    this.getContentPane().add(pan);
    this.setVisible(true);
  }
}

