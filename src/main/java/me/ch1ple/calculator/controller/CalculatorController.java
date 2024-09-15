package me.ch1ple.calculator.controller;

import me.ch1ple.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String getHello(){
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String getSummary(@RequestParam(value = "num1", required = false) Integer num1,
                            @RequestParam(value = "num2", required = false) Integer num2) {

        int result = calculatorService.getSummary(num1, num2);
        return num1 + " + " + num2 + " = " + result;
    }

    @GetMapping("/minus")
    public String getSubtraction(@RequestParam(value = "num1", required = false) Integer num1,
                                 @RequestParam(value = "num2", required = false) Integer num2) {
        int result = calculatorService.getSubtraction(num1, num2);
        return num1 + " - " + num2 + " = " + result;
    }

    @GetMapping("/multiply")
    public String getMultiply(@RequestParam(value = "num1", required = false) Integer num1,
                             @RequestParam(value = "num2", required = false) Integer num2) {
        int result = calculatorService.getMultiply(num1, num2);
        return num1 + " * " + num2 + " = " + result;
    }

    @GetMapping("/divide")
    public String getDivision(@RequestParam(value = "num1", required = false) Integer num1,
                             @RequestParam(value = "num2", required = false) Integer num2) {
        if (num1 == null || num2 == null){
            return "Один из параметров отсутствует";
        }
        if (num2 == 0){
            return "Нельзя делить на ноль";
        }
        int result = calculatorService.getDivision(num1, num2);
        return num1 + " / " + num2 + " = " + result;
    }
}
