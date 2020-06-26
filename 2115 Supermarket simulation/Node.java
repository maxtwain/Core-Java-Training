import java.math.BigInteger;

class Node {
    private BigInteger waitTime;
    private Node nextNode;

    Node(){
        waitTime = BigInteger.ZERO;
        nextNode = null;
    }

    void setNextNode(Node next){
        nextNode = next;
    }

    void incrementWaitTime(){
        waitTime = waitTime.add(BigInteger.ONE);
    }

    Node getNextNode(){
        return nextNode;
    }

    BigInteger getWaitTime(){
        return waitTime;
    }
}
