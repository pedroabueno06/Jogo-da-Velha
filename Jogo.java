import java.util.Random; //Esta biblioteca faz com que o programa faça um sorteio para ver qual dos jogadores irá fazer a primeira jogada
import java.util.Scanner; 
public class Jogo {    
    //Método para o jogador encerrar o jogo om a tecla "/" em qualquer momento do jogo:
    public static String lerEntrada (Scanner scanner) {
        String entrada = scanner.nextLine();
            if (entrada.equals ("/")) {
                    System.out.println("Uma pena você não querer jogar nosso jogo, por tanto o jogo está encerrado.");
                        System.exit(0);
            }
            return entrada;
        }

    //Método para fazer com que o jogo mostre o nome do jogador quando for sua vez de jogar e anunciar seu nome se for o vencedor do jogo:
    public static String getPersonagem (char simbolo, String escolhaJogador1, String escolhaJogador2) {
        if (simbolo == 'X') {
            return "Paul Deitel";
        } else { 
            return "Harvey Deitel";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        Jogo jogo = new Jogo();
            int errosConsecutivos = 0; //variável para armazenar os erros consecutivos do jogador
            int[] ultimaJogada = new int[2]; //variável para armazenar a última jogada do jogador
            Perguntas ultimaPerguntaCorreta = null; //Armazena a última pergunta correta respondida pelo jogador
            Perguntas perguntaAnterior = null; //Armazena a última pergunta respondida pelo jogador, para que não que não seja repetida em caso de acerto
            String dificuldade; // Variável para os jogadores escolherem a dificuldade das perguntas que irão ser feitas durante o jogo
            String escolhaJogador1; //Váriável para o jogador 1 escolher seu personagem
            String escolhaJogador2 = ""; //Inicializa a variável com string vazia
            String vencedor; //Variável que verifica qual jogador é o vencedor do jogo
            
            System.out.println("===Seja bem vindo ao Deitel VOOX===");
                System.out.println("Digite 0 se quiser saber as regras, 1 se quiser iniciar o jogo ou / para encerrar.");
                    String acao1 = lerEntrada(scanner);
            
            if (acao1.equals ("0")) {
                System.out.println("\nRegras do jogo Deitel VOOX: \n");
                System.out.println("1- Este é um jogo da velha que tem como conteúdo, a linguagem de programação 'Java', baseado nos capítulos 8,9 e 10 do livro Java: Como Programar; \n");
                System.out.println("2- Necessita de 2 jogadores para ser jogado \n");
                System.out.println("3- Os jogadores devem escolher entre as seguintes dificuldades de perguntas: \n");
                System.out.println("- Iniciante; \n");
                System.out.println("- Intermediário; \n");
                System.out.println("- Avançado. \n");
                System.out.println("4- Cada jogador deve escolher entre os seguintes personagens: (Para escolher os personagens, basta digitar X ou O) \n");
                System.out.println("- Paul Deitel(X); \n");
                System.out.println("- Harvey Deitel(O). \n");
                System.out.println("5- Após a escolha dos personagens, os jogadores deverão escolher o tipo de tabuleiro que desejam jogar: \n");
                System.out.println("- Digite 3x3 para escolher o tabuleiro 3x3. \n");
                System.out.println("- Digite 4x4 para escolher o tabuleiro 4x4.");
                System.out.println("Digite 5x5 para escolher o tabuleiro 5x5.");
                System.out.println("6- Cada jogador inicia o jogo com 30 moedas para serem utilizadas no sistema de dicas; \n");
                System.out.println("7- O sistema do jogo escolhe aleatoriamente que deve iniciar o jogo; \n");
                System.out.println("8- O sistema do jogo escolhe aleatóriamente a pergunta que será feita ao jogador; \n");
                System.out.println("9- Para realizar a marcação no tabuleiro, é necessário responder uma pergunta que envolve 4 alternativas selecionada aleatoriamente pelo sistema sobre os conteúdos que estão em um dos três capítulos já pré-definidios do livro Java: Como Programar; \n");
                System.out.println("10- Cada jogador terá até um minuto para responder cada pergunta e mais cinco minutos caso deseje ler as breves explicações que estarão nas caixas de texto, mas ao acionar a caixa de texto, o seu tempo para responder a pergunta será paralisado e iniciado do ponto em que parou após a leitura; \n");
                System.out.println("11- Em caso do jogador ter acertado uma das perguntas e errar as próximas duas perguntas de forma consecutiva, o sistema irá retirar a ultima marcação que o jogador realizou no tauleiro; \n");
                System.out.println("12- Em caso de um dos jogadores não souber tiver conhecimento sobre o assunto de uma das perguntas, ele pode ou reccorrer ao sistema de dicas ou as caixas de texto que nelas haverão breves explicações sobre o conteúdo das perguntas; \n");
                System.out.println("13- O sistema de dicas funciona da seguinte maneira: \n");
                System.out.println("- Cada jogador inicia o jogo com 30 moedas; \n");
                System.out.println("- A dica 1 custa 5 moedas e irá retirar uma das alternativas da pergunta em questão; \n");
                System.out.println("- A dica 2 custa 10 moedas e irá retirar duas alternativas da pergunta em questão; \n");
                System.out.println("- A dica 3 custa 15 moedas e irá retirar três alternativas da pergunta em questão; \n");
                System.out.println("- Cada dica só poderá ser utilizada em uma rodada e na próxima não poderá ser utilizada. \n");
                System.out.println("- As dicas devem ser utilizadas em sua ordem, ou seja, primeiro você deve utilizar a dica 1, depois a dica 2 e por último a dica 3; \n");
                System.out.println("14- Um jogador só poderá ganhar se completar uma linha, coluna ou quina com seu símbolo escolhido; \n");
                System.out.println("15- Em caso de vir a ocorrer velha, ou seja, nenhum dos jogadores conseguiu realizar uma das combinações necessárias para ganhar, o jogo será reiniciado automaticamente e as moedas dos jogadores devolvidas se utilizadas. \n");
                
                System.out.println("Digite 1 para iniciar o jogo.");
                acao1 = lerEntrada(scanner);
                    System.out.println("\nÓtimo, a seguir você receberá mais instruções.");
            
                } else if (acao1.equals ("1")) {
                    System.out.println("\nÓtimo, a seguir você receberá mais instruções.");

                } else {
                    do {
                        System.out.println("Opção inválida!");
                            System.out.println("Digite apenas 0, 1 ou /: ");
                                acao1 = lerEntrada(scanner);


                } while (!acao1.equals("0") && !acao1.equals("1"));

                if (acao1.equals ("0")) {
                    System.out.println("\nRegras do jogo Deitel VOOX: \n");
                    System.out.println("1- Este é um jogo da velha que tem como conteúdo, a linguagem de programação 'Java', baseado nos capítulos 8,9 e 10 do livro Java: Como Programar; \n");
                    System.out.println("2- Necessita de 2 jogadores para ser jogado \n");
                    System.out.println("3- Os jogadores devem escolher entre as seguintes dificuldades de perguntas: \n");
                    System.out.println("- Iniciante; \n");
                    System.out.println("- Intermediário; \n");
                    System.out.println("- Avançado. \n");
                    System.out.println("4- Cada jogador deve escolher entre os seguintes personagens: (Para escolher os personagens, basta digitar X ou O) \n");
                    System.out.println("- Paul Deitel(X); \n");
                    System.out.println("- Harvey Deitel(O). \n");
                    System.out.println("5- Após a escolha dos personagens, os jogadores deverão escolher o tipo de tabuleiro que desejam jogar: \n");
                    System.out.println("- Digite 3x3 para escolher o tabuleiro 3x3. \n");
                    System.out.println("- Digite 4x4 para escolher o tabuleiro 4x4.");
                    System.out.println("Digite 5x5 para escolher o tabuleiro 5x5.");
                    System.out.println("6- Cada jogador inicia o jogo com 30 moedas para serem utilizadas no sistema de dicas; \n");
                    System.out.println("7- O sistema do jogo escolhe aleatoriamente que deve iniciar o jogo; \n");
                    System.out.println("8- O sistema do jogo escolhe aleatóriamente a pergunta que será feita ao jogador; \n");
                    System.out.println("9- Para realizar a marcação no tabuleiro, é necessário responder uma pergunta que envolve 4 alternativas selecionada aleatoriamente pelo sistema sobre os conteúdos que estão em um dos três capítulos já pré-definidios do livro Java: Como Programar; \n");
                    System.out.println("10- Cada jogador terá até um minuto para responder cada pergunta e mais cinco minutos caso deseje ler as breves explicações que estarão nas caixas de texto, mas ao acionar a caixa de texto, o seu tempo para responder a pergunta será paralisado e iniciado do ponto em que parou após a leitura; \n");
                    System.out.println("11- Em caso do jogador ter acertado uma das perguntas e errar as próximas duas perguntas de forma consecutiva, o sistema irá retirar a ultima marcação que o jogador realizou no tauleiro; \n");
                    System.out.println("12- Em caso de um dos jogadores não souber tiver conhecimento sobre o assunto de uma das perguntas, ele pode ou reccorrer ao sistema de dicas ou as caixas de texto que nelas haverão breves explicações sobre o conteúdo das perguntas; \n");
                    System.out.println("13- O sistema de dicas funciona da seguinte maneira: \n");
                    System.out.println("- Cada jogador inicia o jogo com 30 moedas; \n");
                    System.out.println("- A dica 1 custa 5 moedas e irá retirar uma das alternativas da pergunta em questão; \n");
                    System.out.println("- A dica 2 custa 10 moedas e irá retirar duas alternativas da pergunta em questão; \n");
                    System.out.println("- A dica 3 custa 15 moedas e irá retirar três alternativas da pergunta em questão; \n");
                    System.out.println("- Cada dica só poderá ser utilizada em uma rodada e na próxima não poderá ser utilizada. \n");
                    System.out.println("- As dicas devem ser utilizadas em sua ordem, ou seja, primeiro você deve utilizar a dica 1, depois a dica 2 e por último a dica 3; \n");
                    System.out.println("14- Um jogador só poderá ganhar se completar uma linha, coluna ou quina com seu símbolo escolhido; \n");
                    System.out.println("15- Em caso de vir a ocorrer velha, ou seja, nenhum dos jogadores conseguiu realizar uma das combinações necessárias para ganhar, o jogo será reiniciado automaticamente e as moedas dos jogadores devolvidas se utilizadas. \n");
                    
                    System.out.println("Digite 1 para iniciar o jogo.");
                        acao1 = lerEntrada(scanner);
                            System.out.println("\nÓtimo, a seguir você receberá mais instruções.");
                    
                } else if (acao1.equals ("1")) {
                    System.out.println("\nÓtimo, a seguir você receberá mais instruções.");
                }
            }

                System.out.println("Antes de iniciar o jogo, escolha a dificuldade desejada: (Digite 2 para inciante, 3 para intermediário e 4 para avançado) ");
                    dificuldade = lerEntrada(scanner);
                if (dificuldade.equals("2")) {
                    System.out.println("\nDificuldade escolhida: Iniciante.");
                        System.out.println("A seguir você receberá mais instruções.");

                } else if (dificuldade.equals ("3")) {
                    System.out.println("\nDificuldade escolhida: Intermediária.");
                        System.out.println("A seguir você receberá mais instruções.");

                } else if (dificuldade.equals ("4")) {
                    System.out.println("\nDificuldade escolhida: Avançada.");
                        System.out.println("A seguir você receberá mais instruções.");
                }

                //Escolha dos personagens que serão atribuídos ao X e O:
                System.out.println("\nEscolha de personagens: \n");
                    System.out.println("Jogador 1 escolhe primeiro:");
                        System.out.println("Digite Paul Deitel (X) para escolher o X e Harvey Deitel (O) para ser O.");
                                escolhaJogador1 = lerEntrada(scanner);

                    while (!escolhaJogador1.equals ("Paul Deitel (X)") && !escolhaJogador1.equals ("Harvey Deitel (O)")) {
                         System.out.println("\nOpção inválida!");
                                System.out.println("Digite apenas Paul Deitel (X) para escolher o X e Harvey Deitel (O) para ser O. ");
                                    escolhaJogador1 = lerEntrada(scanner);
                    }

                    //O personagem que não for escolhido pelo jogador 1, será atruído automaticamnte ao jogador 2:
                    if (escolhaJogador1.equals("Paul Deitel (X)")) {
                        escolhaJogador2 = "Harvey Deitel (O)";
                            System.out.println("\nJogador 1: Paul Deitel (X)");
                                System.out.println("Jogador 2: Harvey Deitel (O)");
                    } else {
                        escolhaJogador2 = "Paul Deitel (X)";
                            System.out.println("\nJogador 1: Harvey Deitel (O)");
                                System.out.println("Jogador 2: Paul Deitel (X) ");
                    }

                    //Escolha do tipo de tabuleiro:
                    System.out.println("\nEscolha do tipo de tabuleiro:");
                    System.out.println("Digite 1 para escolher o tabuleiro 3x3.");
                    System.out.println("\nDigite 2 para escolher o tabuleiro 4x4.");
                    System.out.println("\nDigite 3 para escolher o tabuleiro 5x5.");
                    System.out.println("\nDigite sua escolha de tabuleiro: ");
                        acao1 = lerEntrada (scanner);

                    if (acao1.equals ("1")) {
                        System.out.println("\nTabuleiro escolhido: 3x3.");

                    } else if (acao1.equals ("2")) {
                        System.out.println("\nTabuleiro escolhido: 4x4.");

                    } else if (acao1.equals ("3")) {
                        System.out.println("\nTabuleiro escolhido: 5x5.");

                    } else {
                        do { 
                            System.out.println("\nOpção inválida!");
                                System.out.println("Digite apenas 1, 2 ou 3:");
                                    acao1 = lerEntrada (scanner);

                    } while (!acao1.equals ("1") && !acao1.equals ("2") && !acao1.equals ("3"));
                    }
                        
                    BancoPerguntas bancoPerguntas = new BancoPerguntas();
                    //Faz o sorteio sobre qual jogador vai começar o jogo:
                    boolean jogoCompleto = false;
                        while (!jogoCompleto) {
                            TabuleiroJogoDaVelha tabuleiroJogoDaVelha = new TabuleiroJogoDaVelha (acao1);
                                int moedaJogador1 = 30;
                                    int moedasJogador2 = 30;
                                        Random random = new Random();
                                            char jogadorAtual;

                                                if (random.nextBoolean()) {
                                                        jogadorAtual = 'X';
                                                    } else {
                                                        jogadorAtual = 'O';
                                                    }

                                                    boolean jogando = true;

                                                    Cronometro cronometro = new Cronometro();

                                                    while (jogando) {
                                                        System.out.println("\nEstado atual do tabuleiro:");
                                                            tabuleiroJogoDaVelha.mostrarTabuleiro();

                                                    //Mostrar o personagem que cada jogador escolheu:
                                                    System.out.println("Jogador 1: (" + escolhaJogador1 + ")"  + ".");
                                                    System.out.println("Jogador 2: (" + escolhaJogador2 + ")" + ".");
                                                            
                                                    //Mostra quem é o jogador da vez:
                                                    System.out.println("\nVez do " + getPersonagem(jogadorAtual, escolhaJogador1, escolhaJogador2) + ":");

                                                    //inicia o crônometro para o jogador responder a pergunta e fazer sua jogada:
                                                    System.out.println("Você tem 1 minuto para responder a pergunta e fazer a sua jogada!");
                                                        cronometro.iniciar();

                                                        //Faz o sorteio da pergunta e a aplica:
                                                        Perguntas perguntasAtual;
                                                        if (perguntaAnterior != null) {
                                                            perguntasAtual = perguntaAnterior;
                                                                perguntaAnterior = null;
                                                        } else if (ultimaPerguntaCorreta != null) {
                                                            perguntasAtual = ultimaPerguntaCorreta;
                                                                ultimaPerguntaCorreta = null; //Faz com que a última pergunta acertada não seja repetida
                                                        } else {
                                                            perguntasAtual = bancoPerguntas.sortearPerguntas(dificuldade);
                                                        } 

                                                        if (perguntasAtual == null) {
                                                            System.out.println("Erro ao carregar pergunta. Tente novamente");
                                                                cronometro.pararCronometro(); //Crônometro para se a pergunta der erro
                                                                    continue;
                                                        }

                                                        System.out.println("\n=== PERGUNTA ===");
                                                            boolean respostaCorreta = perguntasAtual.fazerPergunta(scanner);

                                                        if (respostaCorreta) {
                                                            System.out.println("Sua resposta está correta!");
                                                                errosConsecutivos = 0; //Reinicia os erros consecutivos
                                                                    perguntaAnterior = null;                                                                                      

                                                        //Lógica se o jogador acertar a pergunta:
                                                        System.out.println("Digite a linha do tabueleiro que deseja marcar (0-" + (tabuleiroJogoDaVelha.getTamanho()-1) + "): ");
                                                            int linha = Integer.parseInt (lerEntrada (scanner)); //Integer está encapsulando o valor int e transformando em um objeto
                                                        System.out.println("Digite a coluna do tabueleiro que deseja marcar (0-" + (tabuleiroJogoDaVelha.getTamanho()-1) + "): ");
                                                            int coluna = Integer.parseInt (lerEntrada (scanner)); //Integer está encapsulando o valor int e transformando em um objeto
                                                        cronometro.pararCronometro(); //Crônometro para se a pergunta der erro

                                                        if (tabuleiroJogoDaVelha.realizarJogada(linha, coluna, jogadorAtual)) {
                                                            ultimaJogada[0] = linha; //Armaneza a última jogada feita pelo jogador
                                                                ultimaJogada[1] = coluna; //armazena a última jogada feita pelo jogador

                                                            //Verifica se venceu o jogo:
                                                            if (tabuleiroJogoDaVelha.verificarVitoria(jogadorAtual)) {
                                                                vencedor = getPersonagem(jogadorAtual, escolhaJogador1, escolhaJogador2);
                                                                    tabuleiroJogoDaVelha.mostrarTabuleiro();
                                                                        System.out.println("Parabéns " + vencedor + ", você venceu o jogo!");
                                                                            jogoCompleto = true;
                                                                                jogando = false;
                                                                                    continue;
                                                            }
                                                        }
                                                            
                                                            } else {
                                                                //Verifica se o jogador errou a pergunta:
                                                                System.out.println("Sua resposta está incorreta!");
                                                                    errosConsecutivos++;
                                                                cronometro.pararCronometro(); //Crônometro para se a pergunta der erro

                                                                if (errosConsecutivos >= 2) {
                                                                    System.out.println("Você errou duas perguntas consecutivas, portanto sua última jogada será desfeita.");
                                                                        tabuleiroJogoDaVelha.removerJogada(ultimaJogada[0], ultimaJogada[1]);
                                                                            errosConsecutivos = 0; //Reinicia os erros consecutivos
                                                                    cronometro.pararCronometro(); //Crônometro para se a pergunta der erro

                                                                }    

                                                            }                                                                

                                                            //verifica se o jogo der empate:
                                                            if (tabuleiroJogoDaVelha.verificaEmpate()) {
                                                                tabuleiroJogoDaVelha.mostrarTabuleiro();
                                                                    System.out.println("O jogo deu velha! Por isso será reiniciado.");
                                                                
                                                                    //Após o reinicio do jogo, as moedas dos jogadores são devolvidas se forem utilizadas:
                                                                    moedaJogador1 = 30;
                                                                    moedasJogador2 = 30;
                                                                    jogando = false;
                                                            } else {
                                                                jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X'; //Os operádores ternários ? e : são substitutos dos operadores concidcionais if/else
                                }
            }
        }
    }
}
