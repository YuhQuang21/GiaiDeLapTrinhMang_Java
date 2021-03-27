/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JTextPane;
import java.net.Socket;

/**
 *
 * @author Administrator
 */
public class MessageSocket {

    /**
     * @param args the command line arguments
     */
    private  Socket socket;
    private JTextPane txpMessageBox;
    private DataOutputStream dos;
    private DataInputStream dis;

    public MessageSocket(Socket socket, JTextPane txpMessageBox) throws IOException {
        this.socket = socket;
        this.txpMessageBox = txpMessageBox; 
        dos = new DataOutputStream(socket.getOutputStream());
        dis = new DataInputStream(socket.getInputStream());
    }
    public void receive(){
        
    }
    public void sendByServer(String msg) throws IOException{
        String strCurrent = txpMessageBox.getText();
        txpMessageBox.setText(strCurrent + "\nServer: " + msg);
        dos.writeUTF(txpMessageBox.getText());
    }
    public void sendByClient(String msg) throws IOException{
        String strCurrent = txpMessageBox.getText();
        txpMessageBox.setText(strCurrent + "\nClient: " + msg);
        dos.writeUTF(txpMessageBox.getText());
    }
    public void close(){
        try {
            dis.close();
            dos.close();
            socket.close();
        } catch (Exception e) {
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
}
