package ru.vsu.cs.cg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ObjReader {

    private static final String OBJ_VERTEX_TOKEN = "v";
    private static final String OBJ_TEXTURE_TOKEN = "vt";
    private static final String OBJ_NORMAL_TOKEN = "vn";
    private static final String OBJ_FACE_TOKEN = "f";

    public static Model read(String fileContent) {
        final ArrayList<Vector3f> vertices = new ArrayList<>();
        final ArrayList<Vector2f> textureVertices = new ArrayList<>();
        final ArrayList<Vector3f> normals = new ArrayList<>();
        final ArrayList<Polygon> polygons = new ArrayList<>();
        final Scanner scanner = new Scanner(fileContent);

        int lineInd = 0;
        while (scanner.hasNextLine()) {
            final String line = scanner.nextLine();
            ArrayList<String> wordsInLine = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
            if (wordsInLine.isEmpty() || wordsInLine.get(0).equals("#")) {
                continue;
            }

            final String token = wordsInLine.get(0);
            wordsInLine.remove(0);

            ++lineInd;
            switch (token) {
                case OBJ_VERTEX_TOKEN -> vertices.add(Parser.parseVertex(wordsInLine, lineInd));
                case OBJ_TEXTURE_TOKEN -> textureVertices.add(Parser.parseTextureVertex(wordsInLine, lineInd));
                case OBJ_NORMAL_TOKEN -> normals.add(Parser.parseNormal(wordsInLine, lineInd));
                case OBJ_FACE_TOKEN -> polygons.add(Parser.parsePolygon(wordsInLine, lineInd, vertices.size(),
                        textureVertices.size(), normals.size()));
                default -> {
                }
            }
        }

        return new Model(vertices, textureVertices, normals, polygons);
    }
}
