/*
Figure 7.19 defined a two dimensional array of grades with 10 rows and three columns, representing 10 students' grades on three exams.  Use a stream pipeline to calculate the average of all the grades.  For this exercise, use Stream method of to create a stream from the two dimensional array and Stream method flatMapToInt to map each row into a stream of int values.

My notes: I couldn't find a use for the method of.
 */

import java.util.Arrays;

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
    }
}