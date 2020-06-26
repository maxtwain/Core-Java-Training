class Queen {
    private int row;
    private int col;
    private int qNum;

    Queen(){
        row = 0;
        col = 0;
    }

    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }

    void setQNum(int qNum){
        this.qNum = qNum;
    }

    // requires canAdvance check first
    void advance(){
        if (col == 7){
            ++row;
            col = 0;
        }
        else{
            ++col;
        }
    }
    void matchPosition(Queen previousQueen){
        row = previousQueen.getRow();
        col = previousQueen.getCol();
    }

    boolean canAdvance(){
        return !(row == 7 && col == 7);
    }

    private boolean isAttacked(Queen attacker){
        return getRow() == attacker.getRow() ||
                getCol() == attacker.getCol() ||
                Math.abs(getRow() - attacker.getRow()) ==
                        Math.abs(getCol() - attacker.getCol());
    }

    boolean isSafe(Queen[] queens){
        for(int attIndex = 0; attIndex < qNum; ++attIndex){
            if(this.isAttacked(queens[attIndex])){
                return false;
            }
        }
        return true;
    }
}
