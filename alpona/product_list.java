
package alpona;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.table.DefaultTableModel;

public class product_list extends JFrame implements ActionListener {
         private Container c2;
         private JTextField tf1,tf2,tf3,tf4,tf5,tf6;
         private Font f,f1,f2,f3;
         private JButton bt1,bt2,bt3,bt4,bt5;
         private Cursor cs;
         private JComboBox cb1,cb2,cb3;
         private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11;
         private JTextArea ta1;
         private JScrollPane sc;
         private ImageIcon img,img1,img2,img3,img4;
         private JPasswordField ps;
         private JPanel p1,p2,p3,c; 
         private JTable table,jtable1;
         private JScrollPane scroll,scroll1;
         private DefaultTableModel model;
         private String[] columns ={"ID","Name","Category","Cost","Supplier"};
         private String[] rows = new String[5];
         private CardLayout card;
         int serialId;
         product_list(){
            components();
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               this.setLocationRelativeTo(null);
               setUndecorated(true);
               setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),20,20));
               this.setVisible(true);
               //show_product();
         }

         class jPanelGradient extends JPanel{
              protected void paintComponent(Graphics g){
                  Graphics2D g2d= (Graphics2D) g;
                  int width= getWidth();
                  int height= getHeight();
                  Color color1= new Color(171,102,255);
                  Color color2= new Color(116,182,247);
                  GradientPaint gp= new GradientPaint(0,0,color1,180,height,color2);
                  g2d.setPaint(gp);
                  g2d.fillRect(0,0,width, height);
              }
          }
         public void getString(String catagory){
                 //s= catagory;
                 show_product(catagory);
                 //JOptionPane.showMessageDialog(null, s);
         }
          public ArrayList<ProductSupplierShow>  productList(String s){
            ArrayList<ProductSupplierShow> productList= new ArrayList();  
            try {
                
                  String query= "select * from product where Category='"+s+"' ";
                  PreparedStatement ps= connection.getConnection().prepareCall(query);
                  ResultSet rs=ps.executeQuery(query);
                  ProductSupplierShow psw = null;
                  while(rs.next()){
                      int x= rs.getInt("sid");
                      String q1="select Uname from supplier where SID="+x+"";
                      PreparedStatement ps1= connection.getConnection().prepareCall(q1);
                      ResultSet rs1= ps1.executeQuery(q1);
                      if(rs1.next()) psw= new ProductSupplierShow(rs.getInt("Serial_No"),rs.getDouble("Cost"),rs.getString("PName"),rs.getString("Category"),rs1.getString("Uname"));
                      productList.add(psw);
                  }
              } catch (SQLException ex) {
                  Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(rootPane, ex);
              }
              return productList;
        }
      public void show_product(String s){
            ArrayList<ProductSupplierShow> productList= productList(s);
            model= (DefaultTableModel) table.getModel();
            for(int i=0; i<productList.size();i++){
                rows[0]= Integer.toString(productList.get(i).getPid());
                rows[1]= productList.get(i).getPname();
                rows[2]= productList.get(i).getPcat();
                rows[3]= productList.get(i).getCost()+"";
                rows[4]= productList.get(i).getSupplier();
                model.addRow(rows);
            }
      }
      
      public void components(){
             this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             this.setBounds(80,30,900,650);
             this.setTitle("all products");
               f=new Font("Montserrat",Font.BOLD,30); 
              f1=new Font("Montserrat",Font.BOLD,22);
              f2=new Font("Montserrat",Font.PLAIN,12); 
              f3=new Font("Montserrat",Font.BOLD,15);
              cs = new Cursor(Cursor.HAND_CURSOR);
              
              c2=this.getContentPane();
              c2.setLayout(null);
              
             card = new CardLayout();
             c=new jPanelGradient();
             c.setBounds(0,0,900,650);
             c.setLayout(null);
             c2.add(c);
             
              p1= new jPanelGradient();
              p1.setBounds(0, 0, 900, 100);
              p1.setBackground(Color.DARK_GRAY);
              p1.setLayout(null);
              c.add(p1);
              
           
             
             
             
             jl1= new JLabel("Products");
             jl1.setBounds(330,20,200,50);
             jl1.setFont(f); 
             jl1.setForeground(Color.WHITE);
             p1.add(jl1);
             
          
             jl3 = new JLabel("Select an row");
             jl3.setBounds(640,285,300,20);
             jl3.setFont(f3);
             c.add(jl3);
             
             jl4 = new JLabel("to view the image");
             jl4.setBounds(630,310,300,20);
             jl4.setFont(f3); 
             c.add(jl4);

             
             bt1= new JButton("Back");
             bt1.setBounds(20, 50, 100, 30);
             bt1.setFont(f3);
             bt1.setCursor(cs);
             bt1.setBackground(Color.LIGHT_GRAY);
             p1.add(bt1);
             bt1.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                         dispose();
                         CustomerProduct ne = new CustomerProduct();
                         ne.setVisible(true);
                   
                 }
              
               });
             
             bt2= new JButton("View Details");
             bt2.setBounds(625, 490, 150, 30);
             bt2.setFont(f3);
             bt2.setCursor(cs);
             bt2.setBackground(Color.WHITE);
             c.add(bt2);
              bt2.addActionListener(new ActionListener(){
                 public void actionPerformed(ActionEvent e){
                     try {
                         dispose();
                         ProductShow ne = new  ProductShow();
                         ne.SerialNo.setText(Integer.toString(serialId));
                         String query="select product.Serial_No,product.PName,product.Category,product.Cost,product.Details,product.Quantity,product.Addition_Date,supplier.Email,supplier.Fname,supplier.Lname,supplier.Mobile,supplier.District,supplier.Address \n" +
                                      "from product inner join\n" +
                                      "supplier on product.sid=supplier.SID where product.Serial_No="+serialId+"";
                         PreparedStatement ps= connection.getConnection().prepareStatement(query);
                         ResultSet rs= ps.executeQuery(query);
                         if(rs.next()){
                             ne.Address.setText(rs.getString("Address"));
                             ne.Category.setText(rs.getString("Category"));
                             ne.Date.setText(rs.getString("Addition_Date"));
                             ne.Details.setText(rs.getString("Details"));
                             ne.District.setText(rs.getString("District"));
                             ne.Email.setText(rs.getString("Email"));
                             ne.Price.setText(rs.getDouble("Cost")+" BDT");
                             ne.Quantity.setText(rs.getInt("Quantity")+"");
                             ne.SupplierContact.setText(rs.getString("Mobile"));
                             ne.SupplierName.setText(rs.getString("Fname")+" "+rs.getString("Lname"));
                         }
                         ne.setVisible(true);
                     } catch (SQLException ex) {
                         Logger.getLogger(product_list.class.getName()).log(Level.SEVERE, null, ex);
                     }
                   
                 }
              
               });
            
             
             table = new JTable();
             model = new DefaultTableModel();
             model.isCellEditable(0, 0);
             model.setColumnIdentifiers(columns);
             table.setModel(model);
             table.setFont(f2);
             table.setSelectionBackground(new java.awt.Color(153, 153, 255));
             table.setBackground(Color.WHITE);
             table.setRowHeight(50);

               for (int c = 0; c < table.getColumnCount(); c++)
               {
                   Class<?> col_class = table.getColumnClass(c);
                     table.setDefaultEditor(col_class, null);        // remove editor
                }
            
             scroll= new JScrollPane(table);
             scroll.setBounds(10, 110, 500, 490);
             c.add(scroll);
 
             //jPanelGradient 
             table.addMouseListener(new MouseAdapter(){
             
                    public void mouseClicked(MouseEvent e){
                        
                        jl3.setText("");
                        jl4.setText("");
                        
                        try {
                            int rownumber = table.getSelectedRow();
                            
                            serialId = Integer.parseInt(model.getValueAt(rownumber,0).toString());
                            String q= "select Image from product where Serial_No= "+serialId+"";
                            PreparedStatement ps= connection.getConnection().prepareStatement(q);
                            ResultSet rs= ps.executeQuery(q);
                            if(rs.next()){
                                img= new ImageIcon(rs.getString("Image"));
                                Image imgg= img.getImage();
                                Image newimg= imgg.getScaledInstance(320, 300,Image.SCALE_SMOOTH);
                                img= new ImageIcon(newimg);
                                p2= new JPanel(card);
                                p2.setBounds(540, 150, 320, 300); 
                                jl3= new JLabel(img);
                                p2.add(jl3);
                                c.add(p2);
                               
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(product_list.class.getName()).log(Level.SEVERE, null, ex);
                        }
                     }  
                  
             
             });
             
      }
       
       public void actionPerformed(ActionEvent e) {
              if(e.getSource()==bt2){
                  
              }
       }
       public static void main(String[] args) {
         product_list frame = new product_list();
         frame.setVisible(true);
    }
       
      
}
