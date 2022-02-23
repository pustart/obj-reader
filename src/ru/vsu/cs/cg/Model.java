package ru.vsu.cs.cg;

import java.util.*;

public class Model {
    private ArrayList<Vector3f> vertices = new ArrayList<>();
    private ArrayList<Vector2f> textureVertices = new ArrayList<>();
    private ArrayList<Vector3f> normals = new ArrayList<>();
    private ArrayList<Polygon> polygons = new ArrayList<>();

    public Model(ArrayList<Vector3f> vertices,
                 ArrayList<Vector2f> textureVertices,
                 ArrayList<Vector3f> normals,
                 ArrayList<Polygon> polygons) {
        this.vertices = vertices;
        this.textureVertices = textureVertices;
        this.normals = normals;
        this.polygons = polygons;
    }

    public ArrayList<Vector3f> getVertices() {
        return vertices;
    }

    public ArrayList<Vector2f> getTextureVertices() {
        return textureVertices;
    }

    public ArrayList<Vector3f> getNormals() {
        return normals;
    }

    public ArrayList<Polygon> getPolygons() {
        return polygons;
    }
}