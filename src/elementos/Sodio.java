package elementos;

public class Sodio extends Elemento {

private double reatividade;
	
	public Sodio(String nome, String simbolo, int numeroAtomico, Estado estado, double reatividade) {
		super(nome, simbolo, numeroAtomico, estado);
		
		this.setReatividade(reatividade);
	}

	public Sodio() {
		super("Sódio", "Na", 11, Estado.SOLIDO);
		
		this.reatividade = 0.93;
	}

	@Override
	public String reagir(Elemento elemento) {
		
		if (elemento instanceof Sodio) {
			return  "Erro: Nenhuma reação ocorre entre elementos idênticos";
		}
		
		if (elemento instanceof Agua) {
			
			return this.reagirComAgua(elemento);
		} 
		
		if (elemento instanceof Hidrogenio) {
			if (this.getEstado() == Estado.SOLIDO) {
				return "Hidreto de Sódio (NaH)";
			} else {
				return "Erro: Só há reação se o Sódio estiver no estado sólido. Estado nesse experimento -> " + this.getEstado();
			}
		}
		
		if (elemento instanceof Oxigenio) {
			double reducao = this.reatividade * 0.8;
			this.setReatividade(this.reatividade -= reducao);
			return "Óxido de Sódio(Na₂O)";
		}
		
		return "Erro: Elementos não reagem entre si";
	}
	
	public String reagirComAgua(Elemento elemento) {
		this.setReatividade(0.0);
		return "Hidróxido de Sódio (NaOH) + Hidrogênio (H₂) + Calor. A reatividade foi perdida";
	}

	public double getReatividade() {
		return reatividade;
	}

	public void setReatividade(double reatividade) {
		if (reatividade < 0) { 
			this.reatividade = 0.0;
			throw new IllegalArgumentException("Reatividade não pode ser menor que zero, valor atribuido automaticamente para 0.0");
		} else if (reatividade > 0.93){
			this.reatividade = 0.93;
			throw new IllegalArgumentException("Reatividade não pode ser maior que 0.93, valor atribuido automaticamente para 0.93");
		} else {
			this.reatividade = reatividade;
		}
	}
	
	public void restaurarReatividade() {
	    this.reatividade = 0.93;
	}

	@Override
	public String toString() {
		return super.toString() + ", Reatividade: " + reatividade;
	}
	
	
}
