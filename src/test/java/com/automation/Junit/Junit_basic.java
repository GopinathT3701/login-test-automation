package com.automation.Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Junit_basic {

    // Sample methods
    int add(int a, int b) {
        return a + b;
    }
    
    int subtract(int a, int b) {
    	return a - b;
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
    void testSubtraction() {
        Assertions.assertEquals(7, subtract(12, 5), "12 - 5 should equal 7");
    }
    
    @Test
    void testMultiplication() {
        Assertions.assertEquals(12, multiply(3, 4), "3 * 4 should equal 12");
    }
}
