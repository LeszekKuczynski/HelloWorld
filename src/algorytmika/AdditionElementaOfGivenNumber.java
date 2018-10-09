package algorytmika;

import java.util.Scanner;

public class AdditionElementaOfGivenNumber {
    public static void main(String[] args) {
        System.out.println("---Addition of each element from given decimal number----");
        long givenNumber = new Scanner(System.in).nextLong();
        if (givenNumber >= 0)
            System.out.println(addition(givenNumber));
        else System.out.println("Only numbers >= 0");
    }

    private static long addition(long givenNumber) {
        if (givenNumber < 0) return -1;
        if (givenNumber < 10) return (givenNumber % 10);
        return (givenNumber % 10) + addition(givenNumber / 10);
    }
}
