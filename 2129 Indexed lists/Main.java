
class Main{
    public static void main(String[] args){
        Register list = new Register();
        list.insertItem("cheese");
        list.print();
        list.insertItem("ice");
        list.print();
        list.insertItem("Book");
        list.print();
        list.insertItem("cookie");
        list.print();
        list.insertItem("cake");
        list.print();
        list.insertItem("Czar");
        list.print();

        list.removeItem("ice");
        list.print();
        list.removeItem("Book");
        list.print();
        list.removeItem("cake");
        list.print();

    }
}