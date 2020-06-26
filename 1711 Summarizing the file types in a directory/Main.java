/*
Section 15.3 demonstrated how to get information about files and directories on disk.  In addition, you used a DirectoryStream to display the contents of a directory.  Interface DirectoryStream now contains default method entries, which returns a Stream.  Use the techniques from Section 15.3, DirectoryStream method entries, lambdas and streams to summarized the types of files in a specified directory.

My notes:  I am not really sure that there is much to do here.  Most of this program is just printing.  Nearly all the print operations in the book are within lambda blocks, which is nearly the same thing as putting them inside these if blocks.  I was able to modify Path assignment and DirectoryStream iteration.  DirectoryStream has no entries method.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

class Main{
    public static void main(String[] args) throws IOException{

        System.out.println("Enter file or directory name: ");
        Path path = Paths.get(new Scanner(System.in).nextLine());

        if (Files.exists(path)){
            System.out.printf("%n%s exists%n", path.getFileName());
            System.out.printf("%s a directory%n", Files.isDirectory(path) ? "Is" : "Is not");
            System.out.printf("%s an absolute path%n", path.isAbsolute() ? "Is" : "Is not");
            System.out.printf("Last modified: %s%n", Files.getLastModifiedTime(path));
            System.out.printf("Size: %s%n", Files.size(path));
            System.out.printf("Path: %s%n", path);
            System.out.printf("Absolute path: %s%n", path.toAbsolutePath());
            if (Files.isDirectory(path)){
                System.out.printf("%nDirectory contents:%n");
                Files.newDirectoryStream(path).iterator().forEachRemaining(System.out::println);
            }
        }
        else {
            System.out.printf("%s does not exist%n", path);
        }
    }
}