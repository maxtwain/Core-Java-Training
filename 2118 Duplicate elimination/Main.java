import java.security.SecureRandom;

class Main{
    public static void main(String[] args){
        Integer[] arr = new Integer[10];

        for(int i0 = 0; i0 < arr.length; ++i0){
            int randNum = new SecureRandom().nextInt(10);
            boolean isDuplicate = false;
            for(int i1 = 0; i1 < i0; ++i1){
                if(randNum == arr[i1]){
                    isDuplicate = true;
                }
            }
            if(!isDuplicate){
                arr[i0] = randNum;
            } else{
                --i0;
            }
        }

        for(Integer integer: arr){
            System.out.println(integer);
        }
    }
}