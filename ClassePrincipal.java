import javax.swing.*;
public class ClassePrincipal{
public static void main(String[] args){

       SwingUtilities.invokeLater(new Runnable() {  
            public void run() {  
                TelaIntroducao thisClass = new TelaIntroducao();                 
              thisClass.setVisible(true);  
            }  
        });  
    }
}
  

