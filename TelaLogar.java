import javax.swing.JFrame;  
import javax.swing.JButton;  
import javax.swing.JLabel;  
import javax.swing.JTextField;  
import javax.swing.JPasswordField;  
import javax.swing.JOptionPane;  
import java.awt.Dimension;  
import java.awt.FlowLayout;  
import java.awt.Color;  
import java.awt.event.ActionListener;  
import java.awt.event.ActionEvent;  
  
public class TelaLogar extends JFrame{  
    private TratarBotoesLogin tbl;  
    private JButton b1, b2;  
    private JPasswordField id;  
    private JLabel l1;  
    private JPasswordField c1;  
      
    public TelaLogar(){  
    setTitle("LOGIN");  
    b1 = new JButton("OK");  
    b2 = new JButton("CANCELAR");  
    l1 = new JLabel("Digite a senha");  
    c1 = new JPasswordField(6);  
    id = new JPasswordField();  
    tbl = new TratarBotoesLogin(b1,b2);  
    id.setPreferredSize(new Dimension(70, 20));  
    getContentPane().setLayout(new FlowLayout());  
    getContentPane().add(l1);  
    getContentPane().add(id);  
    getContentPane().add(b1);  
    getContentPane().add(b2);  
    b1.setForeground(Color.blue);  
    b2.setForeground(Color.red);  
    b1.addActionListener(tbl);  
    b2.addActionListener(tbl);  
    l1.setForeground(Color.BLACK);  
      
    setVisible(true);  
    setSize(200,100);  
    setResizable(false);
    setLocationRelativeTo(null);  
      
   }        
    public class TratarBotoesLogin implements ActionListener{  
    private JButton b1, b2;  
    public TratarBotoesLogin(JButton ba, JButton bb){  
        b1 = ba;  
        b2 = bb;  
        }  
              
    public void actionPerformed(ActionEvent acao){    	  
        if(acao.getSource() == b1){          
        	String senha = String.valueOf(id.getPassword());        	
        	if (senha.compareTo("123") == 0){ 
			setVisible(false);         		        	  
        		new FramePrincipal();        		        	  
        		}else{        			        		
        			if(senha.compareTo("123")!=0){        				        			
        				JOptionPane.showMessageDialog(null,"SENHA INCORRETA.TENTE NOVAMENTE.");
        				}
        			    } 
                		}else{                			  
            				System.out.println("CANCELADO");
            				System.exit(0);
            			}      
                }   
          }  
}  
