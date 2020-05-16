package trabgrafo;

public class No {

    private String nome;
    private boolean visitado;
    private boolean adicionado;
    private No prox;
    Fila vizinhos= new Fila();
    private int peso;
    

    public No(String nome) {
        this.nome = nome;
        this.visitado = false;
    }

    public No(String nome, boolean visitado, int peso) {
        this.nome = nome;
        this.visitado = false;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
    
}
