public class Cronometro {
    private Thread cronometro;
    private volatile boolean tempoEsgotado; //O volatile é utilizado para indicar que uma variável pode ser modificada por diferentes threads de forma simultânea
    private volatile boolean jogadaFeita;
    private long tempoInicial;
    private long tempoLimite;
    private boolean ativo;
    private long tempoDecorrido;

public Cronometro() {
    this.tempoEsgotado = false;
    this.jogadaFeita = false;
}

public void iniciar() {
    tempoEsgotado = false;
    jogadaFeita = false;

    cronometro = new Thread (() -> {
        int segundos = 60; //Crônometro inicia com 60 segundos
            while (segundos > 0 && !jogadaFeita) {
                try { //Pode lançar uma execeção
                    Thread.sleep (1000);
                        segundos--;
                        System.out.print("\r [Tempo restante: " + segundos + " s] "); //\r faz com que o cursor retorne ao inicio da linha
                        Thread.sleep (1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
            if (!jogadaFeita && segundos <= 0) {
                tempoEsgotado = true;
                    System.out.println("\nSeu tempo está esgotado, por tanto a vez é do próximo jogador." );
                    
            }
    });

    cronometro.start();

}

    public void pararCronometro() {
        jogadaFeita = false;
            if (cronometro != null) {
                cronometro.interrupt();
            }
    }

    public boolean isTempoEsgotado() {
        return tempoEsgotado;
    }

    public void retornar(long tempo) {
        tempoInicial = System.currentTimeMillis() - (tempoLimite - tempo);
    }

    public long pausar() {
        if (ativo) {
            tempoDecorrido = System.currentTimeMillis() - tempoInicial;
            ativo = false;
            return tempoLimite - tempoDecorrido;
        }
        return tempoLimite;
    }

}
