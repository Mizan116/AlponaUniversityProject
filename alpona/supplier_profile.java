
package alpona;

import java.awt.CardLayout;
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
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.PreparedStatement;
import javax.swing.JPanel;


public class supplier_profile extends JFrame{
         private Container c;
         public static JTextField tf1,tf2,tf3,tf4,tf5,tf6;
         private Font f,f1,f2,f3;
         private JButton bt1,bt2,bt3,bt4,bt5;
         private Cursor cs;
         private JComboBox cb1,cb2,cb3;
         private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11;
         public  JTextArea ta1;
         private JScrollPane sc;
         private ImageIcon img,img1,img2,img3;
         private JPasswordField ps;
          private JPanel p1,p2;
         String s;
        
        
             
         supplier_profile() throws SQLException{
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setBounds(100,30,900,650);
              this.setTitle("Supplier Profile");
              components();
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               this.setLocationRelativeTo(null);
               setUndecorated(true);
               setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
               this.setVisible(true);
              Connection con;
              Statement st;
              PreparedStatement p;
              ResultSet rs;
              
            try {
                Dashboard d= new Dashboard();
                con= connection.getConnection();
                st= con.createStatement();
                String query= "SELECT * FROM supplier where Uname= '"+d.usernameShow.getText()+"'";

                p=con.prepareStatement(query);
                rs= st.executeQuery(query);
                if(rs.next()){
                    //System.out.println(ls.uname);
                    //p.setString(1, s);
                    tf6.setText(rs.getString(2));
                    tf1.setText(rs.getString(3));
                    tf2.setText(rs.getString(4));
                    tf4.setText(rs.getString(6));
                    tf5.setText(rs.getString(7));
                    tf3.setText(rs.getString(8));
                    ta1.setText(rs.getString(9));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
              
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
              c= this.getContentPane();
              c.setLayout(null);
              c.setBackground(Color.DARK_GRAY);   
              f=new Font("Montserrat",Font.BOLD,45); 
              f1=new Font("Montserrat",Font.BOLD,25);
              f2=new Font("Montserrat",Font.BOLD,16); 
              f3=new Font("Montserrat",Font.BOLD,18);
              cs = new Cursor(Cursor.HAND_CURSOR);
              img= new ImageIcon(getClass().getResource("p1.png"));
              img1= new ImageIcon(getClass().getResource("back.png"));
//              
//              p1= new jPanelGradient();
//              p1.setBounds(0, 0, 650, 900);
//              p1.setBackground(Color.DARK_GRAY);
//              p1.setLayout(null);
//              c.add(p1);

              p2= new jPanelGradient();
              p2.setBackground(Color.DARK_GRAY);
              p2.setBounds(0,0,900,650);
              p2.setLayout(null);
              c.add(p2);
              
 
              jl1= new JLabel("Profile");
              jl1.setBounds(440, 50, 200,50);
              jl1.setFont(f);
              jl1.setForeground(Color.PINK);
              p2.add(jl1);
              
              jl9= new JLabel("User Name:");
              jl9.setBounds(250, 140, 140,30);
              jl9.setFont(f1);
              jl9.setForeground(Color.ORANGE);
              p2.add(jl9);
              
                
              tf6= new JTextField("");///user name
              tf6.setBounds(400, 140, 225, 30);
              tf6.setFont(f3);
              tf6.setEditable(false);
              tf6.setBorder(null);
              tf6.setHorizontalAlignment(JTextField.CENTER);
              p2.add(tf6);
              
              jl2= new JLabel("Name         :");
              jl2.setBounds(250, 180, 140,30);
              jl2.setFont(f1);
              jl2.setForeground(Color.ORANGE);
              p2.add(jl2);
              
              jl3= new JLabel("District      :");
              jl3.setBounds(250, 240, 140,30);
              jl3.setFont(f1);
              jl3.setForeground(Color.ORANGE);
              p2.add(jl3);
              
              jl5= new JLabel("Area          :");
              jl5.setBounds(250, 300, 140,30);
              jl5.setFont(f1);
              jl5.setForeground(Color.ORANGE);
              p2.add(jl5);
              
              jl6= new JLabel("Mobile       :");
              jl6.setBounds(250, 390, 140,30);
              jl6.setFont(f1);
              jl6.setForeground(Color.ORANGE);
              p2.add(jl6);
              
              jl7= new JLabel("Email         :");
              jl7.setBounds(250, 450, 140,30);
              jl7.setFont(f1);
              jl7.setForeground(Color.ORANGE);
              p2.add(jl7);

              
              jl4 = new JLabel(img);
              jl4.setBounds(10, 10, img.getIconWidth(), img.getIconHeight());
              p2.add(jl4);

              
              tf1= new JTextField("");///First name
              tf1.setBounds(400, 185, 110, 30);
              tf1.setFont(f3);
              tf1.setEditable(false);
              tf1.setBorder(null);
              tf1.setHorizontalAlignment(JTextField.CENTER);
              p2.add(tf1);
              
              tf2= new JTextField("");///Last name
              tf2.setBounds(515, 185, 110, 30);
              tf2.setFont(f3);
              tf2.setBorder(null);
              tf2.setEditable(false);
              tf2.setHorizontalAlignment(JTextField.CENTER);
              p2.add(tf2);
              
              tf3= new JTextField("");///District
              tf3.setBounds(400, 240, 225, 30);
              tf3.setFont(f3);
              tf3.setForeground(Color.BLACK);
              tf3.setEditable(false);
              tf3.setBorder(null);
              tf3.setHorizontalAlignment(JTextField.CENTER);
              p2.add(tf3);
              
              tf4= new JTextField(" ");///Mobile
              tf4.setBounds(400, 395, 225, 30);
              tf4.setFont(f3);
              tf4.setEditable(false);
              tf4.setBorder(null);
              tf4.setHorizontalAlignment(JTextField.CENTER);
              p2.add(tf4);
              
              tf5= new JTextField("");///Email
              tf5.setBounds(400, 450, 225, 30);
              tf5.setFont(f3);
              tf5.setEditable(false);
              tf5.setBorder(null);
              tf5.setHorizontalAlignment(JTextField.LEFT);
              p2.add(tf5);

              ta1= new JTextArea("");//Area
              ta1.setLineWrap(true);
              ta1.setWrapStyleWord(true);
              ta1.setFont(f3);
              ta1.setBorder(null);
              ta1.setEditable(false);
              sc= new JScrollPane(ta1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
              sc.setBounds(400, 300, 225, 80);
              p2.add(sc);
              
              bt3= new JButton("Back");
              bt3.setBounds(60, 550, 80, 30);
              bt3.setFont(f2);
              bt3.setCursor(cs);
              bt3.setBackground(Color.LIGHT_GRAY);
              bt3.setForeground(Color.BLACK);
              bt3.setBorder(null);
              p2.add(bt3);
              
              bt3.addActionListener(new ActionListener(){
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      
                      dispose();
                      Dashboard ne = new  Dashboard();
                      ne.setVisible(true);
                  }
              
              } );
              
              
          }
    
       public static void main(String[] args) throws SQLException {
        supplier_profile pf = new supplier_profile();
        pf.setVisible(true);
    }
}
