abstract class Path {
    MapNode[][] pathMap;
    Head head;
    private int pathIndex;

    Path(){}
    Path(Maze maze) {
        pathMap = new MapNode[maze.getRowSize()][maze.getColSize()];
        for (int row = 0; row < maze.getRowSize(); ++row){
            for (int col = 0; col < maze.getColSize(); ++col){
                pathMap[row][col] = new MapNode(0);
            }
        }

        head = new Head(maze.getEntryRow(), 0);
        pathIndex = 1;
        markPathMap();
        head.set(maze.getEntryRow(), 1);
        markPathMap();
    }

    MapNode[][] getPathMap(){
        return pathMap;
    }
    Head getHead(){ return head; }

    private void markPathMap(){
        int row = head.getRow();
        int col = head.getCol();
        pathMap[row][col].set(pathIndex, MapNodeState.PATH);
        ++pathIndex;
    }

    void advance(Maze maze){
        Direction facing = getAdvanceDirection(maze);
        head.set(head.shiftCopy(facing));
        markPathMap();
    }
    void advance(Maze maze, Direction travelDirection){
        head.set(head.shiftCopy(travelDirection));
        markPathMap();
    }

    void retreat(){
        int minIndex = Integer.MAX_VALUE;
        for (Direction direction : Direction.values()){
            Head testHead = head.shiftCopy(direction);
            int row = testHead.getRow();
            int col = testHead.getCol();
            if (direction != Direction.NONE &&
                    pathMap[row][col].getIndex() > 0 &&
                    minIndex > pathMap[row][col].getIndex()){
                minIndex = pathMap[row][col].getIndex();
            }
        }

        for (Direction direction : Direction.values()){
            Head testHead = head.shiftCopy(direction);
            int row = testHead.getRow();
            int col = testHead.getCol();
            if (minIndex == pathMap[row][col].getIndex()){
                head.set(testHead);
            }
        }
    }

    Direction getAdvanceDirection(Maze maze){
        for (Direction facing : Direction.values()) {
            if (canAdvance(maze, facing)){
                return facing;
            }
        }
        return Direction.NONE;
    }

    boolean exitReached(){
        return head.getCol() + 1 == pathMap[0].length;
    }

    abstract boolean canAdvance(Maze maze, Direction testDirection);
}
