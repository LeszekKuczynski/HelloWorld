/*a1=1;
a2=0,5
        a3= -(an-1) * (an-2) = -(a2) * (a1) = -0,5 * 1; -0,5
        a4 = -(a_n-1) * (a_n-2) = -(a_3) * (a_2) = - ( -0,5)
        */
/*a1=1
a_2=0.5
a_3=-(a_n-1) * (a_n-2) = -(1) * (0.5)
a_4= -(a_3) * (a_2) = -(-(1) * (0.5)) * (0.5) = - (-0.5) *0.5 = 0.25
a_5=  -(a_4) * (a_3) = - (0.25) * (0.5)

*/


package algorytmika;

import java.util.Scanner;

public class nTyWyrazCiagu {
    public static void main(String[] args) {
        System.out.println("===n-ty wyraz ciagu---");

        int n = new Scanner(System.in).nextInt();
        //
        float result = nthWordOfSequenceLiniowo(n);
        System.out.println("--wer. liniowa\n" + result);
        result =  nthWordOfSequence(n);
        System.out.println("--wer. rekurencyjna\n" + result);
    }

    private static float nthWordOfSequenceLiniowo(int n) {
        float a_n_2 = 1f;
        float a_n_1 = 0.5f;
        float a_n;

        int i = 3;

        if(n<=0) return 0;
        else if(n==1) return a_n_2;
        else if(n==2) return a_n_1;
        else {
            do{
                a_n = (-1)* (a_n_1) * (a_n_2);
                a_n_2 = a_n_1;
                a_n_1 = a_n;
                n--;
            }while(n>2);
            return a_n;
        }
    }

    //
    private static float nthWordOfSequence(int n) {
        if (n<=0)
            return 0;
        if (n == 1)
            return 1.0f;
        if (n == 2)
            return 0.5f;
        return  -nthWordOfSequence(n - 1) * nthWordOfSequence(n - 2);
    }
}
