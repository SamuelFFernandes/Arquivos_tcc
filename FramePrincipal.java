import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FramePrincipal extends JFrame{
	private JLabel l1, l2;
	private JMenuBar me;
 	private JMenuItem itemAlunos, itemConsultas, itemFuncionarios, itemVisitantes;
   	private JMenuItem itemNutricionistas, itemPersonalVip, itemForcaAtivaVoce, itemSair;
   	private JMenuItem itemAluno, itemFuncionario, itemPagas, itemAtrasadas;
 	private CadastroAluno cad;
 	private CadastroFuncionario cadf;
 	private CadastroVisitantes cadv;
 	private ConsultaAluno conAluno;
 	private Aluno al;
 	private Funcionario fu;
 	private Pagas pg;
 	private Atrasadas at; 	 	
 	private Informacoes in;
 	private Personal pe;
 	private ForcaAtiva fa;
 	private Sair sa;
 	
public FramePrincipal(){
	setTitle("ACADEMIA GLICOGÊNIO"); 
	
	
	JMenu menu1 = new JMenu("CADASTROS");  // Menu OK!
	cad = new CadastroAluno();
	itemAlunos = new JMenuItem("Alunos");
	itemAlunos.addActionListener(new TratarCadAluno(cad));
	cadf = new CadastroFuncionario();	
	itemFuncionarios = new JMenuItem("Funcionários");
	itemFuncionarios.addActionListener(new TratarCadFunc(cadf));	
	cadv = new CadastroVisitantes();
	itemVisitantes = new JMenuItem("Visitantes");
	itemVisitantes.addActionListener(new TratarCadVis(cadv));
	conAluno = new ConsultaAluno();
	itemConsultas = new JMenuItem("Alunos Cadastrados");
	itemConsultas.addActionListener(new TratarConsuAluno(conAluno));
	menu1.add(itemAlunos);        
    menu1.add(itemFuncionarios);     
    menu1.add(itemVisitantes);
    menu1.add(new JSeparator()); //linha que finaliza o menu de opções
    
      
    JMenu menu2 = new JMenu("CONSULTAS");
    menu2.add(itemConsultas); //  referente aos alunos cadastrados
    menu2.add(new JMenuItem("Funcionários cadastrados"));       //fazer consulta
    menu2.add(new JMenuItem("Mensalidades atrasadas / pagas")); //fazer consulta
    menu2.add(new JSeparator()); //linha que finaliza o menu de opções
    

    JMenu menu3 = new JMenu("RELATÓRIOS");  // Menu OK!
    al = new Aluno();
	itemAluno = new JMenuItem("Alunos da Academia");
	itemAluno.addActionListener(new AlunosCad(al));
	fu = new Funcionario();
	itemFuncionario = new JMenuItem("Funcionários da Academia");
	itemFuncionario.addActionListener(new FuncCad(fu));
	pg = new Pagas();
	itemPagas = new JMenuItem("Mensalidades Pagas");
	itemPagas.addActionListener(new MensalPag(pg)); 
	at = new Atrasadas();
	itemAtrasadas = new JMenuItem("Mensalidades Atrasadas");
	itemAtrasadas.addActionListener(new MensalAtras(at)); 
    menu3.add(itemAluno);
    menu3.add(itemFuncionario);
    menu3.add(itemPagas);
    menu3.add(itemAtrasadas);
    menu3.add(new JSeparator()); //linha que finaliza o menu de opções
    
 
    JMenu menu4 = new JMenu("MODALIDADES");   // fazer este menu todo
    menu4.add(new JMenuItem("musculação "));
    menu4.add(new JMenuItem("ginástica"));
    menu4.add(new JMenuItem("piscina"));
    menu4.add(new JMenuItem("yoga"));
    menu4.add(new JMenuItem("danças"));
    menu4.add(new JMenuItem("lutas"));
    menu4.add(new JMenuItem("pilates"));
    menu4.add(new JSeparator());
    
    
    JMenu menu5 = new JMenu("SERVIÇOS"); // Menu OK!
    in = new Informacoes();
	itemNutricionistas = new JMenuItem("Nutricionistas");
	itemNutricionistas.addActionListener(new InfNutricao(in));
	pe = new Personal();
	itemPersonalVip = new JMenuItem("Personal Vip");
	itemPersonalVip.addActionListener(new InfPersonalVip(pe));
	fa = new ForcaAtiva();
	itemForcaAtivaVoce = new JMenuItem("Roupas Fitness");
	itemForcaAtivaVoce.addActionListener(new InfForcaAtiva(fa)); 
    menu5.add(itemNutricionistas);
    menu5.add(itemPersonalVip);
    menu5.add(itemForcaAtivaVoce);
    menu5.add(new JSeparator());
    
 
    JMenu menu6 = new JMenu("SAIR DO SISTEMA");  // Menu OK!
    sa = new Sair();
    itemSair = new JMenuItem("Sair");
    itemSair.addActionListener(new TratarSaidaPrincipal(sa));
    menu6.add(itemSair);
    
    
    
    JMenuBar bar = new JMenuBar();
    bar.add(menu1);
    bar.add(menu2);
    bar.add(menu3);
    bar.add(menu4);
    bar.add(menu5);
    bar.add(menu6);        
    
	
	JFrame jan = new JFrame();
    jan.setJMenuBar(bar);
	getContentPane().setBackground(Color.BLACK);
	getContentPane().setLayout(new FlowLayout());
    getContentPane().add(bar);
    
    Icon bug = new ImageIcon("travelbug.gif");   
    JLabel l1 = new JLabel(new ImageIcon("C:\\ImagensProjeto\\FOTO.jpg"));
    Icon bug_2 = new ImageIcon("travelbug.gif");   
    JLabel l2 = new JLabel(new ImageIcon("C:\\ImagensProjeto\\ENDERECO.jpg"));
    add(l1);
    add(l2); 
     
    setVisible(true);
	setSize(550, 550);
	setResizable(false);
    setLocationRelativeTo(null);	

	}
	
	
}