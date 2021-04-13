package com.mowitnow.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileContent {

    private Coordinates limitCoordinates;

    private List<MowerInstructions> mowerInstructionsList;

    public FileContent(Coordinates limitCoordinates, List<MowerInstructions> mowerInstructionsList) {
        this.limitCoordinates = limitCoordinates;
        this.mowerInstructionsList = mowerInstructionsList;
    }

    public FileContent() {
        this.limitCoordinates = new Coordinates();
        this.mowerInstructionsList = new ArrayList<>();
    }

    public void setLimitCoordinates(Coordinates limitCoordinates) {
        this.limitCoordinates = limitCoordinates;
    }

    public Coordinates getLimitCoordinates() {
        return limitCoordinates;
    }

    public <E> void setMowerInstructionsList(List<MowerInstructions> mowerInstructionsList) {
        this.mowerInstructionsList = mowerInstructionsList;
    }

    public List<MowerInstructions> getMowerInstructionsList() {
        return mowerInstructionsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileContent that = (FileContent) o;
        return Objects.equals(limitCoordinates, that.limitCoordinates) &&
                Objects.equals(mowerInstructionsList, that.mowerInstructionsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(limitCoordinates, mowerInstructionsList);
    }

    @Override
    public String toString() {
        return "FileContent{" +
                "limitCoordonates=" + limitCoordinates +
                ", mowerInstructionsList=" + mowerInstructionsList +
                '}';
    }
}
