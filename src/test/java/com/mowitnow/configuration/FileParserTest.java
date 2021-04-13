package com.mowitnow.configuration;

import com.mowitnow.configuration.exception.ExceptionConstants;
import com.mowitnow.configuration.exception.MowItNowException;
import com.mowitnow.domain.Coordinates;
import com.mowitnow.domain.FileContent;
import com.mowitnow.domain.Mower;
import com.mowitnow.domain.MowerInstructions;
import com.mowitnow.domain.enumeration.Instruction;
import com.mowitnow.domain.enumeration.Orientation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

@DisplayName("File parser test")
class FileParserTest {

    @DisplayName("Should be equals")
    @Test
    public void shouldBeEquals() {
        FileContent fileContent1 = new FileContent();
        fileContent1.setLimitCoordinates(new Coordinates(5, 5));
        fileContent1.setMowerInstructionsList(
                new ArrayList<>(Arrays.asList(
                        new MowerInstructions(new Mower(1, 2, Orientation.NORTH), new ArrayList<>(Arrays.asList(Instruction.ROTATION_LEFT, Instruction.MOVING_FORWARD, Instruction.ROTATION_LEFT, Instruction.MOVING_FORWARD, Instruction.ROTATION_LEFT, Instruction.MOVING_FORWARD, Instruction.ROTATION_LEFT, Instruction.MOVING_FORWARD, Instruction.MOVING_FORWARD))),
                        new MowerInstructions(new Mower(3, 3, Orientation.EAST), new ArrayList<>(Arrays.asList(Instruction.MOVING_FORWARD, Instruction.MOVING_FORWARD, Instruction.ROTATION_RIGHT, Instruction.MOVING_FORWARD, Instruction.MOVING_FORWARD, Instruction.ROTATION_RIGHT, Instruction.MOVING_FORWARD, Instruction.ROTATION_RIGHT, Instruction.ROTATION_RIGHT, Instruction.MOVING_FORWARD)))
                ))
        );
        FileContent fileContent2 = FileParser.parseFileContent(Constants.PATH + "File");
        Assertions.assertEquals(fileContent1, fileContent2);
    }

    @DisplayName("Should be not equals")
    @Test
    public void shouldBeNotEquals() {
        FileContent fileContent1 = new FileContent();
        fileContent1.setLimitCoordinates(new Coordinates(5, 5));
        fileContent1.setMowerInstructionsList(
                new ArrayList<>(Arrays.asList(
                        new MowerInstructions(new Mower(1, 2, Orientation.NORTH), new ArrayList<>(Arrays.asList(Instruction.ROTATION_LEFT, Instruction.MOVING_FORWARD, Instruction.ROTATION_LEFT, Instruction.MOVING_FORWARD, Instruction.ROTATION_LEFT, Instruction.MOVING_FORWARD, Instruction.ROTATION_LEFT, Instruction.MOVING_FORWARD, Instruction.MOVING_FORWARD)))
                ))
        );
        FileContent fileContent2 = FileParser.parseFileContent(Constants.PATH + "File");
        Assertions.assertNotEquals(fileContent1, fileContent2);
    }

    @Test
    @DisplayName("Should be true because mower coordonates is out of boundry")
    public void shouldFailBecauseMowerCoordonateOutOfBoundry() {
        Exception exception = Assertions.assertThrows(MowItNowException.class, () -> {
            FileParser.parseFileContent(Constants.PATH + "WrongFile2");
        });
        Assertions.assertTrue(exception.getMessage().contains(ExceptionConstants.LAWN_INDEX_OUT_OF_BOUNDS));
    }

}
