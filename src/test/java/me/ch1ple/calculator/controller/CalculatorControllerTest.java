package me.ch1ple.calculator.controller;

import me.ch1ple.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.GetMapping;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {
    private final CalculatorController controller = new CalculatorController(new CalculatorService());
    @Test
    void getHello(){
        //test
        String actual = controller.getHello();

        //check
        assertEquals(actual, "Добро пожаловать в калькулятор");
    }

}