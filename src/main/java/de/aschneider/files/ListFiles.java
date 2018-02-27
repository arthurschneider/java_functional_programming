package de.aschneider.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ListFiles {

    public static void main(String[] args) throws IOException {
        System.out.println("List everything in the current directory:");
        try (Stream<Path> stream = Files.list(Paths.get("."))) {
            stream.forEach(System.out::println);
        }

        System.out.println("List only the directories in the current path:");
        try (Stream<Path> stream = Files.list(Paths.get("."))) {
            stream.filter(Files::isDirectory).forEach(System.out::println);
        }

        System.out.println("List all java files in the de/aschneider package:");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(
                Paths.get("src/main/java/de/aschneider"),
                path -> path.toString().endsWith(".java"))) {

            stream.forEach(System.out::println);
        }

        
        System.out.println("List hidden files in current directory:");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(
                Paths.get("."), path -> new File(path.toString()).isHidden())){ 
            stream.forEach(System.out::println);
        }
    }
}
