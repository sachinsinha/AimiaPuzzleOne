package com.sachin.puzzleone;

import com.sachin.puzzleone.enums.OverTens;
import com.sachin.puzzleone.util.PuzzleOneUtility;


public class NumbersToWordsTransformer {

    private NumberToWordMapper numberToWordMapper;
    private PuzzleOneUtility puzzleOneUtility;

    public NumbersToWordsTransformer(NumberToWordMapper numberToWordMapper) {
        this.numberToWordMapper = numberToWordMapper;
        this.puzzleOneUtility = new PuzzleOneUtility();
    }

    public String transform(String number) {
        number = number.replaceAll(",", "").replaceAll(Constants.BLANK_SPACE, "");
        if(!puzzleOneUtility.validateInput(Constants.REG_EX_VALIDATE_INPUT, number)) {
            throw new IllegalArgumentException("Figures in billion(s) are too overwhelming for me... and yes only number please (I do not mind if they are formatted)");
        }
        String[] threeDigitsArray = getThreeDigitsArray(number);

        String figuresInWords = "";
        for(int i=0; i < threeDigitsArray.length; i++) {
            if(threeDigitsArray[i]!= null && Integer.parseInt(threeDigitsArray[i]) != 0) {
                if(i > 0) {
                    figuresInWords = transformThreeDigits(threeDigitsArray[i]) + Constants.BLANK_SPACE + numberToWordMapper.getOverTensMap().get(String.valueOf(i)) + figuresInWords;
                } else {
                    figuresInWords = transformThreeDigits(threeDigitsArray[i]);
                }
            }
        }
        if(figuresInWords.isEmpty()) {
            figuresInWords= Constants.ZERO;
        }
        return figuresInWords.trim();
    }

    private String transformThreeDigits(String hundredString) {
        String figureInWords="";
        if(hundredString.length() < 3) {
            hundredString = "00" + hundredString;
            hundredString = hundredString.substring(hundredString.length() - 3);
        }
        String ones=hundredString.substring(2);
        if(!"0".equals(ones)) {
            figureInWords= Constants.BLANK_SPACE + numberToWordMapper.getOnesMap().get(ones);
        }
        String tens = hundredString.substring(1,2);
        if(!"0".equals(tens)) {
            if("1".equals(tens)){
                figureInWords = Constants.BLANK_SPACE + numberToWordMapper.getTensMap().get(tens+ones);
            }
            else {
                figureInWords = Constants.BLANK_SPACE + numberToWordMapper.getTensMap().get(tens + "0") + figureInWords.replaceAll(Constants.BLANK_SPACE, "-");
            }
        }
        String hundred = hundredString.substring(0,1);
        if(!"0".equals(hundred)) {
            figureInWords = Constants.BLANK_SPACE + numberToWordMapper.getOnesMap().get(hundred) + Constants.BLANK_SPACE + OverTens.hundred.toString() + figureInWords;
        }
        return figureInWords;
    }

    private String[] getThreeDigitsArray(String number) {
        String[] threeDigitsArray = new String[Constants.ARRAY_SIZE_FOR_MILLION];
        if (number.length() > 3) {
            if (number.length() > 6) {
                threeDigitsArray[0] = number.substring(number.length() - 3);
                threeDigitsArray[1] = number.substring(number.length() - 2 * 3, number.length() - 3);
                threeDigitsArray[2] = number.substring(0, number.length() - 2 * 3);

            } else {
                threeDigitsArray[0] = number.substring(number.length() - 3);
                threeDigitsArray[1] = number.substring(0, number.length() - 3);
            }
        } else {
            threeDigitsArray[0] = number;
        }
        return threeDigitsArray;
    }
}
