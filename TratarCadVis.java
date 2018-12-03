import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TratarCadVis implements ActionListener{	
	private CadastroVisitantes telaAux3;
	
	public TratarCadVis(CadastroVisitantes tela3){
		telaAux3 = tela3;
	}
	public void actionPerformed (ActionEvent acao){
		telaAux3.setVisible(true);
    }	
}
