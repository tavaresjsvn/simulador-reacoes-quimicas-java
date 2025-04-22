package elementos;

public class Hidrogenio extends Elemento {

	private boolean inflamavel;

	public Hidrogenio(String nome, String simbolo, int numeroAtomico, Estado estado) {
		super(nome, simbolo, numeroAtomico, estado);
		
		this.inflamavel = true;
	}
	
	public Hidrogenio() {
		super("Hidrogênio", "H", 1, Estado.GASOSO);
		
		this.inflamavel = true;
	}

	@Override
	public String reagir(Elemento elemento){
		
		if (elemento instanceof Hidrogenio) {
			return  "Erro: Nenhuma reação ocorre entre elementos idênticos";
		}
		
		if (elemento instanceof Oxigenio) {
			Oxigenio oxigenio = (Oxigenio) elemento;
			
			this.reagirComOxigenio(oxigenio);
		}
		
		if (elemento instanceof Carbono) {
			Carbono carbono = (Carbono) elemento;
			
			return carbono.reagirComHidrogenio(this);
		}
		
		
		if (elemento instanceof Sodio) {
			if (elemento.getEstado() == Estado.SOLIDO) {
				return "Hidreto de Sódio (NaH)";
			} else {
				return "Erro: Só há reação se o Sódio estiver no estado sólido. Estado nesse experimento -> " + elemento.getEstado();
			}
		}
		
		return "Erro: Elementos não reagem entre si";
	}
	
	public String reagirComOxigenio(Oxigenio oxigenio) {
		if (verificarEstados(oxigenio, Estado.GASOSO, Estado.GASOSO)) {
			
			double novaEletronegatividade = oxigenio.getEletronegatividade() - 0.5;
			oxigenio.setEletronegatividade(novaEletronegatividade);
			this.setInflamavel(false);
			return "Água (H₂O)";
		} else {
			return "Erro: Oxigênio e Hidrogênio só reagem em estado gasoso. Estado dos elementos nesse experimento -> Hidrogênio: " + this.getEstado() + " " + oxigenio.getNome() + ": " + oxigenio.getEstado();
		}
	}

	public boolean isInflamavel() {
		return inflamavel;
	}

	public void setInflamavel(boolean inflamavel) {
		this.inflamavel = inflamavel;
	}
	
	public void tornarInflamavel() {
	    this.inflamavel = true;
	}

	@Override
	public String toString() {
		return super.toString() + ", Inflamável: " + this.inflamavel;
	}
	
}
