import java.security.SecureRandom;

class MazePath extends Path{

    MazePath(Maze maze){
        super(maze);

        while (!isFinished()){
            int possibleAdvanceCount = 0;
            for (Direction direction : Direction.values()){
                if (direction != Direction.NONE &&
                        canAdvance(maze, direction)){
                    ++possibleAdvanceCount;
                }
            }

            if (possibleAdvanceCount > 0){
                Direction advanceDirection = randDirection(maze, possibleAdvanceCount);
                advance(maze, advanceDirection);
            } else {
                retreat();
            }
        }
        makeExit(maze);
    }

    private void printMap(Maze maze){

        for (int row = 0; row < maze.getRowSize(); ++row){
            for (int col = 0; col < maze.getColSize(); ++col){
                if(maze.get()[row][col].isWall()){
                    System.out.print("# ");
                } else if(row == head.getRow() &&
                        col == head.getCol()){
                    System.out.print("X ");
                }
                else if(pathMap[row][col].isPath()){
                    System.out.print("O ");
                } else if(pathMap[row][col].isEmpty()){
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    boolean canAdvance(Maze maze, Direction advanceHead){
        Head adjacentHead = head.shiftCopy(advanceHead);
        int row = adjacentHead.getRow();
        int col = adjacentHead.getCol();

        int nonPathCount = 0;
        if (!(row < 0 || row >= pathMap.length ||
                col < 0 || col >= pathMap[0].length) &&
                pathMap[row][col].isEmpty() &&
                !maze.get()[row][col].isWall()){
            // find three adjacent non-path (can be wall or empty)

            for (Direction direction : Direction.values()){
                if (direction != Direction.NONE &&
                        isWallOrEmpty(adjacentHead, direction)){
                    ++nonPathCount;
                }
            }
        }
        return nonPathCount >= 3;
    }

    private boolean isWallOrEmpty(Head advanceHead, Direction direction){
        Head testHead = advanceHead.shiftCopy(direction);
        int row = testHead.getRow();
        int col = testHead.getCol();

        return !(row < 0 || row >= pathMap.length ||
                col < 0 || col >= pathMap[0].length) &&
                !pathMap[row][col].isPath();
    }

    private Direction randDirection(Maze maze, int possibleAdvanceCount){
        int rotateCount = new SecureRandom().nextInt(possibleAdvanceCount);
        Direction travel = Direction.NORTH;
        while (!canAdvance(maze, travel) || rotateCount > 0){
            travel = travel.rotate();
            if (canAdvance(maze, travel)){
                -- rotateCount;
            }
        }
        return travel;
    }

    private void makeExit(Maze maze){
        int exitPossibleCount = 0;
        for(int row = 1; row < maze.getRowSize() - 1; ++row){
            if(pathMap[row][maze.getColSize() - 2].isPath()){
                ++exitPossibleCount;
            }
        }
        int exitRand = new SecureRandom().nextInt(exitPossibleCount);
        int exitRow = 1;
        while(exitRand > 0 || !pathMap[exitRow][maze.getColSize() - 2].isPath()){
            ++exitRow;
            if(pathMap[exitRow][maze.getColSize() - 2].isPath()){
                --exitRand;
            }
        }
        pathMap[exitRow][maze.getColSize() - 1].set(1, MapNodeState.PATH);
    }

    private boolean isFinished(){
        int row = head.getRow();
        int col = head.getCol();
        return pathMap[row][col].getIndex() == 1;
    }
}
