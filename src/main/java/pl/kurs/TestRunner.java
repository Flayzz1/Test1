package pl.kurs;
import java.util.*;

public class TestRunner {
    public static void main(String[] args) {

        //Zadanie 01:
        int[] sequence1 = {2, 4, 6, 8, 10};
        int[] sequence2 = {3, 9, 27, 81};
        int[] sequence3 = {1, 2, 4, 8, 16};
        int[] sequence4 = {1, 2, 3, 5, 8};

        System.out.println("Zadanie 01:");
        System.out.println(Test.isArithmetic(sequence1));
        System.out.println(Test.isArithmetic(sequence2));
        System.out.println(Test.isArithmetic(sequence3));
        System.out.println(Test.isArithmetic(sequence4));
        System.out.println();

        //Zadanie 02:
        System.out.println("Zadanie 02:");
        System.out.println(Test.getSequenceName(sequence1));
        System.out.println(Test.getSequenceName(sequence2));
        System.out.println(Test.getSequenceName(sequence3));
        System.out.println(Test.getSequenceName(sequence4));
        System.out.println();

        //Zadanie 03:
        System.out.println("Zadanie 03:");
        ArrayList<Integer> superPrimesList = Test.superPrimes(1, 101);
        for (int num : superPrimesList) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        //Zadanie 04:
        System.out.println("Zadanie 04:");
        List<String> sequences = Arrays.asList(
                "1 2 3 4",
                "10 20 30 40 50 70",
                "1 3 2 55 4 3 222 4 6 7",
                "9 2 88 999 4 82 103 57 21 92"
        );

        for (String sequence : sequences) {
            Test.analyzeSequence(sequence);
        }

    }
}
