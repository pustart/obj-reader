package ru.vsu.cs.cg;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PolygonParserTest {

    @Test
    public void parsePolygon01() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1", "6", "3"));
        ArrayList<Integer> expectedVertex = new ArrayList<>(Arrays.asList(0, 5, 2));
        ArrayList<Integer> expectedTextureVertexIndexes = new ArrayList<>();
        ArrayList<Integer> expectedNormalIndexes = new ArrayList<>();

        Polygon expectedPolygon = new Polygon(expectedVertex, expectedTextureVertexIndexes, expectedNormalIndexes);
        Polygon resultPolygon = Parser.parsePolygon(wordsInLineWithoutToken, 10, 10, 0, 0);

        System.out.println("Expected: " + expectedPolygon);
        System.out.println("Result: " + resultPolygon);
        Assertions.assertEquals(expectedPolygon, resultPolygon);
    }

    @Test
    public void parsePolygon02() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1", "6"));

        try {
            Polygon polygon = Parser.parsePolygon(wordsInLineWithoutToken, 10, 10, 0, 0);
            System.out.println(polygon);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Too few arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void parsePolygon03() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("jdhfshf", "ade", "адпо"));

        try {
            Polygon polygon = Parser.parsePolygon(wordsInLineWithoutToken, 10, 10, 0, 0);
            System.out.println(polygon);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Failed to parse int value.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void parsePolygon04() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1/2", "6/4", "3/5"));
        ArrayList<Integer> expectedVertex = new ArrayList<>(Arrays.asList(0, 5, 2));
        ArrayList<Integer> expectedTextureVertexIndexes = new ArrayList<>(Arrays.asList(1, 3, 4));
        ArrayList<Integer> expectedNormalIndexes = new ArrayList<>();

        Polygon expectedPolygon = new Polygon(expectedVertex, expectedTextureVertexIndexes, expectedNormalIndexes);
        Polygon resultPolygon = Parser.parsePolygon(wordsInLineWithoutToken, 10, 10, 6, 0);

        System.out.println("Expected: " + expectedPolygon);
        System.out.println("Result: " + resultPolygon);

        Assertions.assertEquals(expectedPolygon, resultPolygon);
    }

    @Test
    public void parsePolygon05() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1/2/3", "6/4/4", "3/5/2"));
        ArrayList<Integer> expectedVertex = new ArrayList<>(Arrays.asList(0, 5, 2));
        ArrayList<Integer> expectedTextureVertexIndexes = new ArrayList<>(Arrays.asList(1, 3, 4));
        ArrayList<Integer> expectedNormalIndexes = new ArrayList<>(Arrays.asList(2, 3, 1));

        Polygon expectedPolygon = new Polygon(expectedVertex, expectedTextureVertexIndexes, expectedNormalIndexes);
        Polygon resultPolygon = Parser.parsePolygon(wordsInLineWithoutToken, 10, 10, 6, 5);

        System.out.println("Expected: " + expectedPolygon);
        System.out.println("Result: " + resultPolygon);

        Assertions.assertEquals(expectedPolygon, resultPolygon);
    }

    @Test
    public void parsePolygon06() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1//2", "6//4", "3//5"));
        ArrayList<Integer> expectedVertex = new ArrayList<>(Arrays.asList(0, 5, 2));
        ArrayList<Integer> expectedTextureVertexIndexes = new ArrayList<>();
        ArrayList<Integer> expectedNormalIndexes = new ArrayList<>(Arrays.asList(1, 3, 4));

        Polygon expectedPolygon = new Polygon(expectedVertex, expectedTextureVertexIndexes, expectedNormalIndexes);
        Polygon resultPolygon = Parser.parsePolygon(wordsInLineWithoutToken, 10, 10, 0, 6);

        System.out.println("Expected: " + expectedPolygon);
        System.out.println("Result: " + resultPolygon);

        Assertions.assertEquals(expectedPolygon, resultPolygon);
    }

    @Test
    public void parsePolygon07() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1///2", "6///4", "3///5"));

        try {
            Polygon polygon = Parser.parsePolygon(wordsInLineWithoutToken, 10, 10, 0, 0);
            System.out.println(polygon);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Invalid element size.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void parsePolygon08() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1/2/2", "6/3/4", "3/4/5"));

        try {
            Polygon polygon = Parser.parsePolygon(wordsInLineWithoutToken, 10, 10, 10, 0);
            System.out.println(polygon);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. No normals at all in this file.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void parsePolygon09() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("12/2/2", "6/3/4", "30/4/5"));

        try {
            Polygon polygon = Parser.parsePolygon(wordsInLineWithoutToken, 10, 10, 10, 10);
            System.out.println(polygon);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. No normals at all in this file.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }
}
