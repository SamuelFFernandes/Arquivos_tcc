import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TratarCadFunc implements ActionListener{	
	private CadastroFuncionario telaAux2;
	
	public TratarCadFunc(CadastroFuncionario tela2){
		telaAux2 = tela2;
	}	
	public void actionPerformed (ActionEvent acao){
		telaAux2.setVisible(true);
	}	
}
