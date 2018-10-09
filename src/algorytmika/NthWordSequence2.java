package algorytmika;

import java.util.Scanner;

public class NthWordSequence2 {
    public static void main(String[] args) {
        System.out.println("---Generate sequence for n---");
        long n = new Scanner(System.in).nextInt();
        for (int i = 1; i <= n; i++) {
            long sequence = generateSequence2(i);
            System.out.println(sequence);
        }
    }

    private static long generateSequence2(long n) {
        if (n <= 1) return -1;
        return ((-1) * (generateSequence2(n - 1)) * (n)) - 3;
    }
}
