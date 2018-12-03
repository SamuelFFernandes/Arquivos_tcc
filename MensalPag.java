import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MensalPag implements ActionListener{	
	private Pagas telaAux10;
	
	public MensalPag (Pagas tela10){
		telaAux10 = tela10;
	}
	public void actionPerformed (ActionEvent acao){
		telaAux10.setVisible(true);
    }	
}