class MapNode {
    private int index = 0;
    private MapNodeState state;

    MapNode(int index){
        this.index = index;
        state = MapNodeState.EMPTY;
    }
    MapNode(){
        state = MapNodeState.EMPTY;
    }
    MapNode(MapNodeState state){
        this.state = state;
    }

    int getIndex() { return index; }

    void set(int index, MapNodeState state){
        this.index = index;
        this.state = state;
    }
    void setEmpty(){ state = MapNodeState.EMPTY; }
    void setPath(){ state = MapNodeState.PATH; }
    void setWall(){ state = MapNodeState.WALL; }

    boolean isEmpty(){ return state == MapNodeState.EMPTY; }
    boolean isPath(){ return state == MapNodeState.PATH; }
    boolean isWall(){ return state == MapNodeState.WALL; }

}
