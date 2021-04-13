package com.mowitnow.domain;

import com.mowitnow.domain.enumeration.Orientation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tondeuse test")
class MowerTest {

    @Test
    @DisplayName("Should be not null")
    public void shouldBeNotNull (){
        Mower mower1 = new Mower(new Coordinates(0, 0), Orientation.NORTH);
        Assertions.assertNotNull(mower1);
    }

    @Test
    @DisplayName("Should be not equals")
    public void shouldBeNotEquals (){
        Mower mower1 = new Mower();
        Mower mower2 = new Mower(0, 1, Orientation.NORTH);
        Assertions.assertNotEquals(mower1, mower2);
    }

    @Test
    @DisplayName("Should be equals")
    public void shouldBeEquals (){
        Mower mower1 = new Mower();
        Mower mower2 = new Mower();
        mower2.setOrientation(mower1.getOrientation());
        mower2.setCoordonates(mower1.getCoordonates());
        Assertions.assertEquals(mower1, mower2);
    }

}
