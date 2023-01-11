import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int op;

        do {
            System.out.println("Bem-vindo ao jogo 21 fósforos");
            System.out.println("Escolha uma das seguintes opções");
            System.out.println("1-Dois jogadores (humano vs humano)");
            System.out.println("2-Jogue contra o computador (humano vs PC) modo fácil");
            System.out.println("3-Jogue contra o computador (humano vs PC) modo difícil");
            System.out.println("0-Sair");
            op = in.nextInt();

            if (op == 0) {
                break;
            } else if (op == 1) {
                humanoVShumano();
            } else if (op == 2) {
                humanoVScomputadorMF();
            } else if (op == 3) {
                humanoVScomputadorMD();
            } else {
                System.out.println("Opção inválida, tente novamente");
            }
        } while (op != 0);
    }

    private static void humanoVScomputadorMF() {
        int totalFosforos = 21, valorInserido, nmrMax=4, nmrUtil = 1, jogadaPC;
        Random rnd = new Random();

        while (totalFosforos > 1) {
            if(totalFosforos <= 4) {nmrMax = (totalFosforos - 1);}

            System.out.println("Por favor, retira no máximo " + nmrMax + " fósforos. Existem " + totalFosforos + " fósforos.");
            valorInserido = in.nextInt();
            if (valorInserido <= nmrMax && valorInserido >= 1) {
                totalFosforos = totalFosforos - valorInserido;
                System.out.println("Retiraste " + valorInserido + " fósforos. Existem " + totalFosforos + " fósforos.");

                if (totalFosforos > 1) {
                    jogadaPC = rnd.nextInt(1, nmrMax);
                    totalFosforos = totalFosforos - jogadaPC;
                    System.out.println("O computador retirou " + jogadaPC + " fósforos. Restam " + totalFosforos + " fósforos.");
                } else { nmrUtil = 2;}
            } else {
                System.out.println("Jogada Inválida! Repete.");
            }
        }
        if (nmrUtil == 1){
            System.out.println("Que azar! O computador ganhou!");
        } else {System.out.println("Parabéns!! Ganhaste o jogo contra o computador!");}
    }

    private static void humanoVShumano() {
        int totalFosforos = 21, valorInserido, nmrMax=4, nmrUtil = 1;

        while (totalFosforos > 1) {
            if(totalFosforos <= 4) {nmrMax = (totalFosforos - 1);}

            System.out.println("Jogador número " + nmrUtil + ", por favor, retire no máximo " + nmrMax + " fósforos. Existem " + totalFosforos + " fósforos.");
            valorInserido = in.nextInt();
            if (valorInserido <= nmrMax && valorInserido >= 1) {
                totalFosforos = totalFosforos - valorInserido;
                if(nmrUtil == 1) {nmrUtil=2;} else {nmrUtil=1;}
            } else {
                System.out.println("Jogada Inválida! Repita.");
            }
        }
        System.out.println("Jogador número " + nmrUtil + " perdeu!");
    }

    private static void humanoVScomputadorMD() {
        int totalFosforos = 21, valorInserido, nmrMax=4, nmrUtil = 1, jogadaPC;

        while (totalFosforos > 1) {
            if(totalFosforos <= 4) {nmrMax = (totalFosforos - 1);}

            System.out.println("Por favor, retira no máximo " + nmrMax + " fósforos. Existem " + totalFosforos + " fósforos.");
            valorInserido = in.nextInt();
            if (valorInserido <= nmrMax && valorInserido >= 1) {
                totalFosforos = totalFosforos - valorInserido;
                System.out.println("Retiraste " + valorInserido + " fósforos. Existem " + totalFosforos + " fósforos.");

                if (totalFosforos > 1) {
                    jogadaPC = (5 - valorInserido);
                    totalFosforos = totalFosforos - jogadaPC;
                    System.out.println("O computador retirou " + jogadaPC + " fósforos. Restam " + totalFosforos + " fósforos.");
                } else { nmrUtil = 2;}
            } else {
                System.out.println("Jogada Inválida! Repete.");
            }
        }
        if (nmrUtil == 1){
            System.out.println("Que azar! O computador ganhou!");
        } else {System.out.println("Parabéns!! Ganhaste o jogo contra o computador!");}
    }
}