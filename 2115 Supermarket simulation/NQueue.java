import java.math.BigInteger;

class NQueue {
    private Node firstNode;
    private Node lastNode;

    NQueue(){
        firstNode = null;
        lastNode = null;
    }

    void insertNode(){
        if(firstNode == null){
            Node node = new Node();
            firstNode = node;
            lastNode = node;
        } else{
            Node newNode = new Node();
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
    }

    BigInteger removeNodeGetTime(){
        if(firstNode == null){
            throw new RuntimeException("Attempt to remove null.");
        } else{
            BigInteger waitTime = firstNode.getWaitTime();
            firstNode = firstNode.getNextNode();
            return waitTime;
        }
    }

    void incrementQueue(){
        if(firstNode == null){
            throw new RuntimeException("Attempt to increment null");
        } else{
            firstNode.incrementWaitTime();
            Node nodePtr = firstNode.getNextNode();
            while(nodePtr != null){
                nodePtr.incrementWaitTime();
                nodePtr = nodePtr.getNextNode();
            }
        }
    }

    boolean isEmpty(){ return firstNode == null; }
}
