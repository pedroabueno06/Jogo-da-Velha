import java.util.ArrayList;
import java .util.Random;
public class BancoPerguntas {
    private ArrayList<Perguntas> perguntasIniciante;
    private ArrayList<Perguntas> perguntasIntermediario;
    private ArrayList<Perguntas> perguntasAvancado;
    private Random random;

    public BancoPerguntas() {
        perguntasIniciante = new ArrayList<>();
        perguntasIntermediario = new ArrayList<>();
        perguntasAvancado = new ArrayList<>();
        random = new Random();
        
        inicializarPerguntas();
    }

    //Atributo para inicializar as perguntas:
    private void inicializarPerguntas() {
         //Perguntas para o nível iniciante:
        //Perguntas do capítulo 8 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            perguntasIniciante.add(new Perguntas("1- Em um método de instância, qual palavra-chave pode ser usada para fazer referência explícita ao objeto atual (a instância em que o método está sendo chamado)? Página do Livro: 252.\n", 
                                        new String[] {"a) self.\r\n", "b) current.\r\n", "c) this.\r\n", "d) instance.\r\n"},
                                            3, "Iniciante"));

            perguntasIniciante.add(new Perguntas("2- Qual instrução é utilizada para indicar que ocorreu um problema durante a execução de um programa, lançando assim uma exceção? Página do Livro: 248.\n", 
                                        new String[] {"a) raise.\r\n", "b) throw.\r\n", "c) cath.\r\n", "d) error.\r\n"},
                                            2, "Iniciante"));
            
            perguntasIniciante.add(new Perguntas("3- Qual modificador de acesso restringe o acesso aos membros de uma classe apenas a outros membros da mesma classe, tornando-os inacessíveis diretamente por objetos de outras classes? Página do Livro: 252.\n",
                                        new String[] {"a) protected.\r\n", "b) internal.\r\n", "c) private.\r\n", "d) package.\r\n"},
                                            3, "Iniciante"));

            perguntasIniciante.add(new Perguntas("4- Qual modificador de acesso torna os membros de uma classe acessíveis a partir de qualquer outra classe que tenha uma referência a um objeto dessa classe? Página do Livro: 252.\n",
                                        new String[] {"a) open.\r\n", "b) public.\r\n", "c) global.\r\n", "d) external.\r\n"},
                                            2, "Iniciante"));

            perguntasIniciante.add(new Perguntas("5- Qual palavra-chave é usada para indicar que o valor de uma variável não pode ser alterado depois de ter sido inicializado, tornando-a uma constante? Página do Livro: 269.\n",
                                        new String[] {"a) immutable.\r\n", "b) const.\r\n", "c) final.\r\n", "d) static.\r\n"},
                                            3, "Iniciante"));

        //Perguntas do capítulo 9 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            perguntasIniciante.add(new Perguntas("6- Qual conceito de Programação Orientada a Objetos permite que uma nova classe (subclasse) adquira os membros (atributos e métodos) de uma classe existente (superclasse), promovendo a reutilização de código? Página do Livro: 284.\n",
                                        new String[] {"a) Herança.\r\n", "b) Polimorfismo.\r\n", "c)Abstração.\r\n", "d) Encapsulamento.\r\n"},
                                            1, "Iniciante"));

            perguntasIniciante.add(new Perguntas("7- Qual palavra-chave é usada na declaração de uma classe em Java para indicar que ela está herdando de outra classe? Página do Livro: 287.\n",
                                        new String[] {"a) inherits.\r\n", "b) extends.\r\n", "c) super.\r\n", "d) overrides.\r\n"},
                                            2, "Iniciante"));
            
            perguntasIniciante.add(new Perguntas("8- Em uma hierarquia de herança, como são chamadas a classe da qual outra deriva e a classe que realiza a derivação? Páginas do Livro: 284 a 286 e 297 a 303.\n",
                                        new String[] {"a) Pai e Filho.\r\n", "b) Base e Derivada.\r\n", "c) Superclasse e Subclasse.\r\n", "d) Master e Slave.\r\n"},
                                            3, "Iniciante"));

            perguntasIniciante.add(new Perguntas("9- O Java suporta a criação de uma classe que herda diretamente de duas ou mais superclasses? Páginas do Livro: 284 a 286.\n",
                                        new String[] {"a) Sim.\r\n", "b) Apenas com interfaces.\r\n", "c) Apenas ocm versões mais recentes.\r\n", "d) Não.\r\n"},
                                            4, "Iniciante"));

            perguntasIniciante.add(new Perguntas("10- Qual benefício primário a herança oferece no desenvolvimento de software em relação ao código que é comum a várias classes relacionadas? Página do Livro: 284 a 309.\n",
                                        new String[] {"a) Segurança de código.\r\n", "b) Redução de tempo de execução.\r\n", "c) Rutilização de código.\r\n", "d) Maior acoplamento.\r\n"},
                                            3, "Iniciante"));

        //Perguntas do capítulo 10 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            perguntasIniciante.add(new Perguntas("11- O que é uma classe abstrata em Java? Páginas do Livro: 316 e 317.\n",
                                        new String[] {"a) Classe que não pode ser instânciada diretamente.\r\n", "b) Classe que não implementa todos os dados.\r\n", "c) Classe que só possui métodos privados.\r\n", "d) Classe que não pode ter atributos.\r\n"},
                                            1, "Iniciante"));

            perguntasIniciante.add(new Perguntas("12- O que é uma classe concreta? Página do Livro: 320 a 325.\n",
                                        new String[] {"a) Classe que não possui métodos.\n", "b) Classe que da qual é possível criar objetos.\r\n", "c) Classe que só possui métodos abstratos.\r\n", "d) Classe usada apenas como superclasse.\r\n"},
                                            2, "Iniciante"));   

            perguntasIniciante.add(new Perguntas("13- O que é uma interface em Java? Páginas do Livro: 331 e 332.\n",
                                        new String[] {"a) Clase com todos os métodos implementados.\r\n", "b) Conjunto de variáveis globais.\r\n", "c) Classe concreta com métodos privados.\r\n", "d) Contrato de métodos que uma classe deve implementar.\r\n"},
                                            4, "Iniciante"));   

            perguntasIniciante.add(new Perguntas("14- Qual palavra-chave uma classe usa na sua declaração para especificar que ela se compromete a fornecer implementações para todos os métodos abstratos definidos em uma ou mais interfaces? Páginas do Livro: 331 e 332.\n",
                                        new String[] {"a) extends.\r\n", "b) interface.\r\n", "c) overrides.\r\n", "d) implements.\r\n"},
                                            4, "Iniciante"));

            perguntasIniciante.add(new Perguntas("15- Qual conceito de POO (Programação Orientada a Objeto permite que objetos de diferentes classes relacionadas (que compartilham uma superclasse ou implementam uma interface) sejam tratados de forma genérica através de uma referência de supertipo, e que uma chamada de método para essa referência\r\n" + 
                                                "execute o comportamento apropriado para o tipo real do objeto em tempo de execução? Páginas do Livro: 312 a 314.\n",
                                        new String[] {"a) Herança.\r\n", "b) Encapsulamento.\r\n", "c) Polimorfismo.\r\n", "d) Abstração.\r\n"},
                                            3, "Iniciante"));

         //Perguntas para o nível intermediário:
        //Perguntas do capítulo 8 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            perguntasIntermediario.add(new Perguntas("16- Quais são os nomes comuns para os pares de métodos usados para controlar o acesso de leitura e escrita a variáveis de instância que foram declaradas como privadas? Página do Livro: 259.\n",
                                            new String[] {"a) Readers e writers.\r\n", "b) Acessors e Mutators.\r\n", "c) Getters e Setters.\r\n", "d) Load e Save.\r\n"},
                                                3, "Intermediário"));
            
            perguntasIntermediario.add(new Perguntas("17- Como é chamado o conceito em que uma classe contém referências a objetos de outras classes como seus membros, modelando um relacionamento \"tem um\" (has-a)? Página do Livro: 260.\n",
                                            new String[] {"a) Herança.\r\n", "b) Acoplamento.\r\n", "c) Composição.\r\n", "d) Agregação.\r\n"},
                                                3, "Intermediário"));

            perguntasIntermediario.add(new Perguntas("18- Qual tipo especial em Java é usado para definir um conjunto fixo de constantes nomeadas, como os meses do ano ou os naipes de um baralho? Página do Livro: 262.\n",
                                            new String[] {"a) Enum.\r\n", "b) Static class.\r\n", "c) Macro.\r\n", "d) Constant.\r\n"},
                                                1, "Intermediário"));

            perguntasIntermediario.add(new Perguntas("19- Além de constantes nomeadas, um tipo enum em Java pode conter outros membros de classe tradicionais? Página do Livro: 262.\n",
                                            new String[] {"a) Não.\r\n", "b) Apenas métodos.\r\n", "c) Apenas construtores.\r\n", "d) Sim.\r\n"},
                                                4, "Intermediário"));

            perguntasIntermediario.add(new Perguntas("20- Qual palavra-chave é utilizada para declarar um membro (variável ou método) que pertence à classe em si, e não a instâncias específicas da classe, sendo compartilhado por todos os objetos dessa classe? Páginas do Livro: 265 e 268.\n",
                                            new String[] {"a) Class.\r\n", "b) Static.\r\n", "c) Shared.\r\n", "d) Const.\r\n"},
                                                2, "Intermediário"));
        
        //Perguntas do capítulo 9 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            perguntasIntermediario.add(new Perguntas("21- Explique a diferença conceitual entre o relacionamento \"é um\" (is-a) e o relacionamento \"tem um\" (has-a) no contexto de classes e objetos. Página do Livro: 284.\n",
                                            new String[] {"a) Ambos significam herança.\r\n", "b) 'É um' é uma composição e 'tem um' é uma herança.\r\n", "c) Não há diferença entre eles.\r\n", "d) 'É um' se refere à herança e 'tem um' se refere à composição.\r\n"},
                                                4, "Intermediário"));

            perguntasIntermediario.add(new Perguntas("22- Qual modificador de acesso é utilizado em membros de uma superclasse para torná-los acessíveis diretamente pelas suas subclasses, mas não por classes que não são relacionadas por herança? Página do Livro: 286.\n",
                                            new String[] {"a) private.\r\n", "b) package.\r\n", "c) protected.\r\n", "d) internal.\r\n"},
                                                3, "Intermediário"));
            
            perguntasIntermediario.add(new Perguntas("23- O que acontece quando uma subclasse declara um método com o mesmo nome, tipo de retorno e lista de parâmetros de um método existente em sua superclasse? Página do Livro: 287.\n",
                                            new String[] {"a) O método é ocultado.\r\n", "b) O método é sobrescrito. \r\n", "c) O método é duplicado.\r\n", "d) O método é renomeado.\r\n"},
                                                2, "Intermediário"));

            perguntasIntermediario.add(new Perguntas("24- Qual anotação opcional, mas recomendada, você pode usar em um método de subclasse para indicar que ele tem a intenção de redefinir (sobrescrever) um método da superclasse? Página do Livro: 289 e 290.\n",
                                            new String[] {"a) @override.\r\n", "b) @Overload.\r\n", "c) @Extend.\r\n", "d) @Super.\r\n"},
                                                1, "Intermediário"));

            perguntasIntermediario.add(new Perguntas("25- Como um construtor de uma subclasse deve chamar explicitamente um construtor da sua superclasse direta como a primeira instrução no seu corpo? Página do Livro: 303.\n",
                                            new String[] {"a) super().\r\n", "b) base().\r\n", "c) extends().\r\n", "d) parent().\r\n"},
                                                1, "Intermediário"));

        //Perguntas do capítulo 10 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            perguntasIntermediario.add(new Perguntas("26- Como é chamado o processo em que o método específico a ser executado é determinado em tempo de execução, com base no tipo real do objeto referenciado, e não em tempo de compilação? Páginas do Livro: 313 a 316.\n",
                                            new String[] {"a) Vinculação estática.\r\n", "b) Vinculação dinâmica.\r\n", "c) Encadeamento.\r\n", "d) Overloading.\r\n"},
                                                2, "Intermediário"));

            perguntasIntermediario.add(new Perguntas("27- O que é um método abstrato? Páginas do Livro: 316 e 317. \n",
                                            new String[] {"a) Método declarado, mas sem implementação.\r\n", "b) Método que sempre é private.\r\n.", "c) Método declarado e implementado na superclasse.\r\n", "d) Método opcional nas classes abstratas.\r\n"},
                                                1, "Intermediário"));

            perguntasIntermediario.add(new Perguntas("28- Quais são duas das principais diferenças entre uma classe abstrata e uma interface (considerando o Java antes da versão 8)? Páginas do Livro: 316, 317 e 331 e 332.\n",
                                            new String[] {"a) Interface pode ter váriáveis de instância.\r\n", "b) Classe abstrata não pode ter métodos implementados. \r\n", "c) Classe abstrata pode ter variáveis e métodos implementados; interface não.\r\n", "d) Não há diferença diginifcativa.\r\n"},
                                                3, "Intermediário"));

            perguntasIntermediario.add(new Perguntas("29- Antes do Java SE 8, todos os métodos declarados em uma interface eram implicitamente considerados com quais modificadores? Página do Livro: 340.\n",
                                            new String[] {"a) protected e static.\r\n", "b) public e final.\r\n", "c) public e abstract.\r\n", "d) private e static.\r\n"},
                                                3, "Intermediário"));

            perguntasIntermediario.add(new Perguntas("30- Se uma classe implementa uma interface, mas não fornece implementações concretas para todos os métodos abstratos declarados nessa interface, como essa classe deve ser declarada? Páginas do Livro: 331 e 332.\n",
                                            new String[] {"a) Classe concreta.\r\n", "b) Classe abstrata.\r\n", "c) Classe privada.\r\n", "d) Classe pública.\r\n"},
                                                2, "Intermediário"));

         //Perguntas para o nível avançado:
        //Perguntas do capítulo 8 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            perguntasAvancado.add(new Perguntas("31- Para acessar um membro public static de uma classe, como Math.PI ou Math.random(), qual sintaxe é comumente usada, mesmo que não haja objetos da classe instanciados? Página do Livro: 259.\n",
                                            new String[] {"a) objeto.membro \r\n", "b) this.membro \r\n", "c) NomeClasse.membro \r\n", "d) static.membro \r\n"},
                                                3, "Avançado"));

            perguntasAvancado.add(new Perguntas("32- Quando nenhum modificador de acesso (public, protected, private) é especificado para um membro de classe, qual nível de acesso é aplicado por padrão? Página do Livro: 270.\n",
                                            new String[] {"a) package-private (ou apenas 'package').\r\n", "b) public.\r\n", "c) protected.\r\n", "d) private.\r\n"},
                                                1, "Avançado"));
            
            perguntasAvancado.add(new Perguntas("33- Todos os objetos em Java herdam um método da classe Object que fornece uma representação em formato de texto do objeto. Qual é o nome deste método? Página do Livro: 260.\n",
                                            new String[] {"a) stringify.\r\n", "b) describe.\r\n", "c) toText.\r\n", "d) toString"},
                                                4, "Avançado"));

            perguntasAvancado.add(new Perguntas("34- Para realizar cálculos monetários em Java com alta precisão e evitar problemas de arredondamento típicos de tipos de ponto flutuante (double, float), qual classe na API do Java é recomendada? Página do Livro: 271.\n",
                                            new String[] {"a) DecimalFormat.\r\n", "b) BigDecimal.\r\n", "c) MathPrecision.\r\n", "d) MoneyCalc.\r\n"},
                                                2, "Avançado"));

        //Perguntas do capítulo 9 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            perguntasAvancado.add(new Perguntas("35- Se um método sobrescrito em uma subclasse necessita executar parte da lógica implementada na versão da superclasse, como ele pode chamar explicitamente o método da superclasse? Página do Livro: 284 a 287.\n",
                                            new String[] {"a) parent.NomeDoMetrodo().\r\n", "b) super.NomeDoMetodo().\r\n", "c) base.nomeDoMetodo().\r\n", "d) thi.nomeDoMetodo().\r\n"},
                                                2, "Avançado"));

            perguntasAvancado.add(new Perguntas("36- Os construtores definidos em uma superclasse são automaticamente herdados pelas suas subclasses? Página do Livro: 287.\r\n",
                                            new String[] {"a) Sim.\r\n", "b) Apenas se forem public.\r\n", "c) Não.\r\n", "d) Apenas se forem protected.\r\n"},
                                                3, "Avançado"));

            perguntasAvancado.add(new Perguntas("37- Qual classe, no pacote java.lang, é a raiz de toda a hierarquia de classes em Java, significando que toda classe Java herda dela direta ou indiretamente? Página do Livro: 304.\n",
                                            new String[] {"a) Root.\r\n", "b) Base\r\n", "c) Core.\r\n", "d) Object.\r\n"},
                                                4, "Avançado"));

            perguntasAvancado.add(new Perguntas("38- Cite dois métodos comuns que todas as classes Java herdam da classe Object. Página do Livro: 304.\n",
                                            new String[] {"a) print e compare.\r\n", "b) display e match.\r\n", "c) show e cjeck.\r\n", "d) toString e equals.\r\n"},
                                                4, "Avançado"));

        //Perguntas do capítulo 10 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            perguntasAvancado.add(new Perguntas("39- Interfaces são particularmente úteis para permitir o processamento polimórfico de quais tipos de classes? Página do Livro: 338.\n",
                                            new String[] {"a) Classes não relacionadas que compartilham funcionalidades. -Alternativa correta.\r\n", "b) Apenas classes abstratas.\r\n", "c) Apenas subclasses de uma mesma classe.\r\n", "d) Apenas classes completas.\r\n"},
                                                1, "Avançado"));

            perguntasAvancado.add(new Perguntas("40- Qual recurso introduzido no Java SE 8 permite adicionar novos métodos a uma interface existente, fornecendo uma implementação padrão no corpo da interface, sem a necessidade de modificar todas as classes que já implementam essa interface? Página do Livro: 340.\n",
                                            new String[] {"a) Métodos default.\r\n", "b) Métodos abstract.\r\n", "c) Métodos final.\r\n", "d) Métodos static.\r\n" },
                                                1, "Avançado"));

            perguntasAvancado.add(new Perguntas("A partir do Java SE 8, como é chamada uma interface que contém exatamente um método abstrato? Página do Livro: 341.\n",
                                            new String[] {"a) Interface lambda.\r\n", "b) Interface funcional.\r\n", "c) Interface abstrata.\r\n", "d) interface única.\r\n"},
                                                2, "Avançado"));

            perguntasAvancado.add(new Perguntas("42- O estudo de caso que utiliza a interface Payable demonstra como processar polimorficamente objetos de classes como Invoice e Employee que, embora não relacionadas por herança direta, precisam calcular uma \"quantia a pagar\". Qual método essa interface exige que as classes implementadoras forneçam? Página do Livro: 338.\n",
                                            new String[] {"a) calculateTotal.\r\n", "b) processPayment.\r\n", "c) getPaymentAmount.\r\n", "d) makePayment."},
                                                3, "Avançado"));
    }
    public Perguntas sortearPerguntas(String dificuldade) {
        ArrayList<Perguntas> listaPerguntas;
            switch(dificuldade) {
                case "2": 
                    listaPerguntas = perguntasIniciante;
                    break;
                
                case"3":
                    listaPerguntas = perguntasIntermediario;
                    break;
                
                case "4":
                    listaPerguntas = perguntasAvancado;
                    break;
                
                default:
                    System.out.println("Dificuldade inválida!");
                    return null; //Dificuldade inválida
                
            }
            if (listaPerguntas.isEmpty()) {
                System.out.println("\nNão há perguntas cadastradas para esta dificuldade.");
                    return null; //Retorna null se não houver perguntas cadastradas para a dificuldade especificada
            }
            return listaPerguntas.get(random.nextInt(listaPerguntas.size()));
    }
    
}
