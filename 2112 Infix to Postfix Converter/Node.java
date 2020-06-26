class Node {
    private FixCharacter fixData;
    Node nextNode;

    Node(Character data) {
        this(data, null);
    };

    Node(Character data, Node nextNode){
        this.fixData = new FixCharacter(data);
        this.nextNode = nextNode;
    };

    FixCharacter getFix() { return fixData; }
    Node getNext(){
        return nextNode;
    }
    void setData(FixCharacter fixData) {
        this.fixData = fixData;
    }
    void setNext(Node next){
        nextNode = next;
    }

}
