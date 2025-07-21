package com;
import java.util.Scanner;
public class Cronometro1 {
    private Thread cronometro1;
    private volatile boolean tempoEsgotado1; //o volatile é utilizado para indicar que uma variável pode ser modificada por diferentes threads de forma simultânea
    private long tempoInicial1;
    private long tempoLimite1;
    private long tempoDecorrido1;
    private long tempoRestante1;
    private boolean Enter1;
    private Scanner scanner1;
    
public Cronometro1() {
    this.scanner1 = new Scanner(System.in);
    this.tempoEsgotado1 = false;
    this.Enter1 = false;
}

    public void iniciar2() {
        this.tempoInicial1 = System.currentTimeMillis();
        this.tempoLimite1 = 60; //1 minuto em segundos
        this.tempoEsgotado1 = false;
        mostrarTempo1();
    }

    public void iniciar1(int segundos) {
        this.tempoInicial1 = System.currentTimeMillis();
        this.tempoLimite1 = segundos;
        this.tempoEsgotado1 = false;
        this.Enter1 = false;
        mostrarTempo1();
    }

    public boolean tempoEsgotado1() {
        return tempoEsgotado1;
    }
    
    private void mostrarTempo1() {
        cronometro1 = new Thread (() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }

            while (!tempoEsgotado1()) {
                long agora = System.currentTimeMillis();
                    tempoDecorrido1 = (agora - tempoInicial1) /1000;
                        tempoRestante1 = tempoLimite1 - (int) tempoDecorrido1;

                if (tempoRestante1 <= 0) {
                        tempoEsgotado1 = true;
                        System.out.print("\r    ");
                            System.out.println("\nSeu tempo está esgotado, por tanto a vez é do próximo jogador.");
                                System.out.println("Pressione ENTER para continuar o jogo:");
                                    break;
                }

                            System.out.print("\r[Tempo restante: " + tempoRestante1 + " s]"); //\r com que o cronômetro fique na mesma linha, ou seja, não deixa o cronômetro não fique se duplicando a cada segundo que passa
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    break;
                                }
            }
        });
        cronometro1.start();
    }

    public void Enter1() {
        if (tempoEsgotado1) {
            Enter1 = false;
                pararCronometro1();
        }
    }

    public void pararCronometro1() {
        if (cronometro1 != null) {
            cronometro1.interrupt();
        }
        tempoLimite1 = 0;
        tempoEsgotado1 = true;
    }
}
