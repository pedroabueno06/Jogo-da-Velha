public class LinhaColuna {
    private char símbolo;
    private int tamanho;
    
    public LinhaColuna() {
        this.símbolo = ' ';
    
    }

    public char getSímbolo() {
        return símbolo;
    }

    public void setSímbolo(char símbolo) {
        if (this.símbolo == símbolo){
            this.símbolo = símbolo;
        }else {
            System.out.print("Este campo já está sendo utilizado");
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
}
