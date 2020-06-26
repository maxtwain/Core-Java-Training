/*
Figure 7.8 contains an array of survey responses that's hard coded into the program.  Suppose we wish to process survey results that are stored in a file.  This exercise requires two separate programs.  First, create an application that prompts the user for survey responses and outputs each response to a file.  Use a Formatter to create a file called numbers.txt.  Each integer should be written using method format.  Then modify the program in Fig. 7.8 to read the survey responses from numbers.txt.  The responses should be read from the file by using a Scanner.  Use method nextInt to input one integer at a time from the file.  The program should continue to read responses until it reaches the end of the file.  The results should be output to the text file "output.txt".
 */

public class Main{
    public static void main(String[] args){
        CollectData collectData = new CollectData();
        StudentPoll studentPoll = new StudentPoll();
    }
}