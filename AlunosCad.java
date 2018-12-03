import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlunosCad implements ActionListener{	
	private Aluno telaAux7;
	
	public AlunosCad (Aluno tela7){
		telaAux7 = tela7;
	}
	public void actionPerformed (ActionEvent acao){
		telaAux7.setVisible(true);
    }	
}