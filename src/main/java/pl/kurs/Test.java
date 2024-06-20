package pl.kurs;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Test {

//    Zadanie 01:
//    napisz metode boolean isArithmetic(int[] sequence), ktora zwroci informacje o tym czy dany
//    jako argument ciag jest arytmetyczny czy nie.
    public static boolean isArithmetic(int[] sequence) {
        if (sequence.length < 2) {
            return true;
        }

        int difference = sequence[1] - sequence[0];

        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] - sequence[i - 1] != difference) {
                return false;
            }
        }

        return true;
    }

//    Zadanie 02:
//    napisz metode String getSequenceName(int[] sequence) ktora zwroci:
//            - GEOMETRYCZNY - jesli podany ciag jest geometryczny
//- ARYTMETYCZNY - jesli podany ciag jest arytmetyczny
//- INNY - w przypadku gdy zadne z powyzszych

    public static String getSequenceName(int[] sequence) {
        if (sequence == null || sequence.length < 2) {
            return "INNY";
        }

        boolean isArithmetic = true;
        boolean isGeometric = true;

        int arithmeticDifference = sequence[1] - sequence[0];
        double geometricRatio = (double) sequence[1] / sequence[0];

        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] - sequence[i - 1] != arithmeticDifference) {
                isArithmetic = false;
            }
            if ((double) sequence[i] / sequence[i - 1] != geometricRatio) {
                isGeometric = false;
            }
        }

        if (isArithmetic) {
            return "ARYTMETYCZNY";
        } else if (isGeometric) {
            return "GEOMETRYCZNY";
        } else {
            return "INNY";
        }
    }

//    Zadanie 03:
//    napisz metodę int[] superPrimes(int from, int to) ktora zwroci wszystkie liczby super-pierwsze z zakresu <from, to>
//    takż liczbą jest np: 11, dlaczego? Bo liczba super pierwsza to taka która sama jest liczbą pierwszą oraz jej suma cyfr
//    też jest liczbą pierwszą. (a liczba pierwsza to taka ktora ma dokładnie dwa dzielniki, nie wiecej, nie mniej)

    public static ArrayList<Integer> superPrimes(int from, int to) {
        ArrayList<Integer> superPrimesList = new ArrayList<>();

        for (int i = from; i <= to; i++) {
            if (isPrime(i) && isPrime(sumOfDigits(i))) {
                superPrimesList.add(i);
            }
        }

        return superPrimesList;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
//    Zadanie 04:
//    dany jest plik liczby.txt
//    w ktorym w kazdym wierszu sa liczby rozdzielone spacja.
//            np:
//            1 2 3 4
//            10 20 30 40 50 70
//            1 3 2 55 4 3 222 4 6 7
//    itp
//    dla kazdej linii nalezy stworzyc raport w postaci:
//            - okreslic monotonicznosc ciagu
//- znalezc mina, maxa w ciagu
//- znalezc najpopularniejsza liczbe z ciagu
//- stwierdzic czy miedzy min i max znajduja sie wszystkie mozliwe liczby naturalne.
public static void analyzeSequence(String sequence) {
    List<Integer> numbers = parseSequence(sequence);

    String monotonicity = determineMonotonicity(numbers);
    int min = findMin(numbers);
    int max = findMax(numbers);
    int mostFrequent = findMostFrequentNumber(numbers);
    boolean allNaturalNumbersPresent = areAllNaturalNumbersPresent(numbers, min, max);

    System.out.println("Ciąg: " + sequence);
    System.out.println("Monotoniczność: " + monotonicity);
    System.out.println("Min: " + min + ", Max: " + max);
    System.out.println("Najpopularniejsza liczba: " + mostFrequent);
    System.out.println("Wszystkie liczby między Min, a Max: " + allNaturalNumbersPresent);
    System.out.println();
}
    public static List<Integer> parseSequence(String sequence) {
        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(sequence);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                numbers.add(scanner.nextInt());
            } else {
                scanner.next();
            }
        }

        scanner.close();
        return numbers;
    }
    public static String determineMonotonicity(List<Integer> numbers) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > numbers.get(i - 1)) {
                decreasing = false;
            }
            if (numbers.get(i) < numbers.get(i - 1)) {
                increasing = false;
            }
        }
        if (increasing) return "Rosnąca";
        if (decreasing) return "Malejąca";
        return "Brak monotoniczności";
    }

    public static int findMin(List<Integer> numbers) {
        int min = numbers.get(0);

        for (int number : numbers) {
            if (number < min) {
                min = number;
            }
        }

        return min;
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);

        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }

    public static int findMostFrequentNumber(List<Integer> numbers) {
        int[] frequency = new int[1000];

        for (int number : numbers) {
            frequency[number]++;
        }

        int mostFrequentNumber = 0;
        int maxFrequency = 0;

        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
                mostFrequentNumber = i;
            }
        }

        return mostFrequentNumber;
    }

    public static boolean areAllNaturalNumbersPresent(List<Integer> numbers, int min, int max) {
        boolean[] present = new boolean[max - min + 1];

        for (int number : numbers) {
            if (number >= min && number <= max) {
                present[number - min] = true;
            }
        }

        for (boolean isPresent : present) {
            if (!isPresent) {
                return false;
            }
        }

        return true;
    }


}
