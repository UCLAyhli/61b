public class ArrayDeque<T> {
    private T[] items;
    private int size;

    public ArrayDeque(){
        items = new T[8];
        size = 0;
    }

    public void addFirst(T item){
        if (size==items.length){
            resize(size*2);
        }
        System.arraycopy(items, 0, items, 1, size);
        items[0] = item;
        size += 1;
    }
    private void resize(int capacity) {
        T[] a = new T[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
    public void addLast(T item){
        if (items.length==size){
            resize(size*2);
        }
        items[size]= item;
        size += 1;
    }
    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        else{
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for(int i =0; i<size;i++){
            System.out.print(items[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public T removeFirst(){
        T item = items[0];
        if (size-1 <= 0.25*items.length && 0.5*items.length > 8){
            resize((int)0.5*items.length);
        }
        else if(size-1 <= 0.25*items.length && 0.5*items.length <= 8){
            resize(8);
        }
        System.arraycopy(items, 1, items, 0, size-1);
        size = size - 1;
        return item;
    }

    public T removeLast(){
        T item = items[size];
        if (size-1 <= 0.25*items.length && 0.5*items.length > 8){
            resize((int)0.5*items.length);
        }
        else if(size-1 <= 0.25*items.length && 0.5*items.length <= 8){
            resize(8);
        }
        items[size-1]=null;
        size = size - 1;
        return item;
    }
    public T get(int index){
        if (index<0 || index>size-1){
            return null;
        }
        else{
            return items[index];
        }
    }
}
