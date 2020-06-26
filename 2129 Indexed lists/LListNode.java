class LListNode {
    String data;
    LListNode nextNode;

    LListNode(String object){
        this(object, null);
    }

    LListNode(String object, LListNode node){
        data = object;
        nextNode = node;
    }

    String getData(){
        return data;
    }
    LListNode getNext(){
        return nextNode;
    }

    // returns the alphabet index; a = 0, b = 1, c = 2...
    int getIndex(){
        return data.toLowerCase().charAt(0) - 97;
    }
}
