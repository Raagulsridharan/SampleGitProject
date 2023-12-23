package com.revature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    public static Calculator calc ;

    @BeforeAll
    public static void startUp(){
        calc = new Calculator();
    }

    @Test
    public void additionTest(){
        //AAA
        //Arrange
        int num1 = 10;
        int num2 = 20;
        int actualResult = 30;
        //Act
        int expectedResult = calc.addition(num1,num2);
        //Assert
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "5,4,1",
            "10,5,5"
    })
    public void subractionTest(int num1, int num2, int actualResult){
        int expectedResult = calc.subraction(num1,num2);
        Assertions.assertEquals(expectedResult,actualResult,"test passed");
    }

    @Test
    public void multiplicationTest(){
        int num1 = 6;
        int num2 = 3;
        int actualResult = 18;
        int expectedResult = calc.multiplication(num1, num2);
        Assertions.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void divisionTest(){
        int num1 = 15;
        int num2 = 3;
        int actualResult = 5;
        int expectedResult = calc.division(num1,num2);
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void divisionExceptionTest(){
        int num1 = 5;
        int num2 = 0;
        assertThrows(ArithmeticException.class,()->{
            calc.division(num1,num2);
        },"Division by zero throw Arithmatic exception");
    }
}
