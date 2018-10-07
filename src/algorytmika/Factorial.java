/*
exapmle:
0! = 1
1! = 1
2! = 2
3! = 6
...
n! = n * factor(n-1)
5! = 5 * factor(5-1) = 5 * factor(4 * factor(4-1)) =
                        5 * factor(4 * factor(3* factor(3-1))) =
                        5 * factor(4 * factor(3* factor(2 * factor(2-1)))) =
                        5 * 4 * 3 * 2 * 1 =
                        120
*/

package algorytmika;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("---Calculate factorial----");
        System.out.print("n: ");
        int n = new Scanner(System.in).nextInt();
        int product = factorial(n);
        System.out.println("Product of all: " + product);
    }

    //factor metod
    private static int factorial(int n) {
        if (n>1)
            return n * factorial(n - 1);
        return 1;
    }
}
