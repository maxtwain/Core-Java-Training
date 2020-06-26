/*
Write a method mazeGenerator that takes as an argument a two dimensional 12 by 12 character array and randomly produces a maze.  The method should also provide the starting and ending locations of the maze.  Test your method mazeTraversal from Exercise 18.20, using several randomly generated mazes.

My notes:  Backtracking is not my favorite way to generate mazes, nor the easiest, but it is the most flexible.  It can do even or odd numbers of rows or any shape of maze.  The one I built here is not designed for anything but rectangle mazes.  It can take any size, and actually it is no more difficult to make the size adjustable than to make it fixed.

The key in designing a backtracking implementation is that a random direction from the path is not enough.  If one or more movable directions exist, one of these random directions MUST be chosen rather than just immediately backtracking.  Backtracking must only be done if no possible moves exist, not just if the random chosen direction is unavailable.

While maze generation is very similar to the generation of a maze solution, this forceful choosing of a random direction makes it much more complex.  My implementation had me writing twice the amount of code that I had previously.  I also had to redesign some of my previous path work.

This program also suffices for the next exercise, which asks for maze generation of any size.
 */

class Main{
    public static void main(String[] args) {

        Maze maze = new Maze(12, 12);
        printMap(maze);
    }

    private static void printMap(Maze maze){
        for(int row = 0; row < maze.getRowSize(); ++row){
            for(int col = 0; col < maze.getColSize(); ++col){
                if(maze.get()[row][col].isWall()){
                    System.out.print("# ");
                } else if(maze.get()[row][col].isPath()){
                    System.out.print("O ");
                } else if(maze.get()[row][col].isEmpty()){
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void mazeTraversal(Maze maze, SolvePath solvePath){

        Direction facing = solvePath.getAdvanceDirection(maze);
        if (facing != Direction.NONE){
            solvePath.advance(maze);
        } else {
            solvePath.retreat();
        }

        printProgress(maze, solvePath);
        if (!solvePath.exitReached()){
            mazeTraversal(maze, solvePath);
        }
    }

    private static void printProgress(Maze maze, Path path){
        try{
            Thread.sleep(500);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        int headRow = path.getHead().getRow();
        int headCol = path.getHead().getCol();

        for(int row = 0; row < maze.get().length; ++row){
            for(int col = 0; col < maze.get()[0].length; ++col){
                if (row == headRow && col == headCol){
                    System.out.print("X ");
                } else if (path.getPathMap()[row][col].isPath()){
                    System.out.print("O ");
                } else if (maze.get()[row][col].isWall()){
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}