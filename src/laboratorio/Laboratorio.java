package laboratorio;

import java.util.ArrayList;
import elementos.Elemento;

public class Laboratorio {

	private ArrayList<Elemento> elementos = new ArrayList<>();
	private ArrayList<String> historicoReacoes = new ArrayList<>();
	
	public void adicionarElemento(Elemento e) {
		elementos.add(e);
	}
	
	public String misturar(Elemento e1, Elemento e2) {
		
		if (!elementos.contains(e1) || !elementos.contains(e2)) {
			String mensagemErro = "Um ou mais itens não estão adicionados ao laboratório";
			historicoReacoes.add(mensagemErro);
			return mensagemErro;
		}
		
		String reacao = e1.getNome() + " misturado com " + e2.getNome() + " - Resultado: " + e1.reagir(e2);
		
		historicoReacoes.add(reacao);
		return reacao;
	}

	public ArrayList<String> getHistoricoReacoes() {
		return historicoReacoes;
	}

	public void mostrarHistorico() {
		System.out.println("Histórico Completo de Reações:\n__________________________");
		
		for (int i = 0; i < historicoReacoes.size(); i++) {
			System.out.println("Reação Química " + (i + 1) + ". " + historicoReacoes.get(i));
		}
	}	
}
