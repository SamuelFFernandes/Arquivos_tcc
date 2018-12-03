import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class Aluno extends JFrame {
   private JLabel l1;

   public Aluno() {
     setTitle("ALUNOS DA ACADEMIA");
      
    Icon bug_1 = new ImageIcon("travelbug.gif");   
    JLabel l1 = new JLabel(new ImageIcon("C:\\ImagensProjeto\\image4.jpg"));
    add(l1);   
     
     
     

      setSize(500,700);
      setResizable(false);
      setLocationRelativeTo(null);
   }
}
