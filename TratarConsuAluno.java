import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TratarConsuAluno implements ActionListener{	
	private ConsultaAluno telaAux2;
	
	public TratarConsuAluno(ConsultaAluno tela2){
		telaAux2 = tela2;
	}	
	public void actionPerformed (ActionEvent acao){
		telaAux2.setVisible(true);
	}	
}
