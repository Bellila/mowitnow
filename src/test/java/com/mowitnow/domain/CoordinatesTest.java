package com.mowitnow.domain;

import com.mowitnow.configuration.exception.ExceptionConstants;
import com.mowitnow.configuration.exception.MowItNowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Coordinates test")
class CoordinatesTest {

    @Test
    @DisplayName("Should be not null")
    public void shouldBeNotNull() {
        Coordinates coordinates1 = new Coordinates(0, 0);
        Assertions.assertNotNull(coordinates1);
    }

    @Test
    @DisplayName("Should be not equals")
    public void shouldBeNotEquals() {
        Coordinates coordinates1 = new Coordinates(0, 0);
        Coordinates coordinates2 = new Coordinates(3, 0);
        Assertions.assertNotEquals(coordinates1, coordinates2);
    }

    @Test
    @DisplayName("Should be equals")
    public void shouldBeEquals() {
        Coordinates coordinates1 = new Coordinates(0, 0);
        Coordinates coordinates2 = new Coordinates();
        coordinates2.setX(coordinates1.getX());
        coordinates2.setY(coordinates1.getY());
        Assertions.assertEquals(coordinates1, coordinates2);
    }

    @Test
    @DisplayName("Should be failure when creating a coordinates with negative value")
    public void shouldBeFailureWhenCreatingCoordinatesWithNegativeValue() {
        Exception exception = Assertions.assertThrows(MowItNowException.class, () -> {
            new Coordinates(-1, 3);
        });
        Assertions.assertTrue(exception.getMessage().contains(ExceptionConstants.INVALID_COORDINATES));
    }

    @Test
    @DisplayName("Should be failure when creating a coordinates from null")
    public void shouldBeFailureWhenCreatingCoordinatesFromNull() {
        Exception exception = Assertions.assertThrows(MowItNowException.class, () -> {
            Coordinates coordinates = null;
            new Coordinates(coordinates);
        });
        Assertions.assertTrue(exception.getMessage().contains(ExceptionConstants.NULL_COORDINATES));
    }

    @Test
    @DisplayName("Should be success when creating a coordinates from coordinates object")
    public void shouldBeFailureWhenCreatingCoordinatesFromCoordinates() {
            Coordinates coordinates1 = new Coordinates(0, 0);
            Coordinates coordinates2 = new Coordinates(coordinates1);
            Assertions.assertEquals(coordinates1, coordinates2);
    }
}
