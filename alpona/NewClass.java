///My product


package alpona;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import static java.awt.SystemColor.window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Blob;
import javax.imageio.ImageIO;


public class NewClass extends JFrame {
         public static String path;
         File file;
         JFileChooser jfc;
          private Container c2;
         private JTextField tf1,tf2,tf3,tf4,tf5,tf6;
         private Font f,f1,f2,f3,f4,f5;
         private JButton bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
         private Cursor cs;
         private JComboBox cb1,cb2,cb3;
         private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,j31;
         private JTextArea ta1;
         private JScrollPane sc;
         private ImageIcon img,img1,img2,img3,img4;
         private JPasswordField ps;
         private JPanel p1,p2,p3,c; 
         public  JTable table;
         private JScrollPane scroll,scroll1;
         public  DefaultTableModel model;
         private String[] columns ={"ID","Name","Category"};
         public  String[] rows = new String[150];
         private CardLayout card;
         private JFileChooser fs1;
         static JFrame window;
         
         private String[]st1={"Wood Work","Clay Craft","Leather Crafts",
         "Jute Craft","Shell Craft","Metal Craft","Bamboo and cane"
         ,"Paper Craft","Sari","Nakshi Kantha","Fiber Craft","Other"};
         
        NewClass (){
            components();
            
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               this.setLocationRelativeTo(null);
               setUndecorated(true);
               this.setVisible(true);
               setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
               show_product();
      }
        public static void removeImage(JLabel image) {
        image.setVisible(false);/*from w ww.j  a v a  2 s .c  o m*/
        window.remove(image);
    }

        public ArrayList<ProductSupplierShow>  productList(){
            ArrayList<ProductSupplierShow> productList= new ArrayList();  
            try {
                  Dashboard d= new Dashboard();
                  PreparedStatement ps;
                  ResultSet rs;
                  int sid = 0;
                  String q1="select SID from supplier where Uname='"+d.usernameShow.getText()+"'";
                  ps= connection.getConnection().prepareStatement(q1);
                  rs= ps.executeQuery(q1);
                  if(rs.next()) {sid= rs.getInt("SID");}
                  
                  String query= "select * from product where sid="+sid+" ";
                  ps= connection.getConnection().prepareCall(query);
                  rs=ps.executeQuery(query);
                  ProductSupplierShow psw;
                  while(rs.next()){
                      psw= new ProductSupplierShow(rs.getInt("Serial_No"),rs.getString("PName"),rs.getString("Category"));
                      productList.add(psw);
                  }
              } catch (SQLException ex) {
                  Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(rootPane, ex);
              }
              return productList;
        }
      public void show_product(){
            ArrayList<ProductSupplierShow> productList= productList();
            model= (DefaultTableModel) table.getModel();
            for(int i=0; i<productList.size();i++){
                rows[0]= Integer.toString(productList.get(i).getPid());
                rows[1]= productList.get(i).getPname();
                rows[2]= productList.get(i).getPcat();
                model.addRow(rows);
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
             this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             this.setBounds(100,30,900,650);
             this.setTitle("all products for supplier");
               f=new Font("Montserrat",Font.BOLD,30); 
              f1=new Font("Montserrat",Font.BOLD,16);
              f2=new Font("Montserrat",Font.PLAIN,15); 
              
              f3=new Font("Montserrat",Font.BOLD,18);
              f4=new Font("Montserrat",Font.BOLD,15);
              f5=new Font("Montserrat",Font.PLAIN,12);
              cs = new Cursor(Cursor.HAND_CURSOR);
              
              c2=this.getContentPane();
              c2.setLayout(null);
              c2.setBackground( new Color(12,116,117));
              
              c= new jPanelGradient();
              c.setBounds(0, 0, 900, 650);
              c.setBackground(Color.DARK_GRAY);
              c.setLayout(null);
              c2.add(c);
              
              p1= new jPanelGradient();
              p1.setBounds(0, 0, 900, 90);
              p1.setBackground(Color.DARK_GRAY);
              p1.setLayout(null);
              c.add(p1);
              
              card = new CardLayout();
             
             
             jl1= new JLabel("My Products");
             jl1.setBounds(330,20,200,50);
             jl1.setFont(f); 
             jl1.setForeground(Color.WHITE);
             p1.add(jl1);
             
              jl2= new JLabel("Product Name      :");
              jl2.setBounds(50, 130, 150,50);
              jl2.setFont(f1);
              c.add(jl2);
              
              tf1= new JTextField();///prodict name
              tf1.setBackground(Color.WHITE);
              tf1.setBounds(220, 135, 230, 40);
              tf1.setFont(f2);
              c.add(tf1);
              
              jl3= new JLabel("Product Type       :");
              jl3.setBounds(50, 190, 150,50);
              jl3.setFont(f1);
              c.add(jl3);
              
              cb2 = new JComboBox(st1);///product Type
              cb2.setFont(f1);
              cb2.setBounds(220, 195, 230, 40);
              c.add(cb2);
              
              jl4= new JLabel("Product Cost       :");
              jl4.setBounds(50, 245, 150,50);
              jl4.setFont(f1);
              c.add(jl4); 
                
              tf3= new JTextField();///Cost
              tf3.setBackground(Color.WHITE);
              tf3.setBounds(220, 250, 230, 40);
              tf3.setFont(f2);
              c.add(tf3);
              
              jl5= new JLabel("Product Details   :");
              jl5.setBounds(50, 300, 150,50);
              jl5.setFont(f1);             
              c.add(jl5);
              
              ta1= new JTextArea();///details
              ta1.setBackground(Color.WHITE);
              ta1.setFont(f2);
              ta1.setLineWrap(true);
              ta1.setWrapStyleWord(true);
              
                 
              sc= new JScrollPane(ta1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
              sc.setBounds(220, 300, 230, 80);
              c.add(sc);
              
              jl6= new JLabel("Stock of amount :");
              jl6.setBounds(50, 385, 150,50);
              jl6.setFont(f1);
              c.add(jl6);
              
              tf5= new JTextField();///stock_of_amount
              tf5.setBackground(Color.WHITE);
              tf5.setBounds(220, 390, 230, 40);
              tf5.setFont(f2);
              c.add(tf5);
              
              jl6= new JLabel("Product Image  :");
              jl6.setBounds(50, 445, 150,50);
              jl6.setFont(f1);
              c.add(jl6);
              
               FileNameExtensionFilter f1 = new FileNameExtensionFilter("png/jpg","jpg","png");
              fs1 = new JFileChooser();
              fs1.setAcceptAllFileFilterUsed(false);
              fs1.addChoosableFileFilter(f1);
              
              bt4= new JButton("Add Image");
              bt4.setBounds(220, 445, 230, 40);
              bt4.setFont(f2);
              bt4.setCursor(cs);
              bt4.setBackground(Color.WHITE);
              bt4.setBorder(null);
              bt4.setBackground(new java.awt.Color(204, 204, 204));
              c.add(bt4); 
              
                
              bt4.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                     
                  jfc= new JFileChooser();
                  jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
                  FileNameExtensionFilter fnwf= new FileNameExtensionFilter("PNG JPG AND JPEG","png","jpeg","jpg");
                  jfc.addChoosableFileFilter(fnwf);
                  int returnvalue= jfc.showOpenDialog(null);
                  if(returnvalue==JFileChooser.APPROVE_OPTION){
                       file= jfc.getSelectedFile();
                       path=file.getAbsolutePath();
                       
                  }
     
                 }

               });
              
              
              
            
             
             table = new JTable();
             model = new DefaultTableModel();
             model.isCellEditable(0, 0);
             model.setColumnIdentifiers(columns);
             table.setModel(model);
             table.setFont(f5);
             table.setSelectionBackground(new java.awt.Color(204, 255, 204));
             table.setBackground(Color.WHITE);
             table.setRowHeight(50);

               for (int c = 0; c < table.getColumnCount(); c++)
               {
                   Class<?> col_class = table.getColumnClass(c);
                     table.setDefaultEditor(col_class, null);        // remove editor
                }
            
             scroll= new JScrollPane(table);
             scroll.setBounds(480, 400, 400, 220);///table
             c.add(scroll);
             
             table.addMouseListener(new MouseAdapter(){
             
                    public void mouseClicked(MouseEvent e){
                       int id;
                       PreparedStatement ps;
                       ResultSet rs;
                        try {
                            int rownumber = table.getSelectedRow();
                            
                            String ix = model.getValueAt(rownumber,0).toString();
                            id= Integer.parseInt(ix);
                            String name  = model.getValueAt(rownumber,1).toString();
                            String category = model.getValueAt(rownumber,2).toString();
                            tf1.setText(name);
                            cb2.setSelectedItem(category);
                            String query= "select * from product where Serial_No="+id+"";
                            ps= connection.getConnection().prepareStatement(query);
                            rs= ps.executeQuery(query);
                            if(rs.next()){
                                double db=rs.getDouble("Cost");
                                
                                //String cost= db+" BDT";
                                tf3.setText(Double.toString(db));
                                ta1.setText(rs.getString("Details"));
                                tf5.setText(Integer.toString(rs.getInt("Quantity")));
                                path=rs.getString("Image");
                                
                                //tf1.setByte
                            }
                           
                            
                           String q= "select Image from product where Serial_No="+id+"";
                           ps= connection.getConnection().prepareStatement(q);
                           rs= ps.executeQuery();
                           if(rs.next()){
          
                            ImageIcon img= new ImageIcon(rs.getString("Image"));///image
                            Image imgg= img.getImage();
                            Image newimg= imgg.getScaledInstance(400, 250,Image.SCALE_SMOOTH);
                            img= new ImageIcon(newimg);
                            p2= new JPanel(card);
                            p2.setBounds(480, 135, 400, 250);
                            c.add(p2);
                            jl3= new JLabel(img);
                            p2.add(jl3);
                           }
                         
                            
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     }  
                  
             
             });
             
              bt2= new JButton("Clear All");
              bt2.setBounds(120, 520, 150, 30);
              bt2.setFont(f4);
              bt2.setCursor(cs);
              bt2.setBackground(Color.LIGHT_GRAY);
              bt2.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                      tf1.setText("");
                      cb2.setSelectedIndex(0);
                      tf3.setText("");
                      ta1.setText("");
                      tf5.setText("");
                 }
              
               });
              c.add(bt2);
              
              bt5= new JButton("Add Product");
              bt5.setBounds(280, 520, 150, 30);
              bt5.setFont(f4);
              bt5.setCursor(cs);
              bt5.setBackground(Color.LIGHT_GRAY);
              bt5.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){

                     try {
                         Date date= new Date();
                         java.sql.Date sqldate= new java.sql.Date(date.getTime());
                         PreparedStatement st;
                         ResultSet rs;
                         
                         Dashboard d= new Dashboard();
                         int sid = 0;
                         String q1="select SID from supplier where Uname='"+d.usernameShow.getText()+"'";
                         st= connection.getConnection().prepareStatement(q1);
                         rs= st.executeQuery(q1);
                         if(rs.next()) {sid= rs.getInt("SID");}
                         
                         String name= tf1.getText();
                         String type= (String)cb2.getSelectedItem();
                         double cost= Double.parseDouble(tf3.getText());
                         String details= ta1.getText();
                         double quantity= Double.parseDouble(tf5.getText());
                         String x;
                         String query= "insert into alpona.product(PName,Category,Cost,Details,Quantity,Addition_Date,Image,sid) values(?,?,?,?,?,?,?,?)";
                         st= connection.getConnection().prepareStatement(query);
                         st.setString(1, name);
                         st.setString(2, type);
                         st.setDouble(3, cost);
                         st.setString(4, details);
                         st.setDouble(5, quantity);
                         st.setDate(6, sqldate);
                         st.setString(7, path);
                         st.setInt(8, sid);
                         if(st.executeUpdate()>0){
                             JOptionPane.showMessageDialog(null, "New product added");
                             System.out.println("Successful");
                         }
                         else
                         {
                             JOptionPane.showConfirmDialog(null, "Unsuccessfull");
                         }
                         Statement sm;
                         query= "select * from product where sid= "+sid+" and PName= '"+name+"' and Category='"+type+"'" ;
                         st=connection.getConnection().prepareStatement(query);
                         rs= st.executeQuery(query);
                         if(rs.next()){
                             x = Integer.toString(rs.getInt("Serial_No"));
                             rows[0]= x;
                         }
                         rows[1]=name;
                         rows[2]= type;
                         model.addRow(rows);
                     } catch (SQLException ex) {
                         Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                     }
                       
                 }
              
               });
              c.add(bt5);
              
              bt6= new JButton("Update Product");
              bt6.setBounds(120, 560, 150, 30);
              bt6.setFont(f4);
              bt6.setCursor(cs);
              bt6.setBackground(Color.LIGHT_GRAY);
              bt6.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                       int num_row = table.getSelectedRow();
                       if(num_row>=0){
                              
                           try {
                               String ix = model.getValueAt(num_row,0).toString();
                               int id= Integer.parseInt(ix);
                               String name= tf1.getText();
                               String type= (String)cb2.getSelectedItem();
                               double cost= Double.parseDouble(tf3.getText());
                               String details= ta1.getText();
                               double quantity= Double.parseDouble(tf5.getText());
                               
                               String query= "update product set PName=?,Category=?,Cost=?, Details=?, Quantity=?,Image=? where Serial_No= "+id+"";
                               String q1= "select * from product where Serial_No="+id+"";
                               PreparedStatement st;
                               
                               st= connection.getConnection().prepareStatement(query);
                               ResultSet rs = st.executeQuery(q1);
                               
                                    st.setString(1, name);
                                    st.setString(2, type);
                                    st.setDouble(3, cost);
                                    st.setString(4, details);
                                    st.setDouble(5, quantity);
                                    st.setString(6,path);
                   
                                    
                               
                               if(st.executeUpdate()>0){
                                    ImageIcon icon = new ImageIcon("F:\\JavaSwing Project\\Alpona\\src\\icon\\verified account.png");
                                    int result=JOptionPane.showConfirmDialog(null, "Do you confirm?", "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                                      if(result==0){
                                           ImageIcon icon1 = new ImageIcon("F:\\JavaSwing Project\\Alpona\\src\\icon\\Update_confirmed.png");
                                           JOptionPane.showMessageDialog(null, "Updated.","Confirmation", JOptionPane.INFORMATION_MESSAGE, icon1);
                                         }
                                  }
                              else
                              {
                                  JOptionPane.showConfirmDialog(null, "Unsuccessfull");
                              }
                               
                               
                               model.setValueAt(name, num_row, 1);
                               model.setValueAt(type, num_row, 2);
                           } catch (SQLException ex) {
                               Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                               JOptionPane.showMessageDialog(null, "Database Problem");
                           } 
                               
                       }
                       else{
                           JOptionPane.showMessageDialog(null,"No row is selected");
                       }
                 }
              
               });
              c.add(bt6);
              
            
              
              
              bt7= new JButton("Delete Product");
              bt7.setBounds(280, 560, 150, 30);
              bt7.setFont(f4);
              bt7.setBackground(Color.LIGHT_GRAY);
              bt7.setCursor(cs);
              bt7.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                        int num_row = table.getSelectedRow();
                       if(num_row>=0){
                           String ix = model.getValueAt(num_row,0).toString();
                           int id= Integer.parseInt(ix);
                           String query= "delete from product where Serial_No="+id+"";
                           PreparedStatement ps;
                            try {
                                ps= connection.getConnection().prepareStatement(query);
                                if(ps.executeUpdate()>0){
                                    ImageIcon icon = new ImageIcon("F:\\JavaSwing Project\\Alpona\\src\\icon\\verified account.png");
                                    int result=JOptionPane.showConfirmDialog(null, "Do you confirm?", "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                                    if(result==0){
                                        ImageIcon icon1 = new ImageIcon("F:\\JavaSwing Project\\Alpona\\src\\icon\\DeleteIcon.png");
                                         JOptionPane.showMessageDialog(null, "Deleted.","Confirmation", JOptionPane.INFORMATION_MESSAGE, icon1);
                                    }
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                            }
                           model.removeRow(num_row);
                       }
                       else{
                           JOptionPane.showMessageDialog(null,"No row is selected");
                       } 
                 }
              
               });
              c.add(bt7);
               
              bt5= new JButton("Back");
              bt5.setBounds(20, 50, 120, 30);
              bt5.setFont(f4);
              bt5.setCursor(cs);
              bt5.setBackground(Color.LIGHT_GRAY);
              bt5.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                       dispose();
                       Dashboard ne = new Dashboard();
                       ne.setVisible(true);
                 }
              
               });
              p1.add(bt5);
             
      }
       public static void main(String[] args) {
         NewClass  nw= new  NewClass ();
         nw.setVisible(true);
    }
       
      
}
