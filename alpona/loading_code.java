
package alpona;

import java.util.logging.Level;
import java.util.logging.Logger;

public class loading_code {
    public static void main(String[] args) {
        startPage l= new startPage();
        l.setVisible(true);
        LoginPage lg= new LoginPage();
        lg.setVisible(false);
        for(int i=0; i<=100; i++){
            try {
                Thread.sleep(30);
                l.jLabel2.setText(Integer.toString(i)+"%");
                l.jProgressBar1.setValue(i);
                if(i==10) {
                    l.jLabel1.setText("Turning on Modules...");
                }
                 if(i==20) {
                    l.jLabel1.setText("Loading Modules...");
                }
                 if(i==50) {
                    l.jLabel1.setText("Connecting to Database...");
                }
                 if(i==70) {
                    l.jLabel1.setText("Connection Successfull...");
                }
                 if(i==80) {
                    l.jLabel1.setText("Launcing Application...");
                }
                if(i==100){
                    l.setVisible(false);
                    lg.setVisible(true);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(loading_code.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
