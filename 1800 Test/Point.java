class Point {
    private int row;
    private int col;

    Point(int row, int col){
        this.row = row;
        this.col = col;
    }

    Point get(){
        return this;
    }

    int getRow(){
        return row;
    }

    int getCol(){
        return col;
    }
}
