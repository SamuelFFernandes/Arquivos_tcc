import javax.swing.text.*;
import javax.swing.table.*;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;  
import java.awt.TextField;  
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.lang.*;
import java.text.*;
import java.io.*;
import java.util.Scanner;
import java.util.Calendar;
import java.sql.*;

public class CadastroAluno extends JFrame{
    private JButton b1, b2, b3;  
    private JLabel l0, Lcod_matric, Lnome, Lcpf, Lsexo, Lnascimento, Ltel_residencial, Ltel_celular, Lendereco, Lnum, Lbairro, Lcod_plano, Lvalor_parc;
    private JLabel Lcidade, Lestado, Lcep, Ldata_matric, Lmodal, Lplano_mes;
    private TextField Cmatric, Cnome, Csex, Cender, Cnum, Cbairro, Ccid, Cestado, Cdata_matric, Ccod_plano, Cvalor_parc, Ccpf, Cnasc, Ctel_res, Ctel_cel, Ccep;    
    private TextField Cmodalidade, Cplano_mes;    
    private TratarBotoesTelaAluno tba;
    private JComboBox combo, combo_2, combo_3, combo_4; 
        
    String Snome, Scpf, Ssex, Snasc, Sender, Sbairro, Scid, Sestado, Scep, Sdata_matric, mvenc;
	Long Dmatric, Dnum, Dtel_res, Dtel_cel, Dmodalidade, Dplano_mes, Dcod_plano, ultimo, ultimoP, mnummen;
	Double Dvalor_Parc, valorP;
	
	Connection cn;
    ResultSet rs;
    Statement st;
		
	public CadastroAluno() {
		setTitle("CADASTRO DE ALUNOS");			
	    JPanel p1 = new JPanel(); p1.setLayout(new FlowLayout(FlowLayout.LEFT));       
		JPanel p2 = new JPanel(); p2.setLayout(new GridLayout(3,0,3,5));  
        JPanel p3 = new JPanel(); p3.setLayout(new FlowLayout(3));         
        
        Icon bug = new ImageIcon("travelbug.gif");   
    	JLabel l0 = new JLabel(new ImageIcon("C:\\ImagensProjeto\\CADASTRO.jpg"));
    	p1.add(l0);     	
    	
        String sexo[] = {"","M","F"};
    	combo = new JComboBox(sexo);
   	 	combo.setBackground(Color.white);
    	combo.setForeground(Color.black);
    	combo.addItemListener(new ItemListener(){
      	public void itemStateChanged(ItemEvent ie){
        Ssex = (String)combo.getSelectedItem();
      }
    });
    	String uf[] = {"","AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RR","RO","RJ","RN","RS","SC","SP","SE","TO"};
    	combo_2 = new JComboBox(uf);
   	 	combo_2.setBackground(Color.white);
    	combo_2.setForeground(Color.black);
    	combo_2.addItemListener(new ItemListener(){
      	public void itemStateChanged(ItemEvent ie){
        Sestado = (String)combo_2.getSelectedItem();
      }
    });
        String modalidade[] = {"","1","2","3","4","5","6","7"};
    	combo_3 = new JComboBox(modalidade);
   	 	combo_3.setBackground(Color.white);
    	combo_3.setForeground(Color.black);
    	combo_3.addItemListener(new ItemListener(){
      	public void itemStateChanged(ItemEvent ie){
        String tmp1 = (String)combo_3.getSelectedItem();
        Dmodalidade = Long.parseLong(tmp1);
      }
    });
        String planos[] = {"","1","3","6","12"};
    	combo_4 = new JComboBox(planos);
   	 	combo_4.setBackground(Color.white);
    	combo_4.setForeground(Color.black);
    	combo_4.addItemListener(new ItemListener(){
      	public void itemStateChanged(ItemEvent ie){
        String tmp2 = (String)combo_4.getSelectedItem();
        Dplano_mes = Long.parseLong(tmp2);
      }
    });
    	b1 = new JButton("Novo");
    	b2 = new JButton("Limpar");
    	b3 = new JButton("Salvar");  
    	  	   	  	
        Lcod_matric = new JLabel ("Cod. Matrícula:");
    	Lnome = new JLabel ("Nome:");
    	Lcpf = new JLabel ("CPF:");
  		Lsexo = new JLabel ("Sexo:");
    	Lnascimento = new JLabel ("Nascimento");
    	Ltel_residencial = new JLabel ("tel residencial:");
    	Ltel_celular = new JLabel ("tel celular:");
    	Lendereco = new JLabel ("Endereço:");
    	Lnum = new JLabel ("nº");
    	Lbairro = new JLabel ("Bairro:");
    	Lcidade = new JLabel("Cidade:");
    	Lestado = new JLabel("Estado:");
    	Lcep = new JLabel ("CEP:");
    	Ldata_matric = new JLabel ("Data da matricula");
    	SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
    	Lmodal = new JLabel ("Modalidade:");
    	Lplano_mes = new JLabel ("Plano meses:");
    	Lcod_plano = new JLabel ("Cod_Plano:");
    	Lvalor_parc = new JLabel ("Valor Parcela:");
		
 	 // Consultando e atribuindo o novo Codigo de Matricula
    	try{
			ultimoRegistroAluno();
		}catch(FileNotFoundException exception) {
			System.err.println(exception);
        	System.exit(1);
        }
		Cmatric = new TextField ("12345");
        Cmatric.setText(String.valueOf(ultimo+1));
		Cmatric.setEditable(false);
		
		// Consultando e atribuindo o novo Codigo de Plano
		try{
			ultimoRegistroPlano();
		}catch(FileNotFoundException exception) {
			System.err.println(exception);
        	System.exit(1);
        }
		Ccod_plano = new TextField ("12345");
        Ccod_plano.setText(String.valueOf(ultimoP+1));
		Ccod_plano.setEditable(false);
				
		// Consultando e atribuindo o novo Codigo de Plano
		try{
			ultimoRegistroPlano();
		}catch(FileNotFoundException exception) {
			System.err.println(exception);
        	System.exit(1);
        }
		Ccod_plano = new TextField ("12345");
        Ccod_plano.setText(String.valueOf(ultimoP+1));
		Ccod_plano.setEditable(false);
		
		
		// Consultando e atribuindo o novo Codigo de Plano
		try{
			valorDaParcela();
			Cvalor_parc = new TextField ("0.00");
			Cvalor_parc.setText(valorP+"");
			Cvalor_parc.setEditable(false);
			} catch(FileNotFoundException exception) {
				System.err.println(exception);
        		System.exit(1);
        	}    	
    	
    	Cmatric.setEditable(false);
    	Cnome = new TextField (50);
    	Ccpf = new TextField (15);    
    	Csex = new TextField (8);
    	Cnasc = new TextField (20);    
    	Ctel_res = new TextField (16);    
    	Ctel_cel = new TextField (15);    
    	Cender = new TextField (33);
    	Cnum = new TextField (6);   	
    	Cbairro	= new TextField (40); 
    	Ccid = new TextField (25);    	
    	Cestado = new TextField (8);
    	Ccep = new TextField (12);    
    	Cdata_matric = new TextField (8);
    	Cmodalidade = new TextField (8);
    	Cplano_mes = new TextField (8);    	
    	Ccod_plano.setEditable(false);
    	Cvalor_parc.setEditable(false);
    	Cdata_matric.setText(data.format(Calendar.getInstance().getTime()));
    	Cdata_matric.setEditable(false);

    	TextField [] vetTF = {Cnome, Ccpf, Csex, Cnasc, Ctel_res, Ctel_cel, Cender, Cnum, Cbairro, Ccid, Cestado, Ccep, Cdata_matric, Cmodalidade, Cplano_mes};
    	   	
    	p1.add(Lcod_matric);
    	p1.add(Cmatric);
    	p1.add(Lnome);
    	p1.add(Cnome);
    	p1.add(Lcpf);
    	p1.add(Ccpf); 
    	p1.add(Lendereco);
    	p1.add(Cender);
    	p1.add(Lnum); 
    	p1.add(Cnum);     	
    	p1.add(Lsexo);
    	p1.add(combo);
    	p1.add(Lnascimento);
    	p1.add(Cnasc);
    	p1.add(Ltel_residencial);
    	p1.add(Ctel_res);
    	p1.add(Ltel_celular);
    	p1.add(Ctel_cel);       
    	p1.add(Lbairro);
    	p1.add(Cbairro);
    	p1.add(Lcidade);
    	p1.add(Ccid);    	
    	p1.add(Lestado);
    	p1.add(combo_2);
    	p1.add(Lcep);
    	p1.add(Ccep);
    	p2.add(Lcod_plano);
		p2.add(Ccod_plano);
		p2.add(Lvalor_parc);
		p2.add(Cvalor_parc);
		p2.add(Ldata_matric);
    	p2.add(Cdata_matric);
    	p2.add(Lmodal);
    	p2.add(combo_3);
    	p2.add(Lplano_mes);
    	p2.add(combo_4);
    	     	   	 
    	p1.add(p2);
    	    	    	
    	p3.add(b1);
    	p3.add(b2);
    	p3.add(b3);
    	p1.add(p3);      	  	    	    	
    	b1.setForeground(Color.blue);
    	b2.setForeground(Color.blue);
    	b3.setForeground(Color.blue);	
    	tba = new TratarBotoesTelaAluno(b1,b2,b3, vetTF); 
    	b1.addActionListener(tba);
		b2.addActionListener(tba);
		b3.addActionListener(tba); 
		this.setContentPane(p1);
		 
		setSize(600,360);
		setResizable(false);
		setLocationRelativeTo(null);	
		
	}
	class TratarBotoesTelaAluno implements ActionListener{
	private JButton b1, b2, b3;
	private TextField [] vetC;
	
	public TratarBotoesTelaAluno(JButton ba, JButton bb, JButton bc, TextField [] vetCampos){
		b1 = ba;
		b2 = bb;
		b3 = bc;
		
		vetC = vetCampos;
	}	
	 public void actionPerformed(ActionEvent acao){    
        if(acao.getSource() == b1) {
        	for(TextField campo : vetC)
            campo.setText("");
            System.out.println("Novo aberto");
            } else {
            	if(acao.getSource() == b2) {
            		for(TextField campo : vetC)
            		campo.setText("");
            		System.out.println("Formulario limpo");
            		}else{
            			if(acao.getSource() == b3){
            				try{            					
            					Dmatric = Long.parseLong(Cmatric.getText());
        						Snome = Cnome.getText();
        						Scpf = Ccpf.getText();
        						Sender = Cender.getText();
        						Dnum = Long.parseLong(Cnum.getText());
        						Snasc = Cnasc.getText();
        						Dtel_res = Long.parseLong(Ctel_res.getText());
        						Dtel_cel = Long.parseLong(Ctel_cel.getText());
        						Sbairro = Cbairro.getText();
        						Scid = Ccid.getText();
        						Scep = Ccep.getText();
        						Sdata_matric = Cdata_matric.getText();
        						Dcod_plano = Long.parseLong(Ccod_plano.getText());
        						
        						inserirCadastro();
        						inserirCadastroPlano();
        						inserirCadastroMensalidade();
        						
        						}catch(FileNotFoundException exception) {
								System.err.println(exception);
        						System.exit(1);
        					}
            				
                		    System.out.println("Salvando no banco de dados");
                		    JOptionPane.showMessageDialog(null,"Cadastrado com Sucesso");
                		    }
                	 }  	
           	  }    
        }
 } 
     	
    //Realizar consulta do ultimo registro em aluno 
	public void ultimoRegistroAluno() throws FileNotFoundException {
		try {
     	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            cn = DriverManager.getConnection(Conexao.CONEXAO);
            st = cn.createStatement();
            String query = "SELECT max(MATRICULA) AS ULTIMA_MATRICULA FROM ALUNO;";
            rs = st.executeQuery(query);
            while(rs.next()) {
				ultimo = Long.parseLong(rs.getString(1));
			}
        } catch (Exception e) {
        }
	}

	//Realizar consulta do ultimo registro em PLano 
	public void ultimoRegistroPlano() throws FileNotFoundException {
		try {
     	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            cn = DriverManager.getConnection(Conexao.CONEXAO);
            st = cn.createStatement();
            String query = "SELECT max(COD_PLANO) AS ULTIMO_PLANO FROM PLANO;";
            rs = st.executeQuery(query);
            while(rs.next()) {
				ultimoP = Long.parseLong(rs.getString(1));
			}
        } catch (Exception e) {
        }
	}
	
	//Realizar consulta do Valor da Parcela
	public void valorDaParcela() throws FileNotFoundException {
		try {
     	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            cn = DriverManager.getConnection(Conexao.CONEXAO);
            st = cn.createStatement();
            String query = "Select MODALIDADE.[VALOR_MENSALIDADE] From PLANO Inner Join  MODALIDADE On PLANO.[COD_MOD] = MODALIDADE.[COD_MOD] Where PLANO.[COD_PLANO] = (Select     MAX(PLANO.[COD_PLANO]) As ULTIMO   From     PLANO) Group By   MODALIDADE.[VALOR_MENSALIDADE], PLANO.[COD_PLANO], MODALIDADE.[COD_MOD]";
            rs = st.executeQuery(query);
            while(rs.next()) {
				valorP = Double.parseDouble(rs.getString(1));
			}
        } catch (Exception e) {
        }
	}
    
   //Inserir Cadastro ALUNO 
	public void inserirCadastro() throws FileNotFoundException {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            cn = DriverManager.getConnection(Conexao.CONEXAO);
            st = cn.createStatement();
            
            
            File file = new File ("querye2.txt");   
            Scanner sc = new Scanner(file);   
            String txtDestino = sc.nextLine();
            
            String query = "INSERT  INTO ALUNO (CPF, NOME, SEXO, NASCIMENTO, TEL_RES, TEL_CEL, LOGRADOURO, NUM_RES, BAIRRO, CIDADE, UF, CEP) VALUES ("+ 
            //txtDestino +  
            "'"+ Scpf +"', "+
            "'"+ Snome +"', "+
            "'"+ Ssex +"', "+
            "#"+ Snasc +"#, "+
            Dtel_res + ", " +
            Dtel_cel + ", " +
            "'"+ Sender +"', "+
            Dnum + ", " +
            "'"+ Sbairro +"', "+
            "'"+ Scid +"', "+
            "'"+ Sestado +"', "+
            "'"+ Scep +"');";
                         
            rs = st.executeQuery(query);
            
            FileWriter writer = new FileWriter("saida.txt"); 
            PrintWriter saida = new PrintWriter(writer,true);
          
            cn.clearWarnings();
            saida.close();   
	    	writer.close();
     	
     		System.out.println("Aluno Cadastrado!!");
     		cn.clearWarnings();

        } catch (Exception e) {
        }
	}
	
	//Inserir Cadastro PLANO
	public void inserirCadastroPlano() throws FileNotFoundException {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            cn = DriverManager.getConnection(Conexao.CONEXAO);
            st = cn.createStatement();
            
            
            File file = new File ("querye2.txt");   
            Scanner sc = new Scanner(file);   
            String txtDestino = sc.nextLine();
            
            String query = "INSERT  INTO PLANO (COD_MATRICULA, COD_MOD, DATA_MATRICULA, PLANO_MESES) VALUES ("+ 
            //txtDestino +  
            Dmatric +", "+
            Dmodalidade +", "+
            "#"+ Sdata_matric +"#, "+
            Dplano_mes +");";
            rs = st.executeQuery(query);
            
            FileWriter writer = new FileWriter("saida.txt"); 
            PrintWriter saida = new PrintWriter(writer,true);
          
            cn.clearWarnings();
            saida.close();   
	    	writer.close();
     	
     		System.out.println("Plano cadastrado!!");
     		cn.clearWarnings();

        } catch (Exception e) {
        }
	}
	
	//Inserir Mensalidade
	public void inserirCadastroMensalidade() throws FileNotFoundException {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            cn = DriverManager.getConnection(Conexao.CONEXAO);
            st = cn.createStatement();
            
			mvenc = "18/07/2010";
            
            File file = new File ("querye2.txt");   
            Scanner sc = new Scanner(file);   
            String txtDestino = sc.nextLine();
            
            String query = "INSERT  INTO MENSALIDADE (COD_PLANO, NUM_MENSALIDADE, VALOR_MENS_MOD, DATA_VENC) VALUES ("+ 
            //txtDestino +  
            Dcod_plano +", "+
            mnummen +", "+
            valorP +", "+
            "#"+ mvenc +"#);";
            
           rs = st.executeQuery(query);
            
            FileWriter writer = new FileWriter("saida.txt"); 
            PrintWriter saida = new PrintWriter(writer,true);
          
            cn.clearWarnings();
            saida.close();   
	    	writer.close();
     	
     		System.out.println("Mensalidade Inserida!!");
     		cn.clearWarnings();

        } catch (Exception e) {
        }
	}
	
   }