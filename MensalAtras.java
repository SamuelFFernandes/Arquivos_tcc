import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MensalAtras implements ActionListener{	
	private Atrasadas telaAux9;
	
	public MensalAtras (Atrasadas tela9){
		telaAux9 = tela9;
	}
	public void actionPerformed (ActionEvent acao){
		telaAux9.setVisible(true);
    }	
}