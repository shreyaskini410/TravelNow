/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelnow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgotPassword extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2,b3;
    ForgotPassword(){
        setBounds(300,150,850,400);
        getContentPane().setBackground(Color.ORANGE);
        setLayout(null);
        
        JPanel p=new JPanel();
        p.setBounds(30,30,500,300);
        p.setLayout(null);
        add(p);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travelnow\\icons\\lock.jpg"));
        Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l6=new JLabel(i3);
        l6.setBounds(580,50,200,200);
        add(l6);
        
        JLabel l1=new JLabel("Username:");
        l1.setBounds(40,20,100,25);
        l1.setFont(new Font("",Font.BOLD,14));
        p.add(l1);
        
        t1=new JTextField();
        t1.setBounds(220,20,170,25);
        p.add(t1);
        
        b1=new JButton("Search");
        b1.setBounds(400,20,90,20);
        b1.addActionListener(this);
        p.add(b1);
        
        JLabel l2=new JLabel("Name:");
        l2.setBounds(40,50,100,25);
        l2.setFont(new Font("",Font.BOLD,14));
        p.add(l2);
        
        t2=new JTextField();
        t2.setBounds(220,50,170,25);
        p.add(t2);
        
        JLabel l3=new JLabel("Your security question:");
        l3.setBounds(40,80,170,25);
        l3.setFont(new Font("",Font.BOLD,14));
        p.add(l3);
        
        t3=new JTextField();
        t3.setBounds(220,80,170,25);
        p.add(t3);
        
        JLabel l4=new JLabel("Answer:");
        l4.setBounds(40,110,170,25);
        l4.setFont(new Font("",Font.BOLD,14));
        p.add(l4);
        
        t4=new JTextField();
        t4.setBounds(220,110,170,25);
        p.add(t4);
        
        b2=new JButton("Retrieve");
        b2.setBounds(400,110,90,20);
        b2.addActionListener(this);
        p.add(b2);
        
        JLabel l5=new JLabel("New Password");
        l5.setBounds(40,140,170,25);
        l5.setFont(new Font("",Font.BOLD,14));
        p.add(l5);
        
        t5=new JTextField();
        t5.setBounds(220,140,170,25);
        p.add(t5);
        
        b3 = new JButton("Back");
        b3.setBounds(220, 230, 100, 30);
        b3.addActionListener(this);
        p.add(b3);
    }
    
    public void actionPerformed(ActionEvent ae){
        Conn c=new Conn();
        if(ae.getSource()==b1){
            try{
                String sql="select * from account where username = '"+t1.getText()+"'";
                ResultSet rs=c.s.executeQuery(sql);
                while(rs.next()){
                    t2.setText(rs.getString("name"));
                    t3.setText(rs.getString("security"));
                }
            }
            catch(Exception e){
                
            }
        }else if(ae.getSource()==b2){
            
        }
        else if(ae.getSource()==b3){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new ForgotPassword().setVisible(true);
    }
}
