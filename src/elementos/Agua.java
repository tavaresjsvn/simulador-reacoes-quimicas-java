package elementos;

public class Agua extends Elemento{
	
	public Agua() {
		super("Água", "H₂O", 0, Estado.LIQUIDO);
	}

	public Agua(String nome, String simbolo, int numeroAtomico, Estado estado) {
		super(nome, simbolo, numeroAtomico, estado);
	}

	@Override
	public String reagir(Elemento elemento) {
		
		if (elemento instanceof Agua) {
            return "Erro: Nenhuma reação ocorre entre elementos idênticos";
        }
        
        if (elemento instanceof Sodio) {
        	Sodio sodio = (Sodio) elemento;
        	
        	return sodio.reagirComAgua(this);
        }
        
        if (elemento instanceof Ferro) {
        	Ferro ferro = (Ferro) elemento;
        	
        	return ferro.oxidar(this);
        }
        
        return "Erro: Elementos não reagem entre si";
	}

	
}
