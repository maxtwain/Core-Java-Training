import java.util.ArrayList;

class Register {
    private ArrayList<LList> register;

    Register(){
        register = new ArrayList<>();
        for(int i = 0; i < 26; ++i){
            register.add(new LList());
        }
    }

    void insertItem(String item){
        int index = item.toLowerCase().charAt(0) - 97;
        register.get(index).insert(item);
    }

    void removeItem(String item){
        int index = item.toLowerCase().charAt(0) - 97;
        register.get(index).removeItem(item);
    }

    boolean isEmpty(){
        boolean isEmpty = true;
        for(LList alphaList: register){
            if(!alphaList.isEmpty()){
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    void print(){
        if(isEmpty()){
            System.out.printf("Empty list%n");
        } else{
            System.out.printf("The list is: %n");
            for(LList alphaList: register){
                alphaList.print();
            }
        }
        System.out.printf("%n%n");
    }
}
