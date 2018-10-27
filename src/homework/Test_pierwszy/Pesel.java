package homework.Test_pierwszy;

import java.util.Scanner;

public class Pesel {
    public static void main(String[] args) {

        int[] pesel = new int[11];
        String input = new Scanner(System.in).nextLine();
        String[] pesels = input.split(" ");
        for(String element : pesels){
            System.out.println(checkPesel(element));
        }
    }

    private static String checkPesel(String element) {
        String result = "N";
        if(element.length() != 11){
            return result;
        } else {
            int checkingIntegrity = (Character.getNumericValue(element.charAt(0)) * 1) + (Character.getNumericValue(element.charAt(1)) * 3) + (Character.getNumericValue(element.charAt(2)) * 7) + (Character.getNumericValue(element.charAt(3)) * 9) + (Character.getNumericValue(element.charAt(4)) * 1) + (Character.getNumericValue(element.charAt(5)) * 3) + (Character.getNumericValue(element.charAt(6)) * 7) + (Character.getNumericValue(element.charAt(7)) * 9) + (Character.getNumericValue(element.charAt(8)) * 1) + (Character.getNumericValue(element.charAt(9)) * 3) + (Character.getNumericValue(element.charAt(10)) * 1);
            if(checkingIntegrity%10==0)
                result = "D";
            return result;
        }
    }

}
