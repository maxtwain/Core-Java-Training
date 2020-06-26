import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

class StudentPoll {

    StudentPoll(){
        try (Scanner inNumbers = new Scanner(Paths.get("numbers.txt"));
             Formatter outNumbers = new Formatter("output.txt")){

            int[] frequency = new int[6];

            while (inNumbers.hasNext()){
                try{
                    ++frequency[inNumbers.nextInt()];
                } catch (ArrayIndexOutOfBoundsException arrEx){
                    arrEx.printStackTrace();
                }
            }

            outNumbers.format("%s%10s%n", "Rating", "Frequency");
            for (int index = 1; index < frequency.length; ++index){
                outNumbers.format("%6d%10d%n", index, frequency[index]);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
