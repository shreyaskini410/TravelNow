
package travelnow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.*;

public class BookPackage extends JFrame implements ActionListener{
    JLabel l11,l12,l13,l14,l15;
    Choice c1;
    JTextField t1;
    JButton b1,b2,b3;
    BookPackage(){

        setBounds(300,100,500,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel l1=new JLabel("BOOK PACKAGE");
        l1.setBounds(100,10,400,30);
        l1.setFont(new Font("Raleway",Font.BOLD,25));
        add(l1);
        
        JLabel l2=new JLabel("Username:");
        l2.setBounds(100,70,100,30);
        l2.setFont(new Font("Raleway",Font.PLAIN,16));
        add(l2);
        
        l11=new JLabel();
        l11.setBounds(250,70,100,30);
        l11.setFont(new Font("Raleway",Font.PLAIN,16));
        add(l11);
        
        JLabel l3=new JLabel("Select Package:");
        l3.setBounds(100,110,120,30);
        l3.setFont(new Font("Raleway",Font.PLAIN,16));
        add(l3);
        
        c1=new Choice();
        c1.add("Standard Package");
        c1.add("Prime Package");
        c1.add("Premium Package");
        c1.setBounds(250,110,140,30);
        add(c1);
        
        JLabel l4=new JLabel("Total Persons:");
        l4.setBounds(100,150,120,30);
        l4.setFont(new Font("Raleway",Font.PLAIN,16));
        add(l4);
        
        t1=new JTextField("1");
        t1.setBounds(250,150,140,20);
        add(t1);
        
        JLabel l5=new JLabel("ID:");
        l5.setBounds(100,190,100,30);
        l5.setFont(new Font("Raleway",Font.PLAIN,16));
        add(l5);
        
        l12=new JLabel();
        l12.setBounds(250,190,100,30);
        l12.setFont(new Font("Raleway",Font.PLAIN,16));
        add(l12);
        
        JLabel l6=new JLabel("Number:");
        l6.setBounds(100,230,100,30);
        l6.setFont(new Font("Raleway",Font.PLAIN,16));
        add(l6);
        
        l13=new JLabel();
        l13.setBounds(250,230,100,30);
        l13.setFont(new Font("Raleway",Font.PLAIN,16));
        add(l13);
        
        JLabel l7=new JLabel("Phone:");
        l7.setBounds(100,270,100,30);
        l7.setFont(new Font("Raleway",Font.PLAIN,16));
        add(l7);
        
        l14=new JLabel();
        l14.setBounds(250,270,100,30);
        l14.setFont(new Font("Raleway",Font.PLAIN,16));
        add(l14);
        
        JLabel l8=new JLabel("Total Price:");
        l8.setBounds(100,310,100,30);
        l8.setFont(new Font("Raleway",Font.PLAIN,16));
        add(l8);
        
        l15=new JLabel();
        l15.setBounds(250,310,100,30);
        l15.setForeground(Color.BLUE);
        l15.setFont(new Font("Raleway",Font.PLAIN,16));
        add(l15);
        
        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where username= 'kini'");
            while(rs.next()){
                l11.setText(rs.getString("username"));
                l12.setText(rs.getString("id"));
                l13.setText(rs.getString("number"));
                l14.setText(rs.getString("phone"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        b1=new JButton("Check Price");
        b1.setBounds(60,380,120,25);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Book Package");
        b2.setBounds(200,380,120,25);
        b2.addActionListener(this);
        add(b2);
        
        b3=new JButton("Back");
        b3.setBounds(340,380,120,25);
        b3.addActionListener(this);
        add(b3);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String p=c1.getSelectedItem();
            int persons=Integer.parseInt(t1.getText());
            int cost=0;
            if(p.equals("Standard Package")){
                cost+=27000;
            }if(p.equals("Prime Package")){
                cost+=31000;
            }if(p.equals("Premium Package")){
                cost+=42000;
            }
            cost*=persons;
            l15.setText("Rs " + cost);
            
            
        }else if(ae.getSource()==b2){
            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookPackage values('"+l11.getText()+"','"+c1.getSelectedItem()+"','"+t1.getText()+"','"+l12.getText()+"','"+l13.getText()+"','"+l14.getText()+"','"+l15.getText()+"')");
                JOptionPane.showMessageDialog(null,"Booking done Successfully");
                this.setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==b3){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new BookPackage().setVisible(true);
    }
}
