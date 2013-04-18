package com.sachin.puzzleone.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PuzzleOneUtility {
    public PuzzleOneUtility() {
    }

    public boolean validateInput(String regEx, String number) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}