package task1; //java -jar task1.jar test1.txt

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;

import static java.lang.Math.round;

public class Task1 {
    public static int[] sortedArray;

    public static void main(String[] args) throws Exception {
        String filePath = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int lines = 0;
        while (reader.readLine() != null) {
            lines++; //подсчет количества чисел для массива
        }
        reader.close();

        int[] inputArray = new int[lines];

        Scanner scanner = new Scanner(new File(filePath));
        int i = 0;
        while (scanner.hasNextInt()) {
            inputArray[i] = scanner.nextInt();
            i++;
        }

        sortedArray = Arrays.copyOf(inputArray, lines);
        Arrays.sort(sortedArray);

        calculatePercentile();
        calculateMedian();
        getMaxValue();
        getMinValue();
        getAverageValue();
        }

    static void calculatePercentile() {
        int n = (int) (round(0.9 * (sortedArray.length - 1)) + 1); //расчет дробного порядкового номера
        double p = ((0.9 * (sortedArray.length - 1)) + 1) - n;
        double percentile = sortedArray[n-1] + p * (sortedArray[n] - sortedArray[n-1]);
        System.out.printf(Locale.ENGLISH,"%.2f%n", percentile);
        }

    static void calculateMedian() {
        if (sortedArray.length % 2 == 0) {
            int n = sortedArray.length / 2;
            double median = (sortedArray[n] + sortedArray[n+1]) / 2;
            System.out.printf(Locale.ENGLISH,"%.2f%n", median);
        } else {
            int n = (sortedArray.length + 1) / 2;
            double result = sortedArray[n];
            System.out.printf(Locale.ENGLISH,"%.2f%n", result);
        }
    }
    static void getMaxValue() {
        int n = sortedArray.length;
        double result = sortedArray[n-1];
        System.out.printf(Locale.ENGLISH,"%.2f%n", result);
    }

    static void getMinValue() {
        double result = sortedArray[0];
        System.out.printf(Locale.ENGLISH,"%.2f%n", result);
    }

    static void getAverageValue() {
        double sum = 0;
        for (int d : sortedArray) {
            sum += d;
        }
        System.out.printf(Locale.ENGLISH,"%.2f%n", sum / sortedArray.length);
    }
}
