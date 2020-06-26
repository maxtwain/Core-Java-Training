import java.util.NoSuchElementException;

class LList {
    private LListNode firstNode;

    LList(){
        firstNode = null;
    }

    void insert(String insertItem){
        LListNode newNode = new LListNode(insertItem, null);

        if(isEmpty()){
            firstNode = newNode;
        } else if(insertItem.compareToIgnoreCase(firstNode.data) < 0) {
            newNode.nextNode = firstNode;
            firstNode = newNode;
        } else {
            LListNode currentNode = firstNode;
            while(currentNode.nextNode != null &&
                    insertItem.compareToIgnoreCase(currentNode.nextNode.data) > 0){
                currentNode = currentNode.nextNode;
            }
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
        }
    }

    String removeFromFront() throws NoSuchElementException {
        if(isEmpty()){
            throw new NoSuchElementException("list is empty");
        }

        String removedItem = firstNode.data;

        if(firstNode.nextNode == null){
            firstNode = null;
        } else{
            firstNode = firstNode.nextNode;
        }
        return removedItem;
    }

    String removeItem(String item) throws NoSuchElementException{
        String removedItem = "";

        if(isEmpty()){
            throw new NoSuchElementException("list is empty");
        } else if(firstNode.data.equalsIgnoreCase(item)){
            firstNode = firstNode.nextNode;
        } else{
            LListNode currentNode = firstNode;
            while(currentNode.nextNode != null &&
                    !item.equalsIgnoreCase(currentNode.nextNode.data)){
                currentNode = currentNode.nextNode;
            }
            if(currentNode.nextNode == null){
                System.out.println("Element does not exist.");
            } else if(currentNode.nextNode.nextNode == null){
                removedItem = currentNode.nextNode.data;
                currentNode.nextNode = null;
            } else{
                removedItem = currentNode.nextNode.data;
                currentNode.nextNode = currentNode.nextNode.nextNode;
            }
        }
        return removedItem;
    }

    LListNode getLocation(String item){
        LListNode keyNode = null;

        if(isEmpty()){
            throw new NoSuchElementException("list is empty");
        } else if(firstNode.data.equalsIgnoreCase(item)){
            keyNode = firstNode.nextNode;
        } else{
            LListNode currentNode = firstNode;
            while(currentNode.nextNode != null &&
                    !item.equalsIgnoreCase(currentNode.nextNode.data)){
                currentNode = currentNode.nextNode;
            }
            if(currentNode.nextNode == null){
                System.out.println("Element does not exist.");
            } else{
                keyNode = currentNode.nextNode;
            }
        }
        return keyNode;
    }

    boolean isEmpty(){
        return firstNode == null;
    }

    void print(){
        if(isEmpty()){
            return;
        }

        LListNode current = firstNode;
        while(current != null){
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }
    }
}
