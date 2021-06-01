import java.util.Scanner;

public class principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o nome do primeiro jogador: ");
        String nomeJogador1 = sc.nextLine();

        Jogador jogador1 = new Jogador(nomeJogador1);

        System.out.print("Informe o nome do segundo jogador: ");
        String nomeJogador2 = sc.nextLine();

        Jogador jogador2 = new Jogador(nomeJogador2);

        System.out.print("Informe o tamanho do tabuleiro: ");
        int tamanhoTabuleiro = sc.nextInt();
        sc.nextLine();

        jogoDaVelha jogoDaVelha = new jogoDaVelha(tamanhoTabuleiro);
        jogoDaVelha.toString();


        boolean continua = true;
        while (continua) {

            IniciaRodada(jogador1, jogador2, jogoDaVelha);

            System.out.println("\nSelecione uma opção:");
            System.out.println("1 - Nova partida. ");
            System.out.print("2 - Para terminar. ");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 2) {

                System.out.println("\n-------------- Placar final --------------");
                System.out.println(jogador1.getNome() +" ficou com " + jogador1.getPontuacao() + " ponto(s).");
                System.out.println("vs");
                System.out.println(jogador2.getNome() +" ficou com " + jogador2.getPontuacao() + " ponto(s).");

                if (jogador1.getPontuacao() == jogador2.getPontuacao()) {

                    System.out.println();
                    System.out.println("O jogo empatou");
                    System.out.println("---------------------------------------------");
                } else if (jogador1.getPontuacao() > jogador2.getPontuacao()) {

                    System.out.println();
                    System.out.println(jogador1.getNome() + " ganhou!");
                    System.out.println("---------------------------------------");
                } else {
                    
                    System.out.println();
                    System.out.println(jogador2.getNome() + " ganhou!");
                    System.out.println("---------------------------------------");

                }

                continua = false;
            } else {

                jogoDaVelha = new jogoDaVelha(tamanhoTabuleiro);
                jogoDaVelha.toString();
            }

        }

    }

    private static void IniciaRodada(Jogador jogador1, Jogador jogador2, jogoDaVelha jogoDaVelha) {

        Scanner sc = new Scanner(System.in);
        boolean vencedor = false;
        while (!vencedor) {

            System.out.println(jogador1.getNome() + " informe onde quer marcar X .");

            boolean jogadaValida = false;
            while (!jogadaValida) {

                System.out.print("Linha: ");
                int valorX = sc.nextInt();
                sc.nextLine();
                System.out.print("Coluna: ");
                int valorY = sc.nextInt();
                sc.nextLine();

                jogadaValida = jogoDaVelha.realizaJogada(valorX, valorY, 'X');
            }

            jogoDaVelha.toString();

            vencedor = jogoDaVelha.verificaGanhador();

            if (vencedor) {
                jogador1.adicionaPonto();
                System.out.println(jogador1.getNome() + " ganhou esta rodada e está com " + jogador1.getPontuacao() + " ponto(s)");
                break;
            } else if (jogoDaVelha.getJogadasRestantes() == 0) {
                System.out.println("Empatou");
                break;
            }

            System.out.println(jogador2.getNome() + " informe onde quer marcar O .");

            jogadaValida = false;
            while (!jogadaValida) {

                System.out.print("Linha: ");
                int valorX = sc.nextInt();
                sc.nextLine();
                System.out.print("Coluna: ");
                int valorY = sc.nextInt();
                sc.nextLine();

                jogadaValida = jogoDaVelha.realizaJogada(valorX, valorY, 'O');
            }

            jogoDaVelha.toString();

            vencedor = jogoDaVelha.verificaGanhador();

            if (vencedor) {
                jogador2.adicionaPonto();
                System.out.println(jogador2.getNome() + " ganhou esta rodada e está com " + jogador2.getPontuacao() + " ponto(s)");
                break;
            }
            if (jogoDaVelha.getJogadasRestantes() == 0) {
                System.out.println("Empatou");
                break;
            }

        }
    }

}
