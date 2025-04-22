package elementos;

public class Ferro extends Elemento {

	private boolean magnetico;

	public Ferro(String nome, String simbolo, int numeroAtomico, Estado estado) {
		super(nome, simbolo, numeroAtomico, estado);
		
		this.magnetico = true;
	}

	public Ferro() {
		super("Ferro", "Fe", 26, Estado.SOLIDO);
		
		this.magnetico = true;
	}

	@Override
	public String reagir(Elemento elemento) {
	
		if (elemento instanceof Ferro) {
			return  "Erro: Nenhuma reação ocorre entre elementos idênticos";
		}
		
		if ( elemento instanceof Agua) {
			return this.oxidar(elemento);
		}
		
		if (elemento instanceof Carbono) {
			if (this.getEstado() == Estado.SOLIDO && elemento.getEstado() == Estado.SOLIDO) {
				return "Carboneto de Ferro";
			} else {
				return "Erro: Só existe reação se os dois elementos estiverem em estado sólido e em alta temperatura";
			}
		}
		
		if (elemento instanceof Oxigenio) {
			return this.oxidar(elemento);
		}
		
		return "Erro: Elementos não reagem entre si";
	}
	
	public String oxidar(Elemento elemento) {
		
		String velocidade = "";
		boolean reage = false;
		
		if (magnetico == false) {
			return "Erro: Reação falhou pois o ferro está oxidado e sem magnetização!";
		}
		
		if (elemento instanceof Oxigenio) { 
			reage = true;
			
			if (elemento.getEstado() == Estado.GASOSO) {
				velocidade = "rápida";
			} else {
				velocidade = "lenta";
			}
		}
		
		if (elemento instanceof Agua) {
			velocidade = "lenta";
			reage = true;
		}
		
		if (reage) {
			this.setMagnetico(false);
			 return "Óxido de Ferro (Ferrugem) - reação " + velocidade + ". Propriedades magnéticas perdidas";
		}
		
		return "Erro: A Oxidação falhou, o processo só ocorre com a mistura de Ferro com Água ou Oxigênio";
	}

	public boolean isMagnetico() {
		return magnetico;
	}

	public void setMagnetico(boolean magnetico) {
		this.magnetico = magnetico;
	}
	
	public void magnetizar() {
	    this.magnetico = true;
	}

	@Override
	public String toString() {
		return super.toString() + ", Magnético: " + this.magnetico;
	}
	
	

}
