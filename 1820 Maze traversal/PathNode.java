class PathNode {
    private int index = 0;
    private boolean marked = false;

    PathNode(int index){
        this.index = index;
    }

    int getIndex() { return index; }
    boolean isMarked() { return marked; }

    void set(int index, boolean marked){
        this.index = index;
        this.marked = marked;
    }


}
