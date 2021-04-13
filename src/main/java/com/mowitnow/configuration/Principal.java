package com.mowitnow.configuration;

import com.mowitnow.domain.FileContent;
import com.mowitnow.domain.MowerInstructions;
import com.mowitnow.domain.enumeration.Instruction;
import com.mowitnow.service.MowerService;
import com.mowitnow.service.impl.MowerServiceImpl;

public class Principal {

    private MowerService mowerService = new MowerServiceImpl();
    private StringBuilder sb = new StringBuilder();

    public void run(FileContent fileContent) {
        for (MowerInstructions mowerInstructions : fileContent.getMowerInstructionsList()) {
            for (Instruction instruction : mowerInstructions.getInstructions()) {
                mowerInstructions.setMower(
                        this.mowerService.applyInstruction(mowerInstructions.getMower(), instruction, fileContent.getLimitCoordinates())
                );
            }
            sb.append(
                    mowerService.getPositionAndOrientation(mowerInstructions.getMower())
            ).append("\n");
        }
        System.out.println(sb);
    }
}
