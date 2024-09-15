package me.ch1ple.calculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();
    private static final Random random = new Random();
    @ParameterizedTest
    @MethodSource("provideDifferentNumbers")
    void shouldReturnCorrectResult_WhenCorrectParams_ThenCorrectResultSum(int num, int num2){
        int expected = num + num2;

        //test
        int actual = calculatorService.getSummary(num, num2);

        //check
        assertEquals(actual, expected);
    }
    @ParameterizedTest
    @MethodSource("provideNullParams")
    void shoudldThrowException_WhenParamNullForSum(String message, Integer num1, Integer num2){
        //test && check
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.getSummary(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("provideDifferentNumbers")
    void shouldReturnCorrectResult_WhenCorrectParams_ThenCorrectResultSub(int num, int num2){
        int expected = num - num2;

        //test
        int actual = calculatorService.getSubtraction(num, num2);

        //check
        assertEquals(actual, expected);
    }
    @ParameterizedTest
    @MethodSource("provideNullParams")
    void shoudldThrowException_WhenParamNullForSub(String message, Integer num1, Integer num2){
        //test && check
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.getSubtraction(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("provideDifferentNumbers")
    void shouldReturnCorrectResult_WhenCorrectParams_ThenCorrectResultMulti(int num, int num2){
        int expected = num * num2;

        //test
        int actual = calculatorService.getMultiply(num, num2);

        //check
        assertEquals(actual, expected);
    }
    @ParameterizedTest
    @MethodSource("provideNullParams")
    void shoudldThrowException_WhenParamNullForMulti(String message, Integer num1, Integer num2){
        //test && check
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.getMultiply(num1, num2));
    }
    @Test
    void shouldReturnCorrectResult_WhenCorrectParams_ThenCorrectResultDivide() {
        int num = 100;
        int num2 = 100;
        int expected = num / num2;

        //test
        int actual = calculatorService.getDivision(num, num2);

        //check
        assertEquals(actual, expected);
    }
    @Test
    void shoudldThrowException_WhenSecondParamIsZero() {
        int num = random.nextInt(1, 100);
        int num2 = 0;

        //test & check
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.getDivision(num, num2));
    }
    @ParameterizedTest
    @MethodSource("provideNullParams")
    void shoudldThrowException_WhenParamNullForDivide(String message, Integer num1, Integer num2){
        //test && check
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.getDivision(num1, num2));
    }
    private static Stream<Arguments> provideNullParams(){
        return Stream.of(Arguments.of("Отсутствует первый параметр", null, random.nextInt()),
                Arguments.of("Отсутствует второй параметр", random.nextInt(), null),
                Arguments.of("Отсутствуют оба параметра", null, null));
    }

    private static Stream<Arguments> provideDifferentNumbers(){
        return Stream.of(Arguments.of(0, 0),
                Arguments.of(100, 2),
                Arguments.of(-1, 2),
                Arguments.of(10000, 10000));
    }
}