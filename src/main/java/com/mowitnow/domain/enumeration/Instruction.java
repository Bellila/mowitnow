package com.mowitnow.domain.enumeration;

import com.mowitnow.configuration.exception.ExceptionConstants;
import com.mowitnow.configuration.exception.MowItNowException;

import java.util.Arrays;
import java.util.Optional;

public enum Instruction {
    ROTATION_RIGHT("D"),
    ROTATION_LEFT("G"),
    MOVING_FORWARD("A");

    private String value;

    Instruction(String value) {
        this.value = value;
    }

    public static Instruction get(String value) {
        Optional<Instruction> optionalInstruction = Arrays.stream(values())
                .filter(instruction -> instruction.value.equals(value))
                .findFirst();
        if (optionalInstruction.isPresent()) {
            return optionalInstruction.get();
        } else {
            throw new MowItNowException(ExceptionConstants.INVALID_INSTRUCTION_VALUE);
        }
    }

    public static String getValue(Instruction instruction) {
        return instruction.value;
    }
}
