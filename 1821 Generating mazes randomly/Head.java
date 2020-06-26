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
    void set(int row, int col){
        this.row = row;
        this.col = col;
    }

    Head shiftCopy(Direction testDirection){
        int row = getRow();
        int col = getCol();
        switch (testDirection){
            case NORTH:
                --row;
                break;
            case EAST:
                ++col;
                break;
            case WEST:
                --col;
                break;
            case SOUTH:
                ++row;
        }
        return new Head(row, col);
    }
}
