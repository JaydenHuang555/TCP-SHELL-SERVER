package jay.util.collection.stack;

public class Node {

    Object val;
    Node prev, next;

    Node(Object val){
        this.val = val;
        this.prev = null;
        this.next = null;
    }

}
