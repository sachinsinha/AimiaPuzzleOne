package com.sachin.puzzleone;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class NumbersToWordsTransformerTest {

    NumbersToWordsTransformer transformer;


    NumberToWordMapper numberToWordMapper;

    @Before
    public void before() {
        numberToWordMapper = new NumberToWordMapper();
        transformer = new NumbersToWordsTransformer(numberToWordMapper);
    }
    @Test
    public void shouldConvertFiguresInMillionToWords() throws Exception {
        String s = transformer.transform("999, 999, 999");
        assertThat(s, is("nine hundred ninety-nine million nine hundred ninety-nine thousand nine hundred ninety-nine"));

        s = transformer.transform("99, 999, 999");
        assertThat(s, is("ninety-nine million nine hundred ninety-nine thousand nine hundred ninety-nine"));

        s = transformer.transform("28, 999, 998");
        assertThat(s, is("twenty-eight million nine hundred ninety-nine thousand nine hundred ninety-eight"));

        s = transformer.transform("1456980");
        assertThat(s, is("one million four hundred fifty-six thousand nine hundred eighty"));


        s = transformer.transform("1456912");
        assertThat(s, is("one million four hundred fifty-six thousand nine hundred twelve"));

        s = transformer.transform("1456902");
        assertThat(s, is("one million four hundred fifty-six thousand nine hundred two"));

        s = transformer.transform("1, 000, 000");
        assertThat(s, is("one million"));

        s = transformer.transform("100, 000, 000");
        assertThat(s, is("one hundred million"));

        s = transformer.transform("10, 000, 001");
        assertThat(s, is("ten million one"));

        s = transformer.transform("10, 101, 001");
        assertThat(s, is("ten million one hundred one thousand one"));

        s = transformer.transform("56945781");
        assertThat(s, is("fifty-six million nine hundred forty-five thousand seven hundred eighty-one"));

        s = transformer.transform("000, 000, 000");
        assertThat(s, is("zero"));

        s = transformer.transform("000, 000, 000");
        assertThat(s, is("zero"));

    }

    @Test
    public void shouldConvertFiguresInThousandToWords() {
        String s = transformer.transform("999, 999");
        assertThat(s, is("nine hundred ninety-nine thousand nine hundred ninety-nine"));

        s = transformer.transform("100, 000");
        assertThat(s, is("one hundred thousand"));

        s = transformer.transform("99, 999");
        assertThat(s, is("ninety-nine thousand nine hundred ninety-nine"));

        s = transformer.transform("65, 000");
        assertThat(s, is("sixty-five thousand"));

        s = transformer.transform("9999");
        assertThat(s, is("nine thousand nine hundred ninety-nine"));


        s = transformer.transform("10000");
        assertThat(s, is("ten thousand"));

        s = transformer.transform("10001");
        assertThat(s, is("ten thousand one"));

        s = transformer.transform("999001");
        assertThat(s, is("nine hundred ninety-nine thousand one"));

        s = transformer.transform("000, 000");
        assertThat(s, is("zero"));
    }

    @Test
    public void shouldConvertFiguresInHundredToWords() {

        String s = transformer.transform("999");
        assertThat(s, is("nine hundred ninety-nine"));

        s = transformer.transform("100");
        assertThat(s, is("one hundred"));

        s = transformer.transform("101");
        assertThat(s, is("one hundred one"));

        s = transformer.transform("121");
        assertThat(s, is("one hundred twenty-one"));

        s = transformer.transform("111");
        assertThat(s, is("one hundred eleven"));


        s = transformer.transform("000");
        assertThat(s, is("zero"));

    }

    @Test
    public void shouldConvertFiguresInTensToWords() {

        String s = transformer.transform("99");
        assertThat(s, is("ninety-nine"));

        s = transformer.transform("11");
        assertThat(s, is("eleven"));

        s = transformer.transform("10");
        assertThat(s, is("ten"));

        s = transformer.transform("71");
        assertThat(s, is("seventy-one"));

        s = transformer.transform("00");
        assertThat(s, is("zero"));

    }


    @Test
    public void shouldConvertFiguresInOnesToWords() {

        String s = transformer.transform("9");
        assertThat(s, is("nine"));

        s = transformer.transform("1");
        assertThat(s, is("one"));

        s = transformer.transform("2");
        assertThat(s, is("two"));

        s = transformer.transform("7");
        assertThat(s, is("seven"));

        s = transformer.transform("0");
        assertThat(s, is("zero"));

    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowNumberFormatExceptionForInvalidNumber() throws Exception {
        String s = transformer.transform("999, a999");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForBillionOrOver() throws Exception {
        String s = transformer.transform("1, 000, 000, 000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForNegativeNumber() throws Exception {
        String s = transformer.transform("-1");
    }





}
