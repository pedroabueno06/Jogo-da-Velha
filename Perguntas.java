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


    public Perguntas (String pergunta, String[] alternativas, int respostaCorreta, String dificuldade) {
        this.pergunta = pergunta;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
        this.dificuldade = dificuldade;
        this.explicacao = explicacao;
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
    
    public boolean fazerPergunta(Scanner scanner) {
            System.out.println(pergunta);

            //Mostra as alternativas da questão
            for (int i = 0; i < alternativas.length; i++) {
        System.out.println((i+1) + ") " + alternativas[i]);
    }

            //Oferece ao usuário, a opção de receber explicações sobre a pergunta ou apenas responde-la:
            System.out.println("Digite 0 se quiser receber explicações sobre a questão ou 1 para responder a pergunta:");
                resposta = lerEntrada (scanner);

            if (resposta.equals ("0")) {
                    if (explicacao != null) {
                        System.out.println("\nVocê tem 5 minutos para ler as explicações sobre a pergunta em questão:");
                        System.out.println(explicacao);
                        System.out.println("Pressione ENTER para continuar.");
                                resposta = lerEntrada (scanner);
                    } else {
                        System.out.println("\nNão há explicações referentes a esta pergunta.");
                    }
                                    
                                //Volta na pergunta em questão:
                                System.out.println("\n" + pergunta);
                                    for (int i = 0; i < alternativas.length; i++) {
                                        System.out.println((i+1) + ") " + alternativas[i]);
                                    }
            }
            
            System.out.println("Digite o número da resposta (1-" + alternativas.length + "):");
                resposta = lerEntrada (scanner);

            return Integer.parseInt(resposta) == respostaCorreta;
    }
}
