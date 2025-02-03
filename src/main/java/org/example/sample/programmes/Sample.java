package org.example.sample.programmes;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample {

    public static void main(String[] args) {
        removeDuplicatesFromString();
        removeFirstDuplicates();
        findTheSumOfNumbers();
        findTheSumOfTwoDimensionalArray();
        sortString("bharath");
        reverseString(); // using java 8
        System.out.println("reverseStringUsingRecursive::" + reverseStringUsingRecursive("bharath")); // using recursive functions
        occurancesInTheString();
        System.out.println("Is it a palindrome? " + checkPalindrome("112211"));
        findFibonacciNumber(9);
        FindThe3LargestNumber();
        PrintAllFibonacciNumber(9);
        checkForVowels("bharath");
        checkIfNumberIsPrime();
        reverseWordsInString("I Love My India");
        bubbleSort();
        insertSort();
        tripletToFindSum();
        sortMapUsingKey();
        convertListToHashMap();

        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int N = arr.length;
        int d = 2;

        // Function calling
        Rotate(arr, d, N);
        PrintTheArray(arr, N);
    }

    // Function to rotate array
    static void Rotate(int arr[], int d, int n) {

        // Storing rotated version of array
        int temp[] = new int[n];

        // Keeping track of the current index of temp[]
        int k = 0;

        // Storing the n - d elements of array arr[] to the front of temp[]
        for (int i = d; i < n; i++) {
            temp[k] = arr[i];
            k++;
        }

        // Storing the first d elements of array arr[] into temp
        for (int i = 0; i < d; i++) {
            temp[k] = arr[i];
            k++;
        }

        // Copying the elements of temp[] into arr[] to get the final rotated array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    // Function to print elements of the array
    static void PrintTheArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void sortMapUsingKey() {
        System.out.println("sort map using key");
        Map<String, String> map = new HashMap<>();
        map.put("a","23");
        map.put("z","2");
        map.put("p", "6");
        map.put("r","24");

        System.out.println("Sort using the key");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

        System.out.println("Sort using the value");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
    }

    private static void tripletToFindSum() {
        int[] a = {1, 2, 3, 4, 5, 8,4,1};
        int n = a.length;
        int sum = 10;
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 1; j++) {
                for (int k = 0; k < n; k++) {
                    if (a[i] + a[j] + a[k] == sum) {
                        System.out.println("triplet are " + a[i] + " " + a[j] + " " + a[k]);
                    }
                }
            }
        }
    }

    private static void insertSort() {
        System.out.println("Insertion sort");
       /* Select the first unsorted element.
        swap other elements to the right to create the correct position and shift the unsorted element.
        Advance the marker to the right one element.*/

        int a[] = {2, 45, 2, 2, 6, 6, 3, 2, 44, 22, 33};
        int i, j = 0, key = 0;
        for (i = 1; i < a.length; i++) {
            key = a[i];
            j = i - 1;

             /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
        System.out.println("insert sort");
        Arrays.stream(a).forEach(System.out::println);
    }

    private static void bubbleSort() {
        System.out.println("Bubble sort technique");
        int a[] = {2, 45, 2, 2, 6, 6, 3, 2, 44, 22, 33};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        Arrays.stream(a).boxed().forEach(System.out::println);
    }

    private static void convertListToHashMap() {
        // creating arraylist to add elements
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Guava");
        fruits.add("Pineapple");
        fruits.add("Apple");

        // printing contents of arraylist before conversion
        System.out.println("Elements in ArrayList are : " + fruits);

        // creating new hashmap and using method reference
        // with necessary classes for the conversion

        HashMap<String, Integer> hashmap = fruits.stream().collect(Collectors.toMap(Function.identity(), String::length, (e1, e2) -> e1, HashMap::new));
        hashmap.entrySet().forEach(System.out::println);
    }

    private static void reverseWordsInString(String str) {
        Arrays.stream(str.split(" ")).collect(Collectors.toCollection(LinkedList::new)).descendingIterator().forEachRemaining(System.out::println);
    }

    private static void checkIfNumberIsPrime() {
        int[] a = {1, 3, 4, 5, 6, 8, 8, 4, 3, 2, 4, 5, 9, 9, 9, 9};

        Function<Integer, Boolean> function = i -> IntStream.rangeClosed(2, i / 2).boxed().anyMatch(s -> i % s == 0);

        List<Integer> result = Arrays.stream(a).boxed().filter(m -> function.apply(m)).collect(Collectors.toList());

        result.stream().forEach(System.out::println);
    }

    private static void checkForVowels(String str) {
        System.out.println("is it contains vowels " + str.matches(".*[aeiou].*"));
    }

    private static void PrintAllFibonacciNumber(int i) {
        System.out.println("Print all the fibonaccu numbers up to " + i);
        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).map(a -> a[0]).limit(i).forEach(System.out::println);
    }

    private static void FindThe3LargestNumber() {
        int[] a = {12, 3, 4, 55};
        int num = (int) Arrays.stream(a).boxed().collect(Collectors.toCollection(TreeSet::new)).stream().toArray()[3 - 1];
        System.out.println("The third largest array is ::" + num);
    }

    private static void findFibonacciNumber(int i) {
        int num = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]}).limit(i).reduce((a, b) -> b).get()[0];


        System.out.println("findFibonacciNumber:: " + num);
        int num1 = 0, num2 = 1;
        List<Integer> arr = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            arr.add(num1);
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
        }
        System.out.println("Fibonacci number of " + i + " is " + arr.get(arr.size() - 1));
    }

    private static Boolean checkPalindrome(String str) {
        return str.chars().mapToObj(c -> (char) c).reduce("", (a, b) -> b + a, (s1, s2) -> s2 + s1).equalsIgnoreCase(str);
    }

    private static void occurancesInTheString() {
        String str = "bharath";
        str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().forEach(System.out::println);
    }

    private static String reverseStringUsingRecursive(String str) {
        if (str.length() == 1) {
            return str;
        }
        return reverseStringUsingRecursive(str.substring(1)) + str.charAt(0);
    }

    private static void reverseString() {
        String input = "bharath";
        String output = input.chars().mapToObj(c -> (char) c).reduce("", (a, b) -> b + a, (s1, s2) -> s2 + s1);
        System.out.println("Reversed String::" + output);
    }

    private static void sortString(String input) {
        System.out.println("Sort the String");
        String output = input.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        System.out.println("output after sorting String::" + output);
    }

    private static void findTheSumOfTwoDimensionalArray() {
        int a[][] = {{0, 1, 2}, {3, 4, 5}, {3, 4}};

        System.out.println("find The Sum Of Two Dimensional Array:" + Arrays.stream(a).flatMapToInt(Arrays::stream).sum());
    }

    private static void findTheSumOfNumbers() {
        int a[] = {1, 3, 4, 2, 3, 6, 8, 5, 3, 5, 7, 9, 9};

        System.out.println("finding the sum of numbers in an array: " + Arrays.stream(a).sum());
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        System.out.println("Result using reduce:" + Arrays.stream(a).reduce(0, (i1, i2) -> i1 + i2));
        System.out.println("Result: " + result);
    }

    private static void removeFirstDuplicates() {
        System.out.println("Remove First Duplicates");
        String str = "bharath";
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (!result.contains(String.valueOf(str.charAt(i)))) {
                result += str.charAt(i);
            }
        }


        System.out.println("After removing duplicates ::" + result);
    }

    private static void removeDuplicatesFromString() {
        String str = "bharath";
        System.out.println("Remove Duplicates from String");
        System.out.println(Arrays.stream(str.split("")).distinct().collect(Collectors.joining()));
    }
}
