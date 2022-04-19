package vn.techmaster.ex01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;


@RestController
@RequestMapping("/" )
public class RandomController {
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;

    private static final List<String> quotes = List.of("Kiến tha lâu đầy tổ", "Có công mài sắt, có ngày nên kim",
            "Không thầy đố mày làm nên", "Học thầy không tày học bạn");

    public static int randomNumber(int min, int max) {
        Random gen = new Random();
        return gen.nextInt((max - min) + 1) + min;
    }

    @GetMapping("/random")
    public String randomString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }

        return sb.toString();
    }

    @GetMapping("/quote")
    public String randomQuote() {
        int number = randomNumber(0, 3);
        return quotes.get(number);
    }

}
