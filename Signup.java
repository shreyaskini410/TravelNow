/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelnow;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Shreyas
 */
public class Signup extends JFrame implements ActionListener{
    JButton b1,b2;
    JTextField t1,t2,t4,t3;
    Choice c1;
    Signup(){
        setBounds(100,100,900,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(255-255-153));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel l1=new JLabel("User Name:");
        l1.setFont(new Font("",Font.BOLD,14));
        l1.setBounds(50,20,100,25);
        p1.add(l1);
        
        t1=new JTextField();
        t1.setBounds(200,20,180,25);
        p1.add(t1);
        
        JLabel l2=new JLabel("Name: ");
        l2.setFont(new Font("",Font.BOLD,14));
        l2.setBounds(50,60,100,25);
        p1.add(l2);
        
        t2=new JTextField();
        t2.setBounds(200,60,180,25);
        p1.add(t2);
        
        JLabel l3=new JLabel("Password:");
        l3.setFont(new Font("",Font.BOLD,14));
        l3.setBounds(50,100,100,25);
        p1.add(l3);
        
        t3=new JTextField();
        t3.setBounds(200,100,180,25);
        p1.add(t3);
        
        JLabel l4=new JLabel("Security Question:");
        l4.setFont(new Font("",Font.BOLD,14));
        l4.setBounds(50,140,140,25);
        p1.add(l4);
        
        c1 = new Choice();
        c1.add("What is the colour of your eyes?");
        c1.add("What is your ethnicity?");
        c1.add("Which month is your birthday?");
        c1.add("Which is your favorite sport?");
        c1.setBounds(200,140,180,25);
        p1.add(c1);
        
        JLabel l5=new JLabel("Answer: ");
        l5.setFont(new Font("",Font.BOLD,14));
        l5.setBounds(50,180,100,25);
        p1.add(l5);
        
        t4=new JTextField();
        t4.setBounds(200,180,180,25);
        p1.add(t4);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travelnow\\icons\\signup.png"));
        JLabel l6=new JLabel(i1);
        l6.setBounds(550,20,250,250);
        add(l6);
        
        b1=new JButton("Sign Up");
        b1.addActionListener(this);
        b1.setBounds(80,250,100,25);
        p1.add(b1);
        
        b2=new JButton("Back");
        b2.addActionListener(this);
        b2.setBounds(250,250,100,25);
        p1.add(b2);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String username=t1.getText();
            String name=t2.getText();
            String password=t3.getText();
            String security=c1.getSelectedItem();
            String answer=t4.getText();
            
            String query="insert into account values('"+username+"', '"+name+"', '"+password+"', '"+security+"', '"+answer+"')";
            
            try{
                Conn c=new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Account created successfully");
                
                this.setVisible(false);
                new Login().setVisible(true);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==b2){
            new Login().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Signup().setVisible(true);
    }
}
