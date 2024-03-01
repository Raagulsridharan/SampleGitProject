package com.revature.java8.streams;

public class MaxRepeatingSubstring {

    public static String findMaxRepeatingSubstring(String str) {
        String result = "";
        int maxLength = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String substring = str.substring(i, j);
                if (str.indexOf(substring, i + 1) != -1) {
                    int currentLength = j - i;
                    if (currentLength >= maxLength) {
                        maxLength = currentLength;
                        result = substring;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Sample input 1
        String input1 = "xyzwyyxyzw";
        System.out.println("Sample output 1: " + findMaxRepeatingSubstring(input1));

        // Sample input 2
        String input2 = "abcabcadef";
        System.out.println("Sample output 2: " + findMaxRepeatingSubstring(input2));
    }
}

