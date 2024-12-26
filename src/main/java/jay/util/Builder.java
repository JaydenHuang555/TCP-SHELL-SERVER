package jay.util;

public class Builder {

    private char buffer[];
    private int size;

    public Builder(){
        this.size = 0;
        this.buffer = new char[1 << 4];
    }

    public void append(final char c){
        buffer[size++] = c;
        if(size == buffer.length){
            char next[] = new char[size * 2];
            for(int i = 0; i < size; i++) next[i] = buffer[i];
            buffer = next;
        }
    }

    public void append(final String cc){
        for(int i = 0; i < cc.length(); i++) append(cc.charAt(i));
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        char dfs[] = new char[size];
        for(int i = 0; i < buffer.length; i++) dfs[i] = buffer[i];
        return String.valueOf(dfs);
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Builder) || (((Builder) o).size) != this.size) return false;
        Builder other = (Builder) o;
        for(int i = 0; i < other.getSize(); i++)
            if(other.buffer[i] != this.buffer[i]) return false;
        return true;
    }

}
