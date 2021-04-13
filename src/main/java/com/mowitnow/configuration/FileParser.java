package com.mowitnow.configuration;

import com.mowitnow.configuration.exception.ExceptionConstants;
import com.mowitnow.configuration.exception.MowItNowException;
import com.mowitnow.domain.Coordinates;
import com.mowitnow.domain.FileContent;
import com.mowitnow.domain.Mower;
import com.mowitnow.domain.MowerInstructions;
import com.mowitnow.domain.enumeration.Instruction;
import com.mowitnow.domain.enumeration.Orientation;
import org.apache.commons.collections4.ListUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    public static FileContent parseFileContent(String path) {
        try {
            FileContent result = new FileContent();
            List<String> lines = Files.readAllLines(Paths.get(path));
            Coordinates limitCoordinates = parseLimitCoordinates(lines.get(0));
            result.setLimitCoordinates(limitCoordinates);
            result.setMowerInstructionsList(parseMowerInstructionsList(lines.subList(1, lines.size()), limitCoordinates));
            return result;
        } catch (IOException e) {
            throw new MowItNowException(ExceptionConstants.FILE_NOT_EXIST);
        }
    }

    private static Coordinates parseLimitCoordinates(String line) {
        String[] parts = line.split(Constants.COORDINATES_SEPERATOR);
        return new Coordinates(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    private static List<MowerInstructions> parseMowerInstructionsList(List<String> lines, Coordinates limitCoordinates) {
        List<MowerInstructions> result = new ArrayList<>();
        List<List<String>> parts = ListUtils.partition(lines, 2);
        for (List<String> list: parts) {
            result.add(parseMowerInstructions(list, limitCoordinates));
        }
        return result;
    }

    private static MowerInstructions parseMowerInstructions(List<String> lines, Coordinates limitCoordinates) {
        return new MowerInstructions(
                parseMower(lines.get(0), limitCoordinates),
                parseInstructions(lines.get(1))
        );
    }

    private static Mower parseMower(String line, Coordinates limitCoordinates) {
        String[] parts = line.split(Constants.COORDINATES_SEPERATOR);
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        if (x > limitCoordinates.getX() || y > limitCoordinates.getY()){
            throw new MowItNowException(ExceptionConstants.LAWN_INDEX_OUT_OF_BOUNDS);
        }
        return new Mower(x, y, Orientation.get(parts[2]));
    }

    private static List<Instruction> parseInstructions(String line) {
        List<Instruction> result = new ArrayList<>();
        for (String c : line.split(Constants.INSTRUCTION_SEPERATOR)) {
            result.add(Instruction.get(c));
        }
        return result;
    }
}
