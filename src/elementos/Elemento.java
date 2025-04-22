package elementos;

public abstract class Elemento {

	protected String nome;
	protected String simbolo;
	protected int numeroAtomico;
	protected Estado estado;

	public Elemento() {
		this.nome = "";
		this.simbolo = "";
		this.numeroAtomico = 0;
		this.estado = Estado.SOLIDO;
	}

	public Elemento(String nome, String simbolo, int numeroAtomico, Estado estado) {
		if (numeroAtomico < 0 ) {
			throw new IllegalArgumentException("Número atômico deve ser positivo");
		}
		this.nome = nome;
		this.simbolo = simbolo;
		this.numeroAtomico = numeroAtomico;
		this.estado = estado;
	}

	public abstract String reagir(Elemento elemento);
	
	protected boolean verificarEstados(Elemento elemento, Estado thisEstadoEsperado, Estado elementoEstadoEsperado) {
		return this.getEstado() == thisEstadoEsperado && elemento.getEstado() == elementoEstadoEsperado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public int getNumeroAtomico() {
		return numeroAtomico;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	 public String toString() {
	        return "Elemento: " + nome + " (" + simbolo + "), Número Atômico: " + numeroAtomico + 
	               ", Estado: " + estado;
	    }
	
	
}
