package vn.techmaster.ex01.controllers;

import org.springframework.web.bind.annotation.*;
import vn.techmaster.ex01.model.BmiStat;

@RestController
@RequestMapping("/bmi")
public class BmiController {

    @PostMapping
    public Double bmiCalculate(@RequestBody BmiStat stat) {
        return stat.getWeight() / (stat.getHeight() * stat.getHeight());
    }
}
