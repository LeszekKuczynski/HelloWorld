package algorytmika.Excercises1;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AdditionElementsFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        String uri = "C:\\Users\\lesze\\IdeaProjects\\HelloWorld\\src\\algorytmika\\Excercises1\\numbers.txt";
        int n = 200;

        generateNumbersToFile(uri, n);
        int[] numbers = readFromFile(uri);

        System.out.println("---File with " + n + " numbers---");
        System.out.println("Input:     Output:");
        int suma = 0;
        for (int element : numbers) {
            suma = suma + element;
            System.out.println(element + "        " + suma);
        }

        System.out.println("---Repeatability----");

        System.out.println("Number:     Repeatibility:");
        int[] repeatability = repeatibility(numbers);
        for (int i = repeatability.length - 1; i >= 101; i--) {
            if (repeatability[i] != 0) System.out.println("-" + (i - 100) + "         " + repeatability[i]);
        }
        for (int i = 0; i < 101; i++) {
            if (repeatability[i] != 0) System.out.println(i + "         " + repeatability[i]);
        }

        System.out.println("The most frequently repeated numbers: ");
        System.out.println("  [Number]         [frequency]");
        int max = 0;
        for (int i = 0; i < repeatability.length; i++) {
            if ( repeatability[i] > max) {
                max = repeatability[i];
            }
        }
        for (int i=0; i<repeatability.length; i++){
            String word = "        ";
            if(repeatability[i] == max){
                if(i>=0 && i <=100) System.out.printf("%6d %s %5d\n", i, word, repeatability[i]);
                else System.out.printf("%6d %s %5d\n", (-1*i), word, repeatability[i]);
            }
        }

    }

    private static int[] repeatibility(int[] numbers) {
        int[] uniquenaturalPositive = uniqueNumbersInNumbersArray(numbers);
        return uniquenaturalPositive;
    }

    private static int[] uniqueNumbersInNumbersArray(int[] numbers) {
        int[] temp = new int[201]; // 0-100 + 101-200; 101+99 = 200 elementów, czyli length = 201
        //Arrays.fill(temp,0);
        int przesuniecie = 100;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= 0) {
                /*tab[0]=0;
                tab[1]=1;
                tab[2]=2;
                ...
                tab[98]=98;
                tab[99]=99;
                tab[100]=100;*/

                //System.out.println(numbers[i]);
                int index = numbers[i];
                temp[index] += 1;
                //System.out.println(temp[numbers[i]]);

            } else {
                /*tab[101] = -1;
                tab[102] = -2;
                tab[103] = -3;
                ...
                tab[198] = -98;
                tab[199] = -99;
                tab[200] = -100;
                tab.lenght = 201;*/

                //System.out.println("numbers[" + i + "]:" + numbers[i]);
                int shuflleIndex = (-1) * (numbers[i]) + przesuniecie;
                //System.out.println("shuffle uniqueNumbers[" + shuflleIndex + "]:" + numbers[i]);
                temp[shuflleIndex] += 1;
            }
        }
        return temp;
    }

    private static int[] addElement(int element, int[] tablica) {
        if (tablica == null) {
            return new int[]{element};
        } else if (tablica.length == 0) {
            int[] temp = new int[]{element};
            //tablica[0] = element;
            return temp;
        } else {
            int[] temp = new int[tablica.length + 1];
            for (int j = 0; j < tablica.length; j++)
                temp[j] = tablica[j];
            temp[temp.length - 1] = element;
            tablica = temp;
            return tablica;
        }
    }

    private static int[] readFromFile(String uri) throws FileNotFoundException {
        int[] temp = new int[0];
        try (Scanner sc = new Scanner(new File(uri))) {
            while (sc.hasNext()) {
                int aInt = sc.nextInt();
                // System.out.println(aInt);
                temp = addElement(aInt, temp);
            }
        }
        return temp;
    }


    private static void generateNumbersToFile(String uri, int n) {

        Integer[] tab = new Integer[n];
        Random rand = new Random();

        for (int i = 0; i < tab.length; i++) {
            tab[i] = rand.nextInt(200) + 1 - 100;
            if (tab[i] < -100 || tab[i] > 100)
                System.out.println("Liczba zpoza zakresu -100, 100: " + tab[i] + "!");
        }
        writeTo(uri, tab);


    }

    private static void writeTo(String uri, Integer[] number) {

        try {
            FileChannel fc;
            try (FileOutputStream fos = new FileOutputStream(new File(uri))) {
                fc = fos.getChannel();


                ByteBuffer bb = ByteBuffer.allocate(1000);
                for (int i = 0; i < number.length; i++) {
                    bb.put((number[i].toString()).getBytes());
                    bb.put("\n".getBytes());
                }

                bb.flip();
                fc.write(bb);
            }

        } catch (IOException e) {

        }
    }


}
