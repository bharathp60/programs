package org.example.sample.programmes;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Sample {

    public static void main(String[] args) {
        removeDuplicatesFromString();
        removeFirstDuplicates();
        findTheSumOfNumbers();
        findTheSumOfTwoDimensionalArray();
         sortString("bharath");
        reverseString(); // using java 8
        //reverseString using recursive functions
        //occurancesInTheString
        //isItPalindrome
        //findFibonacciNumber
        //FindThe3LargestNumber
        //PrintAllFibonacciNumber
        //checkForVowels
        //checkIfNumberIsPrime
        //reverseWordsInString
        //bubbleSort
        //insertionSort
        //tripletToFindSum
        //sortMapUsingKey
        //rotatingLeft
    }

    private static void reverseString() {
        String input = "bharath";
        String output = input.chars().mapToObj(c->(char)c).reduce("",(a,b)->b+a,(s1,s2)->s2+s1);
        System.out.println("Reversed String::"+output);
    }

    private static void sortString(String input) {
        System.out.println("Sort the String");
        String output = input.chars().sorted().collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append).toString();
        System.out.println("output after sorting String::"+output);
    }

    private static void findTheSumOfTwoDimensionalArray() {
        int a[][] = {{0,1,2},{3,4,5},{3,4}};

        System.out.println("find The Sum Of Two Dimensional Array:"+Arrays.stream(a).flatMapToInt(Arrays::stream).sum());
    }

    private static void findTheSumOfNumbers() {
        int a[] = {1,3,4,2,3,6,8,5,3,5,7,9,9};

        System.out.println("finding the sum of numbers in an array: "+Arrays.stream(a).sum());
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            result+=a[i];
        }

        System.out.println("Result: "+result);
    }

    private static void removeFirstDuplicates() {
        System.out.println("Remove First Duplicates");
        String str = "bharath";
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if(!result.contains(String.valueOf(str.charAt(i)))) {
                result += str.charAt(i);
            }
        }


        System.out.println("After removing duplicates ::"+result);
    }

    private static void removeDuplicatesFromString() {
        String str = "bharath";
        System.out.println("Remove Duplicates from String");
        System.out.println(Arrays.stream(str.split("")).distinct().collect(Collectors.joining()));
    }
}
