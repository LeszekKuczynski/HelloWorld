/*
 * Wejście: W - wartość liczby
 * Wyjście: ciąg cyfr binarnych reprezentujących w systemie dwójkowym wartość W
 *
 * K01: kolejna cyfra ← W mod 2, W ← W div 2
 * K02: Jeśli W > 0, to idź do K01
 * K03: Wyprowadź otrzymane cyfry w kolejności odwrotnej do ich otrzymania
 * K04: Zakończ
 */

package algorytmika;

import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println("--Change given decimal number to binary system representacion---");
        long decymal = new Scanner(System.in).nextLong();
        if(decymal>-1)
            System.out.println("Binary system representacion: " + decymalToBinary(decymal));
        else System.out.println("Only positive itegers and zero allowed");
    }
    private static String decymalToBinary(long decymal) {
        if (decymal < 1) return "0";
        if (decymal == 1) return "1";
        if (decymal % 2 == 0) return decymalToBinary(decymal / 2) + "0";
        return decymalToBinary(decymal / 2) + "1";
    }
}
