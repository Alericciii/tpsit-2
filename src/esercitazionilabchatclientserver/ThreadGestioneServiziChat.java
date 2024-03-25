/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esercitazionilabchatclientserver;

/**
 *
 * @author Studente
 */

   public class ThreadGestioneServiziChat implements Runnable {
    private int nrMaxconnessioni;
    private List lista; 
    private ThreadChatConnessioni[] listaConnessioni;
    Thread me;
    private ServerSocket serverChat;

    public ThreadGestioneServiziChat(int numeroMaxConnessioni,List lista){
        this.nrMaxConnessioni = nrMaxConnessioni-1;
        this.lista = lista;
        this.listaConnessioni = new ThreadChatConnessioni[this.nrMaxConnessioni];
        me = new Thread(this);
        me.start();

    }

    public void run(){
        boolean continua = true;
        try{
            serverChat = new ServerSocket(6789);
        }catch(Exception e){
            JOptionPane.showMessaggeDialog(null,"Impossibile instanziare il server");
            continua = false;
        }
        
    if(continua){
        try{
            for(int xx = 0;xx<nrMaxConnessioni;xx++){
                Socket tempo = null;
                tempo = serverChat.accept();
                listaConnessioni[xx]=new ThreadChatConnessioni(this,tempo);
            }
            serverChat.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Impossibile instanziare il server");
        }
    }
    }
     public void spedisciMessaggio(String mex){
    lista.add(mex);
    lista.select(lista.getItemCount()-1);
    for(int xx = 0;xx<nrMaxConnessioni;xx++){
      if(listaConnessioni[xx]!=null){
        listaConnessioni[xx].spedisciMessaggioChat(mex);
      }
    }
  }


