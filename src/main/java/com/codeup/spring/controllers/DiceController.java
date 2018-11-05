package com.codeup.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;


@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    @ResponseBody
    public String returnRollDice() {
        return "<h1>Roll the Dice and Guess a Number!</h1>\n" +
                "\n" +
                "    <a class=\"btn btn-primary\" href=\"/roll-dice/1\">Guess = 1</a>\n" +
                "    <a class=\"btn btn-primary\" href=\"/roll-dice/2\">Guess = 2</a>\n" +
                "    <a class=\"btn btn-primary\" href=\"/roll-dice/3\">Guess = 3</a>\n" +
                "    <a class=\"btn btn-primary\" href=\"/roll-dice/4\">Guess = 4</a>\n" +
                "    <a class=\"btn btn-primary\" href=\"/roll-dice/5\">Guess = 5</a>\n" +
                "    <a class=\"btn btn-primary\" href=\"/roll-dice/6\">Guess = 6</a>";
    }

//    @GetMapping("/roll-dice/{number}")
//    ResponseBody
//    public String checkGuess(@PathVariable int number) {
//        Integer diceRoll = new Random().nextInt(6) + 1;
//        String response = "the number was " + diceRoll.toString();
//        if (number == diceRoll) {
//            response += "You got it!!!";
//        } else {
//            response += "try again!";
//        }
//        response += "<a href='/roll-dice'>Try again</a>";
//        return response;
//    }
}
