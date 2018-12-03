import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TratarSaidaPrincipal implements ActionListener{	
	private Sair telaAux;
	public TratarSaidaPrincipal(Sair tela){
		telaAux = tela;
	}
	public void actionPerformed (ActionEvent acao){
		System.out.println("finalizando.....");
		System.exit(0);

		telaAux.setVisible(true);
	}
}