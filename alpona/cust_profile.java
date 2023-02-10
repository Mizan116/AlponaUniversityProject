
package alpona;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
///61,245,167
///9,111,224
public class cust_profile extends JFrame{
        private Container c2;
         public JTextField tf1,tf2,tf3,tf4,tf5,tf6;
         private Font f,f1,f2,f3;
         private JButton bt1,bt2,bt3,bt4,bt5;
         private Cursor cs;
         private JComboBox cb1,cb2,cb3;
         private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11;
         private JTextArea ta1;
         private JScrollPane sc;
         private ImageIcon img,img1,img2,img3;
         private JPasswordField ps;
         private JPanel c;
         
        cust_profile(){
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setBounds(100,30,900,650);
              this.setTitle("Customer Profile");
              components();
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               this.setLocationRelativeTo(null);
               setUndecorated(true);
               setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
               this.setVisible(true);
         }
           class jPanelGradient extends JPanel{
              protected void paintComponent(Graphics g){
                  Graphics2D g2d= (Graphics2D) g;
                  int width= getWidth();
                  int height= getHeight();
                  Color color1= new Color(61,245,167);
                  Color color2= new Color(9,111,224);
                  GradientPaint gp= new GradientPaint(0,0,color1,180,height,color2);
                  g2d.setPaint(gp);
                  g2d.fillRect(0,0,width, height);
              }
          }
        
          public void components(){
              c2= this.getContentPane();
              c2.setLayout(null);   
              f=new Font("Montserrat",Font.BOLD,45); 
              f1=new Font("Montserrat",Font.BOLD,25);
              f2=new Font("Montserrat",Font.BOLD,16); 
              f3=new Font("Montserrat",Font.BOLD,18);
              cs = new Cursor(Cursor.HAND_CURSOR);
              img= new ImageIcon(getClass().getResource("p1.png"));
              img1= new ImageIcon(getClass().getResource("back.png"));
              
             c=new jPanelGradient();
             c.setBounds(0,0,900,650);
             c.setLayout(null);
             c2.add(c);
              
              jl1= new JLabel("Profile");
              jl1.setBounds(440, 150, 200,50);
              jl1.setFont(f);
              jl1.setForeground(Color.PINK);
              c.add(jl1);
              
              jl9= new JLabel("User Name:");
              jl9.setBounds(250, 240, 140,30);
              jl9.setFont(f1);
              jl9.setForeground(Color.ORANGE);
              c.add(jl9);
              
                
              tf6= new JTextField("");///UserName
              tf6.setBounds(400, 240, 225, 30);
              tf6.setFont(f3);
              tf6.setEditable(false);
              tf6.setHorizontalAlignment(JTextField.CENTER);
              tf6.setBorder(null);
              c.add(tf6);
              
              jl2= new JLabel("Name         :");
              jl2.setBounds(250, 280, 140,30);
              jl2.setFont(f1);
              jl2.setForeground(Color.ORANGE);
              c.add(jl2);
        
              
              jl6= new JLabel("Mobile       :");
              jl6.setBounds(250, 340, 140,30);
              jl6.setFont(f1);
              jl6.setForeground(Color.ORANGE);
              c.add(jl6);
              
              jl7= new JLabel("Email         :");
              jl7.setBounds(250, 400, 140,30);
              jl7.setFont(f1);
              jl7.setForeground(Color.ORANGE);
              c.add(jl7);
              
              jl4 = new JLabel(img);
              jl4.setBounds(10, 10, img.getIconWidth(), img.getIconHeight());
              c.add(jl4);
              
              tf1= new JTextField("");///First name
              tf1.setBounds(400, 280, 110, 30);
              tf1.setFont(f3);
              tf1.setBorder(null);
              tf1.setEditable(false);
              tf1.setHorizontalAlignment(JTextField.CENTER);
              c.add(tf1);
              
              tf2= new JTextField("");//Last Name
              tf2.setBounds(515, 280, 110, 30);
              tf2.setFont(f3);
              tf2.setBorder(null);
              tf2.setEditable(false);
              tf2.setHorizontalAlignment(JTextField.CENTER);
              c.add(tf2);
              
              tf4= new JTextField("");///Mobile
              tf4.setBounds(400, 340, 225, 30);
              tf4.setFont(f3);
              tf4.setBorder(null);
              tf4.setEditable(false);
              tf4.setHorizontalAlignment(JTextField.CENTER);
              c.add(tf4);
              
              tf5= new JTextField("");///Email
              tf5.setBounds(400, 400, 225, 30);
              tf5.setFont(f3);
              tf5.setBorder(null);
              tf5.setEditable(false);
              tf5.setHorizontalAlignment(JTextField.CENTER);
              c.add(tf5);
              
              bt3= new JButton("Back");
              bt3.setBounds(60, 550, 80, 30);
              bt3.setFont(f2);
              bt3.setCursor(cs);
              bt3.setBackground(Color.LIGHT_GRAY);
              bt3.setForeground(Color.BLACK);
              bt3.setBorder(null);
              c.add(bt3);
              
              
               bt3.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      
                      dispose();
                      CustomerProduct ne = new CustomerProduct();
                      ne.setVisible(true);
                    
               
                  }
              
              } );
              
              
              
          }
    
       public static void main(String[] args) {
        cust_profile  pf = new cust_profile();
        pf.setVisible(true);
    }
}
