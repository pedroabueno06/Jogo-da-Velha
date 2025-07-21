package com.example;
import java.util.Random;
import java.util.Scanner;

import com.Cronometro1;
import com.Cronometro2;
import com.Perguntas;
import com.repositorio.BancoPerguntas;
import com.repositorio.service.TabuleiroJogoDaVelha;

import  view.UsuarioLogin;
public class Jogo {
    
    //método para o jogador encerrar o jogo om a tecla "/" em qualquer momento do jogo:
    public static String lerEntrada (Scanner scanner) {
        String entrada = scanner.nextLine();
            if (entrada.equals ("/")) {
                    System.out.println("\nUma pena você não querer jogar o Deitel VOOX, com isso, o jogo está encerrado.");
                        System.exit(0);
            }
            return entrada;
        }

    //método para fazer com que o jogo mostre o nome do jogador quando for sua vez de jogar e anunciar seu nome se for o vencedor do jogo:
    public static String getPersonagem (char simbolo, String escolhaJogador1, String escolhaJogador2) {
        if (simbolo == 'X') {
            return "Paul Deitel";
        } else {
            return "Harvey Deitel";
        }
    }

    public static void main(String[] args) {
        BancoPerguntas banco = new BancoPerguntas();
        //faz com que apareça a tela de login  quando o usuário tecla run na classe principal que no caso é esta:
            view.UsuarioLogin.main(null);

        Scanner scanner = new Scanner (System.in);
        Jogo jogo = new Jogo();
            int errosConsecutivosX = 0; //variável para armazenar os erros consecutivos do jogador X
            int errosConsecutivosO = 0; //variável para armazenar os erros consecutivos do jogador O
            int[] ultimaJogadaX = new int[2]; //variável para armazenar a última jogada do jogador X
            int[] ultimaJogadaO = new int[2]; //variável para armazenar a última jogada do jogador O
            Perguntas ultimaPerguntaCorreta = null; //armazena a última pergunta correta respondida pelo jogador
            Perguntas perguntaAnterior = null; //armazena a última pergunta respondida pelo jogador, para que não que não seja repetida em caso de acerto
            String dificuldade; // variável para os jogadores escolherem a dificuldade das perguntas que irão ser feitas durante o jogo
            String escolhaJogador1; //váriável para o jogador 1 escolher seu personagem
            String escolhaJogador2 = ""; //inicializa a variável com string vazia
            String vencedor; //variável que verifica qual jogador é o vencedor do jogo
            String resetarDicas;
            String nomeJogador = UsuarioLogin.nomeUsuarioLogado;
            
            System.out.println("\nDigite 0 para saber as regras, 1 para iniciar o jogo ou / para encerrar.");
                String acao1 = lerEntrada(scanner);
            
            if (acao1.equals ("0")) {
                System.out.println("\n===Regras do Deitel VOOX===");
                System.out.println("1- Este é um jogo da velha que tem como conteúdo, a linguagem de programação 'Java', baseado nos capítulos 8,9 e 10 do livro Java: Como Programar.\n");
                System.out.println("2- Antes de iniciar o jogo, os jogadores devem realizar um cadastro para poderem se logar no jogo.");
                System.out.println("3- Necessita de 2 jogadores para ser jogado.\n");
                System.out.println("4- Os jogadores devem escolher entre as seguintes dificuldades de perguntas:\n");
                System.out.println("- Iniciante; \n");
                System.out.println("- Intermediário; \n");
                System.out.println("- Avançado. \n");
                System.out.println("5- Cada jogador deve escolher entre os seguintes personagens: (Para escolher os personagens, basta digitar X ou O):\n");
                System.out.println("- Paul Deitel(X); \n");
                System.out.println("- Harvey Deitel(O). \n");
                System.out.println("6- Após a escolha dos personagens, os jogadores deverão escolher o tipo de tabuleiro que desejam jogar: \n");
                System.out.println("- Digite 1 para escolher o tabuleiro 3x3;\n");
                System.out.println("- Digite 2 para escolher o tabuleiro 4x4;\n");
                System.out.println("- Digite  para escolher o tabuleiro 5x5.\n");
                System.out.println("7- Cada jogador inicia o jogo com 30 moedas para serem utilizadas no sistema de dicas.\n");
                System.out.println("8- O sistema do jogo escolhe aleatoriamente que deve iniciar o jogo.\n");
                System.out.println("9- O sistema do jogo escolhe aleatóriamente a pergunta que será feita ao jogador.\n");
                System.out.println("10- Para realizar a marcação no tabuleiro, é necessário responder uma pergunta que envolve 4 alternativas selecionada aleatoriamente pelo sistema sobre");
                System.out.println("   os conteúdos que estão em um dos três capítulos já pré-definidios do livro Java: Como Programar.\n");
                System.out.println("11- Cada jogador terá até um minuto para responder cada pergunta e mais cinco minutos caso deseje ler as breves explicações que estarão nas caixas de texto,");
                System.out.println("    mas ao acionar a caixa de texto, o seu tempo para responder a pergunta será paralisado e iniciado do ponto em que parou após a leitura.\n");
                System.out.println("12- Em caso do jogador ter acertado uma das perguntas e errar as próximas duas perguntas de forma consecutiva, o sistema irá retirar a ultima marcação que o jogador realizou no tauleiro.\n");
                System.out.println("13- Em caso de um dos jogadores não souber tiver conhecimento sobre o assunto de uma das perguntas, ele pode ou reccorrer ao sistema de dicas ou as explicações");
                System.out.println("    que nelas haverão breves esclarecimentos sobre o conteúdo das perguntas.\n");
                System.out.println("14- O sistema de dicas funciona da seguinte maneira:\n");
                System.out.println("- Cada jogador inicia o jogo com 30 moedas;\n");
                System.out.println("- A dica 1 custa 5 moedas e irá retirar uma das alternativas da pergunta em questão;\n");
                System.out.println("- A dica 2 custa 10 moedas e irá retirar duas alternativas da pergunta em questão;\n");
                System.out.println("- A dica 3 custa 15 moedas e irá retirar três alternativas da pergunta em questão;\n");
                System.out.println("- Cada dica só poderá ser utilizada em uma rodada e na próxima não poderá ser utilizada.\n");
                System.out.println("- As dicas devem ser utilizadas em sua ordem, ou seja, primeiro você deve utilizar a dica 1, depois a dica 2 e por último a dica 3.\n");
                System.out.println("15- Um jogador só poderá ganhar se completar uma linha, coluna ou quina com seu símbolo escolhido.\n");
                System.out.println("16- Em caso de vir a ocorrer velha, ou seja, nenhum dos jogadores conseguiu realizar uma das combinações necessárias para ganhar, o jogo será reiniciado automaticamente");
                System.out.println("    e as moedas dos jogadores devolvidas se utilizadas.\n");
                
                System.out.println("Digite 1 para iniciar o jogo:");
                acao1 = lerEntrada(scanner);
                    System.out.println("\nÓtimo, a seguir você receberá mais instruções.");
            
                } else if (acao1.equals ("1")) {
                    System.out.println("\nÓtimo, a seguir você receberá mais instruções.");

                } else {
                    do {
                        System.out.println("\nOpção inválida!");
                            System.out.println("Digite apenas 0, 1 ou /: ");
                                acao1 = lerEntrada(scanner);

                } while (!acao1.equals("0") && !acao1.equals("1"));

                if (acao1.equals ("0")) {
                    System.out.println("\n===Regras do Deitel VOOX===");
                System.out.println("1- Este é um jogo da velha que tem como conteúdo, a linguagem de programação 'Java', baseado nos capítulos 8,9 e 10 do livro Java: Como Programar.\n");
                System.out.println("2- Antes de iniciar o jogo, os jogadores devem realizar um cadastro para poderem se logar no jogo.");
                System.out.println("3- Necessita de 2 jogadores para ser jogado.\n");
                System.out.println("4- Os jogadores devem escolher entre as seguintes dificuldades de perguntas:\n");
                System.out.println("- Iniciante; \n");
                System.out.println("- Intermediário; \n");
                System.out.println("- Avançado. \n");
                System.out.println("5- Cada jogador deve escolher entre os seguintes personagens: (Para escolher os personagens, basta digitar X ou O):\n");
                System.out.println("- Paul Deitel(X); \n");
                System.out.println("- Harvey Deitel(O). \n");
                System.out.println("6- Após a escolha dos personagens, os jogadores deverão escolher o tipo de tabuleiro que desejam jogar: \n");
                System.out.println("- Digite 1 para escolher o tabuleiro 3x3;\n");
                System.out.println("- Digite 2 para escolher o tabuleiro 4x4;\n");
                System.out.println("- Digite  para escolher o tabuleiro 5x5.\n");
                System.out.println("7- Cada jogador inicia o jogo com 30 moedas para serem utilizadas no sistema de dicas.\n");
                System.out.println("8- O sistema do jogo escolhe aleatoriamente que deve iniciar o jogo.\n");
                System.out.println("9- O sistema do jogo escolhe aleatóriamente a pergunta que será feita ao jogador.\n");
                System.out.println("10- Para realizar a marcação no tabuleiro, é necessário responder uma pergunta que envolve 4 alternativas selecionada aleatoriamente pelo sistema sobre");
                System.out.println("   os conteúdos que estão em um dos três capítulos já pré-definidios do livro Java: Como Programar.\n");
                System.out.println("11- Cada jogador terá até um minuto para responder cada pergunta e mais cinco minutos caso deseje ler as breves explicações que estarão nas caixas de texto,");
                System.out.println("    mas ao acionar a caixa de texto, o seu tempo para responder a pergunta será paralisado e iniciado do ponto em que parou após a leitura.\n");
                System.out.println("12- Em caso do jogador ter acertado uma das perguntas e errar as próximas duas perguntas de forma consecutiva, o sistema irá retirar a ultima marcação que o jogador realizou no tauleiro.\n");
                System.out.println("13- Em caso de um dos jogadores não souber tiver conhecimento sobre o assunto de uma das perguntas, ele pode ou reccorrer ao sistema de dicas ou as explicações");
                System.out.println("    que nelas haverão breves esclarecimentos sobre o conteúdo das perguntas.\n");
                System.out.println("14- O sistema de dicas funciona da seguinte maneira:\n");
                System.out.println("- Cada jogador inicia o jogo com 30 moedas;\n");
                System.out.println("- A dica 1 custa 5 moedas e irá retirar uma das alternativas da pergunta em questão;\n");
                System.out.println("- A dica 2 custa 10 moedas e irá retirar duas alternativas da pergunta em questão;\n");
                System.out.println("- A dica 3 custa 15 moedas e irá retirar três alternativas da pergunta em questão;\n");
                System.out.println("- Cada dica só poderá ser utilizada em uma rodada e na próxima não poderá ser utilizada.\n");
                System.out.println("- As dicas devem ser utilizadas em sua ordem, ou seja, primeiro você deve utilizar a dica 1, depois a dica 2 e por último a dica 3.\n");
                System.out.println("15- Um jogador só poderá ganhar se completar uma linha, coluna ou quina com seu símbolo escolhido.\n");
                System.out.println("16- Em caso de vir a ocorrer velha, ou seja, nenhum dos jogadores conseguiu realizar uma das combinações necessárias para ganhar, o jogo será reiniciado automaticamente");
                System.out.println("    e as moedas dos jogadores devolvidas se utilizadas.\n");
                    
                    System.out.println("Digite 1 para iniciar o jogo.");
                        acao1 = lerEntrada(scanner);
                            System.out.println("\nÓtimo, a seguir você receberá mais instruções.");
                    
                } else if (acao1.equals ("1")) {
                    System.out.println("\nÓtimo, a seguir você receberá mais instruções.");
                }
            }

                System.out.println("Antes de iniciar o jogo, escolha a dificuldade desejada: (Digite 1 para inciante, 2 para intermediário e 3 para avançado) ");
                    dificuldade = lerEntrada(scanner);
                
                    if (dificuldade.equals("1")) {
                    System.out.println("\nDificuldade escolhida: Iniciante.");
                        System.out.println("A seguir você receberá mais instruções.");

                    } else if (dificuldade.equals ("2")) {
                        System.out.println("\nDificuldade escolhida: Intermediária.");
                            System.out.println("A seguir você receberá mais instruções.");

                    } else if (dificuldade.equals ("3")) {
                        System.out.println("\nDificuldade escolhida: Avançada.");
                            System.out.println("A seguir você receberá mais instruções.");
                    } else {
                        do {
                            System.out.println("\nDificuldade inválida!");
                            System.out.println("Digite apena 1, 2 ou 3:");
                            dificuldade = lerEntrada(scanner);

                            if (dificuldade.equals("1")) {
                        System.out.println("\nDificuldade escolhida: Iniciante.");
                            System.out.println("A seguir você receberá mais instruções.");

                    } else if (dificuldade.equals ("2")) {
                        System.out.println("\nDificuldade escolhida: Intermediária.");
                            System.out.println("A seguir você receberá mais instruções.");

                    } else if (dificuldade.equals ("3")) {
                        System.out.println("\nDificuldade escolhida: Avançada.");
                            System.out.println("A seguir você receberá mais instruções.");
                    }
                        } while (!dificuldade.equals("1") && !dificuldade.equals("2") && !dificuldade.equals("3"));
                }

                //escolha dos personagens que serão atribuídos ao X e O:
                System.out.println("\nEscolha de personagens: \n");
                    System.out.println("Jogador 1 escolhe primeiro:");
                        System.out.println("Digite Paul Deitel (X) para escolher o X e Harvey Deitel (O) para ser O.");
                                escolhaJogador1 = lerEntrada(scanner);

                    while (!escolhaJogador1.equals ("Paul Deitel (X)") && !escolhaJogador1.equals ("Harvey Deitel (O)")) {
                        System.out.println("\nOpção inválida!");
                                System.out.println("Digite apenas Paul Deitel (X) para escolher o X e Harvey Deitel (O) para ser O. ");
                                    escolhaJogador1 = lerEntrada(scanner);
                        }

                        //o personagem que não for escolhido pelo jogador 1, será atruído automaticamnte ao jogador 2:
                        if (escolhaJogador1.equals("Paul Deitel (X)")) {
                            escolhaJogador2 = "Harvey Deitel (O)";
                                System.out.println("\nJogador 1: " + nomeJogador + " - " + "Paul Deitel (X)");
                                    System.out.println("Jogador 2: Anna - Harvey Deitel (O)");
                            
                                } else {
                                escolhaJogador2 = "Harvey Deitel (O)";
                                    System.out.println("\nJogador 1: " + nomeJogador + " - " + "Harvey Deitel (O)");
                                        System.out.println("Jogador 2: Anna - Paul Deitel (X)");
                        }

                        //escolha do tipo de tabuleiro:
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
                            } while (!acao1.equals("1") && !acao1.equals("2") && !acao1.equals("3"));
                        }
                        
                        BancoPerguntas bancoPerguntas = new BancoPerguntas();
                        //faz o sorteio sobre qual jogador vai começar o jogo:
                        boolean jogoCompleto = false;
                            while (!jogoCompleto) {
                                TabuleiroJogoDaVelha tabuleiroJogoDaVelha = new TabuleiroJogoDaVelha (acao1);
                                    int moedasJogador1 = 30;
                                        int moedasJogador2 = 30;
                                            Random random = new Random();
                                                char jogadorAtual;

                            if (random.nextBoolean()) {
                                jogadorAtual = 'X';
                            } else {
                                jogadorAtual = 'O';
                            }

                            boolean jogando = true;

                            Cronometro1 cronometro = new Cronometro1();
                            Cronometro2 cronometro2 = new Cronometro2();

                            while (jogando) {
                            System.out.println("\nEstado atual do tabuleiro:");
                                tabuleiroJogoDaVelha.mostrarTabuleiro();

                            //mostrar o personagem que cada jogador escolheu:
                            System.out.println("Jogador 1: " + nomeJogador + " - " + "(" + escolhaJogador1 + ")"  + ".");
                                System.out.println("Jogador 2: Anna - (" + escolhaJogador2 + ")" + ".");

                            //mostra quem é o jogador da vez:
                            System.out.println("\nVez do " + getPersonagem(jogadorAtual, escolhaJogador1, escolhaJogador2) + ":");

                            //inicia o crônometro para o jogador responder a pergunta e fazer sua jogada:
                            System.out.println("Você tem 1 minuto para responder a pergunta e fazer sua jogada!");
                                cronometro.iniciar2();

                            //verificação de tempo antes de processar a resposta:
                            if (cronometro.tempoEsgotado1()) {
                                cronometro.Enter1();
                                    cronometro.pararCronometro1();
                                        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X'; //os operádores ternários ? e : são substitutos dos operadores concidcionais if/else
                                            continue;
                            }

                            //faz o sorteio da pergunta e a aplica:
                            Perguntas perguntasAtual;
                            if (perguntaAnterior != null) {
                                perguntasAtual = perguntaAnterior;
                                    perguntaAnterior = null;
                            } else if (ultimaPerguntaCorreta != null) {
                                perguntasAtual = ultimaPerguntaCorreta;
                                    ultimaPerguntaCorreta = null; //faz com que a última pergunta acertada não seja repetida
                            
                            } else {
                                perguntasAtual = bancoPerguntas.sortearPerguntas(dificuldade);
                                
                            }

                            if (perguntasAtual == null) {
                                System.out.println("Erro ao carregar pergunta. Tente novamente");
                                    cronometro.pararCronometro1(); //crônometro para se a pergunta der erro
                                        continue;
                            }

                            boolean podeUsarDicaAtual = !Perguntas.getUsouDicaRodadaAnterior(jogadorAtual);

                            System.out.println("\n=== PERGUNTA ===");
                                int moedasJogadorAtual = (jogadorAtual == 'X') ? moedasJogador1 : moedasJogador2;
                                    boolean respostaCorreta = perguntasAtual.fazerPergunta(scanner, podeUsarDicaAtual, moedasJogadorAtual, cronometro);
                                                        
                            //verificação de tempo antes de processar a resposta:
                            if (cronometro.tempoEsgotado1()) {
                                cronometro.Enter1();
                                    cronometro.pararCronometro1();
                                        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X'; //os operádores ternários ? e : são substitutos dos operadores concidcionais if/else
                                            continue;
                            }

                            if (jogadorAtual == 'X') {
                                moedasJogador1 = moedasJogadorAtual;

                            } else {
                                moedasJogador2 = moedasJogadorAtual;
                            }

                            if (perguntasAtual.usouDica()) {
                                Perguntas.setUsouDicaRodadaAnterior(jogadorAtual, true);

                            } else {
                                Perguntas.setUsouDicaRodadaAnterior(jogadorAtual, false);
                            }

                            if (respostaCorreta) {
                                System.out.println("\nSua resposta está correta!");
                                    //faz com que os erros do jogador atual sejão zerados:
                                    if (jogadorAtual == 'X') {
                                        errosConsecutivosX = 0;

                                    } else {
                                        errosConsecutivosO = 0;
                                    }
                                    perguntaAnterior = null;

                                //lógica se o jogador acertar a pergunta:
                                System.out.println("\nDigite a linha do tabueleiro que deseja marcar (0-" + (tabuleiroJogoDaVelha.getTamanho()-1) + "):");
                                    int linha = Integer.parseInt (lerEntrada (scanner)); //integer está encapsulando o valor int e transformando em um objeto
                                                            
                                System.out.println("\nDigite a coluna do tabueleiro que deseja marcar (0-" + (tabuleiroJogoDaVelha.getTamanho()-1) + "):");
                                    int coluna = Integer.parseInt (lerEntrada (scanner)); //integer está encapsulando o valor int e transformando em um objeto
                                        cronometro.pararCronometro1(); //crônometro para se a pergunta der erro

                                //armazena a jogada de cada um dos jogadores:
                                if (tabuleiroJogoDaVelha.realizarJogada(linha, coluna, jogadorAtual)) {
                                   if (jogadorAtual == 'X') {
                                        ultimaJogadaX[0] = linha;
                                            ultimaJogadaX[1] = coluna;

                                   } else {
                                        ultimaJogadaO[0] = linha;
                                            ultimaJogadaO[1] = coluna;
                                   }

                                    //verifica se o jogo teve algum vencedor:
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
                                //verifica se o jogador errou a pergunta:
                                System.out.println("\nSua resposta está incorreta!");

                                //verifica se o Jogador não errou duas perguntas consecutivas
                                if (jogadorAtual == 'X') {
                                    errosConsecutivosX++;
                                    if (errosConsecutivosX == 2) {
                                        System.out.println("Jogador X (Paul Deitel) errou duas perguntas consecutivas, por tanto, sua última jogada será desfeita!");
                                            tabuleiroJogoDaVelha.removerJogada(ultimaJogadaX[0], ultimaJogadaX[1]);
                                                errosConsecutivosX = 0;
                                    }
                                    
                                } else {
                                    errosConsecutivosO++;
                                        if (errosConsecutivosO == 2) {
                                            System.out.println("Jogador O (Harvey Deitel) errou duas perguntas consecutivas, por tanto, sua última jogada será desfeita!");
                                                tabuleiroJogoDaVelha.removerJogada(ultimaJogadaO[0], ultimaJogadaO[1]);
                                                    errosConsecutivosO = 0;
                                        }
                                }
                                cronometro.pararCronometro1(); //crônometro para se a pergunta der erro
                                
                            }

                            //verifica se o jogo der empate:
                            if (tabuleiroJogoDaVelha.verificaEmpate()) {
                            tabuleiroJogoDaVelha.mostrarTabuleiro();
                                System.out.println("O jogo deu velha! Por isso será reiniciado.");
                                                                
                            //após o reinicio do jogo, as moedas dos jogadores são devolvidas se forem utilizadas:
                            moedasJogador1 = 30;
                                moedasJogador2 = 30;
                                    jogando = false;
                            } else {
                                jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X'; //os operádores ternários ? e : são substitutos dos operadores concidcionais if/else
                            }
            }
        }
    }
}
