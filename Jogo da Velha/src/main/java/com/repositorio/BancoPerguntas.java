package com.repositorio;
//Imports das classes que componhem o jogo:
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.Explicacao;
import com.Perguntas;

public class BancoPerguntas {
    
    //Método para o jogador encerrar o jogo om a tecla "/" em qualquer momento do jogo:
    public static String lerEntrada (Scanner scanner) {
        String entrada = scanner.nextLine();
            if (entrada.equals ("/")) {
                    System.out.println("\nUma pena você não querer jogar o Deitel VOOX, com isso, o jogo está encerrado.");
                        System.exit(0);
            }
            return entrada;
        }

    private ArrayList<Perguntas> perguntasIniciante;
    private ArrayList<Perguntas> perguntasIntermediario;
    private ArrayList<Perguntas> perguntasAvancado;
    private Random random;
    private String resposta;
    private Thread cronometro;
    private String explicacao;

public BancoPerguntas() {
    perguntasIniciante = new ArrayList<>();
    perguntasIntermediario = new ArrayList<>();
    perguntasAvancado = new ArrayList<>();
    random = new Random();
        
    inicializarPerguntas();
}

    //Atributo para inicializar as perguntas:
    private void inicializarPerguntas() {
        Explicacao explicacao = new Explicacao("");
         //Perguntas para o nível iniciante:
        //Perguntas do capítulo 8 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            Perguntas pergunta1 = new Perguntas("1- Em um método de instância, qual palavra-chave pode ser usada para fazer referência explícita ao objeto atual (a instância em que o método está sendo chamado)? Página do Livro: 252.\n", 
                                        new String[] {"a) self.\r\n", "b) current.\r\n", "c) this.\r\n", "d) instance.\r\n"},
                                            3, "Iniciante", "", "", null, false);
                                                pergunta1.setExplicacao("=== Explicações sobre a pergunta 1: ===\n" +
                                                "\na linguagem de programação “Java”, quando um método de instância é executado, o mesmo manipula as variáveis e chama outros métodos associados ao objeto que o invocou." +
                                                "Quando há ambiguidade entre variáveis locais e variáveis de instância com o mesmo nome, além disso, utiliza-se um recurso que faz com que possamos diferenciar claramente qual " + 
                                                " elemento está sendo referenciado. Este recurso é especialmente útil em construtores, onde parâmetros frequentemente possuem os mesmo nomes das variáveis de instância. Além disso," + 
                                                " cada objeto possui sua própria cópia de variáveis, enquanto os métodos são compartilhados por todos os objetos da mesma classe.\n");
                                                perguntasIniciante.add(pergunta1);

            Perguntas pergunta2 = new Perguntas("2- Qual instrução é utilizada para indicar que ocorreu um problema durante a execução de um programa, lançando assim uma exceção? Página do Livro: 248.\n", 
                                        new String[] {"a) raise.\r\n", "b) throw.\r\n", "c) cath.\r\n", "d) error.\r\n"},
                                            2, "Iniciante", "", "", null, false);
                                                pergunta2.setExplicacao("=== Explicações sobre a pergunta 2: ===\\n" + 
                                                "A instrução é utilizada para lançar exceções a fim de indicar que houve um problema. Além disso, quando uma é lançada, o fluxo normal do programa é interrompido e assim o"+
                                                " controle é transferido para o bloco try-catch mais próximo que possa tratar a exceção. Também, a palavra-chave é o oposto de “Catch”.\n");
                                                perguntasIniciante.add(pergunta2);
            
            Perguntas pergunta3 = new Perguntas("3- Qual modificador de acesso restringe o acesso aos membros de uma classe apenas a outros membros da mesma classe, tornando-os inacessíveis diretamente" +
                                                " por objetos de outras classes? Página do Livro: 252.\n",
                                        new String[] {"a) protected.\r\n", "b) internal.\r\n", "c) private.\r\n", "d) package.\r\n"},
                                            3, "Iniciante", "", "", null, false);
                                            pergunta3.setExplicacao("=== Explicações sobre a pergunta 3: ===\n" +
                                            "Dentro de uma classe, alguns componentes são destinados exclusivamente ao seu funcionamento interno e não podem ser acessados de forma direta por outros elementos externos." +
                                            " Essa separação oferece garantia de que quem utiliza a classe interage apenas com os serviços que a mesma oferece, sem precisar conhecer ou interferir na maneira como suas" +
                                            " operações são realizadas. Quando há tentativas de acessar diretamente partes internas restritas da classe, o compilador impede a ação, assim exibindo mensagens de erro para" +
                                            " sinalizar que esse tipo de acesso não é permitido. É o nível de acesso mais privado.\n");
                                            perguntasIniciante.add(pergunta3);


            Perguntas pergunta4 = new Perguntas("4- Qual modificador de acesso torna os membros de uma classe acessíveis a partir de qualquer outra classe que tenha uma referência a um objeto dessa classe? Página do Livro: 252.\n",
                                        new String[] {"a) open.\r\n", "b) public.\r\n", "c) global.\r\n", "d) external.\r\n"},
                                            2, "Iniciante", "", "", null, false);
                                            pergunta4.setExplicacao("=== Explicações sobre a pergunta 4: ===\n" +
                                            " Em uma classe, alguns componentes são disponibilizados para que outras partes do programa possam utilizá-los, funcionando como a interface que expõe os serviços  oferecidos." +
                                            " Esses elementos acessíveis permitem que quem utilizar a classe consiga interagir com suas funcionalidades, sem a necessidade de conhecer ou modificar a forma como as tarefas" +
                                            " são executadas internamente. Define a interface pública da classe.\n");
                                            perguntasIniciante.add(pergunta4);


            Perguntas pergunta5 = new Perguntas("5- Qual palavra-chave é usada para indicar que o valor de uma variável não pode ser alterado depois de ter sido inicializado, tornando-a uma constante? Página do Livro: 269.\n",
                                        new String[] {"a) immutable.\r\n", "b) const.\r\n", "c) final.\r\n", "d) static.\r\n"},
                                            3, "Iniciante", "", "", null, false);
                                            pergunta5.setExplicacao("=== Explicações sobre a pergunta 5: ===\n" +
                                            "Dentro da Programação Orientada a Objetos (POO), é muito comum que certas variáveis precisam manter um valor fixo e que não seja necessário fazer mudanças após serem " +
                                            " inicializadas, assim garantindo maior segurança e previsibilidade ao código. Esse conceito reforça certas práticas que são consideradas importantes, como o princípio" +
                                            " do menor privilégio, que busca restringir alterações indevidas a dados sensíveis ou críticos.\n");
                                            perguntasIniciante.add(pergunta5);

        //Perguntas do capítulo 9 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            Perguntas pergunta6 = new Perguntas("6- Qual conceito de Programação Orientada a Objetos permite que uma nova classe (subclasse) adquira os membros (atributos e métodos) de uma classe existente (superclasse)," +
                                                " promovendo a reutilização de código? Página do Livro: 284.\n",
                                        new String[] {"a) Herança.\r\n", "b) Polimorfismo.\r\n", "c) Abstração.\r\n", "d) Encapsulamento.\r\n"},
                                            1, "Iniciante", "", "", null, false);
                                            pergunta6.setExplicacao("=== Explicações sobre a pergunta 6: ===\n" +
                                            "O conceito de POO permite que uma nova classe possa adquirir atributos e comportamentos já definidos em uma classe já existente, assim facilitando a reutilização e a organização" +
                                            " do código. A classe mais geral fornece características comuns que podem ser compartilhadas por diversas outras classes mais específicas, que, por sua vez, podem estender," +
                                            "especializar ou até realizar a modificação desses comportamentos. Relacionamento \"é um\".\n");
                                            perguntasIniciante.add(pergunta6);

            Perguntas pergunta7 = new Perguntas("7- Qual palavra-chave é usada na declaração de uma classe em Java para indicar que ela está herdando de outra classe? Página do Livro: 287.\n",
                                        new String[] {"a) inherits.\r\n", "b) extends.\r\n", "c) super.\r\n", "d) overrides.\r\n"},
                                            2, "Iniciante", "", "", null, false);
                                            pergunta7.setExplicacao("=== Explicações sobre a pergunta 7: ===\n" +
                                            "Essa palavra-chave é utilizada quando queremos declarar uma classe para assim estabelecer um relacionamento onde a nova classe (Subclasse) passa a ser uma especialização de uma" +
                                            " classe (Superclasse) já existente, ou seja, ela passa a herdar os comportamentos e atributos definidos na classe original.\n");
                                            perguntasIniciante.add(pergunta7);

            Perguntas pergunta8 = new Perguntas("8- Em uma hierarquia de herança, como são chamadas a classe da qual outra deriva e a classe que realiza a derivação? Páginas do Livro: 284 a 286 e 297 a 303.\n",
                                        new String[] {"a) Pai e Filho.\r\n", "b) Base e Derivada.\r\n", "c) Superclasse e Subclasse.\r\n", "d) Master e Slave.\r\n"},
                                            3, "Iniciante", "", "", null, false);
                                            pergunta8.setExplicacao("=== Explicações sobre a pergunta 8: ===\n" +
                                            "Dentro da hierarquia de herança, a classe da qual outra deriva é chamada de classe mais geral, pois define características e comportamentos comuns que podem ser reutilizados." +
                                            " Já a classe que realiza derivação é a classe mais específica, pois amplia ou adapta esses comportamentos para representar um tipo de subconjunto com características adicionais." +
                                            " Esse tipo de relacionamento permite com que o programador possa reaproveitar o código e a criação de estruturas organizadas e especializadas.\n");
                                            perguntasIniciante.add(pergunta8);

            Perguntas pergunta9 = new Perguntas("9- O Java suporta a criação de uma classe que herda diretamente de duas ou mais superclasses? Páginas do Livro: 284 a 286.\n",
                                        new String[] {"a) Sim.\r\n", "b) Apenas com interfaces.\r\n", "c) Apenas ocm versões mais recentes.\r\n", "d) Não.\r\n"},
                                            4, "Iniciante", "", "", null, false);
                                            pergunta9.setExplicacao("=== Explicações sobre a pergunta 9: ===\n" +
                                            "Em Java, uma classe pode herdar de forma direta apenas uma única superclasse, pois a linguagem adota o modelo de herança única, no qual cada subclasse estende exatamente uma" +
                                            " superclasse direta. Embora não permite herança múltipla de classe, o Java possibilita que uma classe implemente diversas interfaces, oferecendo assim uma maneira alternativa" +
                                            " e segura de alcançar muitos dos benefícios associados à herança múltipla.\n");
                                            perguntasIniciante.add(pergunta9);

            Perguntas pergunta10 = new Perguntas("10- Qual benefício primário a herança oferece no desenvolvimento de software em relação ao código que é comum a várias classes relacionadas? Página do Livro: 284 a 309.\n",
                                        new String[] {"a) Segurança de código.\r\n", "b) Redução de tempo de execução.\r\n", "c) Rutilização de código.\r\n", "d) Maior acoplamento.\r\n"},
                                            3, "Iniciante", "", "", null, false);
                                            pergunta10.setExplicacao("=== Explicações sobre a pergunta 10: ===\n" +
                                            "Permite que o código comum seja escrito apenas uma vez." + "\n");
                                            perguntasIniciante.add(pergunta10);

        //Perguntas do capítulo 10 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            Perguntas pergunta11 = new Perguntas("11- O que é uma classe abstrata em Java? Páginas do Livro: 316 e 317.\n",
                                        new String[] {"a) Classe que não pode ser instânciada diretamente.\r\n", "b) Classe que não implementa todos os dados.\r\n", "c) Classe que só possui métodos privados.\r\n", "d) Classe que não pode ter atributos.\r\n"},
                                            1, "Iniciante", "", "", null, false);
                                            pergunta11.setExplicacao("=== Explicações sobre a pergunta 11: ===\n" +
                                            "Este tipo de classe serve como um modelo para outras, definindo atributos e comportamentos comuns, mas sem fornecer implementações completas. Por isso, não é possível criar" +
                                            "objetos diretamente a partir dela. Suas subclasses devem implementar os métodos que faltam para que possam ser utilizados normalmente na criação de objetos. Uma classe que" +
                                            "muitas vezes está incompleta, assim sendo utilizada como uma superclasse.\n");
                                            perguntasIniciante.add(pergunta11);

            Perguntas pergunta12 = new Perguntas("12- O que é uma classe concreta? Página do Livro: 320 a 325.\n",
                                        new String[] {"a) Classe que não possui métodos.\n", "b) Classe que da qual é possível criar objetos.\r\n", "c) Classe que só possui métodos abstratos.\r\n", "d) Classe usada apenas como superclasse.\r\n"},
                                            2, "Iniciante", "", "", null, false);
                                            pergunta12.setExplicacao("=== Explicações sobre a pergunta 12: ===\n" + 
                                            "Este é aquele tipo de classe que estende uma classe abstrata e fornece implementações completas para todos os métodos herdados. Como nos exemplos, diversas subclasses" +
                                            " como SalariedEmployee, HourlyEmployee, CommissionEmployee e BasePlusComissionEmployee que estão no capítulo 10 do livro Java: Como Programar, implementam o método" +
                                            " earnings, que era abstrato na superclasse Employee, além de outros métodos próprios e utilizam funcionalidades através de chamadas aos métodos da superclasse," +
                                            " como toString. Este processo destaca-se pelo uso da herança, sobrescrita de métodos e reutilização de códigos.\n");
                                            perguntasIniciante.add(pergunta12);

            Perguntas pergunta13 = new Perguntas("13- O que é uma interface em Java? Páginas do Livro: 331 e 332.\n",
                                        new String[] {"a) Clase com todos os métodos implementados.\r\n", "b) Conjunto de variáveis globais.\r\n", "c) Classe concreta com métodos privados.\r\n", "d) Contrato de métodos que uma classe deve implementar.\r\n"},
                                            4, "Iniciante", "", "", null, false);
                                            pergunta13.setExplicacao("=== Explicações sobre a pergunta 13: ===\n" +
                                            "Em Java, uma interface define um conjunto de métodos que diferentes classes podem implementar, mesmo que não tenham relação entre si, permitindo que sejam" +
                                            " tratados de maneira uniforme. Ela estabelece uma forma padronizada de interação entre objetos, semelhante aos controles de um rádio, que determinam o que" +
                                            " pode ser feito, mas não como será feito. Interfaces não possuem implementações concretas, apenas declarações de métodos e constantes, e são utilizadas" +
                                            " para garantir que classes distintas compartilhem comportamentos comuns, assim possibilitando o processamento polimórfico desses desses objetos.\n");
                                            perguntasIniciante.add(pergunta13);

            Perguntas pergunta14 = new Perguntas("14- Qual palavra-chave uma classe usa na sua declaração para especificar que ela se compromete a fornecer implementações para todos os métodos abstratos" +
                                                " definidos em uma ou mais interfaces? Páginas do Livro: 331 e 332.\n",
                                        new String[] {"a) extends.\r\n", "b) interface.\r\n", "c) overrides.\r\n", "d) implements.\r\n"},
                                            4, "Iniciante", "", "", null, false);
                                            pergunta14.setExplicacao("=== Explicações sobre a pergunta 14: ===\n" +
                                            "Em Java, quando uma classe deseja garantir que irá fornecer as implementações de todos os métodos definidos por uma ou mais interfaces, ela deve" +
                                            " indicar de forma explícita essa intenção logo na linha de sua declaração, seguida pelo nome da interface. Esse compromisso é essencial, pois o" +
                                            " compilador verifica se todos os métodos exigidos foram devidamente implementados; caso contrário, a classe deve ser declarada como abstrata." +
                                            " Usada após a cláusula extends (se houver).\n");
                                            perguntasIniciante.add(pergunta14);

            Perguntas pergunta15 = new Perguntas("15- Qual conceito de POO (Programação Orientada a Objetos) permite que objetos de diferentes classes relacionadas (que compartilham uma superclasse ou implementam uma interface) sejam tratados de forma genérica através de uma" + 
                                                " através de uma referência de supertipo, e que uma chamada de método para essa referência execute o comportamento apropriado para o tipo real do objeto em tempo de execução? Páginas do Livro: 312 a 314.\n",
                                        new String[] {"a) Herança.\r\n", "b) Encapsulamento.\r\n", "c) Polimorfismo.\r\n", "d) Abstração.\r\n"},
                                            3, "Iniciante", "", "", null, false);
                                            pergunta15.setExplicacao("=== Explicações sobre a pergunta 15: ===\n" +
                                            "Esse conceito permite que objetos de diferentes classes, mas que compartilham uma superclasse ou interface, sejam tratados de forma genérica." +
                                            " Mesmo usando uma referência do tipo mais real do objeto, definido em tempo de execução. Isso acaba por facilitar a criação de sistemas" +
                                            " flexíveis, onde novas classes podem ser adicionadas com pouca ou nenhuma alteração do código já existente. Significa \"muitas formas\".\n");
                                            perguntasIniciante.add(pergunta15);

         //Perguntas para o nível intermediário:
        //Perguntas do capítulo 8 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            Perguntas pergunta16 = new Perguntas("16- Quais são os nomes comuns para os pares de métodos usados para controlar o acesso de leitura e escrita a variáveis de instância que foram declaradas como privadas? Página do Livro: 259.\n",
                                            new String[] {"a) Readers e writers.\r\n", "b) Acessors e Mutators.\r\n", "c) Getters e Setters.\r\n", "d) Load e Save.\r\n"},
                                                3, "Intermediário", "", "", null, false);
                                                pergunta16.setExplicacao("=== Explicações sobre a pergunta 16: ===\n" +
                                                "Em diversas classes, são criados métodos específicos para alterar e consultar os valores de suas variáveis internas, assim permitindo" +
                                                " que outras partes do programa interajam com esses dados de forma controlada. Esses métodos, por sua vez, são importantes pois permitem" +
                                                " a validação sobre as alterações, garantindo, por exemplo, que valores inválidos não sejam atribuídos, como um dia inexistente em uma" +
                                                " data ou peso negativo. Essa abordagem melhora da manutenção do código, assim facilitando a depuração e promove boas práticas no" +
                                                " desenvolvimento, pois centraliza as operações de modificação e acesso, fazendo com que problemas que poderiam surgir caso as" +
                                                " variáveis fossem manipuladas diretamente sejam evitados. Pense em como você definiria (alteraria) ou obteria (faria a leitura de) um valor.\n");
                                                perguntasIntermediario.add(pergunta16);
            
            Perguntas pergunta17 = new Perguntas("17- Como é chamado o conceito em que uma classe contém referências a objetos de outras classes como seus membros, modelando um relacionamento \"tem um\" (has-a)? Página do Livro: 260.\n",
                                            new String[] {"a) Herança.\r\n", "b) Acoplamento.\r\n", "c) Composição.\r\n", "d) Agregação.\r\n"},
                                                3, "Intermediário", "", "", null, false);
                                                pergunta17.setExplicacao("=== Explicações sobre a pergunta 17: ===\n" +
                                                "Em diversos casos, uma classe necessita incorporar objetos de outras classes como parte de sua estrutura, estabelecendo uma relação em que um" +
                                                " objeto é composto por outros. Esse tipo de organização permite que um objeto faça utilização de funcionalidades ou dados de outros objetos," +
                                                " promovendo uma modelagem mais realista e modular. Por exemplo, ao criar um registro de um funcionário, é possível associar a ele objetos que" +
                                                " representam sua data de nascimento e data de contratação, fazendo com que facilite o gerenciamento dessas informações. É uma alternativa à" +
                                                " herança para reutilização de código.\n");
                                                perguntasIntermediario.add(pergunta17);

            Perguntas pergunta18 = new Perguntas("18- Qual tipo especial em Java é usado para definir um conjunto fixo de constantes nomeadas, como os meses do ano ou os naipes de um baralho? Página do Livro: 262.\n",
                                            new String[] {"a) Enum.\r\n", "b) Static class.\r\n", "c) Macro.\r\n", "d) Constant.\r\n"},
                                                1, "Intermediário", "", "", null, false);
                                                pergunta18.setExplicacao("=== Explicações sobre a pergunta 18: ===\n" +
                                                "Em muitas situações, é útil definir um conjunto fixo de constantes que fazem a representação de valores específicos dentro de um contexto," +
                                                " como status, categorias ou opções. Esse conjunto pode ser estruturado de forma a incluir, além dos próprios identificadores, atributos" +
                                                " adicionais, e comportamentos, como variáveis, métodos e até construtores, oferecendo uma solução organizada e segura para representar" +
                                                " essas informações. Dessa maneira cada constante pode ter seus próprios dados associados e métodos para acessá-los,  assim facilitando" +
                                                " operações como iteração sobre todas as opções disponíveis ou obtenção de descrições específicas.\n");
                                                perguntasIntermediario.add(pergunta18);

            Perguntas pergunta19 = new Perguntas("19- Além de constantes nomeadas, um tipo enum em Java pode conter outros membros de classe tradicionais? Página do Livro: 262.\n",
                                            new String[] {"a) Não.\r\n", "b) Apenas métodos.\r\n", "c) Apenas construtores.\r\n", "d) Sim.\r\n"},
                                                4, "Intermediário", "", "", null, false);
                                                pergunta19.setExplicacao("=== Explicações sobre a pergunta 19: ===\n" +
                                                "Em Java é possível fazer a expansão da funcionalidade de determinados tipos através da inclusão de componentes adicionais além dos valores" +
                                                "tradicionais. Isso permite que cada elemento desse tipo carregue informações específicas e execute comportamentos próprios, seguindo certas" +
                                                " regras importantes que oferecem garantia sobre a integridade do código. Pense se eles podem ter construtores, campos ou métodos.\n");
                                                perguntasIntermediario.add(pergunta19);

            Perguntas pergunta20 = new Perguntas("20- Qual palavra-chave é utilizada para declarar um membro (variável ou método) que pertence à classe em si, e não a instâncias específicas da classe, " +
                                                "sendo compartilhado por todos os objetos dessa classe? Páginas do Livro: 265 e 268.\n",
                                            new String[] {"a) Class.\r\n", "b) Static.\r\n", "c) Shared.\r\n", "d) Const.\r\n"},
                                                2, "Intermediário", "", "", null, false);
                                                pergunta20.setExplicacao("=== Explicações sobre a pergunta 20: ===\n" +
                                                "Em algumas situações, é preciso que determinadas informações sejam compartilhadas entre todos os objetos de uma mesma classe," +
                                                " evitando a duplicação desnecessária de dados. Para isso, a linguagem Java oferece ao usuário um mecanismo que permite associar atributos" +
                                                " e comportamentos diretamente à classe, em vez de vinculá-los a instâncias específicas. Esse recurso também facilita o acesso a membros" +
                                                " da classe sem a necessidade de fazer a criação objetos, sendo amplamente utilizado em diversas aplicações, como na contagem de instâncias" +
                                                " criadas ou no fornecimento de utilitários matemáticos.\n");
                                                perguntasIntermediario.add(pergunta20);
        
        //Perguntas do capítulo 9 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            Perguntas pergunta21 = new Perguntas("21- Explique a diferença conceitual entre o relacionamento \"é um\" (is-a) e o relacionamento \"tem um\" (has-a) no contexto de classes e objetos. Página do Livro: 284.\n",
                                            new String[] {"a) Ambos significam herança.\r\n", "b) 'É um' é uma composição e 'tem um' é uma herança.\r\n", "c) Não há diferença entre eles.\r\n", "d) 'É um' se refere à herança e 'tem um' se refere à composição.\r\n"},
                                                4, "Intermediário", "", "", null, false);
                                                pergunta21.setExplicacao("=== Explicações sobre a pergunta 21: ===\n" +
                                                "Dentro da POO, existem dois tipos fundamentais de relacionamento entre classes: um deles ocorre quando uma classe deriva de outra, assim" +
                                                " adquirindo seus comportamentos e características e podendo especializá-los conforme necessário; já o outro tipo de relacionamento vem a" +
                                                " ocorrer quando uma classe inclui referências a objetos de outras classes como parte de sua estrutura, compondo-se desses elementos para" +
                                                " formar funcionalidades mais complexas.\n");
                                                perguntasIntermediario.add(pergunta21);

            Perguntas pergunta22 = new Perguntas("22- Qual modificador de acesso é utilizado em membros de uma superclasse para torná-los acessíveis diretamente pelas suas subclasses," +
                                                " mas não por classes que não são relacionadas por herança? Página do Livro: 286.\n",
                                            new String[] {"a) private.\r\n", "b) package.\r\n", "c) protected.\r\n", "d) internal.\r\n"},
                                                3, "Intermediário", "", "", null, false);
                                                pergunta22.setExplicacao("=== Explicações sobre a pergunta 22: ===\n" +
                                                "Na programação orientada a objetos, existe um modificador de acesso que proporciona um nível intermediário de visibilidade, ou seja," +
                                                "ele permite que membros de uma superclasse sejam acessados diretamente pelas suas subclasses e por outras classes que pertencem ao" +
                                                " mesmo pacote. Um nível de acesso entre public e private.\n");
                                                perguntasIntermediario.add(pergunta22);
            
            Perguntas pergunta23 = new Perguntas("23- O que acontece quando uma subclasse declara um método com o mesmo nome, tipo de retorno e lista de parâmetros de um método existente em sua superclasse? Página do Livro: 287.\n",
                                            new String[] {"a) O método é ocultado.\r\n", "b) O método é sobrescrito. \r\n", "c) O método é duplicado.\r\n", "d) O método é renomeado.\r\n"},
                                                2, "Intermediário", "", "", null, false);
                                                pergunta23.setExplicacao("===Explicações sobre a pergunta 23: ===\n" +
                                                "Quando uma subclasse faz a declaração de um método com o mesmo nome, tipo de retorno e lista de parâmetros de um método existente" +
                                                " na sua superclasse, a implementação definida na subclasse passa a ser utilizada quando métodos desse nome são chamados em objetos" +
                                                " da subclasse. Isso permite que a subclasse adapte ou faça modificações sobre o comportamento herdado da superclasse para atender às" +
                                                " suas necessidades específicas, promovendo a reutilização de código e a especialização funcional.\n");
                                                perguntasIntermediario.add(pergunta23);

            Perguntas pergunta24 = new Perguntas("24- Qual anotação opcional, mas recomendada, você pode usar em um método de subclasse para indicar que ele tem a intenção de redefinir (sobrescrever) um método da superclasse? Página do Livro: 289 e 290.\n",
                                            new String[] {"a) @override.\r\n", "b) @Overload.\r\n", "c) @Extend.\r\n", "d) @Super.\r\n"},
                                                1, "Intermediário", "", "", null, false);
                                                pergunta24.setExplicacao("=== Explicações sobre a pergunta 24: ===\n" +
                                                "Uma prática que é recomendada ao realizar a redefinição de um método herdado de uma superclasse é utilizar uma anotação específica" +
                                                "antes da declaração do método. Essa anotação serve como um tipo de instrução ao compilador, indicando que a intenção é substituir" +
                                                " um método existente na hierarquia de classes. Caso a assinatura do método declarado na subclasse não corresponda de forma exata" +
                                                " à do método na superclasse o compilador emitirá uma mensagem de erro, assim ajudando a evitar falhas sutis no programa.\n");
                                                perguntasIntermediario.add(pergunta24);

            Perguntas pergunta25 = new Perguntas("25- Como um construtor de uma subclasse deve chamar explicitamente um construtor da sua superclasse direta como a primeira instrução no seu corpo? Página do Livro: 303.\n",
                                            new String[] {"a) super().\r\n", "b) base().\r\n", "c) extends().\r\n", "d) parent().\r\n"},
                                                1, "Intermediário", "", "", null, false);
                                                pergunta25.setExplicacao("=== Explicações sobre a pergunta 25: ===\n" +
                                                "Quando um construtor de uma subclasse precisa garantir que os atributos herdados da superclasse consigam ser devidamente inicializados," +
                                                " assim ele deve invocar, como sua primeira instrução, um construtor da superclasse direta. Isso estabelece uma cadeia de chamadas entre os" +
                                                " construtores, na qual cada um executa a inicialização das partes correspondentes do objeto. Se essa chamada não for feita de forma que fique" +
                                                " explicita, o compilador insere automaticamente uma invocação ao construtor sem argumentos da superclasse. Uma palavra-chave especial seguida" +
                                                " pelos argumentos do construtor da superclasse.\n");
                                                perguntasIntermediario.add(pergunta25);

        //Perguntas do capítulo 10 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            Perguntas pergunta26 = new Perguntas("26- Como é chamado o processo em que o método específico a ser executado é determinado em tempo de execução, com base no tipo real do objeto referenciado," +
                                                " e não em tempo de compilação? Páginas do Livro: 313 a 316.\n",
                                            new String[] {"a) Vinculação estática.\r\n", "b) Vinculação dinâmica.\r\n", "c) Encadeamento.\r\n", "d) Overloading.\r\n"},
                                                2, "Intermediário", "", "", null, false);
                                                pergunta26.setExplicacao("=== Explicações sobre a pergunta 26: ===\n" +
                                                "Esse processo ocorre quando um método utilizando uma variável de uma superclasse ou interface, o programa decide qual versão do método" +
                                                "executar com base no tipo de real do objeto que está sendo referenciado, e não no tipo da variável . Assim, mesmo utilizando uma referência" +
                                                " genérica, o comportamento executado será o mais específico, correspondente à classe concreta do objeto em tempo de execução. Também conhecido" +
                                                " como vinculação tardia.\n");
                                                perguntasIntermediario.add(pergunta26);

            Perguntas pergunta27 = new Perguntas("27- O que é um método abstrato? Páginas do Livro: 316 e 317. \n",
                                            new String[] {"a) Método declarado, mas sem implementação.\r\n", "b) Método que sempre é private.\r\n.", "c) Método declarado e implementado na superclasse.\r\n", "d) Método opcional nas classes abstratas.\r\n"},
                                                1, "Intermediário", "", "", null, false);
                                                pergunta27.setExplicacao("=== Explicações sobre a pergunta 27: ===\n" +
                                                "Esse tipo de método é definido dentro de classes que vem a servir como modelos, indicando comportamentos que devem ser implementados pelas subclasses." +
                                                " Ele especifica o que precisa ser feito, mas deixa para as subclasses a responsabilidade de fornecer os detalhes da execução. Além disso, é um método" +
                                                " declarado em uma classe abstrata (ou interface) sem uma implementação no corpo da superclasse.\n");
                                                perguntasIntermediario.add(pergunta27);

            Perguntas pergunta28 = new Perguntas("28- Quais são duas das principais diferenças entre uma classe abstrata e uma interface (considerando o Java antes da versão 8)? Páginas do Livro: 316, 317 e 331 e 332.\n",
                                            new String[] {"a) Interface pode ter váriáveis de instância.\r\n", "b) Classe abstrata não pode ter métodos implementados. \r\n", "c) Classe abstrata pode ter variáveis e métodos implementados; interface não.\r\n", "d) Não há diferença diginifcativa.\r\n"},
                                                3, "Intermediário", "", "", null, false);
                                                pergunta28.setExplicacao("Explicações sobre a pergunta 28: ===\n" +
                                                "As classes abstratas e interfaces são mecanismos que promovem a reutilização de código e polimorfismo em Java. As classes abstratas servem como" +
                                                " superclasses que compartilham atributos e comportamentos comuns, permitindo herança e exigindo que as subclasses sobrescrevam métodos abstratos" +
                                                " para que possam completar sua funcionalidade. Já as interfaces fazem a definição de contratos que garantem que classes distintas, sem relação" +
                                                " de herança, implementem os mesmos métodos, permitindo que sejam tratadas de forma polimórfica. Pense em variáveis de instância e implementações" +
                                                " padrão de métodos.\n");
                                                perguntasIntermediario.add(pergunta28);

            Perguntas pergunta29 = new Perguntas("29- Antes do Java SE 8, todos os métodos declarados em uma interface eram implicitamente considerados com quais modificadores? Página do Livro: 340.\n",
                                            new String[] {"a) protected e static.\r\n", "b) public e final.\r\n", "c) public e abstract.\r\n", "d) private e static.\r\n"},
                                                3, "Intermediário", "", "", null, false);
                                                pergunta29.setExplicacao("=== Explicações sobre a pergunta 29: ===\n" +
                                                "Antes do Java SE 8, todas as interfaces na linguagem Java era restritas a declarar métodos que especificaram apenas as operações que uma classe" +
                                                " deveria realizar, sem permitir qualquer detalhe de como essas operações que a classe deveria realizar, sem dar permissão a qualquer detalhe de como essas" +
                                                " operações seriam implementadas. Por isso, os métodos em interfaces eram sempre considerados como modificadores que indicavam que deveriam ser públicos e sem " +
                                                " implementação, ou seja, voltados apenas para definição e obrigatoriedade de implementação pelas classes.\n");
                                                perguntasIntermediario.add(pergunta29);

            Perguntas pergunta30 = new Perguntas("30- Se uma classe implementa uma interface, mas não fornece implementações concretas para todos os métodos abstratos declarados nessa interface," +
                                                " como essa classe deve ser declarada? Páginas do Livro: 331 e 332.\n",
                                            new String[] {"a) Classe concreta.\r\n", "b) Classe abstrata.\r\n", "c) Classe privada.\r\n", "d) Classe pública.\r\n"},
                                                2, "Intermediário", "", "", null, false);
                                                pergunta30.setExplicacao("=== Explicações sobre a pergunta 30: ===\n" +
                                                "Quando uma classe está comprometida a implementar uma interface, ela assume a obrigação de fornecer implementações concretas para todos os métodos" +
                                                " especificados por essa interface. Caso a classe não forneça implementações para todos esses métodos, ela não estará completa e, consequentemente," +
                                                " não poderá ser instanciada diretamente e servirá apenas como superclasse.\n");
                                                perguntasIntermediario.add(pergunta30);

         //Perguntas para o nível avançado:
        //Perguntas do capítulo 8 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            Perguntas pergunta31 = new Perguntas("31- Para acessar um membro public static de uma classe, como Math.PI ou Math.random(), qual sintaxe é comumente usada, mesmo que não haja objetos da classe instanciados? Página do Livro: 259.\n",
                                            new String[] {"a) objeto.membro \r\n", "b) this.membro \r\n", "c) NomeClasse.membro \r\n", "d) static.membro \r\n"},
                                                3, "Avançado", "", "", null, false);
                                                pergunta31.setExplicacao("=== Explicações sobre a pergunta 31: ===\n" +
                                                "Classes nunca devem ter dados public não constantes, mas declarar dados public static Final permite disponibilizar as constantes para os clientes da" +
                                                " sua classe. Use o nome da classe seguido por um ponto.\n");
                                                perguntasAvancado.add(pergunta31);

            Perguntas pergunta32 = new Perguntas("32- Quando nenhum modificador de acesso (public, protected, private) é especificado para um membro de classe, qual nível de acesso é aplicado por padrão? Página do Livro: 270.\n",
                                            new String[] {"a) package-private (ou apenas 'package').\r\n", "b) public.\r\n", "c) protected.\r\n", "d) private.\r\n"},
                                                1, "Avançado", "", "", null, false);
                                                pergunta32.setExplicacao("=== Explicações sobre a pergunta 32: ===\n" +
                                                "Em java, quando um membro de uma determinada classe (como método ou variável) é declarado sem especificar um modificador de acesso, ele adota um" +
                                                " tipo de visibilidade que permite sua utilização apenas dentro de classes que pertencem ao mesmo agrupamento lógico de código, conhecido como pacote." +
                                                " A partir desse tipo de acesso, é promovida uma organização interna entre classes relacionadas, assim  facilitando a colaboração entre elas sem fazer" +
                                                " a exposição de seus detalhes a partes externas do sistema.\n");
                                                perguntasAvancado.add(pergunta32);
            
            Perguntas pergunta33 = new Perguntas("33- Todos os objetos em Java herdam um método da classe Object que fornece uma representação em formato de texto do objeto. Qual é o nome deste método? Página do Livro: 260.\n",
                                            new String[] {"a) stringify.\r\n", "b) describe.\r\n", "c) toText.\r\n", "d) toString"},
                                                4, "Avançado", "", "", null, false);
                                                pergunta33.setExplicacao("=== Explicações sobre a pergunta 33: ===\n" +
                                                "Dentro da linguagem de programação Java, há um método herdado por todas as classes que permite obter uma representação textual dos objetos," +
                                                " facilitando a exibição de informações que sejam consideradas relevantes sobre o estado interno de cada instância. Esse método é frequentemente" +
                                                " sobrescrito para personalizar a maneira como os dados do objeto são apresentados em formato de texto. Um bom exemplo do uso dessa funcionalidade" +
                                                " é quando uma classe possui variáveis de instância que são, por sua vez, objetos de outras classes.\n");
                                                perguntasAvancado.add(pergunta33);

            Perguntas pergunta34 = new Perguntas("34- Para realizar cálculos monetários em Java com alta precisão e evitar problemas de arredondamento típicos de tipos de ponto flutuante (double, float)," +
                                                " qual classe na API do Java é recomendada? Página do Livro: 271.\n",
                                            new String[] {"a) DecimalFormat.\r\n", "b) BigDecimal.\r\n", "c) MathPrecision.\r\n", "d) MoneyCalc.\r\n"},
                                                2, "Avançado", "", "", null, false);
                                                pergunta34.setExplicacao("=== Explicações sobre a pergunta 34: ===\n" +
                                                "Em algumas aplicações feitas em Java que fazem o envolvimento de cálculos financeiros ou outras operações que exigem extrema decisão é recomendada" +
                                                " a utilização de uma classe que seja especializada em API, justamente para evitar os problemas típicos de impressão associados aos tipos primitivos" +
                                                " de ponto flutuante, como “Float” E “Double”. Essa classe dá permissão para que possam ser realizadas operações aritméticas com grande perfeição," +
                                                " além de fornecer métodos para controlar o arredondamento e a escala dos números.\n");
                                                perguntasAvancado.add(pergunta34);

        //Perguntas do capítulo 9 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            Perguntas pergunta35 = new Perguntas("35- Se um método sobrescrito em uma subclasse necessita executar parte da lógica implementada na versão da superclasse, como ele pode chamar explicitamente" +
                                                " o método da superclasse? Página do Livro: 284 a 287.\n",
                                            new String[] {"a) parent.NomeDoMetrodo().\r\n", "b) super.NomeDoMetodo().\r\n", "c) base.nomeDoMetodo().\r\n", "d) thi.nomeDoMetodo().\r\n"},
                                                2, "Avançado", "", "", null, false);
                                                pergunta35.setExplicacao("=== Explicações sobre a pergunta 35: ===\n" +
                                                "Quando um método de uma subclasse precisa complementar ou reutilizar parte do comportamento definido na versão correspondente da superclasse," +
                                                " ele pode invocar diretamente esse comportamento. Para isso, utiliza-se uma chamada explícita que refere-se a superclasse que permite executar" +
                                                " o método original dentro da nova implementação. Uma palavra-chave especial seguida por um ponto e o nome do método.\n");
                                                perguntasAvancado.add(pergunta35);

            Perguntas pergunta36 = new Perguntas("36- Os construtores definidos em uma superclasse são automaticamente herdados pelas suas subclasses? Página do Livro: 287.\r\n",
                                            new String[] {"a) Sim.\r\n", "b) Apenas se forem public.\r\n", "c) Não.\r\n", "d) Apenas se forem protected.\r\n"},
                                                3, "Avançado", "", "", null, false);
                                                pergunta36.setExplicacao("=== Explicações sobre a pergunta 36: ===\n" +
                                                "Construtores possuem um papel essencial dentro da criação de objetos e, diferentemente de métodos comuns, não são disponibilizados automaticamente" +
                                                " para as subclasses. Cada subclasse precisa definir de forma explícita seus próprios construtores, mesmo que eles apenas encaminhem dados para inicializar" +
                                                "  a parte da superclasse. Se uma subclasse não definir um construtor, o compilador tentará inserir automaticamente um constritor padrão.\n");
                                                perguntasAvancado.add(pergunta36);

            Perguntas pergunta37 = new Perguntas("37- Qual classe, no pacote java.lang, é a raiz de toda a hierarquia de classes em Java, significando que toda classe Java herda dela direta ou indiretamente? Página do Livro: 304.\n",
                                            new String[] {"a) Root.\r\n", "b) Base\r\n", "c) Core.\r\n", "d) Object.\r\n"},
                                                4, "Avançado", "", "", null, false);
                                                pergunta37.setExplicacao("=== Explicações sobre a pergunta 37: ===\n" +
                                                "Dentro da linguagem Java, todas as classes pertencem a uma hierarquia comum que possui uma única classe base. Essa classe fundamental está incluída no" +
                                                "pacote “java.lang” e fornece métodos essenciais que todas as outras classes herdam, mesmo que isso não seja declarado de forma explícita no código. Contém" +
                                                " métodos fundamentais compartilhados por todos os objetos.\n");
                                                perguntasAvancado.add(pergunta37);

            Perguntas pergunta38 = new Perguntas("38- Cite dois métodos comuns que todas as classes Java herdam da classe Object. Página do Livro: 304.\n",
                                            new String[] {"a) print e compare.\r\n", "b) display e match.\r\n", "c) show e cjeck.\r\n", "d) toString e equals.\r\n"},
                                                4, "Avançado", "", "", null, false);
                                                pergunta38.setExplicacao("=== Explicações sobre a pergunta 38: ===\n" +
                                                "Todas as classes em java herdam funcionalidades que permitem, por exemplo, gerar uma representação textual de seus objetos, útil para exibir informações" +
                                                " ou depurar aplicações e também realizar comparações entre objetos, seja verificar se ocupam o mesmo espaço de memória ou, quando redefinido," +
                                                " comparar o conteúdo armazenado.\n");
                                                perguntasAvancado.add(pergunta38);

        //Perguntas do capítulo 10 do livro "Java: Como Programar" de Deitel e Deitel, 10ª edição:
            Perguntas pergunta39 = new Perguntas("39- Interfaces são particularmente úteis para permitir o processamento polimórfico de quais tipos de classes? Página do Livro: 338.\n",
                                            new String[] {"a) Classes não relacionadas que compartilham funcionalidades.\r\n", "b) Apenas classes abstratas.\r\n", "c) Apenas subclasses de uma mesma classe.\r\n", "d) Apenas classes completas.\r\n"},
                                                1, "Avançado", "", "", null, false);
                                                pergunta39.setExplicacao("=== Explicações sobre a pergunta 39: ===\n" +
                                                "Interfaces são úteis quando se deseja processar de classes distintas de forma polimórfica, desde que essas classes compartilhem um mesmo conjunto" +
                                                " de comportamentos definidos pela interface. Classes que não estão necessariamente relacionadas por herança, mas que compartilham uma funcionalidade em comum.\n");
                                                perguntasAvancado.add(pergunta39);

            Perguntas pergunta40 = new Perguntas("40- Qual recurso introduzido no Java SE 8 permite adicionar novos métodos a uma interface existente, fornecendo uma implementação padrão no corpo da interface," +
                                                " sem a necessidade de modificar todas as classes que já implementam essa interface? Página do Livro: 340.\n",
                                            new String[] {"a) Métodos default.\r\n", "b) Métodos abstract.\r\n", "c) Métodos final.\r\n", "d) Métodos static.\r\n" },
                                                1, "Avançado", "", "", null, false);
                                                pergunta40.setExplicacao("=== Explicações sobre a pergunta 40: ===\n" +
                                                "A partir do Java SE 8, foi introduzida uma funcionalidade que permite incluir novos métodos em interfaces existentes, assim oferecendo uma implementação" +
                                                " padrão diretamente na interface. Esse recurso evita a necessidade de alterar todas as classes que já implementam a interface, pois elas automaticamente" +
                                                " acabam por herdar a nova funcionalidade, a menos que optem por sobrescrevê-la. Esses métodos têm uma implementação por \"omissão\".\n");
                                                perguntasAvancado.add(pergunta40);

            Perguntas pergunta41 = new Perguntas("A partir do Java SE 8, como é chamada uma interface que contém exatamente um método abstrato? Página do Livro: 341.\n",
                                            new String[] {"a) Interface lambda.\r\n", "b) Interface funcional.\r\n", "c) Interface abstrata.\r\n", "d) interface única.\r\n"},
                                                2, "Avançado", "", "", null, false);
                                                pergunta41.setExplicacao("=== Explicações sobre a pergunta 41: ===\n" +
                                                "A partir do Java SE 8, interfaces que possuem exatamente um único método abstrato passaram a ter uma designação específica, destacando-se pela sua" +
                                                " importância no suporte a expressões lambda. Esse tipo de interface é muito utilizado nas APIs do Java para definir comportamentos que podem ser" +
                                                " passados como parâmetros ou executados de forma flexível.\n");
                                                perguntasAvancado.add(pergunta41);

            Perguntas pergunta42 = new Perguntas("42- O estudo de caso que utiliza a interface Payable demonstra como processar polimorficamente objetos de classes como Invoice e Employee que, embora não relacionadas por herança direta," +
                                                " precisam calcular uma \\\"quantia a pagar\\\". Qual método essa interface exige que as classes implementadoras forneçam? Página do Livro: 338.\n",
                                            new String[] {"a) calculateTotal.\r\n", "b) processPayment.\r\n", "c) getPaymentAmount.\r\n", "d) makePayment."},
                                                3, "Avançado", "", "", null, false);
                                                explicacao.setExplicacao("=== Explicações sobre a pergunta 42: ===\n" +
                                                "Durante o estudo de caso apresentado na questão, a interface Payable é utilizada para permitir o processamento polimórfico de objetos de classes distintas," +
                                                " como Invoice e Employee, que compartilham a necessidade de calcular um valor correspondente a um pagamento. Para viabilizar essa funcionalidade, a interface" +
                                                " define um método que cada classe implementadora deve fornecer, garantindo assim que qualquer objeto do tipo Payable possa ser tratado de forma uniforme no" +
                                                " sistema, independentemente de sua classe concreta.\n");
                                                perguntasAvancado.add(pergunta42);
    }
    public Perguntas sortearPerguntas(String dificuldade) {
        ArrayList<Perguntas> listaPerguntas;
            switch(dificuldade) {
                case "1": 
                    listaPerguntas = perguntasIniciante;
                    break;
                
                case"2":
                    listaPerguntas = perguntasIntermediario;
                    break;
                
                case "3":
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

    private boolean TempoEsgotado() {
        return !cronometro.isAlive();
    }
}