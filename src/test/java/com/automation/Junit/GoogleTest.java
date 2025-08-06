package com.automation.Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoogleTest {

    // Sample methods
    int add(int a, int b) {
        return a + b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    // Test methods
    @Test
    void testAddition() {
        Assertions.assertEquals(5, add(2, 3), "2 + 3 should equal 5");
    }

    @Test
    void testMultiplication() {
        Assertions.assertEquals(12, multiply(3, 4), "3 * 4 should equal 12");
    }
}
