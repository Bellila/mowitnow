package com.mowitnow.domain;

import com.mowitnow.domain.enumeration.Orientation;

import java.util.Objects;

public class Mower {

    private Coordinates coordinates;

    private Orientation orientation;

    public Mower(Coordinates coordinates, Orientation orientation) {
        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    public Mower(int x, int y, Orientation orientation) {
        this.coordinates = new Coordinates(x, y);
        this.orientation = orientation;
    }

    public Mower() {
        this.coordinates = new Coordinates(0 ,0);
        this.orientation = Orientation.NORTH;
    }

    public void setCoordonates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordonates() {
        return coordinates;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return Objects.equals(coordinates, mower.coordinates) &&
                orientation == mower.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, orientation);
    }

    @Override
    public String toString() {
        return "Tondeuse{" +
                "coordonnees=" + coordinates +
                ", orientation=" + orientation +
                '}';
    }
}
