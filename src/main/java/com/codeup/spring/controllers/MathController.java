package com.codeup.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
class MathController {
    @RequestMapping(path = "/add/{a}/and/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int a, @PathVariable int b) {
        return a + " plus" + b + " is " + (a + b) + "!";
    }

    @RequestMapping(path = "/substract/{a}/from/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String substract(@PathVariable int a, @PathVariable int b) {
        return a + " minus " + b + " is " + (a - b) + "!";
    }

    @RequestMapping(path = "/multiply/{a}/and/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int a, @PathVariable int b) {
        return a + " multiply " + b + " is " + (a * b) + "!";
    }

    @RequestMapping(path = "/divide/{a}/by/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int a, @PathVariable int b) {
        return a + " divided by " + b + " is " + (a / b) + "!";
    }

}
