public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;

    public ArrayDeque(){
        items = (T []) new Object[8];
        size = 0;
    }
    @Override
    public void addFirst(T item){
        if (size==items.length){
            resize(size*2);
        }
        System.arraycopy(items, 0, items, 1, size);
        items[0] = item;
        size += 1;
    }
    private void resize(int capacity) {
        T[] a = (T []) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
    @Override
    public void addLast(T item){
        if (items.length==size){
            resize(size*2);
        }
        items[size]= item;
        size += 1;
    }
    @Override
    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        for(int i =0; i<size;i++){
            System.out.print(items[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    @Override
    public T removeFirst(){
        if(size==0){
            return null;
        }
        T item = items[0];
        if (size-1 <= 0.25*items.length && 0.5*items.length > 8){
            resize((int)(0.5*items.length));
        }
        else if(size-1 <= 0.25*items.length && 0.5*items.length <= 8){
            resize(8);
        }
        System.arraycopy(items, 1, items, 0, size-1);
        size = size - 1;
        return item;
    }
    @Override
    public T removeLast(){
        if(size==0){
            return null;
        }
        T item = items[size-1];
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
    @Override
    public T get(int index){
        if (index<0 || index>size-1){
            return null;
        }
        else{
            return items[index];
        }
    }
}
