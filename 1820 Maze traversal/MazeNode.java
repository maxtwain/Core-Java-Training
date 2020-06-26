class MazeNode {
    private boolean marked;

    MazeNode(boolean marked){
        this.marked = marked;
    }

    boolean isMarked(){ return marked; }

    void setMarked(boolean marked){
        this.marked = marked;
    }
}
