package elementos;

public enum Estado {

	SOLIDO("Sólido", "S"),
    LIQUIDO("Líquido", "L"),
    GASOSO("Gasoso", "G");
    
    private final String nome;
    private final String siglaEstado;
    
    private Estado(String nome, String siglaEstado) {
        this.nome = nome;
        this.siglaEstado = siglaEstado;
    }
    
    public String getNome() {
        return nome;
    }
    
    @Override
    public String toString() {
        return nome + " (" + siglaEstado + ")";
    }
}
