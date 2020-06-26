/*
Write a simple generic version of method isEqualTo that compares its two arguments with the equals method and returns true if they're equal and false otherwise.  Use this generic method in a program that calls isEqualTo with a variety of built in types, such as Object or Integer.  When you run this program, are the objects passed to isEqualTo compared based on their contents or their references?
 */

class Main{
    public static void main(String[] args){
        int one = 1;
        int two = 2;
        int three = 1;
        String name;
        {
            Object a = one;
            Object b = two;
            Object c = three;
            name = "Object";
            System.out.printf("%s a0 %s equal to a1%n", name, isEqualTo(a, b) ? "is" : "is not");
            System.out.printf("%s a0 %s equal to a1%n", name, isEqualTo(a, c) ? "is" : "is not");
            System.out.printf("%s a0 %s equal to a1%n", name, isEqualTo(b, c) ? "is" : "is not");
            System.out.println();
        }

        {
            Integer a = one;
            Integer b = two;
            Integer c = three;
            name = "Integer";
            System.out.printf("%s a0 %s equal to a1%n", name, isEqualTo(a, b) ? "is" : "is not");
            System.out.printf("%s a0 %s equal to a1%n", name, isEqualTo(a, c) ? "is" : "is not");
            System.out.printf("%s a0 %s equal to a1%n", name, isEqualTo(b, c) ? "is" : "is not");
            System.out.println();
        }

        {
            Number a = one;
            Number b = two;
            Number c = three;
            name = "Number";
            System.out.printf("%s a0 %s equal to a1%n", name, isEqualTo(a, b) ? "is" : "is not");
            System.out.printf("%s a0 %s equal to a1%n", name, isEqualTo(a, c) ? "is" : "is not");
            System.out.printf("%s a0 %s equal to a1%n", name, isEqualTo(b, c) ? "is" : "is not");
            System.out.println();
        }

        {
            Double a = (double) one;
            Double b = (double) two;
            Double c = (double) three;
            name = "Double";
            System.out.printf("%s a0 %s equal to a1%n", name, isEqualTo(a, b) ? "is" : "is not");
            System.out.printf("%s a0 %s equal to a1%n", name, isEqualTo(a, c) ? "is" : "is not");
            System.out.printf("%s a0 %s equal to a1%n", name, isEqualTo(b, c) ? "is" : "is not");
            System.out.println();
        }
    }

    private static <T> boolean isEqualTo(T one, T two){
        return one.equals(two);
    }
}