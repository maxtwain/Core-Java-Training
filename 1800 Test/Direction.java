enum Direction {
    NORTH(1) {
        Direction rotate(){
            return EAST;
        }
    },
    EAST(2) {
        Direction rotate(){
            return SOUTH;
        }
    },
    SOUTH(3) {
        Direction rotate(){
            return WEST;
        }
    },
    WEST(4) {
        Direction rotate(){
            return NONE;
        }
    },
    NONE(5) {
        Direction rotate(){
            return NORTH;
        }
    };

    private int num;

    Direction(int num){
        this.num = num;
    }

    abstract Direction rotate();
}
