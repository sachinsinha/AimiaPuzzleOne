package com.sachin.puzzleone;


import com.sachin.puzzleone.enums.Ones;
import com.sachin.puzzleone.enums.OverTens;
import com.sachin.puzzleone.enums.Tens;

import java.util.HashMap;
import java.util.Map;

public class NumberToWordMapper {
    private Map<String, Ones> onesMap = new HashMap<String, Ones>();
    private Map<String, Tens> tensMap = new HashMap<String, Tens>();
    private Map<String, OverTens> overTensMap = new HashMap<String, OverTens>();

    public NumberToWordMapper() {
        initializeOnes();
        initializeTens();
        initializeOverTens();

    }

    private void initializeOnes() {
        onesMap.put(String.valueOf(1), Ones.one);
        onesMap.put(String.valueOf(2), Ones.two);
        onesMap.put(String.valueOf(3), Ones.three);
        onesMap.put(String.valueOf(4), Ones.four);
        onesMap.put(String.valueOf(5), Ones.five);
        onesMap.put(String.valueOf(6), Ones.six);
        onesMap.put(String.valueOf(7), Ones.seven);
        onesMap.put(String.valueOf(8), Ones.eight);
        onesMap.put(String.valueOf(9), Ones.nine);
    }

    private void initializeTens() {
        tensMap.put(String.valueOf(10), Tens.ten);
        tensMap.put(String.valueOf(11), Tens.eleven);
        tensMap.put(String.valueOf(12), Tens.twelve);
        tensMap.put(String.valueOf(13), Tens.thirteen);
        tensMap.put(String.valueOf(14), Tens.fourteen);
        tensMap.put(String.valueOf(15), Tens.fifteen);
        tensMap.put(String.valueOf(16), Tens.sixteen);
        tensMap.put(String.valueOf(17), Tens.seventeen);
        tensMap.put(String.valueOf(18), Tens.eighteen);
        tensMap.put(String.valueOf(19), Tens.nineteen);
        tensMap.put(String.valueOf(20), Tens.twenty);
        tensMap.put(String.valueOf(30), Tens.thirty);
        tensMap.put(String.valueOf(40), Tens.forty);
        tensMap.put(String.valueOf(50), Tens.fifty);
        tensMap.put(String.valueOf(60), Tens.sixty);
        tensMap.put(String.valueOf(70), Tens.seventy);
        tensMap.put(String.valueOf(80), Tens.eighty);
        tensMap.put(String.valueOf(90), Tens.ninety);
    }

    private void initializeOverTens() {
        overTensMap.put(String.valueOf(0), OverTens.hundred);
        overTensMap.put(String.valueOf(1), OverTens.thousand);
        overTensMap.put(String.valueOf(2), OverTens.million);

    }

    public Map<String, Ones> getOnesMap() {
        return onesMap;
    }

    public Map<String, Tens> getTensMap() {
        return tensMap;
    }

    public Map<String, OverTens> getOverTensMap() {
        return overTensMap;
    }
}
