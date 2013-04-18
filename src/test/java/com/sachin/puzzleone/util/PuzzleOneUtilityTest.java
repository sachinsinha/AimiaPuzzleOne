package com.sachin.puzzleone.util;

import com.sachin.puzzleone.Constants;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PuzzleOneUtilityTest {

    PuzzleOneUtility puzzleOneUtility;
    private long inRangeNumber;
    private long outOfRangeNumber;


    @Before
    public void setUp() {
        puzzleOneUtility = new PuzzleOneUtility();
        inRangeNumber = randomNumber(0, 999999999);
        outOfRangeNumber = randomNumber(1000000000l, 10000000000l);
    }
    @Test
    public void shouldBeTrueForNumbersInRange() throws Exception {
        boolean isValid = puzzleOneUtility.validateInput(Constants.REG_EX_VALIDATE_INPUT, String.valueOf(inRangeNumber));
        assertThat(isValid, is(true));
    }

    @Test
    public void shouldBeFalseForNumbersOutOfRange() throws Exception {
        boolean isValid = puzzleOneUtility.validateInput(Constants.REG_EX_VALIDATE_INPUT, String.valueOf(outOfRangeNumber));
        assertThat(isValid, is(false));
    }

    private long randomNumber(long base, long top) {
        return  base + (long)((Math.random() * (top - base)) + 1);

    }
}
