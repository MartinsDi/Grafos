/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabgrafo;

/**
 *
 * @author Artur
 */
public class Fila {

    No inicio;
    No fim;
    private int qtd;
    private int arestas;
    private boolean find = false;

    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.qtd = 0;
    }

    public boolean isEmpty() {
        return ((this.inicio == null)
                && (this.fim == null));
    }

    public boolean enqueue(String numero) {

        No novo = new No(numero);

        if (isEmpty()) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            this.fim.setProx(novo);
            this.fim = novo;
        }

        this.qtd++;
        return true;
    }

    public boolean enqueue(No novo) {

        if (isEmpty()) {
            this.inicio = novo;
            this.fim = novo;
        } else {
            this.fim.setProx(novo);
            this.fim = novo;
        }

        this.qtd++;
        return true;
    }

    public No dequeue() {
        No removido;

        if (isEmpty()) {
            return null;
        }

        removido = this.inicio;

        if (this.fim == this.inicio) {
            this.fim = null;
            this.inicio = null;
        } else {
            this.inicio = this.inicio.getProx();
            removido.setProx(null);
        }
        this.qtd--;

        return removido;
    }

    public int size() {
        return this.qtd;
    }

    public void adicionaVizinho(String no, String n, int num) {
        No aux;
        aux = this.inicio;
        No novo = new No(n);

        while (aux != null) {

            if (no.equals(aux.getNome())) {
                aux.vizinhos.enqueue(novo);
                arestas++;
                break;
            } else {
                aux = aux.getProx();
            }

        }

    }
    public void encontra(Fila visita, String inicia, String busca) {
        percorre(visita, inicia);
        if (find) {

            No aux = visita.inicio;
            while (aux != null) {
                if (!aux.getNome().equalsIgnoreCase(busca)) {
                    abreVizinho(aux.vizinhos, visita);
                    aux.setVisitado(true);
                    //String a = visita.dequeue().getNome();
                   // System.out.println(a);
                }else{
                    System.out.println("Vertice encontrado");
                    System.out.println(aux.getNome());
                    System.out.println(busca);
                }
            }
        }

    }

    public void percorre(Fila visita, String busca) {
        No aux;
        aux = this.inicio;
        while (aux != null || !find) {
            if (aux.getNome().equalsIgnoreCase(busca)) {
                aux.setVisitado(true);
                visita.enqueue(aux);
                find = true;
            }
            aux = aux.getProx();
        }
    }

    public void abreVizinho(Fila vizinhos, Fila visita) {

        No aux;
        aux = vizinhos.inicio;
        while (aux != null) {
            visita.enqueue(aux);
            aux = aux.getProx();
        }

    }
    

    @Override
    public String toString() {
        String retorno = "Fila{";
        No aux = this.inicio;
        if (this.isEmpty()) {
            retorno += '}';
            return retorno;
        }

        while (aux != null) {
            retorno += aux.getNome() + "->";
            aux = aux.getProx();
        }

        retorno += '}';
        return retorno;
    }

}
