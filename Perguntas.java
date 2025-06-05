import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Perguntas {
    //Método para o jogador encerrar o jogo om a tecla "/" em qualquer momento do jogo:
    public static String lerEntrada (Scanner scanner) {
        String entrada = scanner.nextLine();
            if (entrada.equals ("/")) {
                    System.out.println("Uma pena você não querer jogar nosso jogo, por tanto o jogo está encerrado.");
                        System.exit(0);
            }
            return entrada;
        }

    //Atributos:
    private String pergunta;
    private String[] alternativas;
    private int respostaCorreta;
    private String dificuldade;
    private String explicacao;
    private String resposta;
    private Thread cronometro;
    private static boolean jogador1UsouDicaRodadaAnterior;
    private static boolean jogador2UsouDicaRodadaAnterior;
    private static char jogador;
    private static boolean usouDica = false;

    public Perguntas (String pergunta, String[] alternativas, int respostaCorreta, String dificuldade, String explicacao, String resposta, Thread cronometro, boolean usouDica) {
        this.pergunta = pergunta;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
        this.dificuldade = dificuldade;
        this.explicacao = explicacao;
        this.resposta = resposta;
        this.cronometro = cronometro;
        this.usouDica = usouDica;
    }

    public String getPergunta() {
        return pergunta;
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    public String getDificuldade() {
        return dificuldade;
    }

    public String getExplicacao() {
        return explicacao;
    }

    public void setExplicacao(String explicacao) {
        this.explicacao = explicacao;
    }

    public static boolean getUsouDicaRodadaAnterior(char jogador) {
        return jogador == 'X' ? jogador1UsouDicaRodadaAnterior : jogador2UsouDicaRodadaAnterior;
    }

    public static void setUsouDicaRodadaAnterior(char jogador, boolean valor) {
        if (jogador == 'X') {
            jogador1UsouDicaRodadaAnterior = valor;

        } else {
            jogador2UsouDicaRodadaAnterior = valor;
        }
    }

    public static void resetarDica() {
        usouDica = false;
    }

    public boolean usouDica() {
        return usouDica;
    }

    public void setdicaUtilizada(boolean usou) {
        this.usouDica = usou;
    }

    //Sistema de dicas:
    public boolean Dica (int numDica, int moedas, boolean PodeUsarDica) {
        if (!PodeUsarDica) {
            System.out.println("Você não pode utilizar as dicas nesta rodada!");
                return false;
        }

        int CustoDica;
        int RemoverAlternativas;

        switch (numDica) {
            case 1:
                CustoDica = 5;
                    RemoverAlternativas = 1;
                        break;

            case 2:
                CustoDica = 10;
                    RemoverAlternativas = 2;
                        break;

            case 3:
                CustoDica = 15;
                    RemoverAlternativas = 3;
                        break;

            default:
                System.out.println("Dica inválida!");
                    return false;
        }

        if (moedas < CustoDica) {
            System.out.println("Moedas insuficientes para comprar esta dica! Você tem " + moedas + " moedas.");
                return false;
        }

        Random random = new Random();
        int removidas = 0;
        List<Integer> indicesIncorretos = new ArrayList<>();

        //Remove as alternativas incorretas:
        for (int i = 0; i < alternativas.length; i++) {
            if (i + 1 != respostaCorreta) {
                indicesIncorretos.add(i);
            }
        }

        //Remove as alternativas de forma aleatória:
        while (removidas < RemoverAlternativas && !indicesIncorretos.isEmpty()) {
            int idx = random.nextInt(indicesIncorretos.size());
            int removerIndice = indicesIncorretos.get(idx);
            alternativas [removerIndice] = "";
            indicesIncorretos.remove(idx);
            removidas++;
        }
        return true;
    }

    public boolean fazerPergunta(Scanner scanner, boolean PodeUsarDica, int moedas) {
            System.out.println(pergunta);
            
            //Mostra as alternativas da questão
            for (int i = 0; i < alternativas.length; i++) {
                System.out.println((i+1) + ") " + alternativas[i]);
            }

            while (true) {
                //Oferece ao usuário, a opção de receber explicações sobre a pergunta ou apenas responde-la:
                System.out.println("Digite 0 se quiser receber explicações sobre a questão, 1 se quiser utilizar as dicas ou 2 para responder a pergunta:");
                    resposta = lerEntrada (scanner);

                if (resposta.equals("0")) {
                    if (explicacao != null) {
                        System.out.println("\nVocê tem 5 minutos para ler as explicações sobre a pergunta em questão:");
                        System.out.println(explicacao);
                        System.out.println("Pressione ENTER para continuar.");
                        resposta = lerEntrada(scanner);
                    } else {
                        System.out.println("\nNão há explicações referentes a esta pergunta.");
                    
                    } 
                        
                    
                }    //Verifica se o jogador está tentando utilizar a dica por duas rodadas consecutivas:
                    else if (resposta.equals("1")) {
                        if (usouDica) {
                            System.out.println("\nVocê não pode utilizar uma dicas em duas rodadas consecutivas!");
                                System.out.println("Por favor, espere pelo próxima rodada");
                                    continue;
                        }

                        do { 
                            if (PodeUsarDica && moedas >0) {
                                System.out.println("\n=== Dicas disponíveis: ===");
                                System.out.println("1- Remover 1 alternativa (custo: 5 moedas).");
                                System.out.println("\n2- Remover 2 alternativas (custo: 10 moedas).");
                                System.out.println("\n3- Remover 3 alternativas (custo: 15 moedas).");
                                System.out.println("\nVocê tem " + moedas + " moedas.");
                                System.out.println("\nDigite 1, 2 ou 3 para escolher a dica que deseja utilizar:");
                                resposta = lerEntrada(scanner);

                                if (resposta.equals("1")) {
                                    System.out.println("\nDica escolhida: Dica 1.");
                                        if (Dica(1, moedas, PodeUsarDica)) {
                                            //Preço das dicas:
                                                int custoDica = 5;
                                                    int subtracao = moedas - custoDica;
                                                        //Mostra com quantas moedas o jogador ficou após comprar uma das dicas:
                                                            System.out.println("Vcoê ficou com " + subtracao + " moedas.");
                                    }
                                    
                                } else if (resposta.equals("2")) {
                                    System.out.println("\nDica escolhida: Dica 2.");
                                        if (Dica(2, moedas, PodeUsarDica)) {
                                            //Preço das dicas:
                                                int custoDica = 10;
                                                    int subtracao = moedas - custoDica;
                                                        //Mostra com quantas moedas o jogador ficou após comprar uma das dicas:
                                                            System.out.println("Vcoê ficou com " + subtracao + " moedas.");
                                        }

                                } else if (resposta.equals("3")) {
                                    System.out.println("\nDica escolhida: Dica 3.");
                                        if (Dica(3, moedas, PodeUsarDica)) {
                                            //Preço das dicas:
                                                int custoDica = 10;
                                                    int subtracao = moedas - custoDica;
                                                        //Mostra com quantas moedas o jogador ficou após comprar uma das dicas:
                                                            System.out.println("Vcoê ficou com " + subtracao + " moedas.");
                                        }

                                } else {
                                    try {
                                        int numDica = Integer.parseInt(resposta);
                                            if (Dica(numDica, moedas, PodeUsarDica)) {
                                                moedas -= (numDica == 1 ? 5 : numDica == 2 ? 10 : 15);
                                            }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Opção inválida!");
                                        System.out.println("Digite apenas 1, 2 ou 3:");
                                            resposta = lerEntrada(scanner);
                                    }
                                }
                            }
                        } while (!resposta.equals("1") && !resposta.equals("2") && !resposta.equals("3"));

                        this.usouDica = true;
                        continue;
                        
                }
                                        
                    //Volta na pergunta em questão:
                        System.out.println("\n" + pergunta);
                            for (int i = 0; i < alternativas.length; i++) {
                                System.out.println((i+1) + ") " + alternativas[i]);
                            }
            
                System.out.println("Digite o número da resposta (1-" + alternativas.length + "):");
                    resposta = lerEntrada (scanner);

                    try {
                        return Integer.parseInt(resposta) == respostaCorreta;
                    } catch (NumberFormatException e) {
                        return false;
                    }
            }

    }
}
