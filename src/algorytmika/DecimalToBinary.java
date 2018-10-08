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
        System.out.println("--Change number to binary number---");
        Integer decymal = new Scanner(System.in).nextInt();

        String binary = decymalToBinary(decymal);
        System.out.println(binary);
    }

    private static String decymalToBinary(int decymal) {
        if (decymal < 1)
            return "0";
        if (decymal == 1)
            return "1";
        if (decymal % 2 == 1)
            return decymalToBinary(decymal / 2) + "1";
        return decymalToBinary(decymal / 2) + "0";
    }
}
