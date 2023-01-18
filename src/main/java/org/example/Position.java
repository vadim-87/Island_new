package org.example;

import java.util.Objects;

public class Position {
    private int length;
    private int height;

    public Position(int length, int height) {
        this.length = length;
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return length == position.length && height == position.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, height);
    }
}
