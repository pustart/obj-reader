package ru.vsu.cs.cg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

class ObjReaderVector3fTest {
    @Test
    public void testParseVertex01() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.01", "1.02", "1.03"));
        Vector3f result = Parser.parseVertex(wordsInLineWithoutToken, 5);
        Vector3f expectedResult = new Vector3f(1.01f, 1.02f, 1.03f);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void testParseVertex02() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("ab", "o", "ba"));
        try {
            Parser.parseVertex(wordsInLineWithoutToken, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Failed to parse float value.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseVertex03() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.0", "2.0"));
        try {
            Parser.parseVertex(wordsInLineWithoutToken, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Too few arguments.";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseVertex04() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.0", "2.0", "3.0", "4.0"));
        try {
            Parser.parseVertex(wordsInLineWithoutToken, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Too much arguments";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }

    @Test
    public void testParseVertex05() {
        ArrayList<String> wordsInLineWithoutToken = new ArrayList<>(Arrays.asList("1.0", "2.0", "3.0", "4.0", "2.0", "3.0", "4.0"));
        try {
            Parser.parseVertex(wordsInLineWithoutToken, 10);
        } catch (ObjReaderException exception) {
            String expectedError = "Error parsing OBJ file on line: 10. Too much arguments";
            Assertions.assertEquals(expectedError, exception.getMessage());
        }
    }
}
