import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args){
        SecureRandom secureRandom = new SecureRandom();

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 10; ++i){
            list.add(secureRandom.nextInt(10));
        }

//        for (int num : list){
//            System.out.print(num + " ");
//        }
//        System.out.println();

        secureRandom.ints(100, 1, 3)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .forEach((side, frequency) -> System.out.printf("%-6d%d%n", side, frequency));

    }
}
