package algorytmika.Excercises1;

import java.util.Scanner;

public class PrintFigures {
    public static void main(String[] args) {
        System.out.println("==Draw 4 figures. Give number of hight and wight: ");
        int n = new Scanner(System.in).nextInt();

        printTriangle(n);
        System.out.println();
        printDiagonal(n);
        System.out.println();
        printSquare(n);
        System.out.println();
        printSecendDiagonal(n);
        System.out.println();

    }

    private static void printSecendDiagonal(int n) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (j == i|| (j==n-i-1)) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();

        }
    }

    private static void printSquare(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //if(i==0){
                if (i == 0 || (i == n - 1)) {
                    System.out.print("* ");
                } else {
                    if (j == 0 || (j == n - 1)) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();

        }
    }

    private static void printDiagonal(int n) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {
                if (j == i) System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();

        }
    }

    private static void printTriangle(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();

        }
    }
}
