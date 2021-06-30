
package travelnow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.*;

public class CheckPackage extends JFrame{
    CheckPackage(){
        setBounds(300,100,900,600);
        
        String[] package1=new String[]{"Standard Package","Location : Kochi, Kerala","Hotel : Le Meridian Kochi","Stay : 6 days 7 nights","Airport assistance included",
            "Unlimited Breakfast included","Rs 27000/- Only","BUY NOW LIMITED TIME OFFER!!","kochi.jpg"
        };
        
        String[] package2=new String[]{"Prime Package","Location : Goa","Resort : Baga Beach Resort","Stay : 5 days 6 nights", "Airport assistance included",
          "Beach Side Barbeque Dinner","Rs 31000/- Only","ONE TIME OFFER!!","goa.jpg"  
        };
        
        String[] package3=new String[]{"Premium Package","Location : Manali","Hotel : Hotel Piccadily Manali",
          "Stay : 6 days 7 nights","Adventurous Mountain trek","Skiing Training included","Rs 42000/- Only","Seasonal Offer Hurry!!",
          "manali2.jpg"
        };
        
        JTabbedPane pane=new JTabbedPane();
        
        
        
        pane.addTab("Standard Package", null,createPackage(package1));
        
        pane.addTab("Prime Package", null,createPackage(package2));
        
        pane.addTab("Premium Package", null,createPackage(package3));
        add(pane,BorderLayout.CENTER);
        
    }
    
    public JPanel createPackage(String[] pack){
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        
        JLabel l1=new JLabel(pack[0]);
        l1.setBounds(50,5,500,60);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Raleway",Font.BOLD,35));
        p1.add(l1);
        
        JLabel l2=new JLabel(pack[1]);
        l2.setBounds(50,60,300,30);
        l2.setFont(new Font("Raleway",Font.ITALIC,20));
        p1.add(l2);
        
        JLabel l3=new JLabel(pack[2]);
        l3.setBounds(50,110,300,30);
        l3.setFont(new Font("Raleway",Font.ITALIC,20));
        p1.add(l3);
        
        JLabel l4=new JLabel(pack[3]);
        l4.setBounds(50,160,300,30);
        l4.setFont(new Font("Raleway",Font.ITALIC,20));
        p1.add(l4);
        
        JLabel l5=new JLabel(pack[4]);
        l5.setBounds(50,210,300,30);
        l5.setFont(new Font("Raleway",Font.ITALIC,20));
        p1.add(l5);
        
        JLabel l6=new JLabel(pack[5]);
        l6.setBounds(50,260,300,30);
        l6.setFont(new Font("Raleway",Font.ITALIC,20));
        p1.add(l6);
        
        JLabel l7=new JLabel(pack[6]);
        l7.setBounds(50,330,300,30);
        l7.setFont(new Font("Raleway",Font.ITALIC,25));
        p1.add(l7);
        
        JLabel l9=new JLabel(pack[7]);
        l9.setBounds(200,400,700,60);
        l9.setForeground(Color.RED);
        l9.setFont(new Font("Raleway",Font.ITALIC,35));
        p1.add(l9);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("travelnow\\icons\\"+pack[8]));
        Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l8=new JLabel(i3);
        l8.setBounds(400,20,500,300);
        p1.add(l8);
        
        return p1;
    }
    
    public static void main(String[] args){
        new CheckPackage().setVisible(true);
    }
}
