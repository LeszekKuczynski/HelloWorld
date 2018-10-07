/*0! = 1
        dla n >= 1
        silnia
        1! = 1
        2! = 2 * 1!
        silnia(1) = 1
        3! = 3 * 2! = 3 * silnia(2) = 3 * (2 * silnia(1)) =
        n * (n-1)!*/

package algorytmika;

public class Silnia {
    public static void main(String[] args) {
        int n = 5;
        n = factorial(n);
        System.out.println(n);
    }

    private static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);


    }
}
