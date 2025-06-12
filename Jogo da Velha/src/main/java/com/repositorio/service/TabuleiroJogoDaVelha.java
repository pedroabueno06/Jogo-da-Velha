package  com.repositorio.service;
public class TabuleiroJogoDaVelha {
    public void removerJogada(int linha, int coluna) {
    if (linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho) {
        matriz[linha][coluna] = ' ';
    }
}
    private char[][] matriz;
    private int tamanho;
    private String tipo;

    public TabuleiroJogoDaVelha (String tipo) {
        this.tipo = tipo;
        switch (tipo) {
            //tabuleiro 3x3:
            case "1":
                this.tamanho = 3;
                    break;

            //tabuleiro 4x4:
            case "2":
                this.tamanho = 4;
                    break;

            //tabuleiro 5x5:
            case "3": 
                this.tamanho = 5;
                    break;
        }

        this.matriz = new char[tamanho][tamanho];
            iniciarTabuleiro(); 
    }

        //inicia o tabuleiro:
        private void iniciarTabuleiro() {
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    matriz[i][j] = ' ';
                }
            }
        }

        //mostra a imagem do tabuleiro:
        public void mostrarTabuleiro() {
            for (int i = 0; i < tamanho; i++) {
                System.out.println(); // serve para quebrar a linha
                for (int j = 0; j < tamanho; j++) {
                    System.out.print(" " + (matriz[i][j] == ' ' ? '-' : matriz[i][j]) + " "); //os operádores ternários ? e : são substitutos dos operadores concidcionais if/else:
                        if (j < tamanho -1 ) {
                            System.out.print("|"); //faz com que as colunas possam ser divididas
                        }
                }
                        System.out.println();
                            if ( i < tamanho - 1) {
                                for (int k = 0; k < tamanho; k++) {
                                    System.out.print("---"); //faz com que as linhas possam ser divididas
                                        if ( k < tamanho -1) {
                                            System.out.print("+");
                                        }
                                }
                            } 
            }
             System.out.println();
        }

        //faz com que o jogador possa realizar jogadas:
        public boolean realizarJogada (int linha, int coluna, char simbolo) {
            if ( linha >= 0 && linha < tamanho && coluna >= 0 && coluna < tamanho && matriz[linha][coluna] == ' ') {
                matriz[linha][coluna] = simbolo;
                    return true;
            }
            return false;
        }

        //sistema verifica linhas do tabuleiro:
        public boolean verificarVitoria (char simbolo) {
            //verifica linhas
            for  (int i = 0 ; i < tamanho; i++) {
                boolean vitoriaLinha = true;
                for (int j = 0; j < tamanho; j++) {
                    if  (matriz [i][j] != simbolo) {
                        vitoriaLinha = false;
                        break;
                    }
                }    
                if (vitoriaLinha) {
                    return true;
                }
            }
            
        //sistema verifica colunas do tabuleiro:
        for (int j = 0; j < tamanho; j++) {
            boolean vitoriaColuna = true;
            for (int i = 0; i < tamanho; i++) {
                if (matriz[i][j] != simbolo) {
                    vitoriaColuna = false;
                    break;
                }
            }
            if (vitoriaColuna) {
                return true;
            }
        }
        //sistema verifca a diagonal principal do tabuleiro:
        boolean vitoriaDiagonal1 = true;
        for (int i = 0; i < tamanho; i++) {
            if (matriz[i][i] != simbolo) { 
                vitoriaDiagonal1 = false;
                break;
            }
        }
        if (vitoriaDiagonal1) {
            return true;
        }

            //sistema verifica a diagonal secundária:
            boolean vitoriaDiagonal2 = true;
            for (int i = 0; i < tamanho; i++) {
                if (matriz[i][tamanho - 1 - i] != simbolo) {
                    vitoriaDiagonal2 = false;
                    break;
                }
            }
            return vitoriaDiagonal2;
        }

        //sistema verifica se o jogo não deu empate:
        public boolean verificaEmpate() {
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    if (matriz[i][j] == ' ') {
                        return false;
                    }
                }
            }
            return true;
        }
            
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}