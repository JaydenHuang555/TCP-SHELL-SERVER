package jay.util.collection.stack;

import com.sun.istack.internal.NotNull;

public class Stack<T> {

    private Node head, tail;

    public Stack(){
        this.head = null;
        this.tail = null;
    }

    public void push(@NotNull T item){
        Node node = new Node(item);
        if(head == null){
            head = node;
            tail = head;
        }
        else {
            tail.next = node;
            tail.next.prev = tail;
            tail = tail.next;
        }
    }
    @SuppressWarnings("unchecked")
    public T peek(){
        return (T)tail.val;
    }

    public T pop(){
        T dfs = peek();
        if(head == tail) {
            head = null;
            tail = null;
        }
        else {
            tail.val = null;
            tail = tail.prev;
        }
        return dfs;
    }

    @Override
    public boolean equals(@NotNull Object o){
        return this == o;
    }

}
