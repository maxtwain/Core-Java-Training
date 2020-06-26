/*
Write your own versions of String search methods indexOf and lastIndexOf
 */

public class Main{
    public static void main(String[] args){


    }

    public int myIndexOf(String data, char search){
        for(int index = 0; index < data.length(); ++index){
            if(data.charAt(index) == search){
                return index;
            }
        }
        return -1;
    }

    public int myLastIndexOf(String data, char search){
        for(int index = data.length() - 1; index >= 0; --index){
            if(data.charAt(index) == search){
                return index;
            }
        }
        return -1;
    }
}
