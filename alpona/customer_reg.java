
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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

public class customer_reg extends JFrame {
    
         private Container c;
         private JTextField tf1,tf2,tf3,tf4,tf5,tf6;
         private Font f,f1,f2,f3,f4;
         private JButton bt1,bt2,bt3,bt4,bt5;
         private Cursor cs;
         private JComboBox cb1,cb2,cb3;
         private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11;
         private JTextArea ta1;
         private JScrollPane sc;
         private ImageIcon img,img1,img2,img3;
         private JPasswordField ps;
          private JPanel p1,p2,p3;
          private String[] st3 ={"Barguna","Barishal","Bhola","Bandarban","Bogura",
           "Brahmanbaria","Bagerhat","Chandpur","Chattogram","Chuadanga","Cumilla","Cox's Bazar",
           "Chapai Nawabganj","Dhaka","Dinajpur","Faridpur","Feni","Gazipur","Gaibandha","Gopalganj",
           "Habiganj","Jashore","Jhenaidah","Jamalpur","Joypurhat","Jhalokati","Khulna","Kushtia","Kurigram",
           "Kishoreganj","Khagrachhari","Lalmonirhat","Lakshmipur","Madaripur","Manikganj","Munshiganj",
           "Magura","Meherpur","Mymensingh","Moulvibazar","Narayanganj","Narail","Netrokona","Naogaon",
           "Natore","Nilphamari","Narsingdi","Noakhali","Pabna","Panchagarh","Patuakhali","Pirojpur",
           "Rajshahi","Rangpur","Rajbari","Rangamati","Shariatpur","Satkhira","Sherpur","Sirajganj",
           "Sunamganj","Sylhet","Tangail","Thakurgaon"};
          
         customer_reg(){
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setBounds(100,30,900,650);
              this.setTitle("Supplier Registration");
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
              c.setBackground(Color.WHITE);
              f=new Font("Montserrat",Font.PLAIN,20); 
              f1=new Font("Montserrat",Font.BOLD,25);
              f2=new Font("Montserrat",Font.BOLD,15); 
              f3=new Font("Montserrat",Font.BOLD,20);
              f4=new Font("Montserrat",Font.BOLD,15);
              cs = new Cursor(Cursor.HAND_CURSOR);
              img= new ImageIcon(getClass().getResource("reg.png"));
              img1= new ImageIcon(getClass().getResource("pro.png"));
              img2= new ImageIcon(getClass().getResource("regg2.png"));
              
              p1= new jPanelGradient();
              p1.setBounds(0, 0, 350, 650);
              p1.setBackground(Color.DARK_GRAY);
              p1.setLayout(null);
              c.add(p1);
              
               
              
              jl2= new JLabel("Username:");
              jl2.setBounds(410, 200, 150,30);
              jl2.setFont(f3);
              c.add(jl2);
              
              tf1= new JTextField("");
              tf1.setBounds(530, 205, 220, 30);
              tf1.setFont(f);
              c.add(tf1);
              
              jl3= new JLabel("Password:");
              jl3.setBounds(410, 240, 150,30);
              jl3.setFont(f3);
              c.add(jl3);
              
              ps = new JPasswordField("");
              ps.setBounds(530, 245, 220, 30);
              ps.setEchoChar('*');
              ps.setFont(f);
              c.add(ps);
              
              jl5= new JLabel("Name      :");
              jl5.setBounds(410, 280, 150,30);
              jl5.setFont(f3);
              c.add(jl5);
              
              tf3= new JTextField("First name");
              tf3.setBounds(530, 285, 105, 30);
              tf3.setForeground(new java.awt.Color(102, 102, 102));
              tf3.setFont(f);
              c.add(tf3);
              tf3.addFocusListener(new FocusListener(){
                  @Override
                  public void focusGained(FocusEvent e) {
                      if(tf3.getText().equals("First name")){
                          tf3.setText("");
                          tf3.setForeground(Color.BLACK);
                      }  
                  }

                  @Override
                  public void focusLost(FocusEvent e) {
                      if(tf3.getText().length()==0){
                          tf3.setText("First name");
                          tf3.setForeground(new java.awt.Color(102, 102, 102));
                      } 
                  }
          
               
            });
              
              tf2= new JTextField("Last name");
              tf2.setBounds(645, 285, 105, 30);
              tf2.setForeground(new java.awt.Color(102, 102, 102));
              tf2.setFont(f);
              c.add(tf2);
              tf2.addFocusListener(new FocusListener(){
                  @Override
                  public void focusGained(FocusEvent e) {
                      if(tf2.getText().equals("Last name")){
                          tf2.setText("");
                          tf2.setForeground(Color.BLACK);
                      }  
                  }

                  @Override
                  public void focusLost(FocusEvent e) {
                      if(tf2.getText().length()==0){
                          tf2.setText("Last name");
                          tf2.setForeground(new java.awt.Color(102, 102, 102));
                      } 
                  }
          
               
            });
              
              jl8= new JLabel("Mobile no :");
              jl8.setBounds(410, 320, 150,30);
              jl8.setFont(f3);
              c.add(jl8);
              
              tf4= new JTextField("");
              tf4.setBounds(530, 320, 220, 30);
              tf4.setFont(f);
              c.add(tf4);
              
              jl9= new JLabel("Email :");
              jl9.setBounds(410, 360, 150,30);
              jl9.setFont(f3);
              c.add(jl9);
              
              tf5= new JTextField("");
              tf5.setBounds(530, 360, 220, 30);
              tf5.setFont(f);
              c.add(tf5);
              
            
              
              
              jl4 = new JLabel(img);
              jl4.setBounds(50, 200, img.getIconWidth(), img.getIconHeight());
              p1.add(jl4);
              
              jl10 = new JLabel(img2);
              jl10.setBounds(555, 110, img2.getIconWidth(), img2.getIconHeight());
              c.add(jl10);
              
              bt1= new JButton("Create");
              bt1.setBounds(585, 410, 95, 30);
              bt1.setBackground(Color.DARK_GRAY);
              bt1.setForeground(Color.WHITE);
              bt1.setFont(f2);
              bt1.setCursor(cs);
              c.add(bt1);
              
              bt1.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      String uname= tf1.getText();
                      String pass= String.valueOf(  ps.getPassword());
                      String fname= tf3.getText();
                      String lname= tf2.getText();
                      String mobile= tf4.getText();
                      String mail= tf5.getText();
                      if(uname.equals("")) {
                          JOptionPane.showMessageDialog(null, "Please add a username");
                      }
                      else  if(pass.equals("")) {
                          JOptionPane.showMessageDialog(null, "Please add a password");
                      }
                      else  if(mobile.equals("")) {
                          JOptionPane.showMessageDialog(null, "Please add a mobile number");
                      }
                      else
                      {
                          try {
                              PreparedStatement st;
                              String q1="select * from customer where CUsername= '"+uname+"'";
                              st= connection.getConnection().prepareStatement(q1);
                              ResultSet rs= st.executeQuery(q1);
                              if(rs.next()){
                                  JOptionPane.showMessageDialog(null, "Username Already Exist", "Duplicate", JOptionPane.WARNING_MESSAGE);
                                  tf1.setText("");
                                  ps.setText("");
                                  tf3.setText("");
                                  tf2.setText("");
                                  tf4.setText("");
                                  tf5.setText("");
                              }
                              else
                              {
                                String query= "insert into customer(CUsername, CFname, CLname, Password, PhoneNo, CEmail) values(?,?,?,?,?,?)";

                                st= connection.getConnection().prepareStatement(query);
                                st.setString(1,uname);
                                st.setString(2,fname);
                                st.setString(3,lname);
                                st.setString(4,pass);
                                st.setString(5,mobile);
                                st.setString(6,mail);
                                if(st.executeUpdate()>0){
                                    ImageIcon icon = new ImageIcon("F:\\JavaSwing Project\\Alpona\\src\\icon\\verified account.png");
                                    JOptionPane.showMessageDialog(null, "New Customer Added.","Confirmation", JOptionPane.INFORMATION_MESSAGE, icon);
                                }
                                else
                                {
                                    JOptionPane.showConfirmDialog(null, "Registration unsuccessfull");
                                }
                             }
                          } catch (SQLException ex) {
                              Logger.getLogger(customer_reg.class.getName()).log(Level.SEVERE, null, ex);
                          }
                           
                      }
                      
                  }
              
              } ); 
                  bt1.addMouseListener(new MouseListener(){
                  @Override
                  public void mouseClicked(MouseEvent e) {
                  }

                  @Override
                  public void mousePressed(MouseEvent e) {
                  }

                  @Override
                  public void mouseReleased(MouseEvent e) {
                          
                  }

                  @Override
                  public void mouseEntered(MouseEvent e) {
                     bt1.setBackground(new java.awt.Color(255, 204, 204));
                     bt1.setForeground(Color.BLACK);
                  }

                  @Override
                  public void mouseExited(MouseEvent e) {
                        bt1.setBackground(Color.DARK_GRAY);
                                  bt1.setForeground(Color.WHITE);
                  }
                
              });
              
              bt2= new JButton("Click here to login.");
              bt2.setBounds(460, 450, 140, 20);
              bt2.setForeground(Color.BLUE);
              bt2.setBorder(null);
              bt2.setBackground(Color.WHITE);
              bt2.setFont(f4);
              bt2.setCursor(cs);
              c.add(bt2);
              
              bt2.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      
                      dispose();
                      LoginPage ne = new  LoginPage();
                      ne.setVisible(true);
                  }
              
              } );
              
         }
      public static void main(String[] args) {
          customer_reg nw = new  customer_reg();
           nw.setVisible(true);
     }
}
