package com.calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class Calculator {

    public int add(String numbers) throws NegativeNumException {
        // if 0 is passed return 0;
        if (numbers.length() == 0) return 0;

        String delimiter = "";

        // check for delimiter code
        if (numbers.substring(0, 2).equals("//")) {
            delimiter = numbers.substring(2, 3);
            numbers = numbers.substring(4);
        }

        int result = 0;

        // use .split() on "," to turn string
        // into an array of strings
        String[] nums = numbers.split("[" + delimiter + ",\\n]");

        ArrayList<Integer> negativeNums = new ArrayList<>();

        for (String numString : nums) {
            int num = Integer.parseInt(numString);
            // if num is negative, store in negative num array
            if (num < 0) negativeNums.add(num);
            result += num;
        }

        if (negativeNums.size() > 0) {
            String list = "";
            // [1,2,3,4]
            // "1"
            // " "
            for (Integer num : negativeNums) {
                list += num + " ";
            }
            list = list.substring(0, list.length() - 1);
            throw new NegativeNumException("Negatives not allowed: " + list);
        }

        return result;
    }
}
