import java.util.Scanner;
public class Perguntas {
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
    String resposta = scanner.nextLine();
    
    return Integer.parseInt(resposta) == respostaCorreta;
    }
}
