package com.oracledb.operation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class FileOperations {
    public static void main(String[] args) {
        try {
            //Create directory

            Path dirPath = Paths.get("new_directory");

            if (!Files.exists(dirPath)) {
                Files.createDirectory(dirPath);
                System.out.println("Directory created: " + dirPath);
            }
//Create file and write to it
            Path filePath = dirPath.resolve("miladfile.txt");
            String content = "This is an example file.";
            Files.write(filePath, content.getBytes(StandardCharsets.UTF_8));
            System.out.println("File created and content written:" + filePath);
            // Read the contents of the file
            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            System.out.println("File content:");
            lines.forEach(System.out::println);
            // Copy the file
            Path copiedFilePath = dirPath.resolve("example_copy.txt");
            Files.copy(filePath, copiedFilePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied to: " + copiedFilePath);
            // Delete the file
            Files.deleteIfExists(copiedFilePath);
            System.out.println("Copied file deleted.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

