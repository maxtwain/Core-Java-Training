import java.util.Formatter;
import java.util.Scanner;

class CollectData {
    CollectData(){
        try (Formatter outNumbers = new Formatter("numbers.txt")){
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter number 1 to 5:");
            while (scanner.hasNext()){
                outNumbers.format("%d%n", scanner.nextInt());
                System.out.print("Enter number 1 to 5:");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
