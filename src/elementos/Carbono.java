package elementos;

public class Carbono extends Elemento{

	private int formaLigacoes;
	
	public Carbono(String nome, String simbolo, int numeroAtomico, Estado estado, int formaLigacoes) {
		super(nome, simbolo, numeroAtomico, estado);
		
		this.setFormaLigacoes(formaLigacoes);
	}

	public Carbono() {
		super("Carbono", "C", 6, Estado.SOLIDO);
		
		this.formaLigacoes = 4;
	}


	@Override
	public String reagir(Elemento elemento) {
		
		if (elemento instanceof Carbono) {
			return  "Erro: Nenhuma reação ocorre entre elementos idênticos";
		}
		
		if (elemento instanceof Ferro) {
			if (verificarEstados(elemento, Estado.SOLIDO, Estado.SOLIDO)) {
				return "Carboneto de Ferro";
			} else {
				return "Erro: Só existe reação se os dois elementos estiverem em estado sólido e em alta temperatura";
			}
		}
		
		if(elemento instanceof Hidrogenio) {
			Hidrogenio hidrogenio = (Hidrogenio) elemento;
			return reagirComHidrogenio(hidrogenio);
		}
		
		if(elemento instanceof Oxigenio) {
			return this.realizarCombustao(elemento);
		} 
		
		return "Erro: Elementos não reagem entre si";
	}
	
	public String realizarCombustao(Elemento elemento) {
		
		if (verificarEstados(elemento, Estado.SOLIDO, Estado.GASOSO)) {
			
			if (this.formaLigacoes > 0) {
				this.setFormaLigacoes(0);
				return "Ocorreu uma combustão: Dióxido de Carbono (CO₂), Ligações consumidas completamente após a combustão!";
			} else {
				return "Erro: Reação falhou pois o Carbono não tem mais ligações disponíveis";
			}
			
		} else {
			return "Erro: O Carbono deve estar no estado sólido e o Oxigênio no estado gasoso. Estado dos elementos nesse experimento -> Carbono: " + this.getEstado() + " " + elemento.getNome() + ": " + elemento.getEstado();
		}
	}
	
	public String reagirComHidrogenio(Hidrogenio hidrogenio) {
		if (verificarEstados(hidrogenio, Estado.SOLIDO, Estado.GASOSO)) {
			
			if (this.formaLigacoes > 0) {
				this.setFormaLigacoes(this.formaLigacoes - 1);
				return "Hidrocarboneto (CH₄), ligações de Carbono foram perdidas";
			} else {
				return "Erro: Reação falhou pois o Carbono não tem ligações disponíveis";
			}
			
		} else {
			return "Erro: Só há reação se o Hidrogênio estiver no estado gasoso e o Carbono em estado sólido. Estado dos elementos nesse experimento -> Carbono: " + this.getEstado() + " " + hidrogenio.getNome() + ": " + hidrogenio.getEstado();
		}
	}
	

	public int getFormaLigacoes() {
		return formaLigacoes;
	}

	public void setFormaLigacoes(int novasLigacoes) {
		if (novasLigacoes < 0) { 
            this.formaLigacoes = 0;
            throw new IllegalArgumentException("Tentativa de atribuir um número menor que o permitido para ligações de carbono, não pode ser menor que zero - valor atribuido automaticaemnte para 0");
        } else if (novasLigacoes > 4){
            this.formaLigacoes = 4;
            throw new IllegalArgumentException("Tentativa de atribuir um número maior que o permitido para ligações, não pode ser maior que quatro - valor atribuido automaticamente para 4");
        } else {
        	this.formaLigacoes = novasLigacoes;
        }	
	}
	
	public void restaurarLigacoes() {
	    this.formaLigacoes = 4;
	}

	@Override
	public String toString() {
		return super.toString() + ", número de ligações: " + this.formaLigacoes; 
	}
	
	
}
