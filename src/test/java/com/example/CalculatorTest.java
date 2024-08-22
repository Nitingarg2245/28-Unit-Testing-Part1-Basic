package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
//Use the pattern arrange ,act ,assert
/*
class CalculatorTest {

    private  Calculator calculator;

    @BeforeEach
    void setUp() {
        System.out.println("before each method is called ");
        calculator=new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("after each method is called ");
        calculator=null;
    }


    @Test
    void testAdd() {
        int actual = calculator.add(10, 20);
        assertEquals(30,actual);
    }

    @Test
    void testSubtract() {
        int subtract = calculator.subtract(30, 20);
        assertEquals(10,subtract);

    }

    @Test
    void testMultiply() {
        int multiply = calculator.multiply(10, 20);
        assertEquals(200,multiply);
    }

    @Test
    void testDivideByZero() {
       assertThrows(ArithmeticException.class, ()->calculator.divide(10,0));
    }

    @Test
    void testDivideTwoNaturalNumbers(){
        int divide = calculator.divide(10, 5);
        assertEquals(2,divide);
    }
}*/

/*The problem with beforeEach and afterEach is that they get executed with every  test means our object is creating
again and again in the memory so beforeAll and afterAll is better approach they are used with static methods and
we have to make the calculator variable static too
Lets say we dont want to use beforeAll and afterAll and beforeEach and afterEach then we can sidha use
*********************Calculator calculator = new Calculator();**************************** for the variable
*/
class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    static void  setUp() {
        System.out.println("before All  method is called ");
        calculator=new Calculator();
    }

    @AfterAll
    static void tearDown() {
        System.out.println("after all method is called ");
        calculator=null;
    }


    @Test
    void testAdd() {
        int actual = calculator.add(10, 20);
        assertEquals(30,actual);
    }

    @Test
    void testSubtract() {
        int subtract = calculator.subtract(30, 20);
        assertEquals(10,subtract);

    }

    @Test
    void testMultiply() {
        int multiply = calculator.multiply(10, 20);
        assertEquals(200,multiply);
    }

    @Test
    void testDivideByZero() {
       assertThrows(ArithmeticException.class, ()->calculator.divide(10,0));
    }

    @Test
    void testDivideTwoNaturalNumbers(){
        int divide = calculator.divide(10, 5);
        assertEquals(2,divide);
    }
}
