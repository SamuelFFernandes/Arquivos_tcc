import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;

public class Informacoes extends JFrame {
   private JLabel l1;
	
   public Informacoes() {
     setTitle("NUTRICIONISTAS");

    Icon bug_1 = new ImageIcon("travelbug.gif");   
    JLabel l1 = new JLabel(new ImageIcon("C:\\ImagensProjeto\\image1.jpg"));
    add(l1);
   
     
     

      setSize(500,400);
      setResizable(false);
      setLocationRelativeTo(null);
   }
}


























/*import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JFrame;

public class Informacoes extends JFrame{
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	
	public Informacoes(){
		setTitle("NUTRICIONISTAS");
		l1 = new JLabel("DIETAS BALANCEADAS");
		l2 = new JLabel("AVALIA플O DA COMPOSI플O CORPORAL");
		l3 = new JLabel("AVALIA플O NUTRICIONAL");
		l4 = new JLabel("DIETAS PARA EMAGRECIMENTO");
	    l6 = new JLabel("ACOMPANHAMENTOS ESPECIAIS");
		l7 = new JLabel("NUTRI플O PARA COMPETI합ES");
		l8 = new JLabel("GANHO DE MASSA MUSCULAR");
		
		setLayout(new FlowLayout());
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		/*add(l5);
		add(l6);
		add(l7);
		add(l8);*/
		/*setSize(350,200);
		setLocationRelativeTo(null);
		
	}
}*/