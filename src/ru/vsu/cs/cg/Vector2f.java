package ru.vsu.cs.cg;

import java.util.Objects;

public class Vector2f {
    private final float x;
    private final float y;

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2f vector2f = (Vector2f) o;
        return Float.compare(vector2f.getX(), getX()) == 0 && Float.compare(vector2f.getY(), getY()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}