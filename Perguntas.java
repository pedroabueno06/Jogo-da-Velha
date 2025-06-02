import java.util.Scanner;

public class Perguntas {
//Método para o jogador encerrar o jogo om a tecla "/" em qualquer momento do jogo:
    public static String lerEntrada (Scanner scanner) {
        String entrada = scanner.nextLine();
            if (entrada.equals ("/")) {
                    System.out.println("Uma pena você não querer jogar nosso jogo.");
                        System.exit(0);
            }
            return entrada;
        }

    //Atributos:
    private String pergunta;
    private String[] alternativas;
    private int respostaCorreta;
    private String dificuldade;

    public Perguntas (String pergunta, String[] alternativas, int respostaCorreta, String dificuldade) {
        this.pergunta = pergunta;
        this.alternativas = alternativas;
        this.respostaCorreta = respostaCorreta;
        this.dificuldade = dificuldade;
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
    
    public boolean fazerPergunta(Scanner scanner) {
            System.out.println(pergunta);
    for (int i = 0; i < alternativas.length; i++) {
        System.out.println((i+1) + ") " + alternativas[i]);
    }
    
    System.out.println("\nDigite o número da resposta (1-" + alternativas.length + "):");
    String resposta = lerEntrada (scanner);
    
    return Integer.parseInt(resposta) == respostaCorreta;
}
    }
