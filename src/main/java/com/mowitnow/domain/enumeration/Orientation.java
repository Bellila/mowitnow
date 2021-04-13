package com.mowitnow.domain.enumeration;

import com.mowitnow.configuration.exception.ExceptionConstants;
import com.mowitnow.configuration.exception.MowItNowException;

import java.util.Arrays;
import java.util.Optional;

public enum Orientation {
    NORTH("N"),
    EAST("E"),
    WEST("W"),
    SOUTH("S");

    private String value;

    Orientation(String value) {
        this.value = value;
    }

    public static Orientation get(String value) {
        Optional<Orientation> optionalOrientation = Arrays.stream(values())
                .filter(orientation -> orientation.value.equals(value))
                .findFirst();
        if (optionalOrientation.isPresent()) {
            return optionalOrientation.get();
        } else {
            throw new MowItNowException(ExceptionConstants.INVALID_ORIENTATION_VALUE);
        }
    }

    public static String getValue(Orientation orientation) {
        return orientation.value;
    }
}
