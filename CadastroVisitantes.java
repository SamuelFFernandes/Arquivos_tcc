import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;     
import javax.swing.text.MaskFormatter;   
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;  
import java.awt.event.*;

public class CadastroVisitantes extends JFrame{
    private JButton b1, b2, b3;
    private JLabel l0, l1, l2, l3, l4, l5, l6;
    private JTextField c1, c2, c3;
    private TratarBotoesTelaVisit tbv;
    private JFormattedTextField telefone, telefone_cel, data_visita, rg; 
    private MaskFormatter Tel, Tel_cel, Data_Visita, RG;
		
	public CadastroVisitantes() {
		setTitle("CADASTRO DE VISITANTES");			
	    JPanel p1 = new JPanel(); p1.setLayout(new FlowLayout(FlowLayout.LEFT));       
		JPanel p2 = new JPanel(); p2.setLayout(new FlowLayout ()); //p2.setBackground(Color.BLACK);  
        
        Icon bug = new ImageIcon("travelbug.gif");   
    	JLabel l0 = new JLabel(new ImageIcon("C:\\ImagensProjeto\\CAD_VISIT.jpg"));
    	p1.add(l0);
    	
    	try {  
            Tel = new MaskFormatter("##-####-####");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        } 
        try {  
            Tel_cel = new MaskFormatter("##-####-####");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }
        try {  
           Data_Visita = new MaskFormatter("##/##/####");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }                  
        try {  
           RG = new MaskFormatter("##-###-###-#");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        
        telefone = new JFormattedTextField(Tel);  
        telefone_cel = new JFormattedTextField(Tel_cel);
        data_visita = new JFormattedTextField(Data_Visita);
        rg = new JFormattedTextField(RG);             
        Tel.setValidCharacters("0123456789");
        Tel_cel.setValidCharacters("0123456789"); 
        Data_Visita.setValidCharacters("0123456789");
        RG.setValidCharacters("0123456789");           
        telefone.setColumns(8);
        telefone_cel.setColumns(8);       
        data_visita.setColumns(10);           
        rg.setColumns(10);                                

    	b1 = new JButton("Novo");
    	b2 = new JButton("Salvar");
    	b3 = new JButton("Limpar");
    	     	   	
        l1 = new JLabel ("Código nº: ");
    	l2 = new JLabel ("Nome: ");
    	l3 = new JLabel ("RG: ");
    	l4 = new JLabel ("Telefone residencial: ");
    	l5 = new JLabel ("Telefone cel: ");   
    	l6 = new JLabel ("data da visita: "); 	    	    	
    	c1 = new JTextField (5);
    	c1.setEditable(false);
    	c2 = new JTextField (36);
    	c3 = new JTextField (10);
    	
    	JTextField [] vetTF = { c1, c2, c3, rg, telefone, telefone_cel, data_visita};
    	
    	p1.add(l1);
    	p1.add(c1);
    	p1.add(l2);
    	p1.add(c2);
    	p1.add(l3);
    	p1.add(rg);
    	p1.add(l4);
    	p1.add(telefone);
    	p1.add(l5);
    	p1.add(telefone_cel);
    	p1.add(l6);
    	p1.add(data_visita);    	
  
    	p1.add(p2);

    	p2.add(b1);
    	p2.add(b2);
    	p2.add(b3);
    	b1.setForeground(Color.blue);
    	b2.setForeground(Color.blue);
    	b3.setForeground(Color.red);
    	
    	tbv = new TratarBotoesTelaVisit(b1,b2,b3, vetTF); 
    	b1.addActionListener(tbv);
		b2.addActionListener(tbv);
		b3.addActionListener(tbv);

		this.setContentPane(p1); 
		setSize(600,200);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	class TratarBotoesTelaVisit implements ActionListener{
	private JButton b1, b2, b3;
	private JTextField [] vetC;
	
	public TratarBotoesTelaVisit(JButton ba, JButton bb, JButton bc, JTextField [] vetCampos){
		b1 = ba;
		b2 = bb;
		b3 = bc;	
		vetC = vetCampos;
	}	
	 public void actionPerformed(ActionEvent acao){    
        if(acao.getSource() == b1) { 
        System.out.println("NOVO ABERTO"); 
        for(JTextField campo : vetC)
                		campo.setText("");   
        JOptionPane.showMessageDialog(null,"OK, NOVO ABERTO");              
        } else {    
            if(acao.getSource() == b2) {            
                 System.out.println("SALVANDO..."); 
                 
                 //salvar na Tabela visitantes   
            JOptionPane.showMessageDialog(null,"OK, SALVO COM SUCESSO");                           
            } else {          	    
                if(acao.getSource() == b3) {               	            	 
                    System.out.println("LIMPO!!");    
                	for(JTextField campo : vetC)
                		campo.setText("");
                		JOptionPane.showMessageDialog(null,"OK, LIMPO COM SUCESSO");        
                		
                        }else{
                   }                
                }
              }
            }
          }
}