public class LinkedListDeque<T> implements Deque<T>{
    public class node{
        public node first;
        public node rest;
        public T current;

        public node(node P, node N, T c){
            this.current = c;
            this.first = P;
            this.rest = N;
        }
    }
    private node sent;
    private int num;

    public LinkedListDeque(){
        sent = new node(null,null,null);
        sent.rest = sent;
        sent.first = sent;
        num = 0;
    }
    @Override
    public void addFirst(T item){
        if (num == 0) {
            node First = new node(sent, sent, item);
            num = num + 1;
            sent.rest = First;
            sent.first = First;
        }
        else{
            node First = new node(sent, sent.rest, item);
            num = num + 1;
            sent.rest.first = First;
            sent.rest = First;
        }
    }
    @Override
    public void addLast(T item){
        if (num == 0) {
            node newnode = new node(sent, sent, item);
            num = num + 1;
            sent.rest = newnode;
            sent.first = newnode;
        }
        else{
            node newnode = new node(sent.first, sent, item);
            num = num + 1;
            sent.first.rest = newnode;
            sent.first = newnode;
        }
    }
    @Override
    public boolean isEmpty(){
        if (num==0){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public int size(){
        return num;
    }
    @Override
    public void printDeque(){
        if (num == 0){
            System.out.print("empty");
        }
        else{
            node current = sent.rest;
            for(int i =0;i<num;i++){
                System.out.print(current.current);
                System.out.print(" ");
                current = current.rest;
            }
        }
    }
    @Override
    public T removeFirst(){
        if (num == 0){
            return null;
        }
        else{
            node re = sent.rest;
            sent.rest = re.rest;
            re.rest.first = sent;
            num = num - 1;
            T item = re.current;
            re.current = null;
            re.first = null;
            re.rest = null;
            return item;
        }
    }
    @Override
    public T removeLast(){
        if (num == 0){
            return null;
        }
        else{
            node re = sent.first;
            sent.first = re.first;
            re.first.rest = sent;
            num = num - 1;
            T item = re.current;
            re.current = null;
            re.first = null;
            re.rest = null;
            return item;
        }
    }
    @Override
    public T get(int index){
        if (index > num - 1 || index<0){
            return null;
        }
        else{
            node current = sent;
            for(int i=0;i<index+1;i++){
                current = current.rest;
            }
            return current.current;
        }
    }
    public T getRecursive(int index){
        if (index > num-1){
            return null;
        }
        else {
            return Recur(index).current;
        }
    }

    private node Recur(int index) {
        if (index == 0) {
            return sent.rest;
        } else {
            node now = Recur(index - 1);
            now = now.rest;
            return now;
        }
    }
}
