import java.util.Scanner;
public class Cronometro1 {
    private Thread cronometro1;
    private volatile boolean tempoEsgotado; //O volatile é utilizado para indicar que uma variável pode ser modificada por diferentes threads de forma simultânea
    private long tempoInicial;
    private long tempoLimite;
    private long tempoDecorrido;
    private long tempoRestante;
    private boolean Enter;
    private Scanner scanner;
    
public Cronometro1() {
    this.scanner = new Scanner(System.in);
    this.tempoEsgotado = false;
    this.Enter = false;
}

    public void iniciar() {
        this.tempoInicial = System.currentTimeMillis();
        this.tempoLimite = 60;
        this.tempoEsgotado = false;
        mostrarTempo();
    }

    public void iniciar(int segundos) {
        this.tempoInicial = System.currentTimeMillis();
        this.tempoLimite = segundos;
        this.tempoEsgotado = false;
        this.Enter = false;
        mostrarTempo();
    }

    public boolean tempoEsgotado() {
        return tempoEsgotado;
    }
    
    private void mostrarTempo() {
        cronometro1 = new Thread (() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }

            while (!tempoEsgotado()) {
                long agora = System.currentTimeMillis();
                    tempoDecorrido = (agora - tempoInicial) /1000;
                        tempoRestante = tempoLimite - (int) tempoDecorrido;

                if (tempoRestante <= 0) {
                        tempoEsgotado = true;
                        System.out.print("\r    ");
                            System.out.println("\nSeu tempo está esgotado, por tanto a vez é do próximo jogador.");
                                System.out.println("Pressione ENTER para continuar o jogo:");
                                    break;
                }

                            System.out.print("\r[Tempo restante: " + tempoRestante + " s] ");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    break;
                                }
            }
        });
        cronometro1.start();
    }

    public void Enter() {
        if (tempoEsgotado) {
            Enter = false;
                pararCronometro();
        }
    }

    public void pararCronometro() {
        if (cronometro1 != null) {
            cronometro1.interrupt();
        }
        tempoLimite = 0;
        tempoEsgotado = true;
    }
}
