package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
// Lets say we dont want to use beforeAll and afterAll and beforeEach and afterEach then we can sidha use
// *********************Standard standard=new Standard();**************************** for the variable
import java.util.stream.Stream;

public class StandardTest {
    private final Standard standard=new Standard();

    @ParameterizedTest
    @ValueSource(ints = {10,11,12,13,14,-15})
    public void testIsEvenNumber(int x){
//        Assertions.assertTrue(standard.isEvenNumber(x));
        //we can import static from Assertions class to directly use the methods
        assertTrue(standard.isEvenNumber(x));
    }

    @ParameterizedTest
    @ValueSource(strings = {"racecar","radar","ruby"})
    public void testIsPalindrome(String s){
        assertTrue(standard.isPalindrome(s));
    }

    @ParameterizedTest
    @CsvSource({
            "10,5,15",
            "5,1,6",
            "-5,-0,-5",
            "1,2,4"
    })
    public void testAdd(int a,int b,int expected){
        assertEquals(expected,standard.add(a,b));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/sub.csv",numLinesToSkip = 1)
    public void testSubtract(int a,int b,int expected){
        assertEquals(expected,standard.subtract(a,b));
    }
    @ParameterizedTest
    @MethodSource("multiplicationInputs")
    public void testMultiply(int a,int b,int expected){
        assertEquals(expected,standard.multiply(a,b));
    }

    @ParameterizedTest
    @MethodSource("divisionInputs")
    public void testDivide(int a,int b,int expected){
        assertEquals(expected,standard.divide(a,b));
    }

    @Test
    public void testDivideByZero(){
        assertThrows(ArithmeticException.class,()->standard.divide(10,0));
    }

    static Stream<Arguments> multiplicationInputs(){
       return Stream.of(Arguments.of(10,10,100),
                Arguments.of(2,2,4),
                Arguments.of(5,0,1));
    }
    static Stream<Arguments> divisionInputs(){
       return Stream.of(Arguments.of(10,10,1),
                Arguments.of(2,20,0),
                Arguments.of(50,10,11));
    }
}
