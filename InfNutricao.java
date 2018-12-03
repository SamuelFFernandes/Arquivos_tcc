import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfNutricao implements ActionListener{	
	private Informacoes telaAux5;
	
	public InfNutricao(Informacoes tela5){
		telaAux5 = tela5;
	}
	public void actionPerformed (ActionEvent acao){
		telaAux5.setVisible(true);
    }	
}
