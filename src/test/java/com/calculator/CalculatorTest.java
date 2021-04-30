package com.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void emptyStringTest() {
        // Setup
        int expected = 0;
        // Execute
        int result = 0;
        try {
            result = new Calculator().add("");
        } catch (NegativeNumException e) {
            e.printStackTrace();
        }
        // Assert
        assertEquals(expected, result, "Empty String should return 0");
    }

    @Test
    public void addTwoNumbersTest() {
        int expected = 3;

        int result = 0;
        try {
            result = new Calculator().add("1,2");
        } catch (NegativeNumException e) {
            e.printStackTrace();
        }

        assertEquals(expected, result, "Should add 2 numbers");
    }

    @Test
    public void addUnknownNumberTest() {
        int expected = 6;

        int result = 0;
        try {
            result = new Calculator().add("1,2,3");
        } catch (NegativeNumException e) {
            e.printStackTrace();
        }

        assertEquals(expected, result, "Should add any amount of numbers");
    }

    @Test
    public void handleNewLinesTest() {
        int expected = 6;

        int result = 0;
        try {
            result = new Calculator().add("1,2\n3");
        } catch (NegativeNumException e) {
            e.printStackTrace();
        }

        assertEquals(expected, result, "Should handle new lines as delimiter");
    }

    @Test
    public void handleAnyDelimitersTest() {
        // Input: "//;\n1;2"

        int expected = 3;

        int result = 0;
        try {
            result = new Calculator().add("//;\n1;2");
        } catch (NegativeNumException e) {
            e.printStackTrace();
        }

        assertEquals(expected, result, "Should handle any delimiters");
    }

    @Test
    public void handleDifferentDelimiterTest() {

        int expected = 3;
        int result = 0;
        try {
            result = new Calculator().add("//.\n1.2");
        } catch (NegativeNumException e) {
            e.printStackTrace();
        }

        assertEquals(expected, result, "Should handle any delimiters");
    }

    @Test
    public void handleExceptionTest() {
        NegativeNumException negativeNumException = assertThrows(NegativeNumException.class, () -> {
            new Calculator().add("//.\n-1.2.-3");
        });

        String expected = "Negatives not allowed: -1 -3";
        assertEquals(expected, negativeNumException.getMessage());
    }
}