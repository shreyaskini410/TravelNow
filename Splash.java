
package travelnow;

import javax.swing.*;
import java.awt.*;

public class Splash {
    public static void main(String args[]){
        SplashFrame frame=new SplashFrame();
        frame.setVisible(true);
        int x=1;
        for(int i=1;i<=700;i+=1,x+=1){
            frame.setLocation(50,50);
            frame.setSize(x+i,i);
        }
        try{
            Thread.sleep(10);
            
        }catch(Exception e){
            
        }
    }
}

class SplashFrame extends JFrame implements Runnable{
    Thread t1;
    SplashFrame(){
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("travelnow/icons/welcome.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,500,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l1=new JLabel(i3);
        add(l1);
        setLocation(200,150);
        setSize(900,500);
        
        t1=new Thread(this);
        t1.start();
       
    }
    
    public void run(){
        try{
            Thread.sleep(5000);
            this.setVisible(false);
            
            new Login().setVisible(true);
        }catch(Exception e){}
    }
}