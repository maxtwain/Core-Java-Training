/*
This assumes a rectangular maze with a left entry point and a right exit point.
 */
class Maze {
    private MazeNode[][] mazeMap;

    Maze(String[] mazeStringArr){
        int rowSize = mazeStringArr.length;
        int colSize = mazeStringArr[0].length();

        char[][] charMap = new char[rowSize][colSize];
        for (int index = 0; index < mazeStringArr.length; ++index){
            charMap[index] = mazeStringArr[index].toCharArray();
        }

        mazeMap = new MazeNode[rowSize][colSize];
        for (int row = 0; row < rowSize; ++row){
            for (int col = 0; col < colSize; ++col){
                mazeMap[row][col] = new MazeNode(false);
                if (charMap[row][col] == '#'){
                    mazeMap[row][col].setMarked(true);
                }
            }
        }
    }

    MazeNode[][] get(){
        return mazeMap;
    }

    int getRowSize(){
        return mazeMap.length;
    }
    int getColSize(){ return mazeMap[0].length; }

    int getEntryRow() {
        for(int row = 0; row < mazeMap.length; ++row){
            if(!mazeMap[row][0].isMarked()){
                return row;
            }
        }
        throw new CustomException("Entry index error");
    }
}
