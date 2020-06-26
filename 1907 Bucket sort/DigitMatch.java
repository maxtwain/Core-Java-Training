
class DigitMatch {
    private int[] arr;
    private int firstNumIndex;
    private int lastNumIndex;

    DigitMatch(int maxSize){
        firstNumIndex = 0;
        arr = new int[maxSize];
        for(int i = 0; i < maxSize; ++i){
            arr[i] = -1;
        }
        lastNumIndex = -1;
    }
    int removeFirst(){
        int num = arr[firstNumIndex];
        ++firstNumIndex;
        return num;
    }

    void reset(){
        firstNumIndex = 0;
        lastNumIndex = -1;
    }

    boolean containsNum(){
        return firstNumIndex <= lastNumIndex;
    }

    void setLast(int num){
        ++lastNumIndex;
        arr[lastNumIndex] = num;
    }
}
