
package alpona;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.sql.Connection;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class update_profile_s extends JFrame{
        private Container c2;
         public static JTextField tf1,tf2,tf3,tf4,tf5,tf6;
         private Font f,f1,f2,f3;
         private JButton bt1,bt2,bt3,bt4,bt5;
         private Cursor cs;
         public JComboBox cb1,cb2,cb3;
         private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11;
         public static JTextArea ta1;
         private JScrollPane sc;
         private JCheckBox ckb1;
         private ImageIcon img,img1,img2,img3;
         public JPasswordField ps;
         private JPanel c;
         private String[] st3 ={"Barguna","Barishal","Bhola","Bandarban","Bogura",
           "Brahmanbaria","Bagerhat","Chandpur","Chattogram","Chuadanga","Cumilla","Cox's Bazar",
           "Chapai Nawabganj","Dhaka","Dinajpur","Faridpur","Feni","Gazipur","Gaibandha","Gopalganj",
           "Habiganj","Jashore","Jhenaidah","Jamalpur","Joypurhat","Jhalokati","Khulna","Kushtia","Kurigram",
           "Kishoreganj","Khagrachhari","Lalmonirhat","Lakshmipur","Madaripur","Manikganj","Munshiganj",
           "Magura","Meherpur","Mymensingh","Moulvibazar","Narayanganj","Narail","Netrokona","Naogaon",
           "Natore","Nilphamari","Narsingdi","Noakhali","Pabna","Panchagarh","Patuakhali","Pirojpur",
           "Rajshahi","Rangpur","Rajbari","Rangamati","Shariatpur","Satkhira","Sherpur","Sirajganj",
           "Sunamganj","Sylhet","Tangail","Thakurgaon"};
         
         update_profile_s(){
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setBounds(100,30,900,650);
              this.setTitle("Supplier Profile");
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
            Color color1= new Color(14,174,87);
            Color color2= new Color(12,116,117);
            GradientPaint gp= new GradientPaint(0,0,color1,180,height,color2);
            g2d.setPaint(gp);
            g2d.fillRect(0,0,width, height);
        }
    }
          public void components(){
              c2= this.getContentPane();
              c2.setLayout(null);
              c2.setBackground(Color.DARK_GRAY);   
              f=new Font("Montserrat",Font.BOLD,30); 
              f1=new Font("Montserrat",Font.BOLD,25);
              f2=new Font("Montserrat",Font.BOLD,16); 
              f3=new Font("Montserrat",Font.BOLD,18);
              cs = new Cursor(Cursor.HAND_CURSOR);
              img= new ImageIcon(getClass().getResource("p1.png"));
              img1= new ImageIcon(getClass().getResource("back.png"));
              
              
              c= new jPanelGradient();
              c.setBackground(Color.DARK_GRAY);
              c.setBounds(0,0,900,650);
              c.setLayout(null);
              c2.add(c);
              
              
              jl1= new JLabel("Change Profile");
              jl1.setBounds(415, 50, 250,50);
              jl1.setFont(f);
              jl1.setForeground(Color.PINK);
              c.add(jl1);
              
              jl9= new JLabel("User Name:");
              jl9.setBounds(250, 110, 140,30);
              jl9.setFont(f1);
              jl9.setForeground(Color.ORANGE);
              c.add(jl9);
              
                
              tf6= new JTextField("");///Username
              tf6.setBounds(400, 110, 225, 30);
              tf6.setFont(f3);
              tf6.setBorder(null);
              tf6.setEditable(false);
              c.add(tf6);
              
              jl2= new JLabel("Name         :");
              jl2.setBounds(250, 160, 140,30);
              jl2.setFont(f1);
              jl2.setForeground(Color.ORANGE);
              c.add(jl2);
              
              jl3= new JLabel("District      :");
              jl3.setBounds(250, 210, 140,30);
              jl3.setFont(f1);
              jl3.setForeground(Color.ORANGE);
              c.add(jl3);
              
              jl5= new JLabel("Area          :");
              jl5.setBounds(250, 270, 140,30);
              jl5.setFont(f1);
              jl5.setForeground(Color.ORANGE);
              c.add(jl5);
              
              jl6= new JLabel("Mobile       :");
              jl6.setBounds(250, 360, 140,30);
              jl6.setFont(f1);
              jl6.setForeground(Color.ORANGE);
              c.add(jl6);
              
              jl7= new JLabel("Email         :");
              jl7.setBounds(250, 420, 140,30);
              jl7.setFont(f1);
              jl7.setForeground(Color.ORANGE);
              c.add(jl7);
              
              jl8= new JLabel("Password  :");
              jl8.setBounds(250, 480, 140,30);
              jl8.setFont(f1);
              jl8.setForeground(Color.ORANGE);
              c.add(jl8);
              
              
              ckb1= new JCheckBox("Show Password");
              ckb1.setBounds(395, 513, 150, 20);
              ckb1.setBackground(new java.awt.Color(0, 102, 102));  
              ckb1.setForeground(Color.WHITE);
              c.add(ckb1);
              ckb1.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                    if(ckb1.isSelected()){
                        ps.setEchoChar((char)0);
                    }
                    else{
                       ps.setEchoChar('*');
                    }
                  }
              
              } );
              
              jl4 = new JLabel(img);
              jl4.setBounds(10, 10, img.getIconWidth(), img.getIconHeight());
              c.add(jl4);
              
              tf1= new JTextField("");///First name
              tf1.setBounds(400, 160, 110, 30);
              tf1.setFont(f3);
              tf1.setBorder(null);
              c.add(tf1);
              
              tf2= new JTextField("");///Last name
              tf2.setBounds(515, 160, 110, 30);
              tf2.setFont(f3);
              tf2.setBorder(null);
              c.add(tf2);
              
              tf4= new JTextField("");///Mobile
              tf4.setBounds(400, 365, 225, 30);
              tf4.setFont(f3);
              tf4.setBorder(null);
              c.add(tf4);
              
              tf5= new JTextField("");///Email
              tf5.setBounds(400, 425, 225, 30);
              tf5.setFont(f3);
              tf5.setBorder(null);
              c.add(tf5);
              
              cb2 = new JComboBox(st3);//District
              cb2.setFont(f3);
              cb2.setBounds(400, 210, 225, 30);
              cb2.setBackground(Color.white);
              c.add(cb2); 
              
              ps = new JPasswordField("");
              ps.setBounds(400, 480, 225, 30);
              ps.setEchoChar('*');
              ps.setFont(f3);
              ps.setBorder(null);
              c.add(ps);
              
              ta1= new JTextArea("");
              ta1.setLineWrap(true);
              ta1.setWrapStyleWord(true);
              ta1.setFont(f3);
              ta1.setBorder(null);
              sc= new JScrollPane(ta1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
              sc.setBounds(400, 270, 225, 80);
              c.add(sc);
              
              bt3= new JButton("Back");
              bt3.setBounds(45, 565, 80, 30);
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
                     Dashboard ne = new  Dashboard();
                      ne.setVisible(true);
                  }
              
              } );
              
              bt1= new JButton("Change");
              bt1.setBounds(460, 550, 80, 30);
              bt1.setFont(f2);
              bt1.setCursor(cs);
              bt1.setBackground(Color.LIGHT_GRAY);
              bt1.setForeground(Color.BLACK);
              bt1.setBorder(null);
              c.add(bt1);
               bt1.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      String uname=tf6.getText();
                      String fname=tf1.getText();
                      String lname=tf2.getText();
                      String pass= String.valueOf(  ps.getPassword());
                      String mobile= tf4.getText();
                      String email= tf5.getText();
                      String dis=(String)cb2.getSelectedItem();
                      String address= ta1.getText();
                      try {
                          PreparedStatement p;
                          //ResultSet rs;
                          String query= "update supplier set Fname=?,Lname=?, Password=?, Mobile=?, Email=?, District=?, Address=? where Uname='"+uname +"'";
                          p= connection.getConnection().prepareStatement(query);
                          p.setString(1, fname);
                          p.setString(2, lname);
                          p.setString(3, pass);
                          p.setString(4, mobile);
                          p.setString(5, email);
                          p.setString(6, dis);
                          p.setString(7, address);
                          if(p.executeUpdate()>0){
                            ImageIcon icon = new ImageIcon("F:\\JavaSwing Project\\Alpona\\src\\icon\\verified account.png");
                            int result=JOptionPane.showConfirmDialog(null, "Do you confirm?", "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                              if(result==0){
                                   ImageIcon icon1 = new ImageIcon("F:\\JavaSwing Project\\Alpona\\src\\icon\\Update_confirmed.png");
                                   JOptionPane.showMessageDialog(null, "Updated.","Confirmation", JOptionPane.INFORMATION_MESSAGE, icon1);
                                 }
                          }
                        
                      } catch (SQLException ex) {
                          Logger.getLogger(update_profile_s.class.getName()).log(Level.SEVERE, null, ex);
                      }
                  }
              
              } );
              
          }
    
       public static void main(String[] args) {
        update_profile_s pf = new update_profile_s();
        pf.setVisible(true);
    }
}
