class SolvePath extends Path{

    SolvePath(Maze maze){
        super(maze);
    }

    boolean canAdvance(Maze maze, Direction testDirection){
        Head testHead = head.shiftCopy(testDirection);
        int row = testHead.getRow();
        int col = testHead.getCol();

        return !(row < 0 || row >= pathMap.length ||
                col < 0 || col >= pathMap[0].length ||
                maze.get()[row][col].isWall() ||
                pathMap[row][col].isPath());
    }


}
