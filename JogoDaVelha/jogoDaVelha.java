import java.text.MessageFormat;
import java.util.Arrays;

public class jogoDaVelha {

    private int dimensao;
    private char[][] tabuleiro;
    private int jogadasRestantes;

    public jogoDaVelha(int dimensao) {

        this.dimensao = dimensao;
        this.jogadasRestantes = dimensao * dimensao;
        tabuleiro = new char[dimensao][dimensao];
    }

    public int getJogadasRestantes() {
        return jogadasRestantes;
    }

    public boolean realizaJogada(int x, int y, char valor) {

        if (jogadasRestantes == 0) {

            System.out.println("empate");
            return false;
        }

        if (x < 0 || x > (dimensao-1)) {

            System.out.println("erro");
            return false;
        }
        if  (y < 0 || y > (dimensao-1)){
            
            System.out.println("erro");
            return false;
        }

        if (tabuleiro[x][y] == 0) {

            tabuleiro[x][y] = valor;
            jogadasRestantes--;
            return true;
        }

        System.out.println("erro");
        return false;
    }

    public boolean verificaGanhador() {

        for (int x = 0; x < tabuleiro.length; x++) {

            int pontos = 1;
            if (tabuleiro[x][0] == 0) {
                continue;
            }

            char jogador1 = tabuleiro[x][0];
            for (int y = 1; y < tabuleiro.length; y++) {

                if (tabuleiro[x][y] == 0) {
                    break;
                }
                if (tabuleiro[x][y] == jogador1) {
                    pontos++;
                }
            }

            if (pontos == dimensao) {

                System.out.println("O jogo acabou.");
                return true;
            }
        }

        for (int x = 0; x < tabuleiro.length; x++) {

            int pontos = 1;

            if (tabuleiro[0][x] == 0) {
                continue;
            }

            char jogador1 = tabuleiro[0][x];

            for (int y = 1; y < tabuleiro.length; y++) {

                if (tabuleiro[y][x] == 0) {
                    break;
                }

                if (tabuleiro[y][x] == jogador1) {
                    pontos++;
                }
            }

            if (pontos == dimensao) {

                System.out.println("O jogo acabou.");
                return true;
            }
        }

        if (tabuleiro[0][0] != 0) {

            char jogador1 = tabuleiro[0][0];
            int pontos = 1;

            for (int x = 1; x < tabuleiro.length; x++) {

                if (tabuleiro[x][x] == 0) {
                    break;
                }

                if (tabuleiro[x][x] == jogador1) {
                    pontos++;
                }
            }

            if (pontos == dimensao) {

                System.out.println("O jogo acabou.");
                return true;
            }
        }

        if (tabuleiro[0][tabuleiro.length - 1] != 0) {

            char jogador1 = tabuleiro[0][tabuleiro.length - 1];
            int pontos = 1;

            for (int x = 1; x < tabuleiro.length; x++) {

                if (tabuleiro[x][tabuleiro.length - x - 1] == 0) {
                    break;
                }

                if (tabuleiro[x][tabuleiro.length - x - 1] == jogador1) {
                    pontos++;
                }
            }

            if (pontos == dimensao) {

                System.out.println("O jogo acabou.");
                return true;
            }
        }

        System.out.println();
        return false;
    }

    @Override
    public String toString() {
 
        System.out.println("------------------------------------------");

        System.out.print("   ");
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print(i + "   ");
        }
       
        System.out.println();
        for (int x = 0; x < tabuleiro.length; x++) {

            System.out.print(x + " ");
            for (int y = 0; y < tabuleiro.length; y++) {

                if (tabuleiro[x][y] == 0) {

                    System.out.print(MessageFormat.format("| {0} ", tabuleiro[x][y]));
                } else {
                    System.out.print(MessageFormat.format("| {0} ", tabuleiro[x][y]));
                }

            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("------------------------------------------");

       return "Jogo Da Velha, dimensão " + dimensao + ", tabuleiro " + Arrays.toString(tabuleiro);
    }

}