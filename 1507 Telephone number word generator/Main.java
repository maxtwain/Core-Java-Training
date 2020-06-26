import java.util.Formatter;
import java.util.Scanner;

/*
Standard telephone keypads contain the digits zero through nine.  The numbers two through nine each have three letters associated with them (Fig. 15.19).  Many people find it difficult to memorize phone numbers, so they use the correspondence between digits and letters to develop seven letter words that correspond to their phone numbers.  For example, a person whose telephone number is 686-2377 might use the correspondence indicated in Fig. 15.19 to develop the seven letter word "NUMBERS."  Every seven letter word corresponds to exactly one seven digit telephone number.  A restaurant wishing to increase its takeout business could surely do so with the number 825-3688 (i.e., "TAKEOUT").
Every seven letter phone number corresponds to many different seven letter words, but most of these words represent unrecognizable juxtapositions of letters.  It's possible, however, that the owner of a barbershop would be pleased to know that the shop's telephone number, 424-7288, corresponds to "HAIRCUT."  A veterinarian with the phone number 738-2273 would be pleased to know that the number corresponds to the letters "PETCARE."  An automotive dealership would be pleased to know that the dealership number, 639-2277, corresponds to "NEWCARS."
Write a program that, given a seven digit number, uses a Formatter object to write to file every possible seven letter word combination corresponding to that number.  There are 2,187 such combinations.  Avoid phone numbers with the digits 0 and 1.

Fig 15.19: Telephone keypad digits and letters
2 ABC
3 DEF
4 GHI
5 JKL
6 MNO
7 PRS
8 TUV
9 WXY
 */
class Main{
    public static void main(String[] args){
        try (Formatter formatter = new Formatter("words.txt")){
            String[] keypad = {"ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY"};

            Scanner scanner = new Scanner(System.in);
            System.out.print("Seven digit phone number (example: 123-4567): ");
            String phone = scanner.nextLine().replace("-", "");

            for(int i0 = 0; i0 < 3; ++i0){
                for(int i1 = 0; i1 < 3; ++i1){
                    for(int i2 = 0; i2 < 3; ++i2){
                        for(int i3 = 0; i3 < 3; ++i3){
                            for(int i4 = 0; i4 < 3; ++i4){
                                for(int i5 = 0; i5 < 3; ++i5){
                                    for(int i6 = 0; i6 < 3; ++i6){
                                        char[] word = {
                                                keypad[phone.charAt(0) - '0' - 2].charAt(i0),
                                                keypad[phone.charAt(1) - '0' - 2].charAt(i1),
                                                keypad[phone.charAt(2) - '0' - 2].charAt(i2),
                                                keypad[phone.charAt(3) - '0' - 2].charAt(i3),
                                                keypad[phone.charAt(4) - '0' - 2].charAt(i4),
                                                keypad[phone.charAt(5) - '0' - 2].charAt(i5),
                                                keypad[phone.charAt(6) - '0' - 2].charAt(i6),
                                        };
                                        formatter.format("%s%n", String.valueOf(word));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}