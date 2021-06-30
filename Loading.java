/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelnow;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    JProgressBar p;
    String username;
    Thread t;
    
    public void run(){
        try{
            for(int i=1;i<=100;i++){
                int x=p.getMaximum();
                int y=p.getValue();
                if(y<x){
                    p.setValue(p.getValue()+1);
                }if(i==100){
                    setVisible(false);
                    new Dashboard(username).setVisible(true);
                }
                Thread.sleep(60);
            }
        }catch(Exception e){
            
        }
    }
    Loading(String user){
        username=user;
        t=new Thread(this);
       
        setBounds(400,250,650,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel l1=new JLabel("Welcome to TravelNow");
        l1.setBounds(130,20,600,40);
        l1.setFont(new Font("Raleway",Font.BOLD,35));
        add(l1);
        
        p=new JProgressBar();
        p.setStringPainted(true);
        p.setBounds(180, 130, 300, 25);
        add(p);
        
        JLabel l2=new JLabel("Loading..");
        l2.setBounds(290,150,600,40);
        l2.setFont(new Font("Raleway",Font.BOLD,14));
        l2.setForeground(Color.red);
        add(l2);
        
        t.start();
    }
    public static void main(String[] args){
        new Loading("").setVisible(true);
    }
}
