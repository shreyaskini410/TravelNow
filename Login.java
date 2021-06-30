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

/**
 *
 * @author Shreyas
 */
public class Login extends JFrame implements ActionListener{
    JButton b1,b2,b3;
    JTextField t1;
    JPasswordField t2;
    Login(){
        setLayout(null);
        getContentPane().setBackground(new Color(51-153-255));
        setBounds(300,200,900,400);
        
        JPanel p1=new JPanel();
        p1.setBackground(Color.WHITE);
        p1.setBounds(0,0,400,400);
        add(p1);
        
        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("travelnow\\icons\\login.png"));
        JLabel l1=new JLabel(il);
        l1.setBounds(100,100,300,300);
        p1.add(l1);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        
        JLabel l2=new JLabel("Username : ");
        l2.setBounds(60,20,100,25);
        p2.add(l2);
        
        t1=new JTextField();
        t1.setBounds(60,60,300,30);
        p2.add(t1);
        
        JLabel l3=new JLabel("Password : ");
        l3.setBounds(60,110,100,25);
        p2.add(l3);
        
        t2=new JPasswordField();
        t2.setBounds(60,150,300,30);
        p2.add(t2);
        
        b1=new JButton("Login");
        b1.setBounds(60,200,130,30);
        b1.addActionListener(this);
        p2.add(b1);
        
        b2=new JButton("Sign Up");
        b2.setBounds(250,200,130,30);
        b2.addActionListener(this);
        p2.add(b2);
        
        b3=new JButton("Forgot Password");
        b3.setBounds(130,250,150,30);
        b3.addActionListener(this);
        p2.add(b3);
        
        JLabel l4=new JLabel("Trouble logging in?");
        l4.setForeground(Color.red);
        l4.setBounds(300,230,100,25);
        p2.add(l4);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                String username=t1.getText();
                String password=t2.getText();
                String sql="select * from account where username = '"+username+"' AND password = '"+password+"'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(sql);
                if(rs.next()){
                    this.setVisible(false);
                    new Loading(username).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid Login, Please try again");
                }
            }catch(Exception e){
                
            }
        }else if(ae.getSource()==b2){
            new Signup().setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource()==b3){
            this.setVisible(false);
            new ForgotPassword().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}

