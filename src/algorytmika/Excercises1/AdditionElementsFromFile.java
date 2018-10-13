package algorytmika.Excercises1;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class AdditionElementsFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        String uri = "C:\\Users\\lesze\\IdeaProjects\\HelloWorld\\src\\algorytmika\\Excercises1\\numbers.txt";
        int n = 10;

        generateNumbersToFile(uri, n);
        int[] numbers = readFromFile(uri);
        System.out.println("---Plik z liczbami---");
        for (int element : numbers)
            System.out.println(element);
        System.out.println("---Obliczenia----");
        for (int i = 0; i < numbers.length; i++) {
            int suma = 0;
            for (int j = 0; j <= i; j++)
                suma = suma + numbers[j];
            System.out.println(suma);
        }
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
