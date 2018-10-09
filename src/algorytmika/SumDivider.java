    /*Obliczający sumę liczb będących dzielnikami zadanej liczby.*/

        package algorytmika;

import java.util.Scanner;

public class SumDivider {
    public static void main(String[] args) {
        System.out.println("---Sum all devider of given number--");
        System.out.println("Give number: ");
        int number = new Scanner(System.in).nextInt();

        int sum = division(number);
        System.out.println(sum);
    }

    private static int division(int number) {
        int suma=0;
        if( number > 0){
            for (int i=1; i<number; i++){
                if(number%i == 0)
                    suma+=i;
            }
        } else
            return number;
        return suma;
    }
}
