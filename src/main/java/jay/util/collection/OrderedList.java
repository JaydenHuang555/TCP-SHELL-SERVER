package jay.util.collection;

import com.sun.istack.internal.NotNull;

public class OrderedList<T> {

    private Object buffer[];
    private int size = 0;


    public OrderedList(){
        buffer = new Object[1 << 3];
    }

    public OrderedList(final int cap){
        buffer = new Object[cap];
    }

    public void add(@NotNull T item){
        buffer[size++] = item;
        if(size == buffer.length){
            Object next[] = new Object[size * 2];
            for(int i = 0; i < size; i++) next[i] = buffer[i];
            buffer = next;
        }
    }
    @SuppressWarnings("unchecked")
    public T get(int index){
        if(index > size || index < 0) throw new RuntimeException("invalid index");
        return (T)buffer[index];
    }

    public int getSize(){
        return size;
    }

    @Override
    public boolean equals(@NotNull Object o){
        if(!(o instanceof OrderedList<?>)) return false;
        OrderedList<?> other = (OrderedList<?>) o;
        for(int i = 0; i < other.size; i++) if(other.get(i).hashCode() == this.get(i).hashCode()) return true;
        return false;
    }

}
