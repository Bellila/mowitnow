package com.mowitnow.domain;

import com.mowitnow.domain.enumeration.Instruction;
import com.mowitnow.domain.enumeration.Orientation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

@DisplayName("File content test")
class FileContentTest {

    @Test
    @DisplayName("Should be equals")
    public void shouldBeEquals(){
        FileContent fileContent1 = new FileContent();
        fileContent1.setLimitCoordinates(new Coordinates(5, 5));
        fileContent1.setMowerInstructionsList(
                new ArrayList<>(Arrays.asList(
                        new MowerInstructions(new Mower(2, 5, Orientation.NORTH), new ArrayList<>(Arrays.asList(Instruction.MOVING_FORWARD, Instruction.MOVING_FORWARD, Instruction.ROTATION_RIGHT, Instruction.ROTATION_LEFT)))
                ))
        );
        FileContent fileContent2 = new FileContent(fileContent1.getLimitCoordinates(), fileContent1.getMowerInstructionsList());
        Assertions.assertEquals(fileContent1, fileContent2);
    }

}
