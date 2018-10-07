package algorytmika;

import java.util.Scanner;

public class Fibonaci {
    public static void main(String[] args) {
        System.out.println("---Ciag fibonaciego");
        int n = new Scanner(System.in).nextInt();
        
        int result = fibonaci(n);
        System.out.println(result);
    }

    private static int fibonaci(int n) {
        if(n==0)
            return 0;
        else if (n==1)
            return 1;
        else
            return fibonaci(n-1) + fibonaci( n-2);
    }
}
