class Head {
    private int row;
    private int col;

    Head(int row, int col){
        this.row = row;
        this.col = col;
    }

    int getRow() { return row; }
    int getCol() { return col; }

    void set(Head head){
        this.row = head.getRow();
        this.col = head.getCol();
    }
}
