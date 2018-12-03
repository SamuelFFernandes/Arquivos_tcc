import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane; 
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.JFormattedTextField;     
import javax.swing.text.MaskFormatter;   
import java.text.ParseException;  

public class CadastroFuncionario extends JFrame{
    private JButton b1,  b2,  b3;
    private JLabel l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17;
    private JTextField c1, c2, c3, c4, c5, c6, c7, c8, c10, c11, c12, c13, c15, c16, c17;
    private TratarBotoesTelaFunc tbf;
    private JComboBox combo, combo_2, combo_3;
    private JFormattedTextField data_adm, data_dem, telefone, telefone_cel, rg, cep, salario; 
    private MaskFormatter Data_adm, Data_dem, Tel, Tel_cel, RG, CEP, Salario;		
		
	public CadastroFuncionario() {
		setTitle("CADASTRO DE FUNCIONÁRIOS");			
	    JPanel p1 = new JPanel(); p1.setLayout(new FlowLayout(FlowLayout.LEFT));       
		JPanel p2 = new JPanel(); p2.setLayout(new FlowLayout ()); 
        
        Icon bug = new ImageIcon("travelbug.gif");   
    	JLabel l0 = new JLabel(new ImageIcon("C:\\ImagensProjeto\\CAD_FUNC.jpg"));
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
            Data_adm = new MaskFormatter("##/##/####");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        try {  
            Data_dem = new MaskFormatter("##/##/####");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }
        try {  
           RG = new MaskFormatter("##-####-###-#");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }
        try {  
           CEP = new MaskFormatter("#####-###");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }   
        try {  
        Salario = new MaskFormatter("R$: #.###,##");  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
                        
        telefone = new JFormattedTextField(Tel);  
        telefone_cel = new JFormattedTextField(Tel_cel); 
        rg = new JFormattedTextField(RG);
        data_adm = new JFormattedTextField(Data_adm);
        data_dem = new JFormattedTextField(Data_dem);
        cep = new JFormattedTextField(CEP);
        salario = new JFormattedTextField(Salario);             
        Tel.setValidCharacters("0123456789");
        Tel_cel.setValidCharacters("0123456789"); 
        RG.setValidCharacters("0123456789");         
        Data_adm.setValidCharacters("0123456789");
        CEP.setValidCharacters("0123456789");
        Data_dem.setValidCharacters("0123456789"); 
        Salario.setValidCharacters("0123456789");             
        telefone.setColumns(9);
        telefone_cel.setColumns(9);
        rg.setColumns(10);  
        data_adm.setColumns(7);
        cep.setColumns(9);           
        data_dem.setColumns(7);        
        salario.setColumns(7);                
        
        String função[] = {"PROFESSOR","RECEPCIONISTA","ADMINISTRAÇÃO","AUX. DE LIMPEZA","NUTRICIONISTA", "DIRETOR","SERVIÇOS GERAIS"};
    	combo = new JComboBox(função);
   	 	combo.setBackground(Color.white);
    	combo.setForeground(Color.red);
    	combo.addItemListener(new ItemListener(){
      	public void itemStateChanged(ItemEvent ie){
        String str = (String)combo.getSelectedItem();
      }
    });    
    	String uf[] = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RR","RO","RJ","RN","RS","SC","SP","SE","TO"};
    	combo_2 = new JComboBox(uf);
   	 	combo_2.setBackground(Color.white);
    	combo_2.setForeground(Color.red);
    	combo_2.addItemListener(new ItemListener(){
      	public void itemStateChanged(ItemEvent ie){
        String str = (String)combo_2.getSelectedItem();
      }
    });    
       String horario[] = {"MANHÃ","TARDE","NOITE"};
    	combo_3 = new JComboBox(horario);
   	 	combo_3.setBackground(Color.white);
    	combo_3.setForeground(Color.red);
    	combo_3.addItemListener(new ItemListener(){
      	public void itemStateChanged(ItemEvent ie){
        String str = (String)combo_3.getSelectedItem();
      }
    });    	
    	b1 = new JButton("Novo");
    	b2 = new JButton("Salvar");
    	b3 = new JButton("Limpar");
    	
        l1 = new JLabel ("Registro nº: ");
    	l2 = new JLabel ("Nome: ");
    	l3 = new JLabel ("RG: ");
    	l4 = new JLabel ("Endereço: ");
    	l5 = new JLabel ("nº: ");
    	l6 = new JLabel ("Bairro: ");
    	l7 = new JLabel ("complemento: ");
    	l8 = new JLabel ("CEP: ");
    	l9 = new JLabel ("Estado: ");
    	l10 = new JLabel ("Telefone residencial: ");
    	l11 = new JLabel ("Telefone celular: ");
    	l12 = new JLabel ("Função: ");
    	l13 = new JLabel ("nº CREF: ");
    	l14 = new JLabel ("Horário de trabalho: ");
    	l15 = new JLabel ("data adimissão:");
    	l16 = new JLabel ("data demissão:");
    	l17 = new JLabel ("Salário:");    		    	
    	c1 = new JTextField (5);
    	c1.setEditable(false);
    	c2 = new JTextField (36);
    	c3 = new JTextField (10);
    	c4 = new JTextField (33);
    	c5 = new JTextField (5);
    	c6 = new JTextField (10);
    	c7 = new JTextField (8); 
    	c8 = new JTextField (9);    	
    	c10 = new JTextField (10);
    	c11 = new JTextField (10);
    	c13 = new JTextField (10);
    	c15 = new JTextField (10);
    	c16	= new JTextField (10);
    	c17 = new JTextField (9);
    	
    	JTextField [] vetTF = { c1, c2, rg, c4, c5, c6, c7, cep, telefone, telefone_cel, c13, data_adm, data_dem, salario};
    	
    	p1.add(l1);
    	p1.add(c1);
    	p1.add(l2);
    	p1.add(c2);
    	p1.add(l3);
    	p1.add(rg);
    	p1.add(l4);
    	p1.add(c4);
    	p1.add(l5);
    	p1.add(c5);
    	p1.add(l6);
    	p1.add(c6);
    	p1.add(l7);
    	p1.add(c7);
    	p1.add(l8);
    	p1.add(cep);
    	p1.add(l9);
    	p1.add(combo_2);
    	p1.add(l10);
    	p1.add(telefone);
    	p1.add(l11);
    	p1.add(telefone_cel);
    	p1.add(l12);
    	p1.add(combo);
   		p1.add(l13);
    	p1.add(c13);
    	p1.add(l14);
    	p1.add(combo_3);
    	p1.add(l15);
    	p1.add(data_adm);
    	p1.add(l16);
    	p1.add(data_dem);
    	p1.add(l17);
    	p1.add(salario);
  
    	p1.add(p2);

    	p2.add(b1);
    	p2.add(b2);
    	p2.add(b3);
    	b1.setForeground(Color.blue);
    	b2.setForeground(Color.blue);
    	b3.setForeground(Color.red);
    	
    	tbf = new TratarBotoesTelaFunc(b1,b2,b3, vetTF); 
    	b1.addActionListener(tbf);
		b2.addActionListener(tbf);
		b3.addActionListener(tbf);

		this.setContentPane(p1); 
		setSize(600,350);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	class TratarBotoesTelaFunc implements ActionListener{
	private JButton b1, b2, b3;
	private JTextField [] vetC;
	
	public TratarBotoesTelaFunc(JButton ba, JButton bb, JButton bc, JTextField [] vetCampos){
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
                 
                 // salvar Tabela funcionários  
                 
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