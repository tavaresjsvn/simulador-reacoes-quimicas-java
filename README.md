# Simulador de Reações Químicas em Java

Este projeto simula reações químicas entre elementos como Oxigênio, Hidrogênio, Carbono, Ferro e Sódio, aplicando conceitos avançados de **Programação Orientada a Objetos (POO)** em Java.

A simulação considera regras reais de combinação química e permite observar os resultados e condições de cada reação dentro de um laboratório virtual.

---

## Funcionalidades

- Representação de elementos químicos como objetos com atributos específicos
- Enumeração de estados físicos (sólido, líquido, gasoso)
- Simulação de reações com base em combinações e condições
- Histórico de reações no laboratório
- Utilização de herança, polimorfismo, composição e encapsulamento

---

## Como executar

1. **Clone ou baixe** este repositório
2. **Abra em sua IDE Java**
3. Compile e execute o arquivo `App.java`

---

## Exemplo de uso

```java
Oxigenio o = new Oxigenio();
o.setEstado(Estado.GASOSO);

Hidrogenio h = new Hidrogenio();
h.setEstado(Estado.GASOSO);

Laboratorio lab = new Laboratorio();
String resultado = lab.misturar(o, h);
System.out.println(resultado); // Água (H₂O)

lab.mostrarHistorico();
```

## Estrutura do Projeto
```
src/
├── elementos/
│   ├── Elemento.java
│   ├── Oxigenio.java
│   ├── Hidrogenio.java
│   ├── Carbono.java
│   ├── Ferro.java
│   ├── Sodio.java
│   ├── Agua.java
│   └── Estado.java
├── laboratorio/
│   └── Laboratorio.java
└── App.java
```

## Resuma de Regras de Reação

| Elementos              | Condição                        | Resultado                        |
|------------------------|----------------------------------|----------------------------------|
| Oxigênio + Hidrogênio  | Ambos GASOSO                    | Água (H₂O)                       |
| Oxigênio + Carbono     | C = SÓLIDO, O = GASOSO          | Dióxido de Carbono (CO₂)         |
| Oxigênio + Ferro       | Qualquer estado                 | Óxido de Ferro (Ferrugem)        |
| Hidrogênio + Carbono   | C = SÓLIDO, H = GASOSO          | Hidrocarboneto (CH₄)             |
| Sódio + Água           | Especial                        | NaOH + H₂ + calor                |
| Elementos iguais       | —                               | Nenhuma reação                   |
| Outros casos           | —                               | Elementos não reagem             |

## Conceitos trabalhados:

Herança com classe abstrata Elemento

Polimorfismo com reagir()

Encapsulamento com atributos privados e validadores

Enum para modelar estados físicos

Composição no uso de Laboratorio

## Autor

Desenvolvido por Josevan Tavares como projeto pessoal para praticar conceitos avançados de Orientação a Objetos em Java