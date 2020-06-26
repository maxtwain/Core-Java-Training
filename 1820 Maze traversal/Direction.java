enum Direction {
    NORTH {
        Direction rotate(){
            return EAST;
        }
    },
    EAST {
        Direction rotate(){
            return SOUTH;
        }
    },
    SOUTH {
        Direction rotate(){
            return WEST;
        }
    },
    WEST {
        Direction rotate(){
            return NONE;
        }
    },
    NONE {
        Direction rotate(){
            return NORTH;
        }
    };

    abstract Direction rotate();
}
