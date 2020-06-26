class WordClass {
    private String word;
    private int count;

    WordClass(){
        this.word = "";
        count = 0;
    }
    WordClass(String word){
        this.word = word;
        count = 0;
    }

    void newWord(String word){
        this.word = word;
        count = 1;
    }
    void addCount(){
        ++count;
    }
    int getCount(){
        return count;
    }
    String getWord(){
        return word;
    }
}
