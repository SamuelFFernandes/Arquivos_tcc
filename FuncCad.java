import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FuncCad implements ActionListener{	
	private Funcionario telaAux8;
	
	public FuncCad (Funcionario tela8){
		telaAux8 = tela8;
	}
	public void actionPerformed (ActionEvent acao){
		telaAux8.setVisible(true);
		
    }	
}