package com.mowitnow.domain;

import com.mowitnow.domain.enumeration.Instruction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MowerInstructions {

    private Mower mower;

    private List<Instruction> instructions;

    public MowerInstructions() {
        this.mower = new Mower();
        this.instructions = new ArrayList<>();
    }

    public MowerInstructions(Mower mower, List<Instruction> instructions) {
        this.mower = mower;
        this.instructions = instructions;
    }

    public void setMower(Mower mower) {
        this.mower = mower;
    }

    public Mower getMower() {
        return mower;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MowerInstructions that = (MowerInstructions) o;
        return Objects.equals(mower, that.mower) &&
                Objects.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mower, instructions);
    }

    @Override
    public String toString() {
        return "MowerInstructions{" +
                "mower=" + mower +
                ", instructions=" + instructions +
                '}';
    }
}
