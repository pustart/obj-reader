package ru.vsu.cs.cg;

import java.util.Objects;

public class Vector3f {
    private final float x;
    private final float y;
    private final float z;

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3f vector3f = (Vector3f) o;
        return Float.compare(vector3f.getX(), getX()) == 0 && Float.compare(vector3f.getY(), getY()) == 0 && Float.compare(vector3f.getZ(), getZ()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getZ());
    }
}