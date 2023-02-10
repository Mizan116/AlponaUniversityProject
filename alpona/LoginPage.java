
package alpona;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;

public class LoginPage extends JFrame{
    
         private Container c;
         public JTextField tf1,tf2,tf3,tf4,tf5,tf6;
         private Font f,f1,f2,f3;
         public JButton bt1,bt2,bt3,bt4,bt5;
         private Cursor cs;
         private JComboBox cb1,cb2,cb3;
         private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11;
         private JTextArea ta1;
         private JScrollPane sc;
         private ImageIcon img,img1,img2,img3;
         private JPasswordField ps;
         private JPanel p1,p2,p3;
         private JCheckBox ckb1;
         private String uname;
         private String[] st3 ={"ENTER AS A SUPPLIER","ENTER AS A CUSTOMER"};
         
         LoginPage(){
               this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               this.setBounds(100,30,900,650);
               this.setTitle("Supplier Login");
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
                  Color color1= new Color(67, 67, 67);
                  Color color2= new Color(0, 0, 0);
                  GradientPaint gp= new GradientPaint(0,0,color1,180,height,color2);
                  g2d.setPaint(gp);
                  g2d.fillRect(0,0,width, height);
              }
          }

       
         public void components(){
              c= this.getContentPane();
              c.setLayout(null);
              c.setBackground(new java.awt.Color(204, 204, 204));   
              f=new Font("Montserrat",Font.BOLD,30); 
              f1=new Font("Montserrat",Font.BOLD,15);
              f2=new Font("Montserrat",Font.PLAIN,22); 
              f3=new Font("Montserrat",Font.BOLD,15);
              cs = new Cursor(Cursor.HAND_CURSOR);
              img= new ImageIcon(getClass().getResource("handi1.png"));
              img1= new ImageIcon(getClass().getResource("back.png"));
              img2= new ImageIcon(getClass().getResource("log2.png"));
              
              p1= new jPanelGradient();
              p1.setBounds(0, 0, 350, 650);
              p1.setBackground(Color.DARK_GRAY);
              p1.setLayout(null);
              c.add(p1);
             
              cb2 = new JComboBox(st3);//District
              cb2.setFont(f1);
              cb2.setSelectedItem("ENTER AS A CUSTOMER");
              cb2.setBounds(530, 200, 200, 40);
              cb2.setBackground(Color.white);
              c.add(cb2); 
              
              jl2= new JLabel("Username :");
              jl2.setBounds(410, 250, 150,50);
              jl2.setFont(f1);
              c.add(jl2);
              
              jl3= new JLabel("Password :");
              jl3.setBounds(410, 310, 150,50);
              jl3.setFont(f1);
              c.add(jl3);
              
              tf1= new JTextField("");
              tf1.setBounds(530, 255, 200, 40);
              tf1.setFont(f2);
              c.add(tf1);
              
              ps = new JPasswordField("");
              ps.setBounds(530, 315, 200, 40);
              ps.setEchoChar('*');
              ps.setFont(f2);
              c.add(ps);
              
              bt1= new JButton("Login");
              bt1.setBounds(570, 410, 100, 40);
              bt1.setFont(f2);
              bt1.setCursor(cs);
              bt1.setBackground(new java.awt.Color(0, 204, 204));
              bt1.setForeground(Color.WHITE);
              c.add(bt1);
              bt1.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      
                  if(cb2.getSelectedItem()=="ENTER AS A SUPPLIER"){
                      PreparedStatement p;
                      ResultSet rs;
                      uname= tf1.getText();
                      String pass= String.valueOf(ps.getPassword());
                      String query= "select * from supplier where Uname=? and Password=?";
                      if(uname.equals("") && pass.equals("")){
                          JOptionPane.showMessageDialog(null, "Username and password is empty");
                      }
                      else if(uname.equals("")){
                          JOptionPane.showMessageDialog(null, "Please fillup username");
                      }
                      else if(pass.equals("")){
                          JOptionPane.showMessageDialog(null, "Please fillup password");
                      } 
                      
                      else{
                          try {
                              p= connection.getConnection().prepareStatement(query);
                              p.setString(1, uname);
                              p.setString(2, pass);
                              rs= p.executeQuery();
                              if(rs.next()){
                                 
                                  
                                  //JOptionPane.showMessageDialog(null, "Successfull");
                                  dispose();
                                  setUndecorated(true);
                                  Dashboard d= new Dashboard();
                                  d.usernameShow.setText(uname);
                                  d.setVisible(true);
                         
                              }
                              else{
                                  ImageIcon icon = new ImageIcon("F:\\JavaSwing Project\\Alpona\\src\\icon\\Error_Reg.png");
                                  JOptionPane.showMessageDialog(null, "Username/Password doesn't match", "Login Failed", JOptionPane.ERROR_MESSAGE,icon);
                              }
                          } catch (SQLException ex) {
                              Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                              JOptionPane.showMessageDialog(null, "Database Problem");
                          }
                      }
                  }
                  
                  else{///as a customer/buyer
                      PreparedStatement p;
                      ResultSet rs;
                      uname= tf1.getText();
                      String pass= String.valueOf(ps.getPassword());
                      String query= "select * from customer where CUsername=? and Password=?";
                      if(uname.equals("") && pass.equals("")){
                          JOptionPane.showMessageDialog(null, "Username and password is empty");
                      }
                      else if(uname.equals("")){
                          JOptionPane.showMessageDialog(null, "Please fillup username");
                      }
                      else if(pass.equals("")){
                          JOptionPane.showMessageDialog(null, "Please fillup password");
                      } 
                      
                      else{
                          try {
                              p= connection.getConnection().prepareStatement(query);
                              p.setString(1, uname);
                              p.setString(2, pass);
                              rs= p.executeQuery();
                              if(rs.next()){
                                 
                                  
                                  dispose();
                                  setUndecorated(true);
                                  CustomerProduct ne = new CustomerProduct();
                                  ne.getString(uname);
                                  ne.setVisible(true);
                                  
                         
                              }
                              else{
                                  ImageIcon icon = new ImageIcon("F:\\JavaSwing Project\\Alpona\\src\\icon\\Error_Reg.png");
                                  JOptionPane.showMessageDialog(null, "Username/Password doesn't match", "Login Failed", JOptionPane.ERROR_MESSAGE,icon);
                              }
                          } catch (SQLException ex) {
                              Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                          }
                      }
                      
                  }
                  
                  }
                  
              
              });
              
              
              bt3= new JButton("Create an Account?");
              bt3.setBounds(540, 470, 160, 20);
              bt3.setFont(f3);
              bt3.setCursor(cs);
              bt3.setBackground(new java.awt.Color(204, 204, 204));
              bt3.setForeground(Color.blue);
              bt3.setBorder(null);
              c.add(bt3);
              bt3.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      
                      if(cb2.getSelectedItem()=="ENTER AS A SUPPLIER"){
                      dispose();
                      setUndecorated(true);
                       register_seller ne = new  register_seller();
                        ne.setVisible(true);
                      
                      }
                      else{
                           dispose();
                           setUndecorated(true);
                           customer_reg ne = new  customer_reg();
                           ne.setVisible(true);
                     }
                  }
              
              } );
              
              jl4 = new JLabel(img);
              jl4.setBounds(50, 200, img.getIconWidth(), img.getIconHeight());
              p1.add(jl4);
              
               
              jl1 = new JLabel(img2);
              jl1.setBounds(490, 50, img2.getIconWidth(), img2.getIconHeight());
              c.add(jl1);
              

              
              ckb1= new JCheckBox("Show Password");
              ckb1.setBounds(530, 360, 200, 30);
              ckb1.setBackground(new java.awt.Color(204, 204, 204));   
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
              
         }
      public static void main(String[] args) {
          
            LoginPage nw= new LoginPage();
            nw.setBounds(100,30,900,650);
            
            nw.setVisible(true);
     }
}
