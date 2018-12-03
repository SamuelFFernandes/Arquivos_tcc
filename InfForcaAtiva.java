import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfForcaAtiva implements ActionListener{	
	private ForcaAtiva telaAux6;
	
	public InfForcaAtiva (ForcaAtiva tela6){
		telaAux6 = tela6;
	}
	public void actionPerformed (ActionEvent acao){
		telaAux6.setVisible(true);
    }	
}
