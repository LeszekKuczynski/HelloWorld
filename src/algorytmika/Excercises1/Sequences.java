package algorytmika.Excercises1;

import java.util.Scanner;

public class Sequences {
    public static void main(String[] args) {
        System.out.println("Podaj liczbe n: ");
        int n = new Scanner(System.in).nextInt();

        int[] t1 = n2(n);
        wyswitl(t1);
        System.out.println();

        t1 = nMultiple2(n);
        wyswitl(t1);
        System.out.println();

        t1 = sequence4(n);
        wyswitl(t1);
        System.out.println();

        t1 = fibonaci(n);
        wyswitl(t1);
        System.out.println();


    }

    private static int[] fibonaci(int n) {
        if(n>20)
            return new int[0];
        int[] temp = new int[n];
        temp[0] = 1;
        temp[1] = 1;
        for(int i=2; i<n; i++){
            temp[i]=temp[i-2] + temp[i-1];
        }
        return  temp;
    }

    private static int[] sequence4(int n) {


        if(n>20)
            return new int[0];
        int[] temp = new int[n];
        int a=2;

        boolean up = true;
        temp[0] = a;
        for(int i=1; i<n; i++){
            if(a==8)
                up=false;
            if(a==2)
                up=true;
            if(up)
                a+=2;
            else
                a-=2;
            temp[i]=a;

        }
        return  temp;
    }

    private static int[] nMultiple2(int n) {
        if(n>20)
            return new int[0];
        int[] temp = new int[n];
        int a=-1;
        int mnoznik = 2;
        temp[0] = a;
        for(int i=1; i<n; i++){
            a= a + mnoznik;
            temp[i]=a;
            mnoznik = mnoznik * 2;
        }
        return  temp;
    }

    private static void wyswitl(int[] t1) {
        for (int i=0; i<t1.length;i++) {
            if(i==t1.length-1)
                System.out.print(t1[i]);
            else
                System.out.print(t1[i] + ", ");
        }
    }

    private static int[] n2(int n) {
        /*if(n<)
        return n2(n-1)*/
        if(n>20)
            return new int[0];
        int[] temp = new int[n];
        int a=1;
        temp[0] = a;
        for(int i=1; i<n; i++){
            a=+a+2;
            temp[i]=a;
        }
        return  temp;
    }
}
