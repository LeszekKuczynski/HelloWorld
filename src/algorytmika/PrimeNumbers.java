package algorytmika;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PrimeNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long startTime = System.currentTimeMillis();
        printPrimes(n);
        long endTime = System.currentTimeMillis();
        double pierwszyCzas = (double)((endTime - startTime)/1000);

        System.out.println("==================================================");
        startTime = System.currentTimeMillis();
        printSitoEatostenes(n);
        endTime = System.currentTimeMillis();
        double drugiCzas = (double)((endTime - startTime)/1000);

        System.out.println("==============Statystyka====================================");
        System.out.println("Dla " + n + " liczb czas wykonania programu liczba pierwsza");
        System.out.println(pierwszyCzas);
        System.out.println(drugiCzas);
    }
    private static void printSitoEatostenes(int n){
        boolean[] primes = new boolean[n+1];

        Arrays.fill(primes, true);
        for (int i=2; i<=Math.sqrt(n);i++){
            if (primes[i] = true)
            for (int j =i*i; j<n; j+=i) primes[j]=false;
        }

        for(int i=2; i<=n;i++){
            if(primes[i])
                System.out.println(i);
        }
        /*IntStream.range(1,n).
                filter(t->primes[t] == true).
                forEach(System.out::println);*/
    }

    private static void printPrimes(int n) {
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}