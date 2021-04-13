package com.mowitnow.service.impl;

import com.mowitnow.domain.Coordinates;
import com.mowitnow.domain.Mower;
import com.mowitnow.domain.enumeration.Instruction;
import com.mowitnow.domain.enumeration.Orientation;
import com.mowitnow.service.MowerService;

public class MowerServiceImpl implements MowerService {

    @Override
    public String getPositionAndOrientation(Mower mower) {
        return String.format("%d %d %s", mower.getCoordonates().getX(), mower.getCoordonates().getY(), Orientation.getValue(mower.getOrientation()));
    }

    @Override
    public Mower rotationLeft(Mower mower) {
        switch (mower.getOrientation()) {
            case NORTH:
                return new Mower(mower.getCoordonates(), Orientation.WEST);
            case WEST:
                return new Mower(mower.getCoordonates(), Orientation.SOUTH);
            case SOUTH:
                return new Mower(mower.getCoordonates(), Orientation.EAST);
            case EAST:
                return new Mower(mower.getCoordonates(), Orientation.NORTH);
            default:
                return mower;
        }
    }

    @Override
    public Mower rotationRight(Mower mower) {
        switch (mower.getOrientation()) {
            case NORTH:
                return new Mower(mower.getCoordonates(), Orientation.EAST);
            case WEST:
                return new Mower(mower.getCoordonates(), Orientation.NORTH);
            case SOUTH:
                return new Mower(mower.getCoordonates(), Orientation.WEST);
            case EAST:
                return new Mower(mower.getCoordonates(), Orientation.SOUTH);
            default:
                return mower;
        }
    }

    @Override
    public Mower moving(Mower mower, Coordinates limitCoordinates) {
        Coordinates newCoordinates = new Coordinates(mower.getCoordonates());
        switch (mower.getOrientation()) {
            case NORTH:
                newCoordinates.setY(newCoordinates.getY() + 1);
                break;
            case SOUTH:
                newCoordinates.setY(newCoordinates.getY() - 1);
                break;
            case EAST:
                newCoordinates.setX(newCoordinates.getX() + 1);
                break;
            case WEST:
                newCoordinates.setX(newCoordinates.getX() - 1);
                break;
        }
        if (!outOfBounds(newCoordinates, limitCoordinates)) {
            mower.setCoordonates(newCoordinates);
        }
        return mower;
    }

    private boolean outOfBounds(Coordinates newCoordinates, Coordinates limitCoordinates) {
        return newCoordinates.getX() > limitCoordinates.getX() || newCoordinates.getY() > limitCoordinates.getY();
    }

    @Override
    public Mower applyInstruction(Mower mower, Instruction instruction, Coordinates limitCoordinates) {
        switch (instruction) {
            case ROTATION_LEFT:
                return this.rotationLeft(mower);
            case ROTATION_RIGHT:
                return this.rotationRight(mower);
            case MOVING_FORWARD:
                return this.moving(mower, limitCoordinates);
            default:
                return mower;
        }
    }
}
