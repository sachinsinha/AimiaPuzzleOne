package com.sachin.puzzleone;

import com.sachin.puzzleone.enums.Ones;
import com.sachin.puzzleone.enums.OverTens;
import com.sachin.puzzleone.enums.Tens;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class NumberToWordMapperTest {


    @Test
    public void shouldInitializeOnes_Tens_OverTens() throws Exception {
        //Given
        NumberToWordMapper mapper = null;
        //when
        mapper = new NumberToWordMapper();
        //Then
        assertThat(mapper, notNullValue());
        
        assertThat(mapper.getOnesMap(), notNullValue());
        assertThat(mapper.getTensMap(), notNullValue());
        assertThat(mapper.getOverTensMap(), notNullValue());
        
        assertThat(mapper.getOnesMap().get("7"), is(Ones.seven));
        assertThat(mapper.getOnesMap().get("4"), is(Ones.four));

        assertThat(mapper.getTensMap().get("11"), is(Tens.eleven));
        assertThat(mapper.getTensMap().get("40"), is(Tens.forty));

        assertThat(mapper.getOverTensMap().get("0"), is(OverTens.hundred));
        assertThat(mapper.getOverTensMap().get("1"), is(OverTens.thousand));
        assertThat(mapper.getOverTensMap().get("2"), is(OverTens.million));
    }
}
