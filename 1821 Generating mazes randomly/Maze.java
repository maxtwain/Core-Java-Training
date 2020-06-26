import java.security.SecureRandom;

/*
This assumes a rectangular maze with a left entry point and a right exit point.
 */
class Maze {
    private MapNode[][] mazeMap;

    Maze(String[] mazeStringArr){
        int rowSize = mazeStringArr.length;
        int colSize = mazeStringArr[0].length();

        char[][] charMap = new char[rowSize][colSize];
        for (int index = 0; index < mazeStringArr.length; ++index){
            charMap[index] = mazeStringArr[index].toCharArray();
        }

        mazeMap = new MapNode[rowSize][colSize];
        for (int row = 0; row < rowSize; ++row){
            for (int col = 0; col < colSize; ++col){
                mazeMap[row][col] = new MapNode(MapNodeState.PATH);
                if (charMap[row][col] == '#'){
                    mazeMap[row][col].setWall();
                }
            }
        }
    }

    Maze(int rowSize, int colSize){
        // basic setup
        mazeMap = new MapNode[rowSize][colSize];
        int entryRow = new SecureRandom().nextInt(rowSize - 2) + 1;
        for (int row = 0; row < rowSize; ++row){
            for (int col = 0; col < colSize; ++col){
                mazeMap[row][col] = new MapNode();
                if (row == 0 || row == rowSize - 1 ||
                        (col == 0 && row != entryRow)){
                    mazeMap[row][col].setWall();
                }
            }
        }

        MazePath mazePath = new MazePath(this);
        for(int row = 1; row < rowSize - 1; ++row){
            for(int col = 1; col < colSize; ++col){
                if(mazePath.getPathMap()[row][col].isEmpty()){
                    mazeMap[row][col].setWall();
                }
            }
        }
    }

    MapNode[][] get(){
        return mazeMap;
    }

    int getRowSize(){
        return mazeMap.length;
    }
    int getColSize(){ return mazeMap[0].length; }

    int getEntryRow() {
        for(int row = 0; row < mazeMap.length; ++row){
            if(!mazeMap[row][0].isWall()){
                return row;
            }
        }
        throw new CustomException("Entry index error");
    }


}
