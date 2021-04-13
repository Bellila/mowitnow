package com.mowitnow.service.impl;

import com.mowitnow.domain.Coordinates;
import com.mowitnow.domain.Mower;
import com.mowitnow.domain.enumeration.Orientation;
import com.mowitnow.service.MowerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Interface mower implements test")
class MowerServiceImplTest {

    @DisplayName("Should be true 1")
    @Test
    public void shouldBeTrue1() {
        Mower mower = new Mower();
        MowerService mowerService = new MowerServiceImpl();
        Assertions.assertEquals(mowerService.getPositionAndOrientation(mower), "0 0 N");
    }

    @DisplayName("Should be true 2")
    @Test
    public void shouldBeTrue2() {
        Mower mower = new Mower();
        MowerService mowerService = new MowerServiceImpl();
        Assertions.assertEquals(mowerService.rotationLeft(mower), new Mower(0, 0, Orientation.WEST));
    }

    @DisplayName("Should be true 3")
    @Test
    public void shouldBeTrue3() {
        Mower mower = new Mower();
        MowerService mowerService = new MowerServiceImpl();
        Assertions.assertEquals(mowerService.rotationRight(mower), new Mower(0, 0, Orientation.EAST));
    }

    @DisplayName("Should be true 4")
    @Test
    public void shouldBeTrue4() {
        MowerService mowerService = new MowerServiceImpl();
        Assertions.assertEquals(mowerService.moving(new Mower(), new Coordinates(5, 5)), new Mower(0, 1, Orientation.NORTH));
    }

    @DisplayName("Should be true 5")
    @Test
    public void shouldBeTrue5() {
        MowerService mowerService = new MowerServiceImpl();
        Assertions.assertEquals(mowerService.moving(new Mower(), new Coordinates(0, 0)), new Mower(0, 0, Orientation.NORTH));
    }

}
