public class Main {
    public static void main(String[] args){

        for (TLight light : TLight.values()) {
            System.out.printf("%s: %d seconds, next is %s%n", light,
                    light.getSeconds(), light.next());
        }





//        Direction facing = Direction.NORTH;
//        facing.rotate();
//        System.out.println(facing);

    }

    private static void printStuff(Point[] arr, int index){
        if (arr[index] != null){
            System.out.printf(" row = %d col = %d%n", arr[index].getRow(), arr[index].getCol());
        }
    }
}
