package elementos;

public class Oxigenio extends Elemento {

	private double eletronegatividade;
	
	public Oxigenio(String nome, String simbolo, int numeroAtomico, Estado estado, double eletronegatividade) {
		super(nome, simbolo, numeroAtomico, estado);
		
		this.setEletronegatividade(eletronegatividade);
	}

	public Oxigenio() {
		super("Oxigênio", "O", 8, Estado.GASOSO);

		this.eletronegatividade = 3.5;
	}

	@Override
	public String reagir(Elemento elemento) {
		
		if (elemento instanceof Oxigenio) {
			return  "Erro: Nenhuma reação ocorre entre elementos idênticos";
		}
		
		if (elemento instanceof Hidrogenio) {
			Hidrogenio hidrogenio = (Hidrogenio) elemento;
			
			return hidrogenio.reagirComOxigenio(this);
		}
		
		if (elemento instanceof Carbono) {
			Carbono carbono = (Carbono) elemento;
			
			return carbono.realizarCombustao(this);
		}
		
		if (elemento instanceof Ferro) {
			Ferro ferro = (Ferro) elemento;
			
			return ferro.oxidar(this);
		}
		
		if (elemento instanceof Sodio) {
			Sodio sodio = (Sodio) elemento;
			
			double reducao = sodio.getReatividade() * 0.8;
		    double novaReatividade = sodio.getReatividade() - reducao;
		    sodio.setReatividade(novaReatividade);
		    
			return "Óxido de Sódio(Na₂O)";
		}
		
		
		return "Erro: Elementos não reagem entre si";
	}

	
	public double getEletronegatividade() {
		return eletronegatividade;
	}

	public void setEletronegatividade(double eletronegatividade) {
		if (eletronegatividade < 0.7) {
			this.eletronegatividade = 0.7;
			throw new IllegalArgumentException("Eletronegatividade não pode ser menor que 0.7, valor atribuido automaticamente para 0.7");
		} else if (eletronegatividade > 3.5){
			this.eletronegatividade = 3.5;
			throw new IllegalArgumentException("Eletronegatividade não pode ser maior que 3.5, valor atribuido automaticamente para 3.5");
		} else {
			this.eletronegatividade = eletronegatividade;
		}
	}
	
	public void restaurarEletronegatividade() {
	    this.eletronegatividade = 3.5;
	}

	@Override
	public String toString() {
		return super.toString() + ", Eletronegatividade: " + this.eletronegatividade; 
	}
	
	
}
