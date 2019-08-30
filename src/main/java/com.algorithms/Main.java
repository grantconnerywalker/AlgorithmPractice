package com.algorithms;

import java.util.ArrayList;

// TODO unit tests with many different examples

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Num is " + digitMathManipulation(123456));

        System.out.println(binaryPatternStringMatching("101", "amazing") + " matches");
    }

    private static int digitMathManipulation(int n) {
        // return difference between product and sum, i.e. product - sum
        ArrayList<Integer> numList = new ArrayList();

        while (n > 0) {
            numList.add(n % 10); // mod 10 gives us the first digit of the number
            n = n/10; // dividing by 10 gives us the remaining digits of the number
        }

        int first = numList.remove(0);
        int product = first;
        int sum = first;

        while (!numList.isEmpty()) {
            int num = numList.remove(0);
            product = num * product;
            sum = num + sum;
        }

        return product - sum;
    }

    private static int binaryPatternStringMatching(String pattern, String s) {
        ArrayList<Character> vowels = new ArrayList();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');

        int matches = 0;
        // wherever index of pattern = 0, same index in s is vowel
        // wherever index of pattern = 1, same index in s is consonant

        int patternLength = pattern.length();

        ArrayList<Character> patternChars = new ArrayList();
        for (char patternChar : pattern.toCharArray()) {
            patternChars.add(patternChar);
        }

        for (int i = 0; i < s.length() - patternLength+1; i++) {
            String subString = s.substring(i, i + patternLength);
            for (int j = 0; j < patternChars.size(); j++) {
                if (patternChars.get(j) == '0') {
                    if (!vowels.contains(subString.charAt(j))) {
                        break;
                    }
                    // if doesn't match pattern, continue to next iteration
                } else if (patternChars.get(j) == '1') {
                    if (vowels.contains(subString.charAt(j))) {
                        break;
                    }
                }
                if (j == subString.length()-1) {
                    matches++;
                }
            }
        }
        return matches;
    }

}
