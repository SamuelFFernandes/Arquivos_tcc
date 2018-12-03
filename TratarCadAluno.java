import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TratarCadAluno implements ActionListener{	
	private CadastroAluno telaAux;
	
	public TratarCadAluno(CadastroAluno tela){
		telaAux = tela;
	}
	public void actionPerformed (ActionEvent acao){
		telaAux.setVisible(true);
	}	
}