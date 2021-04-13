package com.mowitnow.service;

import com.mowitnow.domain.Coordinates;
import com.mowitnow.domain.Mower;
import com.mowitnow.domain.enumeration.Instruction;

public interface MowerService {

    public String getPositionAndOrientation(Mower mower);

    public Mower rotationLeft(Mower mower);

    public Mower rotationRight(Mower mower);

    public Mower moving(Mower mower, Coordinates limitCoordinates);

    public Mower applyInstruction(Mower mower, Instruction instruction, Coordinates limitCoordinates);

}
