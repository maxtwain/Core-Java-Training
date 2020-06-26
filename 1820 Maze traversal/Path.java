
class Path {
    private PathNode[][] pathMap;
    private Head head;
    private int pathIndex;

    Path(Maze maze) {
        pathMap = new PathNode[maze.getRowSize()][maze.getColSize()];
        for (int row = 0; row < maze.getRowSize(); ++row){
            for (int col = 0; col < maze.getColSize(); ++col){
                pathMap[row][col] = new PathNode(0);
            }
        }

        head = new Head(maze.getEntryRow(), 0);
        pathIndex = 1;
        markPathMap();
    }

    PathNode[][] getPathMap(){
        return pathMap;
    }
    Head getHead(){ return head; }

    private void markPathMap(){
        int row = head.getRow();
        int col = head.getCol();
        pathMap[row][col].set(pathIndex, true);
        ++pathIndex;
    }

    void advance(Maze maze){
        Direction facing = getAdvanceDirection(maze);
        head.set(testHead(facing));
        markPathMap();
    }

    void retreat(){
        int minIndex = Integer.MAX_VALUE;
        for (Direction direction : Direction.values()){
            Head testHead = testHead(direction);
            int row = testHead.getRow();
            int col = testHead.getCol();
            if (direction != Direction.NONE &&
                    pathMap[row][col].getIndex() > 0 &&
                    minIndex > pathMap[row][col].getIndex()){
                minIndex = pathMap[row][col].getIndex();
            }
        }

        for (Direction direction : Direction.values()){
            Head testHead = testHead(direction);
            int row = testHead.getRow();
            int col = testHead.getCol();
            if (minIndex == pathMap[row][col].getIndex()){
                head.set(testHead);
            }
        }
    }

    private Head testHead(Direction testDirection){
        int row = head.getRow();
        int col = head.getCol();
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

    Direction getAdvanceDirection(Maze maze){
        for (Direction facing : Direction.values()) {
            if (canAdvance(maze, facing)){
                return facing;
            }
        }
        return Direction.NONE;
    }

    private boolean canAdvance(Maze maze, Direction testDirection){
        Head testHead = testHead(testDirection);
        int row = testHead.getRow();
        int col = testHead.getCol();

        return !(row < 0 || row >= pathMap.length ||
                col < 0 || col >= pathMap[0].length ||
                maze.get()[row][col].isMarked() ||
                pathMap[row][col].isMarked());
    }

    boolean exitReached(){
        return head.getCol() + 1 == pathMap[0].length;
    }
}
