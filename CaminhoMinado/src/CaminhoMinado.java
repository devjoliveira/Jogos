import java.util.Scanner;

public class CaminhoMinado {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int tamanho, numeroDeBombas, posicao, contador = 0, pontos = 0;
        boolean errou = false;
        do {
            System.out.print("Digite o tamanho do caminho: ");
            tamanho = entrada.nextInt();
        } while (tamanho <= 1);
        do {
            System.out.print("Digite o número de bombas: ");
            numeroDeBombas = entrada.nextInt();
        } while (numeroDeBombas <= 0 || numeroDeBombas >= tamanho);
        int[] caminho = new int[tamanho];
        do {
            posicao = (int) (Math.random() * (tamanho));
            if (caminho[posicao] == 0) {
                caminho[posicao] = -1;
                contador = contador + 1;
            }
        } while (contador < numeroDeBombas);
        do { // Laço principal
            for (int j : caminho) {
                if (j == 0 || j == -1) {
                    System.out.print(" _ ");
                } else {
                    System.out.print(" x ");
                }
            }
            System.out.println();
            for (int i = 0; i < caminho.length; i++) {
                System.out.print(STR."[\{i}]");
            }
            do {
                System.out.print("\nInforme uma posição: ");
                posicao = entrada.nextInt();
            } while (caminho[posicao] == 1);
            if (caminho[posicao] == -1) {
                errou = true;
            } else {
                caminho[posicao] = 1;
                pontos = pontos + 1;
                if (posicao == 0) {
                    if (caminho[posicao + 1] == -1) {
                        System.out.println("CUIDADO: bomba próxima!");
                    }
                } else if (posicao == (tamanho - 1)) {
                    if (caminho[tamanho - 2] == -1) {
                        System.out.println("CUIDADO: bomba próxima!");
                    }
                } else if (caminho[posicao - 1] == -1 || caminho[posicao
                        + 1] == -1) {
                    System.out.println("CUIDADO: bomba próxima!");
                }
            }
        } while (!errou && pontos < (tamanho - numeroDeBombas));
        if (errou) { // Perdeu
            for (int j : caminho) {
                if (j == 0) {
                    System.out.print(" _ ");
                } else if (j == 1) {
                    System.out.print(" x ");
                } else {
                    System.out.print(" b ");
                }
            }
            System.out.println();
            for (int i = 0; i < caminho.length; i++) {
                System.out.print(STR."[\{i}]");
            }
            System.out.println("\nGame Over!");
            System.out.println(STR."Pontuação: \{pontos}/\{tamanho - numeroDeBombas}");
        } else { // Ganhou
            for (int j : caminho) {
                if (j == 1) {
                    System.out.print(" x ");
                } else if (j == -1) {
                    System.out.print(" b ");
                }
            }
            System.out.println();
            for (int i = 0; i < caminho.length; i++) {
                System.out.print(STR."[\{i}]");
            }
            System.out.println("\nParabéns, você ganhou o jogo!");
            System.out.println(STR."Pontuação: \{pontos}/\{tamanho - numeroDeBombas}");
        }
    }
}