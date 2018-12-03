import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.io.FileNotFoundException;

public class ConsultaAluno extends JFrame{
	private JButton b1, b2, b3;
	private JLabel l1;
	private JPanel p1, p2;
	private TratarBotoes tb;
	private ArrayList<Aluno> alunos;	
	private JTable table;
	private JScrollPane jsp;
	
	Long ultimo;
	Connection cn;
    ResultSet rs;
    Statement st;
	
	public ConsultaAluno(){
		setTitle("CONSULTA DE ALUNOS");
		p1 = new JPanel(); 
		p2 = new JPanel(); 
		p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		b1 = new JButton("CONSULTAR ALUNOS");
		b2 = new JButton("PRIMEIRO CADASTRO");
		b3 = new JButton("ÚLTIMO CADASTRO");
		tb = new TratarBotoes(b1, b2, b3);
		jsp = new JScrollPane();
		table= new JTable();
		p1.add(p2);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(jsp);
		b1.addActionListener(tb);
		b2.addActionListener(tb);
		b3.addActionListener(tb);			
		
		setSize(1100, 600);
		setLocationRelativeTo(null);	
	    setResizable(true);
		setContentPane(p1);		
	}
	
	class TratarBotoes implements ActionListener{
		private JButton b1, b2, b3;
	public TratarBotoes(JButton ba, JButton bb, JButton bc){
		b1 = ba;
		b2 = bb; 
		b3 = bc;
	}
	
	public void actionPerformed(ActionEvent acao){
		if (acao.getSource() == b1){
			try{
				consultar();
				repaint();
				}catch(FileNotFoundException exception) {
					System.err.println(exception);
					System.exit(1);
					}System.out.println("Final da consulta");
					
					
					}else{
						if(acao.getSource() == b2){	
						System.out.println("Primeiro cadastro");
						
						
						}else{
							if(acao.getSource() == b3){
								try{
									ultimoRegistroAluno();									
								    }catch(FileNotFoundException exception){
								    	System.err.println(exception);
								    	//System.exit(1);
								    	}
								    	System.out.println("Ultimo cadstro");
								}
	        	         }
	   
               }
         }
	
   }
   
     //Realizar consulta
	public void consultar() throws FileNotFoundException {
     try {  
    	 	
    	  Driver d = (Driver)Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance(); 
    	  Connection c = DriverManager.getConnection
    	  ("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=C:\\Banco\\Academia.mdb");
    	  st = c.createStatement();
    	  String query = "SELECT * FROM ALUNO;";
            rs = st.executeQuery(query);
            alunos = new ArrayList<Aluno>();
            while(rs.next()) {
            	alunos.add(new Aluno(rs.getString(3),rs.getString(8), rs.getString(9), rs.getString(6), rs.getString(10), rs.getString(11), rs.getString(12)));		
			}
            
            
           c.close();
           montaTableAlunos();
     	System.out.println("\n");

        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	//Realizar consulta do ultimo registro em aluno 
	public void ultimoRegistroAluno() throws FileNotFoundException {
		try {

            String query = "SELECT max(MATRICULA) AS ULTIMA_MATRICULA FROM ALUNO;";
            rs = st.executeQuery(query);
            while(rs.next()) {
				ultimo = Long.parseLong(rs.getString(1));
			}
        } catch (Exception e) {
        }
	}
	private void montaTableAlunos(){
		table.setModel(new MinhaTableModel(new String[]{"Nome","Endereco","Número","Telefone res.","Bairro","Cidade","UF"}, alunos.size(), 7));
		for(int i=0; i<alunos.size(); i++){
			table.setValueAt(alunos.get(i).getNome(), i, 0);
			table.setValueAt(alunos.get(i).getMatricula(), i, 1);
			table.setValueAt(alunos.get(i).getEndereco(), i, 2);
			table.setValueAt(alunos.get(i).getNumero(), i, 3);
			table.setValueAt(alunos.get(i).getBairro(), i, 4);
			table.setValueAt(alunos.get(i).getCidade(), i, 5);
			table.setValueAt(alunos.get(i).getEstado(), i, 6);
		}
		
		jsp.setViewportView(table);
		jsp.setAutoscrolls(true);
		table.setAutoCreateRowSorter(true);
	}
	public class Aluno {
	private String nome;
	private String matricula;
	private String endereco;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	
	public Aluno(String nome, String matricula, String endereco, String numero, String bairro, String cidade, String estado){
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String cidade) {
		this.estado = estado;
	}		
	
}
public class MinhaTableModel extends AbstractTableModel {
	private String[] tituloColunas;
	private Object[][] data;
	private int linhas, colunas;
	
	public MinhaTableModel(String[] tituloColunas, int numLinhas, int numColunas){
		this.tituloColunas= tituloColunas;
		this.data= new Object[numLinhas][numColunas];
		linhas=numLinhas;
		colunas=numColunas;
	}

	public String getColumnName(int col){
		return tituloColunas[col];
	}
	
	public int getColumnCount() {
		return colunas;
	}

	public int getRowCount() {
		return linhas;
	}

	public Object getValueAt(int linha, int coluna) {
		return data[linha][coluna];
	}
	
	public void setValueAt(Object valor, int linha, int coluna) {
		data[linha][coluna]=valor.toString();
		fireTableCellUpdated(linha, coluna);
	}
}
}