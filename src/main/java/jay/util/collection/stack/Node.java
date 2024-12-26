package jay.util.collection.stack;
/*
only meant to be used in this package
 */
class Node {

    Object val;
    Node prev, next;

    Node(Object val){
        this.val = val;
        this.prev = null;
        this.next = null;
    }

}
