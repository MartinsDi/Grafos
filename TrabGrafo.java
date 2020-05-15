package trabgrafo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author diego.oliveira
 */
public class TrabGrafo {

    public static String abrirarquivo() {

        String caminho = "";

        JFileChooser fileChooser = new JFileChooser(); // Menu para escolher o arquivo
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home"))); //pasta inicial para procurar o arquivo

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            caminho = selectedFile.getAbsolutePath(); // caminho do arquivo selecionado
        }

        return caminho;
    }

    public static void main(String[] args) throws IOException {
        int direc;
        int vertices;
        Fila vertice = new Fila();
        Fila visita = new Fila();

        String patch = abrirarquivo();

        BufferedReader BR = new BufferedReader(new FileReader(patch));

        String linha = null;

        direc = Integer.parseInt(linha = BR.readLine());
        vertices = Integer.parseInt(linha = BR.readLine());

        for (int i = 0; i < vertices; i++) {
            linha = BR.readLine();
            No n = new No(linha);
            vertice.enqueue(n);
        }

        linha = BR.readLine();

        if (direc == 0) {
            while (linha != null) {
                StringTokenizer srt = new StringTokenizer(linha, ",");

                while (srt.hasMoreTokens()) {
                    String u = srt.nextToken();
                    String v = srt.nextToken();
                    vertice.adicionaVizinho(u, v, vertices);
                    vertice.adicionaVizinho(v, u, vertices);
                    linha = BR.readLine();

                }

            }
        } else {
            while (linha != null) {
                StringTokenizer srt = new StringTokenizer(linha, ",");

                while (srt.hasMoreTokens()) {
                    String u = srt.nextToken();
                    String v = srt.nextToken();
                    No novo = new No(v);
                    vertice.adicionaVizinho(u, v, vertices);
                }
                linha = BR.readLine();
            }

        }
        System.out.println(vertice.toString());
        No aux = vertice.inicio;
        
            while (aux != null) {
                
            System.out.println("Vertice " + aux.getNome() + " vizinhos:");
            System.out.println(aux.vizinhos.toString());

            aux = aux.getProx();
            
            
        }
            String a = JOptionPane.showInputDialog(null,"Digite o vertice de partida: " );
            String b = JOptionPane.showInputDialog(null,"Digite o vertice de chegada: " );
            vertice.encontra(visita, a, b);
                System.out.println(visita.toString());

    }
}
