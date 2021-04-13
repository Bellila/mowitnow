package com.mowitnow.domain;

import com.mowitnow.domain.enumeration.Instruction;
import com.mowitnow.domain.enumeration.Orientation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

@DisplayName("Mower instructions test")
class MowerInstructionsTest {

    @Test
    @DisplayName("Should be equals")
    public void shouldBeEquals(){
        MowerInstructions mowerInstructions1 = new MowerInstructions();
        mowerInstructions1.setMower(new Mower(0, 0, Orientation.NORTH));
        mowerInstructions1.setInstructions(
                new ArrayList<>(Arrays.asList(Instruction.ROTATION_RIGHT, Instruction.ROTATION_RIGHT, Instruction.MOVING_FORWARD))
        );
        MowerInstructions mowerInstructions2 = new MowerInstructions(
                mowerInstructions1.getMower(), mowerInstructions1.getInstructions()
        );
        Assertions.assertEquals(mowerInstructions1, mowerInstructions2);
    }
}
