/*
Using the String processing capabilities of Chapter 14, the file and directory capabilities of Section 15.3, and a Map Section 16.10, create an application that recursively walks a directory structure supplied by the user and reports the number of files of each file type (such as .java, .txt, .class, .docs, ect.) that exist in the specified directory path.  Display the filename extensions in sorted order.  Next investigate method walk of class the Files.  This method returns a stream that walks a directory and its subdirectories and returns the contents to you as a stream.  Then, reimplement the first part of this exercise, using lambdas and streams, rather than recursion.

My notes:  Based on my experiences with recursion, I don't think it makes sense to do this recursively.  Recursion just introduces the possibility of getting a stack overflow.
 */

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        System.out.println("Enter file or directory name:");
        Path userPath = Paths.get(new Scanner((System.in)).nextLine());

        Map<String, Integer> fileMap = new HashMap<>();

        if (Files.isDirectory(userPath)) {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(userPath);
            for (Path localPath : directoryStream) {
                if (!Files.isDirectory(localPath)) {
                    String fileName = localPath.toString();
                    String fileType = fileName.substring(fileName.length() - 3);

                    if (fileMap.containsKey(fileType)) {
                        fileMap.put(fileType, fileMap.get(fileType) + 1);
                    } else {
                        fileMap.put(fileType, 1);
                    }
                }
            }
        }

        Set<String> keys = fileMap.keySet();
        TreeSet<String> sortedKeys = new TreeSet<>(keys);
        for (String key : sortedKeys) {
            System.out.printf("Type: %s Count: %d%n", key, fileMap.get(key));
        }
    }
}
