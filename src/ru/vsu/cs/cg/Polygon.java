package ru.vsu.cs.cg;

import java.util.ArrayList;
import java.util.Objects;

public class Polygon {
    private final ArrayList<Integer> vertexIndexes;
    private final ArrayList<Integer> textureVertexIndexes;
    private final ArrayList<Integer> normalIndexes;

    public Polygon(ArrayList<Integer> vertexIndexes, ArrayList<Integer> textureVertexIndexes, ArrayList<Integer> normalIndexes) {
        this.normalIndexes = normalIndexes;
        this.textureVertexIndexes = textureVertexIndexes;
        this.vertexIndexes = vertexIndexes;
    }

    public ArrayList<Integer> getVertexIndexes() {
        return vertexIndexes;
    }

    public ArrayList<Integer> getTextureVertexIndexes() {
        return textureVertexIndexes;
    }

    public ArrayList<Integer> getNormalIndexes() {
        return normalIndexes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polygon polygon = (Polygon) o;
        return getVertexIndexes().equals(polygon.getVertexIndexes()) && getTextureVertexIndexes().equals(polygon.getTextureVertexIndexes()) && getNormalIndexes().equals(polygon.getNormalIndexes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVertexIndexes(), getTextureVertexIndexes(), getNormalIndexes());
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "vertexIndexes=" + vertexIndexes +
                ", textureVertexIndexes=" + textureVertexIndexes +
                ", normalIndexes=" + normalIndexes +
                '}';
    }
}