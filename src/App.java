import elementos.*;
import laboratorio.Laboratorio;

public class App {

	public static void main(String[] args) {

		// Inicialização de elementos
        Oxigenio oxigenio = new Oxigenio();
        Hidrogenio hidrogenioGasoso = new Hidrogenio();
        Hidrogenio hidrogenioLiquido = new Hidrogenio();
        hidrogenioLiquido.setEstado(Estado.LIQUIDO);
        Ferro ferro = new Ferro();
        Sodio sodio = new Sodio();
        Carbono carbono = new Carbono("Carbono", "C", 6, Estado.SOLIDO, 4);
        Agua agua = new Agua();
        Oxigenio oxigenioLiquido = new Oxigenio();
        oxigenioLiquido.setEstado(Estado.LIQUIDO);
        Carbono carbonoLiquido = new Carbono();
        carbonoLiquido.setEstado(Estado.LIQUIDO);
        Ferro ferroGasoso = new Ferro();
        ferroGasoso.setEstado(Estado.GASOSO);
        Sodio sodioLiquido = new Sodio();
        sodioLiquido.setEstado(Estado.LIQUIDO);
        
        Laboratorio meuLaboratorio = new Laboratorio();
        
        // Adicionando elementos ao laboratório
        meuLaboratorio.adicionarElemento(oxigenio);
        meuLaboratorio.adicionarElemento(hidrogenioGasoso);
        meuLaboratorio.adicionarElemento(hidrogenioLiquido);
        meuLaboratorio.adicionarElemento(ferro);
        meuLaboratorio.adicionarElemento(sodio);
        meuLaboratorio.adicionarElemento(carbono);
        meuLaboratorio.adicionarElemento(agua);
        meuLaboratorio.adicionarElemento(oxigenioLiquido);
        meuLaboratorio.adicionarElemento(carbonoLiquido);
        meuLaboratorio.adicionarElemento(ferroGasoso);
        meuLaboratorio.adicionarElemento(sodioLiquido);


        System.out.println("Testes de Reações\n______________________");
        
        // Teste 1: Reação entre oxigênio e hidrogênio (ambos gasosos)
        System.out.println("\n1. Reação O₂ + H₂ (gás):");
        System.out.println(meuLaboratorio.misturar(oxigenio, hidrogenioGasoso));
        
        // Teste 2: Reação entre oxigênio e hidrogênio líquido
        System.out.println("\n2. Reação O₂ + H₂ (Hidrogêgino líquido):");
        System.out.println(meuLaboratorio.misturar(oxigenio, hidrogenioLiquido));
        
        // Teste 3: Reação entre carbono e oxigênio
        System.out.println("\n3. Reação C + O₂:");
        System.out.println(meuLaboratorio.misturar(carbono, oxigenio));
        
        // Teste 4: Reação entre carbono e oxigênio, reação repetida sem ligações de carbono
        System.out.println("\n4. Reação C + O₂ (sem ligações de Carbono)");
        System.out.println(meuLaboratorio.misturar(carbono, oxigenio));
        
        // Teste 5: Reação entre sódio e água
        System.out.println("\n5. Reação Na + H₂O:");
        System.out.println(meuLaboratorio.misturar(sodio, agua));
        
        // Teste 6: Tentativa de reação com elemento não adicionado
        System.out.println("\n6. Tentativa com elemento não adicionado:");
        Hidrogenio hidrogenioNaoAdicionado = new Hidrogenio();
        System.out.println(meuLaboratorio.misturar(oxigenio, hidrogenioNaoAdicionado));
        
        // Teste 7: Valores inválidos para atributos
        System.out.println("\n7. Teste de valores inválidos:");
        try {
            carbono.setFormaLigacoes(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro capturado: " + e.getMessage() + "\n");
        }
        
        // Teste 8: Ferro e oxigênio (oxidação)
        System.out.println("\n8. Reação Fe + O₂ (oxidação):");
        System.out.println(meuLaboratorio.misturar(ferro, oxigenio));
        
        // Teste 9: Hidrogênio e carbono
        System.out.println("\n9. Reação H₂ + C (formação de hidrocarboneto):");
        Carbono carbonoNovo = new Carbono(); // Novo carbono com 4 ligações
        meuLaboratorio.adicionarElemento(carbonoNovo);
        System.out.println(meuLaboratorio.misturar(hidrogenioGasoso, carbonoNovo));
        
        // Teste 10: Hidrogênio e sódio
        System.out.println("\n10. Reação H₂ + Na:");
        System.out.println(meuLaboratorio.misturar(hidrogenioGasoso, sodio));
        
        // Teste 11: Sódio líquido e hidrogênio (deve falhar)
        System.out.println("\n11. Reação H₂ + Na (sódio líquido, deve falhar):");
        System.out.println(meuLaboratorio.misturar(hidrogenioGasoso, sodioLiquido));
        
        // Teste 12: Ferro e água (oxidação lenta)
        System.out.println("\n12. Reação Fe + H₂O (oxidação lenta):");
        Ferro ferroNovo = new Ferro(); // Novo ferro para testar
        meuLaboratorio.adicionarElemento(ferroNovo);
        System.out.println(meuLaboratorio.misturar(ferroNovo, agua));
        
        // Teste 13: Reação entre ferro e carbono
        System.out.println("\n13. Reação Fe + C (carboneto de ferro):");
        Ferro ferroNovo2 = new Ferro();
        Carbono carbonoNovo2 = new Carbono();
        meuLaboratorio.adicionarElemento(ferroNovo2);
        meuLaboratorio.adicionarElemento(carbonoNovo2);
        System.out.println(meuLaboratorio.misturar(ferroNovo2, carbonoNovo2));
        
        // Teste 14: Tentativa de reação entre elementos idênticos (oxigênio)
        System.out.println("\n14. Reação O₂ + O₂ (não deve reagir):");
        Oxigenio oxigenioNovo = new Oxigenio();
        meuLaboratorio.adicionarElemento(oxigenioNovo);
        System.out.println(meuLaboratorio.misturar(oxigenio, oxigenioNovo));
        
        // Teste 15: Restauração de propriedades
        System.out.println("\n15. Teste de restauração de propriedades:");
        Oxigenio ox = new Oxigenio();
        meuLaboratorio.adicionarElemento(ox);
        System.out.println("Eletronegatividade inicial: " + ox.getEletronegatividade());
        ox.setEletronegatividade(1.5);
        System.out.println("Eletronegatividade após alteração: " + ox.getEletronegatividade());
        ox.restaurarEletronegatividade();
        System.out.println("Eletronegatividade após restauração: " + ox.getEletronegatividade() + "\n");
        
        // Exibir histórico completo
        meuLaboratorio.mostrarHistorico();

	}

}
