package ru.vsu.cs.cg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of("Enter your path to .obj file here");
        String fileContent = Files.readString(fileName);

        Model model = ObjReader.read(fileContent);
    }
}