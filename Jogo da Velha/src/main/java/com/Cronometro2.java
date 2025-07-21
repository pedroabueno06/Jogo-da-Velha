package com;
import java.util.Scanner;
public class Cronometro2 {
    private Thread cronometro2;
    private volatile boolean TempoEsgotado2; //o volatile é utilizado para indicar que uma variável pode ser modificada por diferentes threads de forma simultânea
    private long TempoInicial2;
    private long TempoLimite2;
    private long TempoDecorrido2;
    private long tempoRestante2;
    private boolean Enter2;
    private Scanner scanner2;

public Cronometro2() {
    this.scanner2 = new Scanner(System.in);
    this.TempoEsgotado2 = false;
    this.Enter2 = false;
}
    public void iniciar2() {
        this.TempoInicial2 = System.currentTimeMillis();
        this.TempoLimite2 = 300; //5 minutos em segundos
        this.TempoEsgotado2 = false;
        MostrarTempo2();
    }

    public void iniciar2(int segundos) {
        this.TempoInicial2 = System.currentTimeMillis();
        this.TempoLimite2 = segundos;
        this.TempoEsgotado2 = false;
        this.Enter2 = false;
        MostrarTempo2();
    }

    public boolean TempoEsgotado2() {
        return TempoEsgotado2;
    }

    private void MostrarTempo2() {
        cronometro2 = new Thread (() -> {

            while (!TempoEsgotado2()) {
                long agora = System.currentTimeMillis();
                    TempoDecorrido2 = (agora - TempoInicial2) /1000;
                        tempoRestante2 = TempoLimite2 - TempoDecorrido2;

                if (tempoRestante2 <= 0) {
                        TempoEsgotado2 = true;
                        System.out.print("\r    ");
                            System.out.println("\n Seu tempo para ler as explicações da pergunta está esgotado, por tanto, você deve responder a pergunta imediatamente.");
                                System.out.println("\nPressione ENTER para continuar o jogo:");
                                    break;
                }

                            System.out.print("\r[Tempo restante: " + tempoRestante2 + " s]"); //\r com que o cronômetro fique na mesma linha, ou seja, não deixa o cronômetro não fique se duplicando a cada segundo que passa
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    return;
                                }
            }
        });
        cronometro2.start();
    }

    public void Enter2() {
        if (TempoEsgotado2) {
            Enter2 = false;
                pararCronometro2();
        }
    }

    public void pararCronometro2() {
        if (cronometro2 != null) {
            cronometro2.interrupt();
        }
        TempoLimite2 = 0;
        TempoEsgotado2 = true;
    }
}


