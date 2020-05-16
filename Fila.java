/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabgrafo;

import static java.lang.Thread.sleep;

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

    public boolean busca(Fila visita, String inicial, String busca) throws InterruptedException {
        No aux;
        aux = this.inicio;
        No vis;

        System.out.println("");
        System.out.println("tostring " + visita.toString() + " tostring");

        while (aux != null) {
            System.out.println(visita.toString());
            if (aux.getNome().equalsIgnoreCase(inicial)) {
                System.out.println(aux.getNome());
                System.out.println(inicial);
                visita.enqueue(aux);
                aux.setVisitado(true);
                break;
            }
            aux = aux.getProx();
        }

        if (aux.getNome().equalsIgnoreCase(busca)) {
            find = true;
            return find;
        }
        //primeiro compara
        vis = visita.inicio;
        while (find != true) {
            incrementa(visita, vis);
            vis = vis.getProx();
            vis.setVisitado(true);
            if (vis.getNome().equalsIgnoreCase(busca)) {
                find = true;
                return find;
            }
            buscaVizinhos(visita, vis);
            vis = vis.getProx();
            vis.setVisitado(true);
        }
        return find;

    }

    public void incrementa(Fila visita, No vis) {
        No aux = vis.vizinhos.inicio;
        

        while (aux != null) {
            if (!aux.getVisitado()) {
                visita.enqueue(aux);
                aux.setVisitado(true);
            }
            aux = aux.getProx();
        }
    }

    public void buscaVizinhos(Fila visita, No vis) {
        No aux = this.inicio;
        while (aux != null) {
            if (aux.getNome().equals(vis.getNome())) {
                visita.enqueue(aux);
                break;
            }

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
