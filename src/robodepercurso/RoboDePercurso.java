/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robodepercurso;

import java.util.Random;
import java.util.Scanner;
import static robodepercurso.Robo.*;

/**
 * Conforme entrevista realizada ontem, e como forma de avaliação de sua
 * proficiência em programação Java, faça o seguinte exercício.
 *
 * Dado: Um espaço plano de 10x10 (Matriz). Crie: Um robô capaz de responder aos
 * seguintes comandos: - Andar x casas; - Virar para x (esquerda, direita, baixo
 * e cima); - Virar para x e andar x casas; - O seu espaço plano é circular,
 * caso o robô atinja o final [9] volta começa a contar novamente do começo [0];
 * - Pense que o robô pode “aprender” a executar outras funções, ou até mesmo
 * criar-se uma versão 2 do robô, então acrescentar novas funcionalidades deve
 * ser simples e sem impacto na aplicação toda. - A cada movimento de andar é
 * preciso informar qual a localização atual do robô no espaço;
 *
 * @author ClaudineiJr
 *
 */
public class RoboDePercurso {

    private static int Gerador() {
        Random local = new Random();
        return local.nextInt(10);
    }

    public static void menu() {
        System.out.println("0. Destuir SkyNet");
        System.out.println("1. Anda logo");
        System.out.println("2. Virar robo");
        System.out.println("3. Virar e andar");
//        System.out.println("4. Andar diagonal");
        System.out.println("Opcao:");
    }

    private static void Andar(int num, Robo Hal2000) {
        LimparMundo(Hal2000);
        int qnt = 0;
        if ((num == 0) || (num < 0)) {
            System.out.println("Quantidade invalida");
        } else if ("cima".equals(Hal2000.direcao)) {
            do {
                if (Hal2000.x == 0) {
                    Hal2000.x = 10;
                }
                Hal2000.x--;
                qnt++;
            } while (qnt != num);
            Hal2000.mundo[Hal2000.x][Hal2000.y] = Hal2000.robot;
        } else if ("baixo".equals(Hal2000.direcao)) {
            for (int i = 0; i < num; i++) {
                if (Hal2000.x > 10) {
                    Hal2000.x = 0;
                }
                Hal2000.x++;
            }
            Hal2000.mundo[Hal2000.x][Hal2000.y] = Hal2000.robot;
        } else if ("esquerda".equals(Hal2000.direcao)) {
            do {
                if (Hal2000.x == 0) {
                    Hal2000.x = 10;
                }
                Hal2000.x--;
                qnt++;
            } while (qnt != num);
            Hal2000.mundo[Hal2000.x][Hal2000.y] = Hal2000.robot;
        } else if ("direita".equals(Hal2000.direcao)) {
            for (int i = 0; i < num; i++) {
                if (Hal2000.y > 10) {
                    Hal2000.y = 0;
                }
                Hal2000.y++;
            }
            Hal2000.mundo[Hal2000.x][Hal2000.y] = Hal2000.robot;
        }
    }

    private static void VirarRobo(Robo Hal2000, String direcao) {
        switch (direcao) {
            case "esquerda":
                Hal2000.direcao = direcao;
                break;
            case "direita":
                Hal2000.direcao = direcao;
                break;
            case "cima":
                Hal2000.direcao = direcao;
                break;
            case "baixo":
                Hal2000.direcao = direcao;
                break;
            default:
                System.out.println("\t! ERROR de direcao !\n");
                break;
        }
    }

    private static void VirarAndar(int num, String direcao, Robo Hal2000) {
        VirarRobo(Hal2000, direcao);
        Andar(num, Hal2000);
    }

    public static void ImprimirMundo(Robo Hal2000) {
        for (int i = 0; i < Hal2000.mundo.length; i++) {
            for (int j = 0; j < Hal2000.mundo.length; j++) {
                System.out.print(Hal2000.mundo[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("Linha " + (Hal2000.x + 1) + "\t Coluna " + (Hal2000.y + 1) + "\t Direcao " + Hal2000.direcao + "\n");
    }

    public static void LimparMundo(Robo Hal2000) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Hal2000.mundo[i][j] = ".";
            }
        }
    }

    public static void Mundo(Robo Hal2000) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Hal2000.mundo[i][j] = ".";
            }
        }
        Hal2000.mundo[Hal2000.x][Hal2000.y] = Hal2000.robot;
    }

    public static void Direcao(Robo Hal2000) {
        System.out.println("\n Direcao atual  " + Hal2000.direcao);
        System.out.println("1. direita \n2. esquerda \n3. cima \n4. baixo \nDigite direcao:  ");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[][] mundo = new String[10][10];
        Robo Hal2000 = new Robo(mundo, "esquerda", "@", Gerador(), Gerador());
        int opcao, num;
        String direcao;
        Scanner entrada = new Scanner(System.in);

        Mundo(Hal2000);
        do {

            ImprimirMundo(Hal2000);
            menu();
            opcao = entrada.nextInt();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    System.out.println("Quantas casas?");
                    num = entrada.nextInt();
                    Andar(num, Hal2000);
                    break;

                case 2:
                    Direcao(Hal2000);
                    direcao = entrada.next().toLowerCase();
                    VirarRobo(Hal2000, direcao);
                    break;

                case 3:
                    Direcao(Hal2000);
                    direcao = entrada.next();
                    System.out.println("Quantas casas?");
                    num = entrada.nextInt();
                    VirarAndar(num, direcao, Hal2000);
                    break;
//                case 4:
//                    break;
                default:
                    System.out.println("Sorry Dave. I can't this");
            }
        } while (opcao != 0);
    }

}
