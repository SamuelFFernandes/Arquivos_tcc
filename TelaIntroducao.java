import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;    
import javax.swing.*;    

public class TelaIntroducao extends JFrame {  

    private JPanel jContentPane; 
    private JLabel lblSplash; 
    private JProgressBar prbProgresso;  
    private Timer timer = null;
    public TelaIntroducao() {  
        initialize(); 

    }  
    private void initialize() {  
        setSize(550, 550);  
        setUndecorated(true);
        setLocationRelativeTo(null); 
        setContentPane(getJContentPane());         
        timer = new Timer(50, new ActionListener() {  
            private int step = 0;                
 
            public void actionPerformed(ActionEvent e) {  
                step++;  
                prbProgresso.setValue(step);  
                if (step == 100) {  
                   TelaIntroducao.this.dispose(); 
                      new TelaLogar();
                }    
            }  
            
        });  
        timer.start(); 
       
    }  
    private JPanel getJContentPane() {  
        if (jContentPane == null) { 
            lblSplash = new JLabel();  
 
            jContentPane = new JPanel();
            jContentPane.setBackground(Color.RED);   
            jContentPane.setLayout(new BorderLayout()); 
            jContentPane.add(getPrbProgresso(), BorderLayout.SOUTH);             
               
            Icon bug = new ImageIcon("travelbug.gif");   
            JLabel l1 = new JLabel(new ImageIcon("C:\\ImagensProjeto\\Introducao.jpg")); 
            jContentPane.add(l1); 
        }  
        return jContentPane;  
    }  
    private JProgressBar getPrbProgresso() {  
        if (prbProgresso == null) {  
            prbProgresso = new JProgressBar();  
        }  
        return prbProgresso;  
    } 
    }