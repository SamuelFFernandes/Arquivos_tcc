import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfPersonalVip implements ActionListener{	
	private Personal telaAux4;
	
	public InfPersonalVip(Personal tela4){
		telaAux4 = tela4;
	}
	public void actionPerformed (ActionEvent acao){
		telaAux4.setVisible(true);
    }	
}