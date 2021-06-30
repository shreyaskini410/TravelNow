
package travelnow;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5;
    String username;
    Dashboard(String username){
        this.username=username;
        setBounds(0,0,1000,700);
        setLayout(null);
        
        JPanel p1=new JPanel();
        p1.setBounds(0,0,1000,60);
        p1.setLayout(null);
        p1.setBackground(Color.ORANGE);
        add(p1);
        
        JLabel l3=new JLabel("TravelNow");
        l3.setBounds(400,20,600,40);
        l3.setFont(new Font("Raleway",Font.BOLD,35));
        p1.add(l3);
        
        JPanel p2=new JPanel();
        p2.setBounds(0,60,300,700);
        p2.setLayout(null);
        p2.setBackground(Color.ORANGE);
        add(p2);
        
        b1=new JButton("Add Personal Details");
        b1.setBackground(Color.ORANGE);
        b1.setFont(new Font("Raleway",Font.BOLD,20));
        b1.setBounds(0,0,300,50);
        b1.addActionListener(this);
        p2.add(b1);
        
        b2=new JButton("Update Personal Details");
        b2.setBackground(Color.ORANGE);
        b2.setFont(new Font("Raleway",Font.BOLD,20));
        b2.setBounds(0,50,300,50);
        b2.addActionListener(this);
        p2.add(b2);
        
        b3=new JButton("Check Package");
        b3.setBackground(Color.ORANGE);
        b3.setFont(new Font("Raleway",Font.BOLD,20));
        b3.setBounds(0,100,300,50);
        b3.addActionListener(this);
        p2.add(b3);
        
        b4=new JButton("Book Package");
        b4.setBackground(Color.ORANGE);
        b4.setFont(new Font("Raleway",Font.BOLD,20));
        b4.setBounds(0,150,300,50);
        b4.addActionListener(this);
        p2.add(b4);
        
        b5=new JButton("View Packages");
        b5.setBackground(Color.ORANGE);
        b5.setFont(new Font("Raleway",Font.BOLD,20));
        b5.setBounds(0,200,300,50);
        b5.addActionListener(this);
        p2.add(b5);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travelnow\\icons\\sun.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        l1.setBounds(0,0,1000,700);
        add(l1);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new AddCustomer(username).setVisible(true);
        }
        if(ae.getSource()==b2){
            new UpdateCustomer(username).setVisible(true);
        }
        if(ae.getSource()==b3){
            new CheckPackage().setVisible(true);
        }
        if(ae.getSource()==b4){
            new BookPackage().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Dashboard("").setVisible(true);
    }
}
