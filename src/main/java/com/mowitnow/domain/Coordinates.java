package com.mowitnow.domain;

import com.mowitnow.configuration.exception.ExceptionConstants;
import com.mowitnow.configuration.exception.MowItNowException;

import java.util.Objects;

public class Coordinates {

    private int x;

    private int y;

    public Coordinates() {
        this.x = 0;
        this.y = 0;
    }

    public Coordinates(int x, int y) {
        if ((x < 0) || (y < 0)) {
            throw new MowItNowException(ExceptionConstants.INVALID_COORDINATES);
        }
        this.x = x;
        this.y = y;
    }

    public Coordinates(Coordinates coordinates) {
        if (coordinates == null) {
            throw new MowItNowException(ExceptionConstants.NULL_COORDINATES);
        }
        this.x = coordinates.x;
        this.y = coordinates.y;
    }

    public void setX(int x) {
        if (x < 0) {
            throw new MowItNowException(ExceptionConstants.INVALID_COORDINATES);
        }
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        if (y < 0) {
            throw new MowItNowException(ExceptionConstants.INVALID_COORDINATES);
        }
        this.y = y;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordonnees{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
