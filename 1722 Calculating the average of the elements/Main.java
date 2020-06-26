/*
Figure 7.19 defined a two dimensional array of grades with 10 rows and three columns, representing 10 students' grades on three exams.  Use streams to calculate the students' individual averages.
 */

import java.util.Arrays;
import java.util.stream.IntStream;

class Main{
    public static void main(String[] args){
        int[][] gradesArray = {
                {87, 96, 70},
                {68, 87, 90},
                {94, 100, 90},
                {100, 81, 82},
                {83, 65, 85},
                {78, 87, 65},
                {85, 75, 83},
                {91, 94, 100},
                {76, 72, 84},
                {87, 93, 73}
        };

        GradeBook gradeBook = new GradeBook("CS101 Introduction to Java Programming", gradesArray);
        System.out.printf("Welcome to the grade book for%n%s%n%n", gradeBook.getCourseName());
        gradeBook.processGrades();

        System.out.printf("%nGrade average = %.2f%n",
                Arrays.stream(gradesArray)
                        .flatMapToInt(Arrays::stream)
                        .average()
                        .getAsDouble()
        );

        IntStream.range(0, gradesArray.length)
                .forEach(row -> System.out.printf("Student %02d average = %.2f%n", row, Arrays.stream(gradesArray[row]).average().getAsDouble()));
    }
}