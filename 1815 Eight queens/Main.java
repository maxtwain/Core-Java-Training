/*
A puzzler for chess buffs is the Eight Queens problem, which asks: Is it possible to place eight queens on an empty chessboard so that no queen is "attacking" any other (i.e., no two queens are in the same row, in the same column, or along the same diagonal)?  For example, if a queen is placed in the upper left corner of the board, no other queens could be placed in any of the marked squares shown in Fig. 18.21.  Solve the problem recursively.  [Hint: Your solution should begin with the first column and look for a location in that column where a queen can be placed - initially, place the queen in the first row.  The solution should then recursively search the remaining columns.  In the first few columns, there will be several locations where a queen may be placed.  Take the first available location.  If a column is reached with no possible location for a queen, the program should return the the previous column and move the queen in that column to a new row.  This continuous backing up and trying new alternatives is an example of recursive backtracking.]

My notes: I am fairly certain that I have this programmed correctly if it is to be recursive, but it seems that my computer runs out of memory before it is finished.  Rather than using recursion, I believe it would be far better to eliminate all these method calls by using iteration.  I believe that the only ways to get this to work as it is are to either eliminate recursive method calls or to increase the available stack memory.
 */

class Main{
    public static void main(String[] args){
        Queen[] queenArr = {
                new Queen(),
                new Queen(),
                new Queen(),
                new Queen(),
                new Queen(),
                new Queen(),
                new Queen(),
                new Queen()
        };

        // Storing array index numbers allows the code to be more readable.
        for(int i = 0; i < 8; ++i){
            queenArr[i].setQNum(i);
        }

        placeQueen(queenArr, 1);
        for(Queen queen : queenArr){
            System.out.printf("row = %d  col = %d%n", queen.getRow(), queen.getCol());
        }
    }

    private static void placeQueen(Queen[] queens, int index){
        while (!queens[index].isSafe(queens) && queens[index].canAdvance()) {
            queens[index].advance();
        }

        if (!queens[index].canAdvance() && (!queens[index].isSafe(queens) || index < 7)) {
            while (index > 0 && !queens[index].canAdvance()) {
                --index;
            }
            queens[index].advance();
            placeQueen(queens, index);
        }
        else if (index < 7) {
            // next queen is set to position of current queen
            queens[index + 1].matchPosition(queens[index]);
            ++index;
            placeQueen(queens, index);
        }
    }
}